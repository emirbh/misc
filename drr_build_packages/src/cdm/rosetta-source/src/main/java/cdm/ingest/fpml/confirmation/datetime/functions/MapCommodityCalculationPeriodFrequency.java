package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.ingest.fpml.confirmation.other.functions.MapPeriodExtendedEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.fpmlenum.PeriodExtendedEnum;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityCalculationPeriodFrequency.MapCommodityCalculationPeriodFrequencyDefault.class)
public abstract class MapCommodityCalculationPeriodFrequency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriodExtendedEnum mapPeriodExtendedEnum;

	/**
	* @param fpmlCalculationPeriodsSchedule 
	* @return calculationPeriodFrequency 
	*/
	public CalculationPeriodFrequency evaluate(CommodityCalculationPeriodsSchedule fpmlCalculationPeriodsSchedule) {
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequencyBuilder = doEvaluate(fpmlCalculationPeriodsSchedule);
		
		final CalculationPeriodFrequency calculationPeriodFrequency;
		if (calculationPeriodFrequencyBuilder == null) {
			calculationPeriodFrequency = null;
		} else {
			calculationPeriodFrequency = calculationPeriodFrequencyBuilder.build();
			objectValidator.validate(CalculationPeriodFrequency.class, calculationPeriodFrequency);
		}
		
		return calculationPeriodFrequency;
	}

	protected abstract CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder doEvaluate(CommodityCalculationPeriodsSchedule fpmlCalculationPeriodsSchedule);

	public static class MapCommodityCalculationPeriodFrequencyDefault extends MapCommodityCalculationPeriodFrequency {
		@Override
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder doEvaluate(CommodityCalculationPeriodsSchedule fpmlCalculationPeriodsSchedule) {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency = CalculationPeriodFrequency.builder();
			return assignOutput(calculationPeriodFrequency, fpmlCalculationPeriodsSchedule);
		}
		
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder assignOutput(CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency, CommodityCalculationPeriodsSchedule fpmlCalculationPeriodsSchedule) {
			final CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder withMetaArgument = CalculationPeriodFrequency.builder()
				.setPeriod(mapPeriodExtendedEnum.evaluate(MapperS.of(fpmlCalculationPeriodsSchedule).<PeriodExtendedEnum>map("getPeriod", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getPeriod()).map("to-string", PeriodExtendedEnum::toDisplayString).get()))
				.setPeriodMultiplier(MapperS.of(fpmlCalculationPeriodsSchedule).<Integer>map("getPeriodMultiplier", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getPeriodMultiplier()).get())
				.setRollConvention(null)
				.setBalanceOfFirstPeriod(MapperS.of(fpmlCalculationPeriodsSchedule).<Boolean>map("getBalanceOfFirstPeriod", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getBalanceOfFirstPeriod()).get())
				.build() == null ? null : CalculationPeriodFrequency.builder()
				.setPeriod(mapPeriodExtendedEnum.evaluate(MapperS.of(fpmlCalculationPeriodsSchedule).<PeriodExtendedEnum>map("getPeriod", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getPeriod()).map("to-string", PeriodExtendedEnum::toDisplayString).get()))
				.setPeriodMultiplier(MapperS.of(fpmlCalculationPeriodsSchedule).<Integer>map("getPeriodMultiplier", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getPeriodMultiplier()).get())
				.setRollConvention(null)
				.setBalanceOfFirstPeriod(MapperS.of(fpmlCalculationPeriodsSchedule).<Boolean>map("getBalanceOfFirstPeriod", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getBalanceOfFirstPeriod()).get())
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlCalculationPeriodsSchedule).<String>map("getId", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getId()).get());
			calculationPeriodFrequency = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(calculationPeriodFrequency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
