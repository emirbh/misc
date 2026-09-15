package cdm.ingest.fpml.confirmation.product.fxvarianceswap.functions;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import cdm.base.datetime.RelativeDates;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenters;
import cdm.observable.asset.PerformanceValuationDates;
import cdm.observable.asset.ValuationDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.fx.FxValuationDateOffset;
import fpml.consolidated.shared.BusinessCenters;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxValuationDateOffsetToValuationDates.MapFxValuationDateOffsetToValuationDatesDefault.class)
public abstract class MapFxValuationDateOffsetToValuationDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenters mapBusinessCenters;

	/**
	* @param fpmlFxValuationDateOffset 
	* @return valuationDates 
	*/
	public ValuationDates evaluate(FxValuationDateOffset fpmlFxValuationDateOffset) {
		ValuationDates.ValuationDatesBuilder valuationDatesBuilder = doEvaluate(fpmlFxValuationDateOffset);
		
		final ValuationDates valuationDates;
		if (valuationDatesBuilder == null) {
			valuationDates = null;
		} else {
			valuationDates = valuationDatesBuilder.build();
			objectValidator.validate(ValuationDates.class, valuationDates);
		}
		
		return valuationDates;
	}

	protected abstract ValuationDates.ValuationDatesBuilder doEvaluate(FxValuationDateOffset fpmlFxValuationDateOffset);

	public static class MapFxValuationDateOffsetToValuationDatesDefault extends MapFxValuationDateOffsetToValuationDates {
		@Override
		protected ValuationDates.ValuationDatesBuilder doEvaluate(FxValuationDateOffset fpmlFxValuationDateOffset) {
			ValuationDates.ValuationDatesBuilder valuationDates = ValuationDates.builder();
			return assignOutput(valuationDates, fpmlFxValuationDateOffset);
		}
		
		protected ValuationDates.ValuationDatesBuilder assignOutput(ValuationDates.ValuationDatesBuilder valuationDates, FxValuationDateOffset fpmlFxValuationDateOffset) {
			valuationDates = toBuilder(ValuationDates.builder()
				.setFinalValuationDate(PerformanceValuationDates.builder()
					.setValuationDates(AdjustableRelativeOrPeriodicDates.builder()
						.setRelativeDates(RelativeDates.builder()
							.setBusinessDayConvention(null)
							.setPeriodMultiplier(MapperS.of(fpmlFxValuationDateOffset).<Integer>map("getPeriodMultiplier", fxValuationDateOffset -> fxValuationDateOffset.getPeriodMultiplier()).get())
							.setPeriod(MapperS.of(fpmlFxValuationDateOffset).<PeriodEnum>map("getPeriod", fxValuationDateOffset -> fxValuationDateOffset.getPeriod()).checkedMap("to-enum", e -> cdm.base.datetime.PeriodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
							.setDayType(MapperS.of(fpmlFxValuationDateOffset).<DayTypeEnum>map("getDayType", fxValuationDateOffset -> fxValuationDateOffset.getDayType()).checkedMap("to-enum", e -> cdm.base.datetime.DayTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
							.setBusinessCenters(mapBusinessCenters.evaluate(MapperS.of(fpmlFxValuationDateOffset).<BusinessCenters>map("getBusinessCenters", fxValuationDateOffset -> fxValuationDateOffset.getBusinessCenters()).get()))
							.build())
						.build())
					.setDeterminationMethod(null)
					.build())
				.build());
			
			return Optional.ofNullable(valuationDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
