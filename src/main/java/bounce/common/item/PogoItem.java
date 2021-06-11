package bounce.common.item;

import bounce.Bounce;
import bounce.common.Registry;
import bounce.common.entity.PogoEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.TieredItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPosWrapper;
import net.minecraft.world.World;

public class PogoItem extends TieredItem {
    public PogoItem(ItemTier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if(!world.isClientSide()) {
            PogoEntity ent = new PogoEntity(Registry.POGO_ENTITY_TYPE.get(), world);
            ent.setPos(player.position().x, player.position().y, player.position().z);
            ent.setItemTier(this.getTier());
            player.startRiding(ent);
            boolean success = world.addFreshEntity(ent);
        }
        return super.use(world, player, hand);
    }
}
