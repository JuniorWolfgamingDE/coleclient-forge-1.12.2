package net.juniorwmg.coleclient_forge.mixin;

import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ICrashReportDetail;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CrashReport.class)
public class MixinCrashReport {

    //TODO: Fix issues with class
    @Final
    @Shadow
    private CrashReportCategory systemDetailsCategory;

    @Inject(method = "populateEnvironment", at = @At("RETURN"))
    private void injectCrashReport(CallbackInfo ci) {
        this.systemDetailsCategory.addDetail("Launcher", new ICrashReportDetail<String>()
        {
            public String call()
            {
                return System.getProperty("launcherName");
            }
        });
    }
}