package bounce.common.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class PogoEntity extends Entity {
    private IItemTier itemTier;
    private float speed = .01f;
    private float leanAmount = 5;
    public float zRot = 0;

    public PogoEntity(EntityType<PogoEntity> entityType, World world) {
        super(entityType, world);
        this.setDeltaMovement(0,-.001D,0);
    }
    public IItemTier getItemTier() { return this.itemTier; }

    public void setItemTier(IItemTier tier) {
        this.itemTier = tier;
    }

    @Override
    public void tick() {
        controlPogo();
        super.tick();
    }

    private void controlPogo() {
        if (!hasPassenger(PlayerEntity.class))
            remove();
        else {
            // Handle gravity
            FluidState fluidState = level.getFluidState(blockPosition().below());
            if (level.isStateAtPosition(blockPosition().below(), blockState -> blockState.getCollisionShape(level, blockPosition().below()).isEmpty()) && fluidState.isEmpty()) {
                setDeltaMovement(getDeltaMovement().subtract(0,  .04D,0));
            } else if (!fluidState.isEmpty()) {
                if (getDeltaMovement().y < -.1)
                    setDeltaMovement(getDeltaMovement().x, -.1, getDeltaMovement().z);
                else
                    setDeltaMovement(getDeltaMovement().subtract(0,  .0004D,0));
            } else {
                setDeltaMovement(new Vector3d(0,.5,0));
            }

            // Handle input
            Vector2f input = Minecraft.getInstance().player.input.getMoveVector();
            xRot = input.y * leanAmount;
            zRot = input.x * leanAmount;

            // Add input angle to rotation to get final movement vector
            if(input.x != 0 || input.y != 0) {
                float inputAngle = (float)Math.toDegrees(MathHelper.atan2(-input.x, input.y));
                float finalAngle = inputAngle + yRot;

                float xComp = MathHelper.sin(-finalAngle * ((float)Math.PI / 180F)) * speed;
                float zComp = MathHelper.cos(finalAngle * ((float)Math.PI / 180F)) * speed;
                this.setDeltaMovement(getDeltaMovement().add(xComp, 0.0D, zComp));
            }

            // Rotate and move
            yRot = MathHelper.wrapDegrees(getPassengers().get(0).yRot);
            move(MoverType.SELF, getDeltaMovement());
        }
    }

    @Override
    public void positionRider(Entity rider) {
        float angle = (float)Math.toRadians(-yRot);
        float offset = .2f;
        rider.setPos(
                getX() - (offset * MathHelper.sin(angle)),
                getY(),
                getZ() - (offset * MathHelper.cos(angle)));
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT p_70037_1_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT p_213281_1_) {

    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}


