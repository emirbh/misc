package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.CalculationPeriodFrequency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.fpmlenum.PeriodExtendedEnum;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityCalculationPeriodsScheduleToCalculationPeriodFrequency.MapCommodityCalculationPeriodsScheduleToCalculationPeriodFrequencyDefault.class)
public abstract class MapCommodityCalculationPeriodsScheduleToCalculationPeriodFrequency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommodityCalculationPeriodsSchedule 
	* @return calculationPeriodFrequency 
	*/
	public CalculationPeriodFrequency evaluate(CommodityCalculationPeriodsSchedule fpmlCommodityCalculationPeriodsSchedule) {
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequencyBuilder = doEvaluate(fpmlCommodityCalculationPeriodsSchedule);
		
		final CalculationPeriodFrequency calculationPeriodFrequency;
		if (calculationPeriodFrequencyBuilder == null) {
			calculationPeriodFrequency = null;
		} else {
			calculationPeriodFrequency = calculationPeriodFrequencyBuilder.build();
			objectValidator.validate(CalculationPeriodFrequency.class, calculationPeriodFrequency);
		}
		
		return calculationPeriodFrequency;
	}

	protected abstract CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder doEvaluate(CommodityCalculationPeriodsSchedule fpmlCommodityCalculationPeriodsSchedule);

	public static class MapCommodityCalculationPeriodsScheduleToCalculationPeriodFrequencyDefault extends MapCommodityCalculationPeriodsScheduleToCalculationPeriodFrequency {
		@Override
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder doEvaluate(CommodityCalculationPeriodsSchedule fpmlCommodityCalculationPeriodsSchedule) {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency = CalculationPeriodFrequency.builder();
			return assignOutput(calculationPeriodFrequency, fpmlCommodityCalculationPeriodsSchedule);
		}
		
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder assignOutput(CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency, CommodityCalculationPeriodsSchedule fpmlCommodityCalculationPeriodsSchedule) {
			final CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder withMetaArgument = CalculationPeriodFrequency.builder()
				.setPeriodMultiplier(MapperS.of(fpmlCommodityCalculationPeriodsSchedule).<Integer>map("getPeriodMultiplier", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getPeriodMultiplier()).get())
				.setPeriod(MapperS.of(fpmlCommodityCalculationPeriodsSchedule).<PeriodExtendedEnum>map("getPeriod", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getPeriod()).checkedMap("to-enum", e -> cdm.base.datetime.PeriodExtendedEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setBalanceOfFirstPeriod(MapperS.of(fpmlCommodityCalculationPeriodsSchedule).<Boolean>map("getBalanceOfFirstPeriod", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getBalanceOfFirstPeriod()).get())
				.setRollConvention(null)
				.build() == null ? null : CalculationPeriodFrequency.builder()
				.setPeriodMultiplier(MapperS.of(fpmlCommodityCalculationPeriodsSchedule).<Integer>map("getPeriodMultiplier", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getPeriodMultiplier()).get())
				.setPeriod(MapperS.of(fpmlCommodityCalculationPeriodsSchedule).<PeriodExtendedEnum>map("getPeriod", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getPeriod()).checkedMap("to-enum", e -> cdm.base.datetime.PeriodExtendedEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setBalanceOfFirstPeriod(MapperS.of(fpmlCommodityCalculationPeriodsSchedule).<Boolean>map("getBalanceOfFirstPeriod", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getBalanceOfFirstPeriod()).get())
				.setRollConvention(null)
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlCommodityCalculationPeriodsSchedule).<String>map("getId", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getId()).get());
			calculationPeriodFrequency = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(calculationPeriodFrequency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
