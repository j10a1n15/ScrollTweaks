package dev.microcontrollers.scrolltweaks.config;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.platform.YACLPlatform;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ScrollTweaksConfig {
    public static final ConfigClassHandler<ScrollTweaksConfig> CONFIG = ConfigClassHandler.createBuilder(ScrollTweaksConfig.class)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(YACLPlatform.getConfigDir().resolve("${id}.json"))
                    .build())
            .build();

    @SerialEntry public boolean disableScroll = false;
    @SerialEntry public boolean reverseScroll = false;
    @SerialEntry public boolean preventOverflowScroll = false;

    public static Screen configScreen(Screen parent) {
        return YetAnotherConfigLib.create(CONFIG, ((defaults, config, builder) -> builder
                .title(Component.translatable("scroll-tweaks.scroll-tweaks"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.translatable("scroll-tweaks.scroll-tweaks"))
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable("scroll-tweaks.disable-scrolling"))
                                .description(OptionDescription.of(Component.translatable("scroll-tweaks.disable-scrolling.description")))
                                .binding(defaults.disableScroll, () -> config.disableScroll, newVal -> config.disableScroll = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable("scroll-tweaks.reverse-scroll-direction"))
                                .description(OptionDescription.of(Component.translatable("scroll-tweaks.reverse-scroll-direction.description")))
                                .binding(defaults.reverseScroll, () -> config.reverseScroll, newVal -> config.reverseScroll = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable("scroll-tweaks.prevent-overflow-scrolling"))
                                .description(OptionDescription.of(Component.translatable("scroll-tweaks.prevent-overflow-scrolling.description")))
                                .binding(defaults.preventOverflowScroll, () -> config.preventOverflowScroll, newVal -> config.preventOverflowScroll = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .build()
                ))).generateScreen(parent);
    }

}
