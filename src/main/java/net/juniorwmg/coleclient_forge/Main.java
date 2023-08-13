package net.juniorwmg.coleclient_forge;

import net.juniorwmg.coleclient_forge.event.CustomEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid = Main.MOD_ID, name = "ColeClient", clientSideOnly = true)
public class Main {
    public static final String MOD_ID = "coleclient_forge";
    private static Configuration configuration;
    private static boolean userCapes;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {

        try {
            configuration = new Configuration(new File(event.getModConfigurationDirectory(), "coleclient.cfg"));
            configuration.load();
            userCapes = configuration.get("cosmetic", "User capes", true, "Give users their capes from OptiFine and MinecraftCapes (if available)").getBoolean();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (configuration.hasChanged())
                configuration.save();
        }

        MinecraftForge.EVENT_BUS.register(new CustomEventHandler());
        System.out.println("AMERICANS, LISTEN! YOUR CHOCOLATE IS REAAAAAALLY BAD!");
    }

    public static boolean isUserCapes() {
        return userCapes;
    }
}
