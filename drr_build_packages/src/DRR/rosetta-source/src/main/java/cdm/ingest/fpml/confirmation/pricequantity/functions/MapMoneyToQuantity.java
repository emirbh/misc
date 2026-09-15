package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapMoneyToQuantity.MapMoneyToQuantityDefault.class)
public abstract class MapMoneyToQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlNotional 
	* @return nonNegativeQuantitySchedule 
	*/
	public NonNegativeQuantitySchedule evaluate(Money fpmlNotional) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlNotional);
		
		final NonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(Money fpmlNotional);

	public static class MapMoneyToQuantityDefault extends MapMoneyToQuantity {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(Money fpmlNotional) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = NonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlNotional);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, Money fpmlNotional) {
			if (exists(MapperS.of(fpmlNotional)).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(NonNegativeQuantitySchedule.builder()
					.setValue(MapperS.of(fpmlNotional).<BigDecimal>map("getAmount", money -> money.getAmount()).get())
					.setUnit(UnitType.builder()
						.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlNotional).<Currency>map("getCurrency", money -> money.getCurrency()).get()))
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
