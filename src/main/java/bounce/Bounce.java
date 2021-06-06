package bounce;

import bounce.client.model.PogoModelRenderer;
import bounce.common.entity.PogoEntity;
import bounce.common.item.PogoItem;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


@Mod("bounce")
public class Bounce {
    public static final String modId = "bounce";
    private static final DeferredRegister<Item> POGO_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, modId);
    public static final RegistryObject<Item> WOODEN_POGO_STICK = POGO_REGISTRY.register("wooden_pogo_stick",  () -> new PogoItem(new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(1).durability(100)));
    private static final DeferredRegister<EntityType<?>> POGO_ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, modId);
    public static final RegistryObject<EntityType<PogoEntity>> POGO_ENTITY = POGO_ENTITY_REGISTRY.register(
            "wooden_pogo_stick",
            () -> EntityType.Builder.<PogoEntity>of(PogoEntity::new, EntityClassification.MISC).build("wooden_pogo_stick"));

    public Bounce() {
        POGO_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
        POGO_ENTITY_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(POGO_ENTITY.get(), PogoModelRenderer::new);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
    }
}