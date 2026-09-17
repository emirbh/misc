package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CalculationAmount;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFixedOrFloatingCalculationAmountToQuantityListWithLocation.MapFixedOrFloatingCalculationAmountToQuantityListWithLocationDefault.class)
public abstract class MapFixedOrFloatingCalculationAmountToQuantityListWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNotionalAmountToQuantityWithLocation mapNotionalAmountToQuantityWithLocation;

	/**
	* @param fpmlFixedCalculationAmount 
	* @param fpmlFloatingCalculationAmount 
	* @param fpmlLeg 
	* @return quantityScheduleList 
	*/
	public List<? extends FieldWithMetaNonNegativeQuantitySchedule> evaluate(CalculationAmount fpmlFixedCalculationAmount, CalculationAmount fpmlFloatingCalculationAmount, Leg fpmlLeg) {
		List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityScheduleListBuilder = doEvaluate(fpmlFixedCalculationAmount, fpmlFloatingCalculationAmount, fpmlLeg);
		
		final List<? extends FieldWithMetaNonNegativeQuantitySchedule> quantityScheduleList;
		if (quantityScheduleListBuilder == null) {
			quantityScheduleList = null;
		} else {
			quantityScheduleList = quantityScheduleListBuilder.stream().map(FieldWithMetaNonNegativeQuantitySchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, quantityScheduleList);
		}
		
		return quantityScheduleList;
	}

	protected abstract List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(CalculationAmount fpmlFixedCalculationAmount, CalculationAmount fpmlFloatingCalculationAmount, Leg fpmlLeg);

	public static class MapFixedOrFloatingCalculationAmountToQuantityListWithLocationDefault extends MapFixedOrFloatingCalculationAmountToQuantityListWithLocation {
		@Override
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(CalculationAmount fpmlFixedCalculationAmount, CalculationAmount fpmlFloatingCalculationAmount, Leg fpmlLeg) {
			List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityScheduleList = new ArrayList<>();
			return assignOutput(quantityScheduleList, fpmlFixedCalculationAmount, fpmlFloatingCalculationAmount, fpmlLeg);
		}
		
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> assignOutput(List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityScheduleList, CalculationAmount fpmlFixedCalculationAmount, CalculationAmount fpmlFloatingCalculationAmount, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlFixedCalculationAmount)).getOrDefault(false)) {
				final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule0 = mapNotionalAmountToQuantityWithLocation.evaluate(MapperS.of(fpmlFixedCalculationAmount).<BigDecimal>map("getAmount", calculationAmount -> calculationAmount.getAmount()).get(), MapperS.of(fpmlFixedCalculationAmount).<Step>mapC("getStep", calculationAmount -> calculationAmount.getStep()).getMulti(), MapperS.of(fpmlFixedCalculationAmount).<Currency>map("getCurrency", calculationAmount -> calculationAmount.getCurrency()).get(), fpmlLeg);
				if (fieldWithMetaNonNegativeQuantitySchedule0 == null) {
					quantityScheduleList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
				} else {
					quantityScheduleList.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule0)));
				}
			} else if (exists(MapperS.of(fpmlFloatingCalculationAmount)).getOrDefault(false)) {
				final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule1 = mapNotionalAmountToQuantityWithLocation.evaluate(MapperS.of(fpmlFloatingCalculationAmount).<BigDecimal>map("getAmount", calculationAmount -> calculationAmount.getAmount()).get(), MapperS.of(fpmlFloatingCalculationAmount).<Step>mapC("getStep", calculationAmount -> calculationAmount.getStep()).getMulti(), MapperS.of(fpmlFloatingCalculationAmount).<Currency>map("getCurrency", calculationAmount -> calculationAmount.getCurrency()).get(), fpmlLeg);
				if (fieldWithMetaNonNegativeQuantitySchedule1 == null) {
					quantityScheduleList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
				} else {
					quantityScheduleList.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule1)));
				}
			} else {
				quantityScheduleList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			}
			
			return Optional.ofNullable(quantityScheduleList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
