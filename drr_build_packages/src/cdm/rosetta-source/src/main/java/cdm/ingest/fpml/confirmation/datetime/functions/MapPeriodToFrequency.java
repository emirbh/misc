package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.Frequency;
import cdm.base.datetime.PeriodExtendedEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.shared.Period;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPeriodToFrequency.MapPeriodToFrequencyDefault.class)
public abstract class MapPeriodToFrequency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlPeriod 
	* @return frequency 
	*/
	public Frequency evaluate(Period fpmlPeriod) {
		Frequency.FrequencyBuilder frequencyBuilder = doEvaluate(fpmlPeriod);
		
		final Frequency frequency;
		if (frequencyBuilder == null) {
			frequency = null;
		} else {
			frequency = frequencyBuilder.build();
			objectValidator.validate(Frequency.class, frequency);
		}
		
		return frequency;
	}

	protected abstract Frequency.FrequencyBuilder doEvaluate(Period fpmlPeriod);

	public static class MapPeriodToFrequencyDefault extends MapPeriodToFrequency {
		@Override
		protected Frequency.FrequencyBuilder doEvaluate(Period fpmlPeriod) {
			Frequency.FrequencyBuilder frequency = Frequency.builder();
			return assignOutput(frequency, fpmlPeriod);
		}
		
		protected Frequency.FrequencyBuilder assignOutput(Frequency.FrequencyBuilder frequency, Period fpmlPeriod) {
			frequency = toBuilder(Frequency.builder()
				.setPeriodMultiplier(MapperS.of(fpmlPeriod).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier()).get())
				.setPeriod(MapperS.of(fpmlPeriod).<PeriodEnum>map("getPeriod", period -> period.getPeriod()).checkedMap("to-enum", e -> PeriodExtendedEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.build());
			
			return Optional.ofNullable(frequency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
