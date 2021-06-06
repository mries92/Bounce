package bounce.client.handlers;

import bounce.Bounce;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BounceEventHandlers {
    @SubscribeEvent
    public static void handleEvent(PlayerInteractEvent.RightClickItem event)
    {
        Minecraft instance = Minecraft.getInstance();
        ClientPlayerEntity player = instance.player;
        if(event.getItemStack().getItem().equals(Bounce.WOODEN_POGO_STICK.get()) && player.isOnGround())
            player.setDeltaMovement(new Vector3d(0,1,0));
    }
}
