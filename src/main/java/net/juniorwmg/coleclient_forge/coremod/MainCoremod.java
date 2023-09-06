package net.juniorwmg.coleclient_forge.coremod;

import net.juniorwmg.coleclient_forge.Main;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.SortingIndex(1001) // Ensure the Coremod runs after Forge's initialization
@IFMLLoadingPlugin.Name("ColeClient (Core)")
@Mod(modid = Main.MOD_ID + "_core", version = "CORE.")
public class MainCoremod implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
