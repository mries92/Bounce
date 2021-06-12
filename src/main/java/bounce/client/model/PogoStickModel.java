package bounce.client.model;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import bounce.common.entity.PogoEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PogoStickModel extends EntityModel<PogoEntity> {
	public final ModelRenderer root;
	private final ModelRenderer shaft;
	private final ModelRenderer base;
	private final ModelRenderer stand;
	private final ModelRenderer handle;

	public PogoStickModel() {
		this.texHeight = 64;
		this.texWidth = 64;

		root = new ModelRenderer(this);
		root.setPos(0.0F, 0.0F, 0.0F);
		root.texOffs(16, 26).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		shaft = new ModelRenderer(this);
		//shaft.setPos(0.0F, 0.0F, 0.0F);
		root.addChild(shaft);
		shaft.texOffs(12, 10).addBox(-1.0F, -29.0F, 1.0F, 1.0F, 20.0F, 1.0F, 0.0F, false);
		shaft.texOffs(8, 10).addBox(-1.0F, -29.0F, -1.0F, 1.0F, 20.0F, 1.0F, 0.0F, false);
		shaft.texOffs(0, 4).addBox(-2.0F, -29.0F, 0.0F, 3.0F, 20.0F, 1.0F, 0.0F, false);

		base = new ModelRenderer(this);
		//base.setPos(0.0F, 0.0F, 0.0F);
		root.addChild(base);
		base.texOffs(28, 8).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		base.texOffs(8, 6).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		base.texOffs(8, 4).addBox(-1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		stand = new ModelRenderer(this);
		//stand.setPos(0.0F, 0.0F, 0.0F);
		root.addChild(stand);
		stand.texOffs(8, 4).addBox(-3.0F, -9.0F, -2.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
		stand.texOffs(23, 4).addBox(-6.0F, -9.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		stand.texOffs(16, 22).addBox(2.0F, -9.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		stand.texOffs(16, 18).addBox(-3.0F, -8.0F, -1.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);

		handle = new ModelRenderer(this);
		handle.setPos(0.0F, 9.0F, 0.0F);
		root.addChild(handle);
		handle.texOffs(0, 2).addBox(-8.0F, -40.0F, 0.0F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		handle.texOffs(0, 0).addBox(-8.0F, -41.0F, 0.0F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		handle.texOffs(16, 14).addBox(-3.0F, -42.0F, -1.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		handle.texOffs(16, 10).addBox(-3.0F, -39.0F, -1.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		handle.texOffs(25, 23).addBox(1.0F, -41.0F, -1.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		handle.texOffs(0, 25).addBox(-3.0F, -41.0F, -1.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(PogoEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

	}

	@Override
	public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
	    root.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
	}
}