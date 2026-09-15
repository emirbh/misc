package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFxLinkedNotionalScheduleToQuantityWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalStepScheduleToQuantityWithLocation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.Calculation;
import fpml.consolidated.ird.CalculationPeriodAmount;
import fpml.consolidated.ird.FxLinkedNotionalSchedule;
import fpml.consolidated.ird.Notional;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCalculationPeriodAmountToQuantityList.MapCalculationPeriodAmountToQuantityListDefault.class)
public abstract class MapCalculationPeriodAmountToQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxLinkedNotionalScheduleToQuantityWithLocation mapFxLinkedNotionalScheduleToQuantityWithLocation;
	@Inject protected MapNotionalStepScheduleToQuantityWithLocation mapNotionalStepScheduleToQuantityWithLocation;

	/**
	* @param fpmlCalculationPeriodAmount 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedules 
	*/
	public List<? extends FieldWithMetaNonNegativeQuantitySchedule> evaluate(CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg) {
		List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> nonNegativeQuantitySchedulesBuilder = doEvaluate(fpmlCalculationPeriodAmount, fpmlLeg);
		
		final List<? extends FieldWithMetaNonNegativeQuantitySchedule> nonNegativeQuantitySchedules;
		if (nonNegativeQuantitySchedulesBuilder == null) {
			nonNegativeQuantitySchedules = null;
		} else {
			nonNegativeQuantitySchedules = nonNegativeQuantitySchedulesBuilder.stream().map(FieldWithMetaNonNegativeQuantitySchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedules);
		}
		
		return nonNegativeQuantitySchedules;
	}

	protected abstract List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg);

	public static class MapCalculationPeriodAmountToQuantityListDefault extends MapCalculationPeriodAmountToQuantityList {
		@Override
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg) {
			List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> nonNegativeQuantitySchedules = new ArrayList<>();
			return assignOutput(nonNegativeQuantitySchedules, fpmlCalculationPeriodAmount, fpmlLeg);
		}
		
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> assignOutput(List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> nonNegativeQuantitySchedules, CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg) {
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule0 = mapNotionalStepScheduleToQuantityWithLocation.evaluate(MapperS.of(fpmlCalculationPeriodAmount).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<Notional>map("getNotionalSchedule", calculation -> calculation.getNotionalSchedule()).<NonNegativeAmountSchedule>map("getNotionalStepSchedule", notional -> notional.getNotionalStepSchedule()).get(), fpmlLeg);
			if (fieldWithMetaNonNegativeQuantitySchedule0 == null) {
				nonNegativeQuantitySchedules.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			} else {
				nonNegativeQuantitySchedules.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule0)));
			}
			
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule1 = mapFxLinkedNotionalScheduleToQuantityWithLocation.evaluate(MapperS.of(fpmlCalculationPeriodAmount).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<FxLinkedNotionalSchedule>map("getFxLinkedNotionalSchedule", calculation -> calculation.getFxLinkedNotionalSchedule()).get(), fpmlLeg);
			if (fieldWithMetaNonNegativeQuantitySchedule1 == null) {
				nonNegativeQuantitySchedules.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			} else {
				nonNegativeQuantitySchedules.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule1)));
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedules)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
