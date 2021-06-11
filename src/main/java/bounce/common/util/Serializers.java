package bounce.common.util;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.IDataSerializer;

public class Serializers {
    public static final IDataSerializer<IItemTier> ITEM_TIER_DATA_SERIALIZER = new IDataSerializer<IItemTier>() {
        @Override
        public void write(PacketBuffer p_187160_1_, IItemTier p_187160_2_) {
            p_187160_1_.writeInt(p_187160_2_.getLevel());
        }

        @Override
        public IItemTier read(PacketBuffer p_187159_1_) {
            return ItemTier.values()[p_187159_1_.getInt(0)];
        }

        @Override
        public IItemTier copy(IItemTier p_192717_1_) {
            return p_192717_1_;
        }
    };
}
