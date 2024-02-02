package io.github.andyjay24.stalinium_mod.mixin;

import io.github.andyjay24.stalinium_mod.StaliniumMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class StaliniumModMixin {
	@Inject(method = "init", at = @At("TAIL"))
	public void onInit(CallbackInfo ci) {
		StaliniumMod.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
