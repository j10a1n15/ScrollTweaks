package org.polyfrost.scrolltweaks.config;

import org.polyfrost.scrolltweaks.ScrollTweaks;
import org.polyfrost.oneconfig.api.config.v1.Config;
import org.polyfrost.oneconfig.api.config.v1.annotations.Switch;

public class ScrollTweaksConfig extends Config {
    public ScrollTweaksConfig() {
        super(ScrollTweaks.ID + ".json", ScrollTweaks.NAME, Category.QOL);

        loadFrom("patcher.toml");
    }


    @Switch(
        title = "Disable Hotbar Scrolling",
        description = "Remove the ability to scroll through your hotbar."
    )
    public boolean disableHotbarScrolling;

    @Switch(
        title = "Invert Hotbar Scrolling",
        description = "Change the direction of scrolling in your hotbar."
    )
    public boolean invertHotbarScrolling;

    @Switch(
        title = "Prevent Overflow Hotbar Scrolling",
        description = "Prevent from directly scrolling between the first and last hotbar slot."
    )
    public boolean preventOverflowHotbarScrolling;
}
