package bounce.client.capabilities;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class PogoStorage implements Capability.IStorage<IPogoCapability> {
    @Nullable
    @Override
    public INBT writeNBT(Capability<IPogoCapability> capability, IPogoCapability instance, Direction side) {
        return null;
    }

    @Override
    public void readNBT(Capability<IPogoCapability> capability, IPogoCapability instance, Direction side, INBT nbt) {

    }
}
