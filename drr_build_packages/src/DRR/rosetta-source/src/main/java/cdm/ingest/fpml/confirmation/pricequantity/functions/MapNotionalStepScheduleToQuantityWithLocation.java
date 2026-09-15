package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.NonNegativeStep;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapNotionalStepScheduleToQuantityWithLocation.MapNotionalStepScheduleToQuantityWithLocationDefault.class)
public abstract class MapNotionalStepScheduleToQuantityWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithLocation createQuantityWithLocation;
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapNonNegativeStepListToDatedValueList mapNonNegativeStepListToDatedValueList;

	/**
	* @param fpmlNotionalStepSchedule 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public FieldWithMetaNonNegativeQuantitySchedule evaluate(NonNegativeAmountSchedule fpmlNotionalStepSchedule, Leg fpmlLeg) {
		FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlNotionalStepSchedule, fpmlLeg);
		
		final FieldWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(NonNegativeAmountSchedule fpmlNotionalStepSchedule, Leg fpmlLeg);

	public static class MapNotionalStepScheduleToQuantityWithLocationDefault extends MapNotionalStepScheduleToQuantityWithLocation {
		@Override
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(NonNegativeAmountSchedule fpmlNotionalStepSchedule, Leg fpmlLeg) {
			FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = FieldWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlNotionalStepSchedule, fpmlLeg);
		}
		
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder assignOutput(FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, NonNegativeAmountSchedule fpmlNotionalStepSchedule, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlNotionalStepSchedule)).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(createQuantityWithLocation.evaluate(NonNegativeQuantitySchedule.builder()
					.setValue(MapperS.of(fpmlNotionalStepSchedule).<BigDecimal>map("getInitialValue", nonNegativeAmountSchedule -> nonNegativeAmountSchedule.getInitialValue()).get())
					.setDatedValue(new ArrayList(mapNonNegativeStepListToDatedValueList.evaluate(MapperS.of(fpmlNotionalStepSchedule).<NonNegativeStep>mapC("getStep", nonNegativeAmountSchedule -> nonNegativeAmountSchedule.getStep()).getMulti())))
					.setUnit(UnitType.builder()
						.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlNotionalStepSchedule).<Currency>map("getCurrency", nonNegativeAmountSchedule -> nonNegativeAmountSchedule.getCurrency()).get()))
						.build())
					.build(), createQuantityKey.evaluate("notionalStepSchedule", fpmlLeg)));
			} else {
				nonNegativeQuantitySchedule = toBuilder(FieldWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
