package drr.enrichment.lei.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.enrichment.lei.LeiData;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(API_GetLeiData.API_GetLeiDataDefault.class)
public abstract class API_GetLeiData implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param lei 
	* @return leiData 
	*/
	public LeiData evaluate(String lei) {
		LeiData.LeiDataBuilder leiDataBuilder = doEvaluate(lei);
		
		final LeiData leiData;
		if (leiDataBuilder == null) {
			leiData = null;
		} else {
			leiData = leiDataBuilder.build();
			objectValidator.validate(LeiData.class, leiData);
		}
		
		return leiData;
	}

	protected abstract LeiData.LeiDataBuilder doEvaluate(String lei);

	public static class API_GetLeiDataDefault extends API_GetLeiData {
		@Override
		protected LeiData.LeiDataBuilder doEvaluate(String lei) {
			LeiData.LeiDataBuilder leiData = LeiData.builder();
			return assignOutput(leiData, lei);
		}
		
		protected LeiData.LeiDataBuilder assignOutput(LeiData.LeiDataBuilder leiData, String lei) {
			return Optional.ofNullable(leiData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
