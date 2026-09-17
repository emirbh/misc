package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CalculationAmount;
import fpml.consolidated.shared.Leg;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFixedOrFloatingCalculationAmountToQuantityListWithAddress.MapFixedOrFloatingCalculationAmountToQuantityListWithAddressDefault.class)
public abstract class MapFixedOrFloatingCalculationAmountToQuantityListWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNotionalAmountToQuantityWithAddress mapNotionalAmountToQuantityWithAddress;

	/**
	* @param fpmlFixedCalculationAmount 
	* @param fpmlFloatingCalculationAmount 
	* @param fpmlLeg 
	* @return quantityScheduleList 
	*/
	public ReferenceWithMetaNonNegativeQuantitySchedule evaluate(CalculationAmount fpmlFixedCalculationAmount, CalculationAmount fpmlFloatingCalculationAmount, Leg fpmlLeg) {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityScheduleListBuilder = doEvaluate(fpmlFixedCalculationAmount, fpmlFloatingCalculationAmount, fpmlLeg);
		
		final ReferenceWithMetaNonNegativeQuantitySchedule quantityScheduleList;
		if (quantityScheduleListBuilder == null) {
			quantityScheduleList = null;
		} else {
			quantityScheduleList = quantityScheduleListBuilder.build();
			objectValidator.validate(ReferenceWithMetaNonNegativeQuantitySchedule.class, quantityScheduleList);
		}
		
		return quantityScheduleList;
	}

	protected abstract ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(CalculationAmount fpmlFixedCalculationAmount, CalculationAmount fpmlFloatingCalculationAmount, Leg fpmlLeg);

	public static class MapFixedOrFloatingCalculationAmountToQuantityListWithAddressDefault extends MapFixedOrFloatingCalculationAmountToQuantityListWithAddress {
		@Override
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(CalculationAmount fpmlFixedCalculationAmount, CalculationAmount fpmlFloatingCalculationAmount, Leg fpmlLeg) {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityScheduleList = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(quantityScheduleList, fpmlFixedCalculationAmount, fpmlFloatingCalculationAmount, fpmlLeg);
		}
		
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder assignOutput(ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityScheduleList, CalculationAmount fpmlFixedCalculationAmount, CalculationAmount fpmlFloatingCalculationAmount, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlFixedCalculationAmount)).getOrDefault(false)) {
				quantityScheduleList = toBuilder(mapNotionalAmountToQuantityWithAddress.evaluate(MapperS.of(fpmlFixedCalculationAmount).<BigDecimal>map("getAmount", calculationAmount -> calculationAmount.getAmount()).get(), fpmlLeg));
			} else if (exists(MapperS.of(fpmlFloatingCalculationAmount)).getOrDefault(false)) {
				quantityScheduleList = toBuilder(mapNotionalAmountToQuantityWithAddress.evaluate(MapperS.of(fpmlFloatingCalculationAmount).<BigDecimal>map("getAmount", calculationAmount -> calculationAmount.getAmount()).get(), fpmlLeg));
			} else {
				quantityScheduleList = toBuilder(ReferenceWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(quantityScheduleList)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
