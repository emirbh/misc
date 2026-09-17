package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapNonNegativeMoneyNonNegativeQuantitySchedule.MapNonNegativeMoneyNonNegativeQuantityScheduleDefault.class)
public abstract class MapNonNegativeMoneyNonNegativeQuantitySchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlNonNegativeMoney 
	* @return priceQuantityList 
	*/
	public NonNegativeQuantitySchedule evaluate(NonNegativeMoney fpmlNonNegativeMoney) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder priceQuantityListBuilder = doEvaluate(fpmlNonNegativeMoney);
		
		final NonNegativeQuantitySchedule priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(NonNegativeMoney fpmlNonNegativeMoney);

	public static class MapNonNegativeMoneyNonNegativeQuantityScheduleDefault extends MapNonNegativeMoneyNonNegativeQuantitySchedule {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(NonNegativeMoney fpmlNonNegativeMoney) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder priceQuantityList = NonNegativeQuantitySchedule.builder();
			return assignOutput(priceQuantityList, fpmlNonNegativeMoney);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder priceQuantityList, NonNegativeMoney fpmlNonNegativeMoney) {
			priceQuantityList = toBuilder(NonNegativeQuantitySchedule.builder()
				.setValue(MapperS.of(fpmlNonNegativeMoney).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get())
				.setUnit(UnitType.builder()
					.setCurrencyValue(MapperS.of(fpmlNonNegativeMoney).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).<String>map("getValue", currency -> currency.getValue()).get())
					.build())
				.build());
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
