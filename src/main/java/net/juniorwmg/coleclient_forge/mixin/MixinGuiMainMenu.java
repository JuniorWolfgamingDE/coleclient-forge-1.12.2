package net.juniorwmg.coleclient_forge.mixin;

import net.juniorwmg.coleclient_forge.gui.GuiMainMenuCC;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public abstract class MixinGuiMainMenu extends GuiScreen {

    @Inject(method = "drawScreen", at = @At("RETURN"))
    private void afterDrawScreen(int mouseX, int mouseY, float partialTicks, CallbackInfo info) {
        GuiScreen customGui = new GuiMainMenuCC();
        ((GuiMainMenu)(Object)this).mc.displayGuiScreen(customGui);
    }

    @Inject(method = "drawScreen", at = @At("RETURN"))
    private void coleDrawClientText(int p_73863_1_, int p_73863_2_, float p_73863_3_, CallbackInfo ci) {
        int widthCole = this.fontRenderer.getStringWidth("Using ColeClient.");
        int widthColeRest = this.width - widthCole - 2;
        this.drawString(this.fontRenderer, "§dUsing §5ColeClient§d.", widthColeRest, this.height - 20, -1);
    }

}
