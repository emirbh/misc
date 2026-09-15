package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.FxLinkedNotionalSchedule;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxLinkedNotionalScheduleToQuantityWithLocation.MapFxLinkedNotionalScheduleToQuantityWithLocationDefault.class)
public abstract class MapFxLinkedNotionalScheduleToQuantityWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithLocation createQuantityWithLocation;
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlFxLinkedNotionalSchedule 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public FieldWithMetaNonNegativeQuantitySchedule evaluate(FxLinkedNotionalSchedule fpmlFxLinkedNotionalSchedule, Leg fpmlLeg) {
		FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlFxLinkedNotionalSchedule, fpmlLeg);
		
		final FieldWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(FxLinkedNotionalSchedule fpmlFxLinkedNotionalSchedule, Leg fpmlLeg);

	public static class MapFxLinkedNotionalScheduleToQuantityWithLocationDefault extends MapFxLinkedNotionalScheduleToQuantityWithLocation {
		@Override
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(FxLinkedNotionalSchedule fpmlFxLinkedNotionalSchedule, Leg fpmlLeg) {
			FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = FieldWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlFxLinkedNotionalSchedule, fpmlLeg);
		}
		
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder assignOutput(FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, FxLinkedNotionalSchedule fpmlFxLinkedNotionalSchedule, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlFxLinkedNotionalSchedule)).getOrDefault(false)) {
				NonNegativeQuantitySchedule ifThenElseResult = null;
				if (exists(MapperS.of(fpmlFxLinkedNotionalSchedule)).getOrDefault(false)) {
					ifThenElseResult = NonNegativeQuantitySchedule.builder()
						.setValue(MapperS.of(fpmlFxLinkedNotionalSchedule).<BigDecimal>map("getInitialValue", fxLinkedNotionalSchedule -> fxLinkedNotionalSchedule.getInitialValue()).get())
						.setUnit(UnitType.builder()
							.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlFxLinkedNotionalSchedule).<Currency>map("getVaryingNotionalCurrency", fxLinkedNotionalSchedule -> fxLinkedNotionalSchedule.getVaryingNotionalCurrency()).get()))
							.build())
						.build();
				}
				nonNegativeQuantitySchedule = toBuilder(createQuantityWithLocation.evaluate(ifThenElseResult, createQuantityKey.evaluate("fxLinkedNotionalSchedule", fpmlLeg)));
			} else {
				nonNegativeQuantitySchedule = toBuilder(FieldWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
