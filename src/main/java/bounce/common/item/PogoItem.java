package bounce.common.item;

import bounce.Bounce;
import bounce.common.entity.PogoEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class PogoItem extends Item {
    public PogoItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if(!world.isClientSide()) {
            boolean success = world.addFreshEntity(new PogoEntity(Bounce.POGO_ENTITY.get(), world));
        }
        return super.use(world, player, hand);
    }
}
