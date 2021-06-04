package bounce;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
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
    private static final RegistryObject<Item> POGO = POGO_REGISTRY.register("wooden_pogo_stick",  () -> new Item(new Item.Properties(){{tab(ItemGroup.TAB_TRANSPORTATION);}}));

    public Bounce() {
        POGO_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {

    }
}