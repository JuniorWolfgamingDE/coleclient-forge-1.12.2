package net.juniorwmg.coleclient_forge.coremod;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.Name("ClientCore")
@IFMLLoadingPlugin.TransformerExclusions("net.juniorwmg.coleclient_forge.coremod")
@IFMLLoadingPlugin.SortingIndex(1001)
public class MainCoremod implements IFMLLoadingPlugin {

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"net.juniorwmg.coleclient_forge.coremod.ClassTransformer"};
    }

    @Override
    public String getModContainerClass() {return null;}

    @Nullable
    @Override
    public String getSetupClass() {return null;}

    @Override
    public void injectData(Map<String, Object> data) {}

    @Override
    public String getAccessTransformerClass() {return null;}
}