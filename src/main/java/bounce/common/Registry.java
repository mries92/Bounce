package bounce.common;

import bounce.common.entity.PogoEntity;
import bounce.common.item.PogoItem;
import bounce.common.util.Serializers;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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
        WOODEN_POGO_STICK = ITEM_REGISTRY.register("wooden_pogo_stick",  () -> new PogoItem(ItemTier.WOOD, .3f, new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(0).durability(100)));
        IRON_POGO_STICK = ITEM_REGISTRY.register("iron_pogo_stick",  () -> new PogoItem(ItemTier.IRON, .35f, new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(0).durability(200)));
        GOLD_POGO_STICK = ITEM_REGISTRY.register("golden_pogo_stick",  () -> new PogoItem(ItemTier.GOLD, .4f, new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(0).durability(300)));
        DIAMOND_POGO_STICK = ITEM_REGISTRY.register("diamond_pogo_stick",  () -> new PogoItem(ItemTier.DIAMOND, .45f, new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(0).durability(400)));

        POGO_ENTITY_TYPE = ENTITY_REGISTRY.register("pogo_stick", () -> EntityType.Builder.of(PogoEntity::new, EntityClassification.MISC).build("pogo_stick"));

        DataSerializers.registerSerializer(Serializers.ITEM_TIER_DATA_SERIALIZER);

        ITEM_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITY_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
