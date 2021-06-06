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
import net.minecraft.util.ResourceLocation;
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
    public void render(PogoEntity entity, float p_225623_2_, float p_225623_3_, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int p_225623_6_) {
        matrixStack.pushPose();
        IVertexBuilder vertexBuilder = renderTypeBuffer.getBuffer(this.model.renderType(this.getTextureLocation(entity)));
        this.model.renderToBuffer(matrixStack, vertexBuilder, p_225623_6_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.popPose();
        super.render(entity, p_225623_2_, p_225623_3_, matrixStack, renderTypeBuffer, p_225623_6_);
    }

    @Override
    public ResourceLocation getTextureLocation(PogoEntity p_110775_1_) {
        return new ResourceLocation("textures/item/metal.png");
    }
}
