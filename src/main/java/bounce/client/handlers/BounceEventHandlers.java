package bounce.client.handlers;

import bounce.Bounce;
import bounce.client.capabilities.IPogoCapability;
import bounce.client.capabilities.PogoCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BounceEventHandlers {
    @CapabilityInject(IPogoCapability.class)
    private static Capability<IPogoCapability> capability = null;

    @SubscribeEvent
    public static void handleEvent(PlayerInteractEvent.RightClickItem event)
    {
        if(capability.getDefaultInstance().getJumping() == false)
        {
            System.out.println("NOW JUMPING");
            capability.getDefaultInstance().setJumping(true);
        } else {
            System.out.println("STOPPED JUMPING");
            capability.getDefaultInstance().setJumping(false);
        }
        Minecraft instance = Minecraft.getInstance();
        ClientPlayerEntity player = instance.player;
        if(event.getItemStack().getItem().equals(Bounce.WOODEN_POGO_STICK.get()) && player.isOnGround())
            player.setDeltaMovement(new Vector3d(0,1,0));
    }
}
