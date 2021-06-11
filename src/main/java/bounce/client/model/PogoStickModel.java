package bounce.client.model;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import bounce.common.entity.PogoEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;

@OnlyIn(Dist.CLIENT)
public class PogoStickModel extends EntityModel<PogoEntity> {
	public final ModelRenderer root;

	public PogoStickModel() {
		root = new ModelRenderer(this, 0, 0).setTexSize(32,32);

		root.texOffs(11, 19).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		root.texOffs(12, 17).addBox(-2.0F, -4.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		root.texOffs(0, 0).addBox(-2.0F, -21.0F, -1.0F, 3.0F, 17.0F, 3.0F, 0.0F, false);
		root.texOffs(16, 4).addBox(1.0F, -20.0F, 0.0F, 1.0F, 12.0F, 1.0F, 0.0F, false);
		root.texOffs(12, 4).addBox(-3.0F, -20.0F, 0.0F, 1.0F, 12.0F, 1.0F, 0.0F, false);
		root.texOffs(12, 2).addBox(-4.0F, -5.0F, 0.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		root.texOffs(9, 0).addBox(-5.0F, -21.0F, 0.0F, 9.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(PogoEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

	}

	@Override
	public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
	    root.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
	}
}