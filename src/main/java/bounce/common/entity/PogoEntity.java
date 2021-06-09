package bounce.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class PogoEntity extends Entity {
    public static enum Type {
        WOOD,
        IRON,
        GOLD,
        DIAMOND
    }

    Type type;
    private float speed;
    public float zRot = 0;

    public PogoEntity(EntityType<PogoEntity> entityType, World world) {
        super(entityType, world);
        type = Type.WOOD;
        speed = .01f;
        this.setDeltaMovement(0,-.001D,0);
    }

    void setType(Type type) {
        this.type = type;
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
            float xInput = 0, zInput = 0;

            // Handle gravity
            if (level.isStateAtPosition(blockPosition().below(), BlockState::isAir))
            {
                setDeltaMovement(getDeltaMovement().subtract(0,  .04D,0));
            } else {
                setDeltaMovement(new Vector3d(0,.5,0));
            }

            // Handle input
            if(Minecraft.getInstance().player.input.up) {
                zInput = 1;
                xRot = 5;
            }
            if(Minecraft.getInstance().player.input.down) {
                zInput = -1;
                xRot = -5;
            }
            if(Minecraft.getInstance().player.input.right) {
                xInput = 1;
                zRot = -5;
            }
            if(Minecraft.getInstance().player.input.left) {
                xInput = -1;
                zRot = 5;
            }

            // Add input angle to rotation to get final movement vector
            float inputAngle = (float)Math.toDegrees(MathHelper.atan2(xInput, zInput));
            float finalAngle = inputAngle + yRot;

            if(xInput != 0 || zInput != 0) {
                float xComp = MathHelper.sin(-finalAngle * ((float)Math.PI / 180F)) * speed;
                float zComp = MathHelper.cos(finalAngle * ((float)Math.PI / 180F)) * speed;
                this.setDeltaMovement(getDeltaMovement().add(xComp, 0.0D, zComp));
            } else {
                xRot = 0; zRot = 0;
            }

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
                getY() - .9,
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


