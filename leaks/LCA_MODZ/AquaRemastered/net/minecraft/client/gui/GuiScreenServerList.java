package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;

public class GuiScreenServerList extends GuiScreen {
   private final GuiScreen field_146303_a;
   private final ServerData field_146301_f;
   private GuiTextField field_146302_g;

   public GuiScreenServerList(GuiScreen p_i1031_1_, ServerData p_i1031_2_) {
      this.field_146303_a = p_i1031_1_;
      this.field_146301_f = p_i1031_2_;
   }

   @Override
   public void updateScreen() {
      this.field_146302_g.updateCursorCounter();
   }

   @Override
   public void initGui() {
      Keyboard.enableRepeatEvents(true);
      this.buttonList.clear();
      this.buttonList.add(new GuiButton(0, width / 2 - 100, height / 4 + 96 + 12, I18n.format("selectServer.select")));
      this.buttonList.add(new GuiButton(1, width / 2 - 100, height / 4 + 120 + 12, I18n.format("gui.cancel")));
      this.field_146302_g = new GuiTextField(2, this.fontRendererObj, width / 2 - 100, 116, 200, 20);
      this.field_146302_g.setMaxStringLength(128);
      this.field_146302_g.setFocused(true);
      this.field_146302_g.setText(this.mc.gameSettings.lastServer);
      this.buttonList.get(0).enabled = this.field_146302_g.getText().length() > 0 && this.field_146302_g.getText().split(":").length > 0;
   }

   @Override
   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
      this.mc.gameSettings.lastServer = this.field_146302_g.getText();
      this.mc.gameSettings.saveOptions();
   }

   @Override
   protected void actionPerformed(GuiButton button) throws IOException {
      if (button.enabled) {
         if (button.id == 1) {
            this.field_146303_a.confirmClicked(false, 0);
         } else if (button.id == 0) {
            this.field_146301_f.serverIP = this.field_146302_g.getText();
            this.field_146303_a.confirmClicked(true, 0);
         }
      }
   }

   @Override
   protected void keyTyped(char typedChar, int keyCode) throws IOException {
      if (this.field_146302_g.textboxKeyTyped(typedChar, keyCode)) {
         this.buttonList.get(0).enabled = this.field_146302_g.getText().length() > 0 && this.field_146302_g.getText().split(":").length > 0;
      } else if (keyCode == 28 || keyCode == 156) {
         this.actionPerformed(this.buttonList.get(0));
      }
   }

   @Override
   protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
      super.mouseClicked(mouseX, mouseY, mouseButton);
      this.field_146302_g.mouseClicked(mouseX, mouseY, mouseButton);
   }

   @Override
   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
      this.drawDefaultBackground();
      this.drawCenteredString(this.fontRendererObj, I18n.format("selectServer.direct"), width / 2, 20, 16777215);
      this.drawString(this.fontRendererObj, I18n.format("addServer.enterIp"), width / 2 - 100, 100, 10526880);
      this.field_146302_g.drawTextBox();
      super.drawScreen(mouseX, mouseY, partialTicks);
   }
}