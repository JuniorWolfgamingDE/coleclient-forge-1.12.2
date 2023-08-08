package net.juniorwmg.coleclient_forge.gui;

import net.minecraft.client.gui.GuiScreen;

public class GuiOptifine extends GuiScreen {
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "DO NOT USE OPTIFINE!" +
                "OptiFine is not supported and may break functionality and compatibility." +
                "Only proceed if you know what you're doing!" +
                "You will not receive ANY support." +
                "Proceed by pressing [ESC].", this.width / 2, this.height / 2, 0xFFFFFF);
    }
}

