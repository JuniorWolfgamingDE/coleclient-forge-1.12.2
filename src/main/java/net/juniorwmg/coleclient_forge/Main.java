package net.juniorwmg.coleclient_forge;

import net.juniorwmg.coleclient_forge.event.CustomEventHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MOD_ID, name = "ColeClient")
public class Main {
    public static final String MOD_ID = "coleclient_forge";

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        System.out.println("AMERICANS, LISTEN! YOUR CHOCOLATE IS REAAAAAALLY BAD!");
        MinecraftForge.EVENT_BUS.register(new CustomEventHandler());
    }
}
