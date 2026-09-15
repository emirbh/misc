package drr.standards.iso.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.standards.iso.MicData;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(API_GetMicData.API_GetMicDataDefault.class)
public abstract class API_GetMicData implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param mic 
	* @return micData 
	*/
	public MicData evaluate(String mic) {
		MicData.MicDataBuilder micDataBuilder = doEvaluate(mic);
		
		final MicData micData;
		if (micDataBuilder == null) {
			micData = null;
		} else {
			micData = micDataBuilder.build();
			objectValidator.validate(MicData.class, micData);
		}
		
		return micData;
	}

	protected abstract MicData.MicDataBuilder doEvaluate(String mic);

	public static class API_GetMicDataDefault extends API_GetMicData {
		@Override
		protected MicData.MicDataBuilder doEvaluate(String mic) {
			MicData.MicDataBuilder micData = MicData.builder();
			return assignOutput(micData, mic);
		}
		
		protected MicData.MicDataBuilder assignOutput(MicData.MicDataBuilder micData, String mic) {
			return Optional.ofNullable(micData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
