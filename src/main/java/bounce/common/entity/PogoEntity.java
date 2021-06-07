package bounce.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
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

    public PogoEntity(EntityType<PogoEntity> entityType, World world) {
        super(entityType, world);
        this.type = Type.WOOD;
        this.setNoGravity(false);
        this.setDeltaMovement(0,-.001D,0);
    }

    void setType(Type type) {
        this.type = type;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.hasPassenger(PlayerEntity.class))
            this.remove();
        if (this.level.isStateAtPosition(this.blockPosition().below(), BlockState::isAir))
        {
            Vector3d delta = this.getDeltaMovement();
            this.setDeltaMovement(new Vector3d(0, delta.y - .04D,0));
        } else {
            this.setDeltaMovement(new Vector3d(0,.8,0));
        }
        this.move(MoverType.SELF, getDeltaMovement());
    }

    @Override
    public void positionRider(Entity rider) {
        rider.setPos(this.getX(), this.getY() - .9, this.getZ() - .2);
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


