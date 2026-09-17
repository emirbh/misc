package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.PeriodExtendedEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.PeriodicPayment;
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.fpmlenum.RollConventionEnum;
import fpml.consolidated.shared.Period;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPeriodicPaymentToCalculationPeriodFrequency.MapPeriodicPaymentToCalculationPeriodFrequencyDefault.class)
public abstract class MapPeriodicPaymentToCalculationPeriodFrequency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlPeriodicPayment 
	* @return calculationPeriodFrequency 
	*/
	public CalculationPeriodFrequency evaluate(PeriodicPayment fpmlPeriodicPayment) {
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequencyBuilder = doEvaluate(fpmlPeriodicPayment);
		
		final CalculationPeriodFrequency calculationPeriodFrequency;
		if (calculationPeriodFrequencyBuilder == null) {
			calculationPeriodFrequency = null;
		} else {
			calculationPeriodFrequency = calculationPeriodFrequencyBuilder.build();
			objectValidator.validate(CalculationPeriodFrequency.class, calculationPeriodFrequency);
		}
		
		return calculationPeriodFrequency;
	}

	protected abstract CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder doEvaluate(PeriodicPayment fpmlPeriodicPayment);

	public static class MapPeriodicPaymentToCalculationPeriodFrequencyDefault extends MapPeriodicPaymentToCalculationPeriodFrequency {
		@Override
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder doEvaluate(PeriodicPayment fpmlPeriodicPayment) {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency = CalculationPeriodFrequency.builder();
			return assignOutput(calculationPeriodFrequency, fpmlPeriodicPayment);
		}
		
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder assignOutput(CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency, PeriodicPayment fpmlPeriodicPayment) {
			calculationPeriodFrequency = toBuilder(CalculationPeriodFrequency.builder()
				.setPeriodMultiplier(MapperS.of(fpmlPeriodicPayment).<Period>map("getPaymentFrequency", periodicPayment -> periodicPayment.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier()).get())
				.setPeriod(MapperS.of(fpmlPeriodicPayment).<Period>map("getPaymentFrequency", periodicPayment -> periodicPayment.getPaymentFrequency()).<PeriodEnum>map("getPeriod", period -> period.getPeriod()).checkedMap("to-enum", e -> PeriodExtendedEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setRollConvention(MapperS.of(fpmlPeriodicPayment).<RollConventionEnum>map("getRollConvention", periodicPayment -> periodicPayment.getRollConvention()).checkedMap("to-enum", e -> cdm.base.datetime.RollConventionEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.build());
			
			return Optional.ofNullable(calculationPeriodFrequency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
