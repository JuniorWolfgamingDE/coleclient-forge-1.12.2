package net.juniorwmg.coleclient_forge.event;

import net.juniorwmg.coleclient_forge.gui.GuiOptifine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
public class CustomEventHandler {
    private boolean guiShown = false;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        // check if the game is in the main menu and the GUI has not been shown yet
        if (Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu && !guiShown) {
            // check if OptiFine is loaded using the Loader.isModLoaded method
            if (Loader.isModLoaded("optifine")) {
                // create an instance of the custom GUI class
                GuiOptifine guiOptifine = new GuiOptifine();
                // display the custom GUI on the screen
                Minecraft.getMinecraft().displayGuiScreen(guiOptifine);
                // set the flag to true to prevent showing the GUI again
                guiShown = true;
            }
        }
    }
}
