package velizarbg.suggestion_tweaker;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(SuggestionTweaker.MODID)
public class SuggestionTweaker {
	public static final String MODID = "suggestion_tweaker";

	public SuggestionTweaker() {
		Constants.config = ModConfig.init();
		DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> SuggestionTweaker::registerConfigScreen);
	}

	private static void registerConfigScreen() {
		ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () -> new ConfigGuiHandler.ConfigGuiFactory((client, parent) ->
			AutoConfig.getConfigScreen(ModConfig.class, parent).get()
		));
	}
}
