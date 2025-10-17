package org.polyfrost.scrolltweaks;

//#if FABRIC
//$$ import net.fabricmc.api.ModInitializer;
//#elseif FORGE
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
//#endif

import org.polyfrost.scrolltweaks.config.ScrollTweaksConfig;

//#if FORGE-LIKE
@Mod(modid = ScrollTweaks.ID, name = ScrollTweaks.NAME, version = ScrollTweaks.VERSION)
//#endif
public class ScrollTweaks
    //#if FABRIC
    //$$ implements ModInitializer
    //#endif
{
    public static final String ID = "@MOD_ID@";
    public static final String NAME = "@MOD_NAME@";
    public static final String VERSION = "@MOD_VERSION@";

    public static ScrollTweaksConfig config;

    //#if FABRIC
    //$$ @Override
    //#elseif FORGE
    @Mod.EventHandler
    //#endif
    public void onInitialize(
        //#if FORGE
        FMLInitializationEvent event
        //#endif
    ) {
        config = new ScrollTweaksConfig();
    }
}
