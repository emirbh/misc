package cdm.ingest.fpml.confirmation.product.swap.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.Calculation;
import fpml.consolidated.ird.CalculationPeriodAmount;
import fpml.consolidated.ird.FxLinkedNotionalSchedule;
import fpml.consolidated.ird.Notional;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetInterestRatePriceCurrency.GetInterestRatePriceCurrencyDefault.class)
public abstract class GetInterestRatePriceCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCalculationPeriodAmount 
	* @return fpmlCurrency 
	*/
	public Currency evaluate(CalculationPeriodAmount fpmlCalculationPeriodAmount) {
		Currency.CurrencyBuilder fpmlCurrencyBuilder = doEvaluate(fpmlCalculationPeriodAmount);
		
		final Currency fpmlCurrency;
		if (fpmlCurrencyBuilder == null) {
			fpmlCurrency = null;
		} else {
			fpmlCurrency = fpmlCurrencyBuilder.build();
			objectValidator.validate(Currency.class, fpmlCurrency);
		}
		
		return fpmlCurrency;
	}

	protected abstract Currency.CurrencyBuilder doEvaluate(CalculationPeriodAmount fpmlCalculationPeriodAmount);

	public static class GetInterestRatePriceCurrencyDefault extends GetInterestRatePriceCurrency {
		@Override
		protected Currency.CurrencyBuilder doEvaluate(CalculationPeriodAmount fpmlCalculationPeriodAmount) {
			Currency.CurrencyBuilder fpmlCurrency = Currency.builder();
			return assignOutput(fpmlCurrency, fpmlCalculationPeriodAmount);
		}
		
		protected Currency.CurrencyBuilder assignOutput(Currency.CurrencyBuilder fpmlCurrency, CalculationPeriodAmount fpmlCalculationPeriodAmount) {
			fpmlCurrency = toBuilder(MapperS.of(fpmlCalculationPeriodAmount).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<Notional>map("getNotionalSchedule", calculation -> calculation.getNotionalSchedule()).<NonNegativeAmountSchedule>map("getNotionalStepSchedule", notional -> notional.getNotionalStepSchedule()).<Currency>map("getCurrency", nonNegativeAmountSchedule -> nonNegativeAmountSchedule.getCurrency()).getOrDefault(MapperS.of(fpmlCalculationPeriodAmount).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<FxLinkedNotionalSchedule>map("getFxLinkedNotionalSchedule", calculation -> calculation.getFxLinkedNotionalSchedule()).<Currency>map("getVaryingNotionalCurrency", fxLinkedNotionalSchedule -> fxLinkedNotionalSchedule.getVaryingNotionalCurrency()).get()));
			
			return Optional.ofNullable(fpmlCurrency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
