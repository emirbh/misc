package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFixedRateToPriceScheduleWithLocation.MapFixedRateToPriceScheduleWithLocationDefault.class)
public abstract class MapFixedRateToPriceScheduleWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;
	@Inject protected CreatePriceWithLocation createPriceWithLocation;
	@Inject protected MapInterestRatePriceSchedule mapInterestRatePriceSchedule;

	/**
	* @param fpmlFixedRate 
	* @param fpmlStepList 
	* @param fpmlCurrency 
	* @param fpmlLeg 
	* @return priceSchedule 
	*/
	public FieldWithMetaPriceSchedule evaluate(BigDecimal fpmlFixedRate, List<? extends Step> fpmlStepList, Currency fpmlCurrency, Leg fpmlLeg) {
		FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceScheduleBuilder = doEvaluate(fpmlFixedRate, fpmlStepList, fpmlCurrency, fpmlLeg);
		
		final FieldWithMetaPriceSchedule priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.build();
			objectValidator.validate(FieldWithMetaPriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder doEvaluate(BigDecimal fpmlFixedRate, List<? extends Step> fpmlStepList, Currency fpmlCurrency, Leg fpmlLeg);

	public static class MapFixedRateToPriceScheduleWithLocationDefault extends MapFixedRateToPriceScheduleWithLocation {
		@Override
		protected FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder doEvaluate(BigDecimal fpmlFixedRate, List<? extends Step> fpmlStepList, Currency fpmlCurrency, Leg fpmlLeg) {
			if (fpmlStepList == null) {
				fpmlStepList = Collections.emptyList();
			}
			FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceSchedule = FieldWithMetaPriceSchedule.builder();
			return assignOutput(priceSchedule, fpmlFixedRate, fpmlStepList, fpmlCurrency, fpmlLeg);
		}
		
		protected FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder assignOutput(FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceSchedule, BigDecimal fpmlFixedRate, List<? extends Step> fpmlStepList, Currency fpmlCurrency, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlFixedRate)).getOrDefault(false)) {
				priceSchedule = toBuilder(createPriceWithLocation.evaluate(mapInterestRatePriceSchedule.evaluate(fpmlFixedRate, fpmlStepList, fpmlCurrency, null), createPriceKey.evaluate("fixedRate", fpmlLeg)));
			} else {
				priceSchedule = toBuilder(FieldWithMetaPriceSchedule.builder().build());
			}
			
			return Optional.ofNullable(priceSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
