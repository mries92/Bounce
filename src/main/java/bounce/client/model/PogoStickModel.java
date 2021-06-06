package bounce.client.model;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import bounce.common.entity.PogoEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;

@OnlyIn(Dist.CLIENT)
public class PogoStickModel extends EntityModel<PogoEntity> {
	private final ModelRenderer[] modelRenderers;
	private final ImmutableList<ModelRenderer> parts;

	public PogoStickModel() {
		modelRenderers = new ModelRenderer[]{(
				new ModelRenderer(this, 0, 0)).setTexSize(128, 64)};
		modelRenderers[0].texOffs(0, 3).addBox(-10.0F, -29.0F, 7.0F, 3.0F, 22.0F, 3.0F, 0.0F, false);
		modelRenderers[0].texOffs(0, 1).addBox(-13.0F, -29.0F, 8.0F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		modelRenderers[0].texOffs(0, 1).addBox(-12.0F, -10.0F, 8.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		modelRenderers[0].texOffs(0, 1).addBox(-9.0F, -8.0F, 8.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		modelRenderers[0].texOffs(0, 3).addBox(-10.0F, -7.0F, 7.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		ImmutableList.Builder<ModelRenderer> builder = ImmutableList.builder();
		builder.addAll(Arrays.asList(modelRenderers));
		this.parts = builder.build();
	}

	public ImmutableList<ModelRenderer> parts() {
		return this.parts;
	}

	@Override
	public void setupAnim(PogoEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

	}

	@Override
	public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {

	}
}