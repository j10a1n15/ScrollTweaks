package dev.microcontrollers.scrolltweaks;

import dev.microcontrollers.scrolltweaks.config.ScrollTweaksConfig;
//? if fabric {
import net.fabricmc.api.ModInitializer;
//?}
//? if neoforge {
/*import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
*///?}

//? if neoforge
/*@Mod("scrolltweaks")*/
public class ScrollTweaks /*? if fabric {*/ implements ModInitializer /*?}*/ {
	//? if fabric {
	@Override
	public void onInitialize() {
		ScrollTweaksConfig.CONFIG.load();
	}
	//?}

	//? if neoforge {
    /*public ScrollTweaks(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, (modContainer, screen) -> ScrollTweaksConfig.configScreen(screen));
    }
	*///?}
}