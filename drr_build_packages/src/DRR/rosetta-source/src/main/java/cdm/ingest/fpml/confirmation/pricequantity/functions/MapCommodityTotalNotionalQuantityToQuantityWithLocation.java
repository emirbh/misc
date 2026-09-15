package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.shared.Leg;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommodityTotalNotionalQuantityToQuantityWithLocation.MapCommodityTotalNotionalQuantityToQuantityWithLocationDefault.class)
public abstract class MapCommodityTotalNotionalQuantityToQuantityWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithLocation createQuantityWithLocation;
	@Inject protected MapQuantityUnitAmountToQuantity mapQuantityUnitAmountToQuantity;

	/**
	* @param fpmlTotalNotionalAmount 
	* @param fpmlQuantityUnit 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public FieldWithMetaNonNegativeQuantitySchedule evaluate(BigDecimal fpmlTotalNotionalAmount, QuantityUnit fpmlQuantityUnit, Leg fpmlLeg) {
		FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlTotalNotionalAmount, fpmlQuantityUnit, fpmlLeg);
		
		final FieldWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlTotalNotionalAmount, QuantityUnit fpmlQuantityUnit, Leg fpmlLeg);

	public static class MapCommodityTotalNotionalQuantityToQuantityWithLocationDefault extends MapCommodityTotalNotionalQuantityToQuantityWithLocation {
		@Override
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlTotalNotionalAmount, QuantityUnit fpmlQuantityUnit, Leg fpmlLeg) {
			FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = FieldWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlTotalNotionalAmount, fpmlQuantityUnit, fpmlLeg);
		}
		
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder assignOutput(FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, BigDecimal fpmlTotalNotionalAmount, QuantityUnit fpmlQuantityUnit, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlTotalNotionalAmount)).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(createQuantityWithLocation.evaluate(mapQuantityUnitAmountToQuantity.evaluate(fpmlTotalNotionalAmount, Collections.<CommodityNotionalQuantity>emptyList(), fpmlQuantityUnit, null), createQuantityKey.evaluate("totalNotionalQuantity", fpmlLeg)));
			} else {
				nonNegativeQuantitySchedule = toBuilder(FieldWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
