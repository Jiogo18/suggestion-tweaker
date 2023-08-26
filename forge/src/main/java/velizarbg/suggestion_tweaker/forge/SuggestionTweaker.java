package velizarbg.suggestion_tweaker.forge;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import velizarbg.suggestion_tweaker.Constants;
import velizarbg.suggestion_tweaker.ModConfig;

@Mod(SuggestionTweaker.MODID)
public class SuggestionTweaker {
	public static final String MODID = "suggestion_tweaker";

	public SuggestionTweaker() {
		Constants.config = ModConfig.init();

		// register config screen
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, () -> ((client, parent) ->
		AutoConfig.getConfigScreen(ModConfig.class, parent).get()
		));
	}
}
