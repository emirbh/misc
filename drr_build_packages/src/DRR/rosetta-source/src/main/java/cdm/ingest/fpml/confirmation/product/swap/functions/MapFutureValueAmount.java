package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.product.asset.FutureValueAmount;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFutureValueAmount.MapFutureValueAmountDefault.class)
public abstract class MapFutureValueAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlFutureValueAmount 
	* @return futureValueAmount 
	*/
	public FutureValueAmount evaluate(fpml.consolidated.shared.FutureValueAmount fpmlFutureValueAmount) {
		FutureValueAmount.FutureValueAmountBuilder futureValueAmountBuilder = doEvaluate(fpmlFutureValueAmount);
		
		final FutureValueAmount futureValueAmount;
		if (futureValueAmountBuilder == null) {
			futureValueAmount = null;
		} else {
			futureValueAmount = futureValueAmountBuilder.build();
			objectValidator.validate(FutureValueAmount.class, futureValueAmount);
		}
		
		return futureValueAmount;
	}

	protected abstract FutureValueAmount.FutureValueAmountBuilder doEvaluate(fpml.consolidated.shared.FutureValueAmount fpmlFutureValueAmount);

	public static class MapFutureValueAmountDefault extends MapFutureValueAmount {
		@Override
		protected FutureValueAmount.FutureValueAmountBuilder doEvaluate(fpml.consolidated.shared.FutureValueAmount fpmlFutureValueAmount) {
			FutureValueAmount.FutureValueAmountBuilder futureValueAmount = FutureValueAmount.builder();
			return assignOutput(futureValueAmount, fpmlFutureValueAmount);
		}
		
		protected FutureValueAmount.FutureValueAmountBuilder assignOutput(FutureValueAmount.FutureValueAmountBuilder futureValueAmount, fpml.consolidated.shared.FutureValueAmount fpmlFutureValueAmount) {
			futureValueAmount = toBuilder(FutureValueAmount.builder()
				.setQuantityValue(NonNegativeQuantitySchedule.builder()
					.setValue(MapperS.of(fpmlFutureValueAmount).<BigDecimal>map("getAmount", _futureValueAmount -> _futureValueAmount.getAmount()).get())
					.setUnit(UnitType.builder()
						.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlFutureValueAmount).<Currency>map("getCurrency", _futureValueAmount -> _futureValueAmount.getCurrency()).get()))
						.build())
					.build())
				.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlFutureValueAmount).<Currency>map("getCurrency", _futureValueAmount -> _futureValueAmount.getCurrency()).get()))
				.setCalculationPeriodNumberOfDays(MapperS.of(fpmlFutureValueAmount).<Integer>map("getCalculationPeriodNumberOfDays", _futureValueAmount -> _futureValueAmount.getCalculationPeriodNumberOfDays()).get())
				.setValueDate(MapperS.of(fpmlFutureValueAmount).<ZonedDateTime>map("getValueDate", _futureValueAmount -> _futureValueAmount.getValueDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.build());
			
			return Optional.ofNullable(futureValueAmount)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
