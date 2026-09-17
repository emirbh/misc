package cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityKey;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityWithLocation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.SingleUnderlyer;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapSingleUnderlyerToNonNegativeQuantityScheduleWithLocation.MapSingleUnderlyerToNonNegativeQuantityScheduleWithLocationDefault.class)
public abstract class MapSingleUnderlyerToNonNegativeQuantityScheduleWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithLocation createQuantityWithLocation;

	/**
	* @param fpmlSingleUnderlyer 
	* @return nonNegativeQuantitySchedule 
	*/
	public FieldWithMetaNonNegativeQuantitySchedule evaluate(SingleUnderlyer fpmlSingleUnderlyer) {
		FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlSingleUnderlyer);
		
		final FieldWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(SingleUnderlyer fpmlSingleUnderlyer);

	public static class MapSingleUnderlyerToNonNegativeQuantityScheduleWithLocationDefault extends MapSingleUnderlyerToNonNegativeQuantityScheduleWithLocation {
		@Override
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(SingleUnderlyer fpmlSingleUnderlyer) {
			FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = FieldWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlSingleUnderlyer);
		}
		
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder assignOutput(FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, SingleUnderlyer fpmlSingleUnderlyer) {
			if (exists(MapperS.of(fpmlSingleUnderlyer).<BigDecimal>map("getOpenUnits", singleUnderlyer -> singleUnderlyer.getOpenUnits())).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(createQuantityWithLocation.evaluate(NonNegativeQuantitySchedule.builder()
					.setValue(MapperS.of(fpmlSingleUnderlyer).<BigDecimal>map("getOpenUnits", singleUnderlyer -> singleUnderlyer.getOpenUnits()).get())
					.setUnit(UnitType.builder()
						.setFinancialUnit(FinancialUnitEnum.SHARE)
						.build())
					.build(), createQuantityKey.evaluate("openUnits", null)));
			} else {
				nonNegativeQuantitySchedule = toBuilder(FieldWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
