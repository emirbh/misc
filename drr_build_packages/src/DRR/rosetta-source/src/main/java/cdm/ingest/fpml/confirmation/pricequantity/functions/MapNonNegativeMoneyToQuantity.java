package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapNonNegativeMoneyToQuantity.MapNonNegativeMoneyToQuantityDefault.class)
public abstract class MapNonNegativeMoneyToQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlNonNegativeMoney 
	* @return nonNegativeQuantitySchedule 
	*/
	public NonNegativeQuantitySchedule evaluate(NonNegativeMoney fpmlNonNegativeMoney) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlNonNegativeMoney);
		
		final NonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(NonNegativeMoney fpmlNonNegativeMoney);

	public static class MapNonNegativeMoneyToQuantityDefault extends MapNonNegativeMoneyToQuantity {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(NonNegativeMoney fpmlNonNegativeMoney) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = NonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlNonNegativeMoney);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, NonNegativeMoney fpmlNonNegativeMoney) {
			if (exists(MapperS.of(fpmlNonNegativeMoney)).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(NonNegativeQuantitySchedule.builder()
					.setValue(MapperS.of(fpmlNonNegativeMoney).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get())
					.setUnit(UnitType.builder()
						.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlNonNegativeMoney).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get()))
						.build())
					.build());
			} else {
				nonNegativeQuantitySchedule = null;
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
