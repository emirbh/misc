package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Leg;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommodityTotalNotionalQuantityToQuantityWithAddress.MapCommodityTotalNotionalQuantityToQuantityWithAddressDefault.class)
public abstract class MapCommodityTotalNotionalQuantityToQuantityWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithAddress createQuantityWithAddress;

	/**
	* @param fpmlTotalNotionalAmount 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public ReferenceWithMetaNonNegativeQuantitySchedule evaluate(BigDecimal fpmlTotalNotionalAmount, Leg fpmlLeg) {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlTotalNotionalAmount, fpmlLeg);
		
		final ReferenceWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(ReferenceWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlTotalNotionalAmount, Leg fpmlLeg);

	public static class MapCommodityTotalNotionalQuantityToQuantityWithAddressDefault extends MapCommodityTotalNotionalQuantityToQuantityWithAddress {
		@Override
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlTotalNotionalAmount, Leg fpmlLeg) {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlTotalNotionalAmount, fpmlLeg);
		}
		
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder assignOutput(ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, BigDecimal fpmlTotalNotionalAmount, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlTotalNotionalAmount)).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(createQuantityWithAddress.evaluate(createQuantityKey.evaluate("totalNotionalQuantity", fpmlLeg)));
			} else {
				nonNegativeQuantitySchedule = toBuilder(ReferenceWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
