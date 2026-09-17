package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
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

@ImplementedBy(MapNotionalAmountWithIdToQuantityWithLocation.MapNotionalAmountWithIdToQuantityWithLocationDefault.class)
public abstract class MapNotionalAmountWithIdToQuantityWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithLocation createQuantityWithLocation;
	@Inject protected MapCurrencyAmountToQuantity mapCurrencyAmountToQuantity;

	/**
	* @param fpmlNotionalAmount 
	* @param fpmlStepList 
	* @param fpmlCurrency 
	* @param id 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public FieldWithMetaNonNegativeQuantitySchedule evaluate(BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, String id, Leg fpmlLeg) {
		FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlNotionalAmount, fpmlStepList, fpmlCurrency, id, fpmlLeg);
		
		final FieldWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, String id, Leg fpmlLeg);

	public static class MapNotionalAmountWithIdToQuantityWithLocationDefault extends MapNotionalAmountWithIdToQuantityWithLocation {
		@Override
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, String id, Leg fpmlLeg) {
			if (fpmlStepList == null) {
				fpmlStepList = Collections.emptyList();
			}
			FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = FieldWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlNotionalAmount, fpmlStepList, fpmlCurrency, id, fpmlLeg);
		}
		
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder assignOutput(FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, String id, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlNotionalAmount)).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(createQuantityWithLocation.evaluate(mapCurrencyAmountToQuantity.evaluate(fpmlNotionalAmount, fpmlStepList, fpmlCurrency, null), createQuantityKey.evaluate(id, fpmlLeg)));
			} else {
				nonNegativeQuantitySchedule = toBuilder(FieldWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
