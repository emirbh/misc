package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eqd.EquityDerivativeBase;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapEquityDerivativeBaseQuantityListWithAddress.MapEquityDerivativeBaseQuantityListWithAddressDefault.class)
public abstract class MapEquityDerivativeBaseQuantityListWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithAddress createQuantityWithAddress;

	/**
	* @param fpmlEquityDerivativeBase 
	* @param fpmlNumberOfOptions 
	* @return quantityList 
	*/
	public ReferenceWithMetaNonNegativeQuantitySchedule evaluate(EquityDerivativeBase fpmlEquityDerivativeBase, BigDecimal fpmlNumberOfOptions) {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityListBuilder = doEvaluate(fpmlEquityDerivativeBase, fpmlNumberOfOptions);
		
		final ReferenceWithMetaNonNegativeQuantitySchedule quantityList;
		if (quantityListBuilder == null) {
			quantityList = null;
		} else {
			quantityList = quantityListBuilder.build();
			objectValidator.validate(ReferenceWithMetaNonNegativeQuantitySchedule.class, quantityList);
		}
		
		return quantityList;
	}

	protected abstract ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(EquityDerivativeBase fpmlEquityDerivativeBase, BigDecimal fpmlNumberOfOptions);

	public static class MapEquityDerivativeBaseQuantityListWithAddressDefault extends MapEquityDerivativeBaseQuantityListWithAddress {
		@Override
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(EquityDerivativeBase fpmlEquityDerivativeBase, BigDecimal fpmlNumberOfOptions) {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityList = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(quantityList, fpmlEquityDerivativeBase, fpmlNumberOfOptions);
		}
		
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder assignOutput(ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityList, EquityDerivativeBase fpmlEquityDerivativeBase, BigDecimal fpmlNumberOfOptions) {
			if (exists(MapperS.of(fpmlNumberOfOptions)).getOrDefault(false)) {
				quantityList = toBuilder(createQuantityWithAddress.evaluate(createQuantityKey.evaluate("numberOfOptions", null)));
			} else {
				quantityList = toBuilder(ReferenceWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(quantityList)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
