package bounce.common.item;

import bounce.common.Registry;
import bounce.common.entity.PogoEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.TieredItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class PogoItem extends TieredItem {
    public Float jumpHeight;

    public PogoItem(ItemTier tier, Float jumpHeight, Properties properties) {
        super(tier, properties);
        this.jumpHeight = jumpHeight;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if(!world.isClientSide()) {
            PogoEntity ent = new PogoEntity(Registry.POGO_ENTITY_TYPE.get(), world);
            ent.setPos(player.position().x, player.position().y, player.position().z);
            ent.setItemTier(this.getTier());
            ent.setJumpHeight(this.jumpHeight);
            player.startRiding(ent);
            world.addFreshEntity(ent);
        }
        return super.use(world, player, hand);
    }
}
