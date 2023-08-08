package net.juniorwmg.coleclient_forge.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

public class GuiOptifine extends GuiScreen {
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "\u00A7c\u00A7lDO NOT USE OPTIFINE!", this.width / 2, this.height / 7, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "OptiFine is not supported and may break functionality and compatibility.", this.width / 2, this.height / 5, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "Only proceed if you know what you're doing! You will NOT receive ANY support.", this.width / 2, this.height / 4, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "Proceed by pressing [ESC].", this.width / 2, this.height / 2, 0xFFFFFF);

    }
}

