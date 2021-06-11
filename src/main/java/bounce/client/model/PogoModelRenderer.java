package bounce.client.model;

import bounce.common.entity.PogoEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class PogoModelRenderer extends EntityRenderer<PogoEntity> {
    protected final PogoStickModel model = new PogoStickModel();

    public PogoModelRenderer(EntityRendererManager manager) {
        super(manager);
        this.shadowRadius = 0.8F;
    }

    @Override
    public void render(PogoEntity entity, float yRot, float p_225623_3_, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int p_225623_6_) {
        matrixStack.pushPose();
        IVertexBuilder vertexBuilder = renderTypeBuffer.getBuffer(this.model.renderType(this.getTextureLocation(entity)));
        matrixStack.mulPose(Vector3f.YN.rotationDegrees(yRot));
        matrixStack.mulPose(Vector3f.XP.rotationDegrees(180));
        matrixStack.mulPose(Vector3f.XP.rotationDegrees(entity.xRot));
        matrixStack.mulPose(Vector3f.ZP.rotationDegrees(entity.zRot));
        this.model.renderToBuffer(matrixStack, vertexBuilder, p_225623_6_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.popPose();
        super.render(entity, yRot, p_225623_3_, matrixStack, renderTypeBuffer, p_225623_6_);
    }

    @Override
    public ResourceLocation getTextureLocation(PogoEntity p_110775_1_) {
        IItemTier itemTier = p_110775_1_.getItemTier();
        if(itemTier == ItemTier.WOOD)
            return new ResourceLocation("bounce:textures/model/wooden_pogo_stick.png");
        if(itemTier == ItemTier.IRON)
            return new ResourceLocation("bounce:textures/model/iron_pogo_stick.png");
        if(itemTier == ItemTier.GOLD)
            return new ResourceLocation("bounce:textures/model/golden_pogo_stick.png");
        if(itemTier == ItemTier.DIAMOND)
            return new ResourceLocation("bounce:textures/model/diamond_pogo_stick.png");
        else
            return new ResourceLocation("bounce:textures/model/wooden_pogo_stick.png");
    }
}
