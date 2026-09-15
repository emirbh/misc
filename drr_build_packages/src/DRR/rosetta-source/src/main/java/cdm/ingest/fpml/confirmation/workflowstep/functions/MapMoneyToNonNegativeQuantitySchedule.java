package cdm.ingest.fpml.confirmation.workflowstep.functions;

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


@ImplementedBy(MapMoneyToNonNegativeQuantitySchedule.MapMoneyToNonNegativeQuantityScheduleDefault.class)
public abstract class MapMoneyToNonNegativeQuantitySchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlMoney 
	* @return priceQuantity 
	*/
	public NonNegativeQuantitySchedule evaluate(Money fpmlMoney) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder priceQuantityBuilder = doEvaluate(fpmlMoney);
		
		final NonNegativeQuantitySchedule priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(Money fpmlMoney);

	public static class MapMoneyToNonNegativeQuantityScheduleDefault extends MapMoneyToNonNegativeQuantitySchedule {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(Money fpmlMoney) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder priceQuantity = NonNegativeQuantitySchedule.builder();
			return assignOutput(priceQuantity, fpmlMoney);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder priceQuantity, Money fpmlMoney) {
			priceQuantity = toBuilder(NonNegativeQuantitySchedule.builder()
				.setValue(MapperS.of(fpmlMoney).<BigDecimal>map("getAmount", money -> money.getAmount()).get())
				.setUnit(UnitType.builder()
					.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlMoney).<Currency>map("getCurrency", money -> money.getCurrency()).get()))
					.build())
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
