package bounce.common.entity;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class PogoEntity extends Entity {
    private PlayerEntity owner;

    public PogoEntity(EntityType<PogoEntity> type, World world) {
        super(type, world);
    }

    @Override
    public void tick()
    {
        //this.setPacketCoordinates(owner.position());
        super.tick();
        if(!this.hasPassenger(PlayerEntity.class))
            this.remove();
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

