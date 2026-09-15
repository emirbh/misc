package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityQuantityFrequency;
import fpml.consolidated.shared.Leg;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommodityNotionalQuantityToQuantityWithLocation.MapCommodityNotionalQuantityToQuantityWithLocationDefault.class)
public abstract class MapCommodityNotionalQuantityToQuantityWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithLocation createQuantityWithLocation;
	@Inject protected MapQuantityUnitAmountToQuantity mapQuantityUnitAmountToQuantity;

	/**
	* @param fpmlNotionalAmount 
	* @param fpmlQuantityStep 
	* @param fpmlQuantityUnit 
	* @param fpmlFrequency 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public FieldWithMetaNonNegativeQuantitySchedule evaluate(BigDecimal fpmlNotionalAmount, List<? extends CommodityNotionalQuantity> fpmlQuantityStep, QuantityUnit fpmlQuantityUnit, CommodityQuantityFrequency fpmlFrequency, Leg fpmlLeg) {
		FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlNotionalAmount, fpmlQuantityStep, fpmlQuantityUnit, fpmlFrequency, fpmlLeg);
		
		final FieldWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlNotionalAmount, List<? extends CommodityNotionalQuantity> fpmlQuantityStep, QuantityUnit fpmlQuantityUnit, CommodityQuantityFrequency fpmlFrequency, Leg fpmlLeg);

	public static class MapCommodityNotionalQuantityToQuantityWithLocationDefault extends MapCommodityNotionalQuantityToQuantityWithLocation {
		@Override
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlNotionalAmount, List<? extends CommodityNotionalQuantity> fpmlQuantityStep, QuantityUnit fpmlQuantityUnit, CommodityQuantityFrequency fpmlFrequency, Leg fpmlLeg) {
			if (fpmlQuantityStep == null) {
				fpmlQuantityStep = Collections.emptyList();
			}
			FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = FieldWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlNotionalAmount, fpmlQuantityStep, fpmlQuantityUnit, fpmlFrequency, fpmlLeg);
		}
		
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder assignOutput(FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, BigDecimal fpmlNotionalAmount, List<? extends CommodityNotionalQuantity> fpmlQuantityStep, QuantityUnit fpmlQuantityUnit, CommodityQuantityFrequency fpmlFrequency, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlNotionalAmount)).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(createQuantityWithLocation.evaluate(mapQuantityUnitAmountToQuantity.evaluate(fpmlNotionalAmount, Collections.<CommodityNotionalQuantity>emptyList(), fpmlQuantityUnit, fpmlFrequency), createQuantityKey.evaluate("notionalAmount", fpmlLeg)));
			} else {
				nonNegativeQuantitySchedule = toBuilder(FieldWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
