package bounce;

import bounce.client.handlers.BounceEventHandlers;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


@Mod("bounce")
public class Bounce {
    public static final String modId = "bounce";
    private static final DeferredRegister<Item> POGO_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, modId);
    public static final RegistryObject<Item> WOODEN_POGO_STICK = POGO_REGISTRY.register("wooden_pogo_stick",  () -> new Item(new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(1).durability(100)));

    public Bounce() {
        POGO_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(BounceEventHandlers.class);
    }
}