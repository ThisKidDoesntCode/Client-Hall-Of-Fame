package net.minecraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class Barrier extends EntityFX {
   protected Barrier(World worldIn, double p_i46286_2_, double p_i46286_4_, double p_i46286_6_, Item p_i46286_8_) {
      super(worldIn, p_i46286_2_, p_i46286_4_, p_i46286_6_, 0.0, 0.0, 0.0);
      this.setParticleIcon(Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(p_i46286_8_));
      this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
      this.motionX = this.motionY = this.motionZ = 0.0;
      this.particleGravity = 0.0F;
      this.particleMaxAge = 80;
   }

   @Override
   public int getFXLayer() {
      return 1;
   }

   @Override
   public void renderParticle(
      WorldRenderer worldRendererIn,
      Entity entityIn,
      float partialTicks,
      float p_180434_4_,
      float p_180434_5_,
      float p_180434_6_,
      float p_180434_7_,
      float p_180434_8_
   ) {
      float f = this.particleIcon.getMinU();
      float f1 = this.particleIcon.getMaxU();
      float f2 = this.particleIcon.getMinV();
      float f3 = this.particleIcon.getMaxV();
      float f4 = 0.5F;
      float f5 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)partialTicks - interpPosX);
      float f6 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)partialTicks - interpPosY);
      float f7 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)partialTicks - interpPosZ);
      int i = this.getBrightnessForRender(partialTicks);
      int j = i >> 16 & 65535;
      int k = i & 65535;
      worldRendererIn.func_181662_b(
            (double)(f5 - p_180434_4_ * 0.5F - p_180434_7_ * 0.5F), (double)(f6 - p_180434_5_ * 0.5F), (double)(f7 - p_180434_6_ * 0.5F - p_180434_8_ * 0.5F)
         )
         .func_181673_a((double)f1, (double)f3)
         .func_181666_a(this.particleRed, this.particleGreen, this.particleBlue, 1.0F)
         .func_181671_a(j, k)
         .func_181675_d();
      worldRendererIn.func_181662_b(
            (double)(f5 - p_180434_4_ * 0.5F + p_180434_7_ * 0.5F), (double)(f6 + p_180434_5_ * 0.5F), (double)(f7 - p_180434_6_ * 0.5F + p_180434_8_ * 0.5F)
         )
         .func_181673_a((double)f1, (double)f2)
         .func_181666_a(this.particleRed, this.particleGreen, this.particleBlue, 1.0F)
         .func_181671_a(j, k)
         .func_181675_d();
      worldRendererIn.func_181662_b(
            (double)(f5 + p_180434_4_ * 0.5F + p_180434_7_ * 0.5F), (double)(f6 + p_180434_5_ * 0.5F), (double)(f7 + p_180434_6_ * 0.5F + p_180434_8_ * 0.5F)
         )
         .func_181673_a((double)f, (double)f2)
         .func_181666_a(this.particleRed, this.particleGreen, this.particleBlue, 1.0F)
         .func_181671_a(j, k)
         .func_181675_d();
      worldRendererIn.func_181662_b(
            (double)(f5 + p_180434_4_ * 0.5F - p_180434_7_ * 0.5F), (double)(f6 - p_180434_5_ * 0.5F), (double)(f7 + p_180434_6_ * 0.5F - p_180434_8_ * 0.5F)
         )
         .func_181673_a((double)f, (double)f3)
         .func_181666_a(this.particleRed, this.particleGreen, this.particleBlue, 1.0F)
         .func_181671_a(j, k)
         .func_181675_d();
   }

   public static class Factory implements IParticleFactory {
      @Override
      public EntityFX getEntityFX(
         int particleID,
         World worldIn,
         double xCoordIn,
         double yCoordIn,
         double zCoordIn,
         double xSpeedIn,
         double ySpeedIn,
         double zSpeedIn,
         int... p_178902_15_
      ) {
         return new Barrier(worldIn, xCoordIn, yCoordIn, zCoordIn, Item.getItemFromBlock(Blocks.barrier));
      }
   }
}
