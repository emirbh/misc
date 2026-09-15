package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapNotionalAmountToQuantityWithLocation.MapNotionalAmountToQuantityWithLocationDefault.class)
public abstract class MapNotionalAmountToQuantityWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNotionalAmountWithIdToQuantityWithLocation mapNotionalAmountWithIdToQuantityWithLocation;

	/**
	* @param fpmlNotionalAmount 
	* @param fpmlStepList 
	* @param fpmlCurrency 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public FieldWithMetaNonNegativeQuantitySchedule evaluate(BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, Leg fpmlLeg) {
		FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlNotionalAmount, fpmlStepList, fpmlCurrency, fpmlLeg);
		
		final FieldWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, Leg fpmlLeg);

	public static class MapNotionalAmountToQuantityWithLocationDefault extends MapNotionalAmountToQuantityWithLocation {
		@Override
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, Leg fpmlLeg) {
			if (fpmlStepList == null) {
				fpmlStepList = Collections.emptyList();
			}
			FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = FieldWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlNotionalAmount, fpmlStepList, fpmlCurrency, fpmlLeg);
		}
		
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder assignOutput(FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, Leg fpmlLeg) {
			nonNegativeQuantitySchedule = toBuilder(mapNotionalAmountWithIdToQuantityWithLocation.evaluate(fpmlNotionalAmount, fpmlStepList, fpmlCurrency, "notionalAmount", fpmlLeg));
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
