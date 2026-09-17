package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.ingest.fpml.confirmation.other.functions.MapPeriodExtendedEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.PeriodExtendedEnum;
import fpml.consolidated.fpmlenum.RollConventionEnum;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCalculationPeriodFrequency.MapCalculationPeriodFrequencyDefault.class)
public abstract class MapCalculationPeriodFrequency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriodExtendedEnum mapPeriodExtendedEnum;

	/**
	* @param fpmlCalculationPeriodFrequency 
	* @return calculationPeriodFrequency 
	*/
	public CalculationPeriodFrequency evaluate(fpml.consolidated.shared.CalculationPeriodFrequency fpmlCalculationPeriodFrequency) {
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequencyBuilder = doEvaluate(fpmlCalculationPeriodFrequency);
		
		final CalculationPeriodFrequency calculationPeriodFrequency;
		if (calculationPeriodFrequencyBuilder == null) {
			calculationPeriodFrequency = null;
		} else {
			calculationPeriodFrequency = calculationPeriodFrequencyBuilder.build();
			objectValidator.validate(CalculationPeriodFrequency.class, calculationPeriodFrequency);
		}
		
		return calculationPeriodFrequency;
	}

	protected abstract CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder doEvaluate(fpml.consolidated.shared.CalculationPeriodFrequency fpmlCalculationPeriodFrequency);

	public static class MapCalculationPeriodFrequencyDefault extends MapCalculationPeriodFrequency {
		@Override
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder doEvaluate(fpml.consolidated.shared.CalculationPeriodFrequency fpmlCalculationPeriodFrequency) {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency = CalculationPeriodFrequency.builder();
			return assignOutput(calculationPeriodFrequency, fpmlCalculationPeriodFrequency);
		}
		
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder assignOutput(CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency, fpml.consolidated.shared.CalculationPeriodFrequency fpmlCalculationPeriodFrequency) {
			calculationPeriodFrequency = toBuilder(CalculationPeriodFrequency.builder()
				.setPeriodMultiplier(MapperS.of(fpmlCalculationPeriodFrequency).<Integer>map("getPeriodMultiplier", _calculationPeriodFrequency -> _calculationPeriodFrequency.getPeriodMultiplier()).get())
				.setPeriod(mapPeriodExtendedEnum.evaluate(MapperS.of(fpmlCalculationPeriodFrequency).<PeriodExtendedEnum>map("getPeriod", _calculationPeriodFrequency -> _calculationPeriodFrequency.getPeriod()).map("to-string", PeriodExtendedEnum::toDisplayString).get()))
				.setRollConvention(MapperS.of(fpmlCalculationPeriodFrequency).<RollConventionEnum>map("getRollConvention", _calculationPeriodFrequency -> _calculationPeriodFrequency.getRollConvention()).checkedMap("to-enum", e -> cdm.base.datetime.RollConventionEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.build());
			
			return Optional.ofNullable(calculationPeriodFrequency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
