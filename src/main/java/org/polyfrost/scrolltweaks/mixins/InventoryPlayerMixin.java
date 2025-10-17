package org.polyfrost.scrolltweaks.mixins;

import net.minecraft.entity.player.InventoryPlayer;
import org.polyfrost.scrolltweaks.ScrollTweaks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryPlayer.class)
public class InventoryPlayerMixin {
    @Shadow
    public int currentItem;

    @Inject(method = "changeCurrentItem", at = @At("HEAD"), cancellable = true)
    private void scrolltweaks$cancelScrolling(int direction, CallbackInfo ci) {
        if (ScrollTweaks.config.disableHotbarScrolling) {
            ci.cancel();
        }
    }

    @Inject(method = "changeCurrentItem", at = @At(value = "HEAD", shift = At.Shift.AFTER))
    private void scrolltweaks$invertScrolling(int direction, CallbackInfo ci) {
        if (ScrollTweaks.config.invertHotbarScrolling) {
            int dir;
            if (direction < 0) {
                dir = -2;
            } else {
                dir = 2;
            }
            this.currentItem += dir;
        }
    }

    @ModifyConstant(method = "changeCurrentItem", constant = {@Constant(intValue = 9, ordinal = 0), @Constant(intValue = 9, ordinal = 2)})
    private int scrolltweaks$preventOverflowScrolling(int constant) {
        if (ScrollTweaks.config.preventOverflowHotbarScrolling) {
            return 1;
        }

        return constant;
    }
}
