package net.juniorwmg.coleclient_forge.mixin;

import net.juniorwmg.coleclient_forge.gui.GuiMainMenuCC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.logging.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.PixelFormat;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@Mixin(value = Minecraft.class, priority = 9999)
public abstract class MixinMinecraft {

    @Final
    @Shadow
    private static Logger LOGGER;

    @Shadow
    private boolean fullscreen;

    /**
     * @author JuniorWMG
     * @reason Change window name
     */
    @Overwrite
    private void createDisplay() throws LWJGLException {
        Display.setResizable(true);
        Display.setTitle("Minecraft 1.12.2 - Powered by ColeClient");
        try {
            Display.create((new PixelFormat()).withDepthBits(24));
        } catch (LWJGLException lwjglexception) {
            LOGGER.error("Couldn't set pixel format", lwjglexception);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException ignored) {
            }
            if (this.fullscreen) {
                this.updateDisplayMode();
            }
            Display.create();
        }
    }

    @Shadow
    private void updateDisplayMode() {
    }

    @Shadow
    private ByteBuffer readImageToBuffer(InputStream imageStream) throws IOException
    {
        return null;
    }

    /**
     * @author JuniorWMG
     * @reason Replace window icon
     */
    @Overwrite
    private void setWindowIcon()
    {
        Util.EnumOS util$enumos = Util.getOSType();

        if (util$enumos != Util.EnumOS.OSX)
        {
            InputStream inputstream = null;
            InputStream inputstream1 = null;

            try
            {
                inputstream = this.getClass().getResourceAsStream("/assets/wmg/icons/icon16.png");
                inputstream1 = this.getClass().getResourceAsStream("/assets/wmg/icons/icon32.png");

                if (inputstream != null && inputstream1 != null)
                {
                    Display.setIcon(new ByteBuffer[] {this.readImageToBuffer(inputstream), this.readImageToBuffer(inputstream1)});
                    LOGGER.info("Icon set");
                }
            }
            catch (IOException ioexception)
            {
                LOGGER.error("Couldn't set icon", (Throwable)ioexception);
            }
            finally
            {
                IOUtils.closeQuietly(inputstream);
                IOUtils.closeQuietly(inputstream1);
            }
        }
    }
}
