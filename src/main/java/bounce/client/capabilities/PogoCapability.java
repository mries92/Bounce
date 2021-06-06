package bounce.client.capabilities;

import net.minecraft.nbt.CompoundNBT;

public class PogoCapability implements IPogoCapability {
    private String NBT_STRING = "jumping";
    private boolean jumping;

    @Override
    public boolean getJumping() {
        return jumping;
    }

    @Override
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    @Override
    public CompoundNBT serializeNBT() {
        final CompoundNBT nbt = new CompoundNBT();
        nbt.putBoolean(NBT_STRING, this.getJumping());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        setJumping(nbt.getBoolean(NBT_STRING));
    }
}