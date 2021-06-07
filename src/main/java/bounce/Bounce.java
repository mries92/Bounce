package bounce;

import bounce.client.model.PogoModelRenderer;
import bounce.common.Registry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod("bounce")
public class Bounce {

    public Bounce() {
        Registry.registerAll();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(Registry.POGO_ENTITY_TYPE.get(), PogoModelRenderer::new);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
    }
}