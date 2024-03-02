package net.juniorwmg.coleclient_forge.gui;

import net.minecraft.client.gui.*;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;

import java.io.IOException;

public class GuiMainMenuCC extends GuiScreen {

    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, 10, 20, "Singleplayer"));
        this.buttonList.add(new GuiButton(1, 40, 20, "Multiplayer"));
        this.buttonList.add(new GuiButton(2, 70, 20, "Options"));
        this.buttonList.add(new GuiButton(3, 100, 20, "Quit Game"));
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // mc.getTextureManager().bindTexture(new ResourceLocation("coleclient_forge", "gui/title/mojang.png"));
        this.drawDefaultBackground();
        // this.drawTexturedModalRect(0, 0, 0, 0, this.width, this.height);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if(button.id == 0) {
            mc.displayGuiScreen(new GuiWorldSelection(this));
        }
        if(button.id == 1) {
            mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        if(button.id == 2) {
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        }
        if(button.id == 3) {
            mc.shutdown();
        }
    }

    /* @Override
    public void handleInput() throws IOException {
        super.handleInput();

        // Check if the ESC key is pressed
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            mc.shutdown();
        }
    } */

}
