/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import java.util.Random;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderEntityItem
extends Render<EntityItem> {
    private final RenderItem itemRenderer;
    private Random field_177079_e = new Random();

    public RenderEntityItem(RenderManager renderManagerIn, RenderItem p_i46167_2_) {
        super(renderManagerIn);
        this.itemRenderer = p_i46167_2_;
        this.shadowSize = 0.15f;
        this.shadowOpaque = 0.75f;
    }

    private int func_177077_a(EntityItem itemIn, double p_177077_2_, double p_177077_4_, double p_177077_6_, float p_177077_8_, IBakedModel p_177077_9_) {
        ItemStack itemstack = itemIn.getEntityItem();
        Item item = itemstack.getItem();
        if (item == null) {
            return 0;
        }
        boolean flag = p_177077_9_.isGui3d();
        int i = this.func_177078_a(itemstack);
        float f = 0.25f;
        float f1 = MathHelper.sin(((float)itemIn.getAge() + p_177077_8_) / 10.0f + itemIn.hoverStart) * 0.1f + 0.1f;
        float f2 = p_177077_9_.getItemCameraTransforms().func_181688_b((ItemCameraTransforms.TransformType)ItemCameraTransforms.TransformType.GROUND).scale.y;
        GlStateManager.translate((float)p_177077_2_, (float)p_177077_4_ + f1 + 0.25f * f2, (float)p_177077_6_);
        if (flag || this.renderManager.options != null) {
            float f3 = (((float)itemIn.getAge() + p_177077_8_) / 20.0f + itemIn.hoverStart) * 57.295776f;
            GlStateManager.rotate(f3, 0.0f, 1.0f, 0.0f);
        }
        if (!flag) {
            float f6 = -0.0f * (float)(i - 1) * 0.5f;
            float f4 = -0.0f * (float)(i - 1) * 0.5f;
            float f5 = -0.046875f * (float)(i - 1) * 0.5f;
            GlStateManager.translate(f6, f4, f5);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        return i;
    }

    private int func_177078_a(ItemStack stack) {
        int i = 1;
        if (stack.stackSize > 48) {
            i = 5;
        } else if (stack.stackSize > 32) {
            i = 4;
        } else if (stack.stackSize > 16) {
            i = 3;
        } else if (stack.stackSize > 1) {
            i = 2;
        }
        return i;
    }

    @Override
    public void doRender(EntityItem entity, double x, double y, double z, float entityYaw, float partialTicks) {
        ItemStack itemstack = entity.getEntityItem();
        this.field_177079_e.setSeed(187L);
        boolean flag = false;
        if (this.bindEntityTexture(entity)) {
            this.renderManager.renderEngine.getTexture(this.getEntityTexture(entity)).setBlurMipmap(false, false);
            flag = true;
        }
        GlStateManager.enableRescaleNormal();
        GlStateManager.alphaFunc(516, 0.1f);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.pushMatrix();
        IBakedModel ibakedmodel = this.itemRenderer.getItemModelMesher().getItemModel(itemstack);
        int i = this.func_177077_a(entity, x, y, z, partialTicks, ibakedmodel);
        for (int j = 0; j < i; ++j) {
            if (ibakedmodel.isGui3d()) {
                GlStateManager.pushMatrix();
                if (j > 0) {
                    float f = (this.field_177079_e.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    float f1 = (this.field_177079_e.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    float f2 = (this.field_177079_e.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    GlStateManager.translate(f, f1, f2);
                }
                GlStateManager.scale(0.5f, 0.5f, 0.5f);
                ibakedmodel.getItemCameraTransforms().func_181689_a(ItemCameraTransforms.TransformType.GROUND);
                this.itemRenderer.renderItem(itemstack, ibakedmodel);
                GlStateManager.popMatrix();
                continue;
            }
            GlStateManager.pushMatrix();
            ibakedmodel.getItemCameraTransforms().func_181689_a(ItemCameraTransforms.TransformType.GROUND);
            this.itemRenderer.renderItem(itemstack, ibakedmodel);
            GlStateManager.popMatrix();
            float f3 = ibakedmodel.getItemCameraTransforms().field_181699_o.scale.x;
            float f4 = ibakedmodel.getItemCameraTransforms().field_181699_o.scale.y;
            float f5 = ibakedmodel.getItemCameraTransforms().field_181699_o.scale.z;
            GlStateManager.translate(0.0f * f3, 0.0f * f4, 0.046875f * f5);
        }
        GlStateManager.popMatrix();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
        this.bindEntityTexture(entity);
        if (flag) {
            this.renderManager.renderEngine.getTexture(this.getEntityTexture(entity)).restoreLastBlurMipmap();
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityItem entity) {
        return TextureMap.locationBlocksTexture;
    }
}

