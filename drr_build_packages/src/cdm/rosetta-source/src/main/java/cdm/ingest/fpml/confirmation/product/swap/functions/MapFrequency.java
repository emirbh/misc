package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.datetime.Frequency;
import cdm.ingest.fpml.confirmation.other.functions.MapPeriodExtendedEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.PeriodExtendedEnum;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFrequency.MapFrequencyDefault.class)
public abstract class MapFrequency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriodExtendedEnum mapPeriodExtendedEnum;

	/**
	* @param fpmlFrequency 
	* @return frequency 
	*/
	public Frequency evaluate(fpml.consolidated.shared.Frequency fpmlFrequency) {
		Frequency.FrequencyBuilder frequencyBuilder = doEvaluate(fpmlFrequency);
		
		final Frequency frequency;
		if (frequencyBuilder == null) {
			frequency = null;
		} else {
			frequency = frequencyBuilder.build();
			objectValidator.validate(Frequency.class, frequency);
		}
		
		return frequency;
	}

	protected abstract Frequency.FrequencyBuilder doEvaluate(fpml.consolidated.shared.Frequency fpmlFrequency);

	public static class MapFrequencyDefault extends MapFrequency {
		@Override
		protected Frequency.FrequencyBuilder doEvaluate(fpml.consolidated.shared.Frequency fpmlFrequency) {
			Frequency.FrequencyBuilder frequency = Frequency.builder();
			return assignOutput(frequency, fpmlFrequency);
		}
		
		protected Frequency.FrequencyBuilder assignOutput(Frequency.FrequencyBuilder frequency, fpml.consolidated.shared.Frequency fpmlFrequency) {
			frequency = toBuilder(Frequency.builder()
				.setPeriodMultiplier(MapperS.of(fpmlFrequency).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).get())
				.setPeriod(mapPeriodExtendedEnum.evaluate(MapperS.of(fpmlFrequency).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()).map("to-string", PeriodExtendedEnum::toDisplayString).get()))
				.build());
			
			return Optional.ofNullable(frequency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
