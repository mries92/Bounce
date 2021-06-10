package bounce.common;

import bounce.common.entity.PogoEntity;
import bounce.common.item.PogoItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class Registry {
    private static final String modId = "bounce";

    private static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, modId);
    private static final DeferredRegister<EntityType<?>> ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, modId);

    public static RegistryObject<Item> WOODEN_POGO_STICK;
    public static RegistryObject<Item> IRON_POGO_STICK;
    public static RegistryObject<Item> GOLD_POGO_STICK;
    public static RegistryObject<Item> DIAMOND_POGO_STICK;
    public static RegistryObject<EntityType<PogoEntity>> POGO_ENTITY_TYPE;

    public static void registerAll() {
        WOODEN_POGO_STICK = ITEM_REGISTRY.register("wooden_pogo_stick",  () -> new PogoItem(ItemTier.WOOD ,new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(0).durability(100)));
        IRON_POGO_STICK = ITEM_REGISTRY.register("iron_pogo_stick",  () -> new PogoItem(ItemTier.IRON ,new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(0).durability(200)));
        GOLD_POGO_STICK = ITEM_REGISTRY.register("golden_pogo_stick",  () -> new PogoItem(ItemTier.GOLD ,new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(0).durability(300)));
        DIAMOND_POGO_STICK = ITEM_REGISTRY.register("diamond_pogo_stick",  () -> new PogoItem(ItemTier.DIAMOND ,new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(0).durability(400)));

        POGO_ENTITY_TYPE = ENTITY_REGISTRY.register("pogo_stick", () -> EntityType.Builder.of(PogoEntity::new, EntityClassification.MISC).build("pogo_stick"));

        ITEM_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITY_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
