package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.product.asset.FloatingRateDefinition;
import cdm.product.common.schedule.CalculationPeriod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.RateObservation;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCalculationPeriodList.MapCalculationPeriodListDefault.class)
public abstract class MapCalculationPeriodList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCalculationPeriodList 
	* @return calculationPeriodList 
	*/
	public List<? extends CalculationPeriod> evaluate(List<? extends fpml.consolidated.ird.CalculationPeriod> fpmlCalculationPeriodList) {
		List<CalculationPeriod.CalculationPeriodBuilder> calculationPeriodListBuilder = doEvaluate(fpmlCalculationPeriodList);
		
		final List<? extends CalculationPeriod> calculationPeriodList;
		if (calculationPeriodListBuilder == null) {
			calculationPeriodList = null;
		} else {
			calculationPeriodList = calculationPeriodListBuilder.stream().map(CalculationPeriod::build).collect(Collectors.toList());
			objectValidator.validate(CalculationPeriod.class, calculationPeriodList);
		}
		
		return calculationPeriodList;
	}

	protected abstract List<CalculationPeriod.CalculationPeriodBuilder> doEvaluate(List<? extends fpml.consolidated.ird.CalculationPeriod> fpmlCalculationPeriodList);

	public static class MapCalculationPeriodListDefault extends MapCalculationPeriodList {
		@Override
		protected List<CalculationPeriod.CalculationPeriodBuilder> doEvaluate(List<? extends fpml.consolidated.ird.CalculationPeriod> fpmlCalculationPeriodList) {
			if (fpmlCalculationPeriodList == null) {
				fpmlCalculationPeriodList = Collections.emptyList();
			}
			List<CalculationPeriod.CalculationPeriodBuilder> calculationPeriodList = new ArrayList<>();
			return assignOutput(calculationPeriodList, fpmlCalculationPeriodList);
		}
		
		protected List<CalculationPeriod.CalculationPeriodBuilder> assignOutput(List<CalculationPeriod.CalculationPeriodBuilder> calculationPeriodList, List<? extends fpml.consolidated.ird.CalculationPeriod> fpmlCalculationPeriodList) {
			calculationPeriodList.addAll(toBuilder(MapperC.<fpml.consolidated.ird.CalculationPeriod>of(fpmlCalculationPeriodList)
				.mapItem(item -> MapperS.of(CalculationPeriod.builder()
					.setAdjustedStartDate(item.<ZonedDateTime>map("getAdjustedStartDate", calculationPeriod -> calculationPeriod.getAdjustedStartDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
					.setAdjustedEndDate(item.<ZonedDateTime>map("getAdjustedEndDate", calculationPeriod -> calculationPeriod.getAdjustedEndDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
					.setNotionalAmount(item.<BigDecimal>map("getNotionalAmount", calculationPeriod -> calculationPeriod.getNotionalAmount()).get())
					.setFixedRate(item.<BigDecimal>map("getFixedRate", calculationPeriod -> calculationPeriod.getFixedRate()).get())
					.setCalculationPeriodNumberOfDays(item.<Integer>map("getCalculationPeriodNumberOfDays", calculationPeriod -> calculationPeriod.getCalculationPeriodNumberOfDays()).get())
					.setFloatingRateDefinition(FloatingRateDefinition.builder()
						.setRateObservation(item.<fpml.consolidated.ird.FloatingRateDefinition>map("getFloatingRateDefinition", calculationPeriod -> calculationPeriod.getFloatingRateDefinition()).<RateObservation>mapC("getRateObservation", floatingRateDefinition -> floatingRateDefinition.getRateObservation())
							.mapItem(_item -> MapperS.of(cdm.observable.asset.RateObservation.builder()
								.setAdjustedFixingDate(_item.<ZonedDateTime>map("getAdjustedFixingDate", rateObservation -> rateObservation.getAdjustedFixingDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
								.setObservationWeight(_item.<Integer>map("getObservationWeight", rateObservation -> rateObservation.getObservationWeight()).get())
								.build())).getMulti())
						.build())
					.build())).getMulti()));
			
			return Optional.ofNullable(calculationPeriodList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
