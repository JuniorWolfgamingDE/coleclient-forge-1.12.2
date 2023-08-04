package net.juniorwmg.coleclient_forge;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "coleclient_forge";

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        System.out.println("AMERICANS, LISTEN! YOUR CHOCOLATE IS REAAAAAALLY BAD!");
    }
}
