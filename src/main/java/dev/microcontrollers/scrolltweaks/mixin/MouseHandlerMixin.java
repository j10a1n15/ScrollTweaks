package dev.microcontrollers.scrolltweaks.mixin;

import dev.microcontrollers.scrolltweaks.config.ScrollTweaksConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
    // mojmap... what is swapPaint...
    @ModifyArg(method = "onScroll", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;swapPaint(D)V"), index = 0)
    private double modifyScroll(double direction) {
        if (ScrollTweaksConfig.CONFIG.instance().disableScroll) return 0;
        assert Minecraft.getInstance().player != null;
        int slot = Minecraft.getInstance().player.getInventory().selected;
        if (ScrollTweaksConfig.CONFIG.instance().reverseScroll) direction = -direction;
        if (ScrollTweaksConfig.CONFIG.instance().preventOverflowScroll && ((slot == 8 && direction < 0) || (slot == 0 && direction > 0)))
            return 0;
        return direction;
    }
}
