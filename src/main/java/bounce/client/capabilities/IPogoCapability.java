package bounce.client.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface IPogoCapability extends INBTSerializable<CompoundNBT> {
    boolean getJumping();
    void setJumping(boolean jumping);
}
