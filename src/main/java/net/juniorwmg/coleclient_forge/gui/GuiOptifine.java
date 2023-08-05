package net.juniorwmg.coleclient_forge.gui;

// import the necessary classes
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

// create a custom GUI class that extends GuiScreen
public class GuiOptifine extends GuiScreen {
    // override the drawScreen method to display some text
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        // draw a string at the center of the screen
        this.drawCenteredString(this.fontRenderer, "DO NOT USE OPTIFINE!", this.width / 2, this.height / 2, 0xFFFFFF);
    }
}

