package bounce.common.entity;

import bounce.common.util.Serializers;
import net.minecraft.block.BlockState;
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
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class PogoEntity extends Entity {
    private float speed = .01f;
    private float leanAmount = 2;
    public float zRot = 0;

    protected static final DataParameter<IItemTier> itemTier = EntityDataManager.defineId(PogoEntity.class, Serializers.ITEM_TIER_DATA_SERIALIZER);
    protected static final DataParameter<Float> jumpHeight = EntityDataManager.defineId(PogoEntity.class, DataSerializers.FLOAT);
    private static final String TAG_ITEM_TIER = "itemTier";
    private static final String TAG_JUMP_HEIGHT = "jumpHeight";


    public PogoEntity(EntityType<PogoEntity> entityType, World world) {
        super(entityType, world);
        this.setDeltaMovement(0,-.001D,0);
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
            FluidState fluidState = level.getFluidState(blockPosition());
            if (level.isStateAtPosition(blockPosition(), blockState -> blockState.getCollisionShape(level, blockPosition()).isEmpty()) && fluidState.isEmpty()) {
                setDeltaMovement(getDeltaMovement().subtract(0,  .04D,0));
            } else if (!fluidState.isEmpty()) {
                if (getDeltaMovement().y < -.1)
                    setDeltaMovement(getDeltaMovement().x, -.1, getDeltaMovement().z);
                else
                    setDeltaMovement(getDeltaMovement().subtract(0,  .0004D,0));
            } else {
                setDeltaMovement(new Vector3d(0, getJumpHeight(),0));
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
        this.entityData.define(itemTier, ItemTier.WOOD);
        this.entityData.define(jumpHeight, 0.1f);
    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT nbt) {
        this.entityData.set(itemTier, ItemTier.values()[nbt.getInt(TAG_ITEM_TIER)]);
        this.entityData.set(jumpHeight, nbt.getFloat(TAG_JUMP_HEIGHT));
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT nbt) {
        nbt.putInt(TAG_ITEM_TIER, this.entityData.get(itemTier).getLevel());
        nbt.putFloat(TAG_JUMP_HEIGHT, this.entityData.get(jumpHeight));
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


    /* EntityData accessors */
    public void setItemTier(IItemTier tier) {
        this.entityData.set(itemTier, tier);
    }

    public IItemTier getItemTier() {
        return this.entityData.get(itemTier);
    }

    public void setJumpHeight(Float height) {
        this.entityData.set(jumpHeight, height);
    }

    public Float getJumpHeight() {
        return this.entityData.get(jumpHeight);
    }

}


