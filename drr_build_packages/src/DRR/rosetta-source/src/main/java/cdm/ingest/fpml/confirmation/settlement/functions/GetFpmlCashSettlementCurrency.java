package cdm.ingest.fpml.confirmation.settlement.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CashPriceMethod;
import fpml.consolidated.ird.CashSettlement;
import fpml.consolidated.ird.CollateralizedCashPriceMethod;
import fpml.consolidated.ird.CrossCurrencyMethod;
import fpml.consolidated.ird.MidMarketValuation;
import fpml.consolidated.ird.MidMarketValuationMethod;
import fpml.consolidated.ird.ReplacementValue;
import fpml.consolidated.ird.ReplacementValueCalculationAgentDeterminationMethod;
import fpml.consolidated.ird.ReplacementValueFirmQuotationsMethod;
import fpml.consolidated.shared.Currency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetFpmlCashSettlementCurrency.GetFpmlCashSettlementCurrencyDefault.class)
public abstract class GetFpmlCashSettlementCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCashSettlement 
	* @return fpmlCurrency 
	*/
	public List<? extends Currency> evaluate(CashSettlement fpmlCashSettlement) {
		List<Currency.CurrencyBuilder> fpmlCurrencyBuilder = doEvaluate(fpmlCashSettlement);
		
		final List<? extends Currency> fpmlCurrency;
		if (fpmlCurrencyBuilder == null) {
			fpmlCurrency = null;
		} else {
			fpmlCurrency = fpmlCurrencyBuilder.stream().map(Currency::build).collect(Collectors.toList());
			objectValidator.validate(Currency.class, fpmlCurrency);
		}
		
		return fpmlCurrency;
	}

	protected abstract List<Currency.CurrencyBuilder> doEvaluate(CashSettlement fpmlCashSettlement);

	public static class GetFpmlCashSettlementCurrencyDefault extends GetFpmlCashSettlementCurrency {
		@Override
		protected List<Currency.CurrencyBuilder> doEvaluate(CashSettlement fpmlCashSettlement) {
			List<Currency.CurrencyBuilder> fpmlCurrency = new ArrayList<>();
			return assignOutput(fpmlCurrency, fpmlCashSettlement);
		}
		
		protected List<Currency.CurrencyBuilder> assignOutput(List<Currency.CurrencyBuilder> fpmlCurrency, CashSettlement fpmlCashSettlement) {
			if (exists(MapperS.of(fpmlCashSettlement).<MidMarketValuation>map("getMidMarketValuation", cashSettlement -> cashSettlement.getMidMarketValuation()).<MidMarketValuationMethod>map("getIndicativeQuotations", midMarketValuation -> midMarketValuation.getIndicativeQuotations())).getOrDefault(false)) {
				fpmlCurrency.addAll(toBuilder(MapperS.of(fpmlCashSettlement).<MidMarketValuation>map("getMidMarketValuation", cashSettlement -> cashSettlement.getMidMarketValuation()).<MidMarketValuationMethod>map("getIndicativeQuotations", midMarketValuation -> midMarketValuation.getIndicativeQuotations()).<Currency>mapC("getCashSettlementCurrency", midMarketValuationMethod -> midMarketValuationMethod.getCashSettlementCurrency()).getMulti()));
			} else if (exists(MapperS.of(fpmlCashSettlement).<MidMarketValuation>map("getMidMarketValuation", cashSettlement -> cashSettlement.getMidMarketValuation()).<MidMarketValuationMethod>map("getIndicativeQuotationsAlternate", midMarketValuation -> midMarketValuation.getIndicativeQuotationsAlternate())).getOrDefault(false)) {
				fpmlCurrency.addAll(toBuilder(MapperS.of(fpmlCashSettlement).<MidMarketValuation>map("getMidMarketValuation", cashSettlement -> cashSettlement.getMidMarketValuation()).<MidMarketValuationMethod>map("getIndicativeQuotationsAlternate", midMarketValuation -> midMarketValuation.getIndicativeQuotationsAlternate()).<Currency>mapC("getCashSettlementCurrency", midMarketValuationMethod -> midMarketValuationMethod.getCashSettlementCurrency()).getMulti()));
			} else if (exists(MapperS.of(fpmlCashSettlement).<MidMarketValuation>map("getMidMarketValuation", cashSettlement -> cashSettlement.getMidMarketValuation()).<MidMarketValuationMethod>map("getCalculationAgentDetermination", midMarketValuation -> midMarketValuation.getCalculationAgentDetermination())).getOrDefault(false)) {
				fpmlCurrency.addAll(toBuilder(MapperS.of(fpmlCashSettlement).<MidMarketValuation>map("getMidMarketValuation", cashSettlement -> cashSettlement.getMidMarketValuation()).<MidMarketValuationMethod>map("getCalculationAgentDetermination", midMarketValuation -> midMarketValuation.getCalculationAgentDetermination()).<Currency>mapC("getCashSettlementCurrency", midMarketValuationMethod -> midMarketValuationMethod.getCashSettlementCurrency()).getMulti()));
			} else if (exists(MapperS.of(fpmlCashSettlement).<ReplacementValue>map("getReplacementValue", cashSettlement -> cashSettlement.getReplacementValue()).<ReplacementValueFirmQuotationsMethod>map("getFirmQuotations", replacementValue -> replacementValue.getFirmQuotations())).getOrDefault(false)) {
				fpmlCurrency.addAll(toBuilder(MapperS.of(fpmlCashSettlement).<ReplacementValue>map("getReplacementValue", cashSettlement -> cashSettlement.getReplacementValue()).<ReplacementValueFirmQuotationsMethod>map("getFirmQuotations", replacementValue -> replacementValue.getFirmQuotations()).<Currency>map("getCashSettlementCurrency", replacementValueFirmQuotationsMethod -> replacementValueFirmQuotationsMethod.getCashSettlementCurrency()).getMulti()));
			} else if (exists(MapperS.of(fpmlCashSettlement).<ReplacementValue>map("getReplacementValue", cashSettlement -> cashSettlement.getReplacementValue()).<ReplacementValueCalculationAgentDeterminationMethod>map("getCalculationAgentDetermination", replacementValue -> replacementValue.getCalculationAgentDetermination())).getOrDefault(false)) {
				fpmlCurrency.addAll(toBuilder(MapperS.of(fpmlCashSettlement).<ReplacementValue>map("getReplacementValue", cashSettlement -> cashSettlement.getReplacementValue()).<ReplacementValueCalculationAgentDeterminationMethod>map("getCalculationAgentDetermination", replacementValue -> replacementValue.getCalculationAgentDetermination()).<Currency>map("getCashSettlementCurrency", replacementValueCalculationAgentDeterminationMethod -> replacementValueCalculationAgentDeterminationMethod.getCashSettlementCurrency()).getMulti()));
			} else if (exists(MapperS.of(fpmlCashSettlement).<CollateralizedCashPriceMethod>map("getCollateralizedCashPriceMethod", cashSettlement -> cashSettlement.getCollateralizedCashPriceMethod())).getOrDefault(false)) {
				fpmlCurrency.addAll(toBuilder(MapperS.of(fpmlCashSettlement).<CollateralizedCashPriceMethod>map("getCollateralizedCashPriceMethod", cashSettlement -> cashSettlement.getCollateralizedCashPriceMethod()).<Currency>map("getCashSettlementCurrency", collateralizedCashPriceMethod -> collateralizedCashPriceMethod.getCashSettlementCurrency()).getMulti()));
			} else if (exists(MapperS.of(fpmlCashSettlement).<CashPriceMethod>map("getCashPriceMethod", cashSettlement -> cashSettlement.getCashPriceMethod())).getOrDefault(false)) {
				fpmlCurrency.addAll(toBuilder(MapperS.of(fpmlCashSettlement).<CashPriceMethod>map("getCashPriceMethod", cashSettlement -> cashSettlement.getCashPriceMethod()).<Currency>map("getCashSettlementCurrency", cashPriceMethod -> cashPriceMethod.getCashSettlementCurrency()).getMulti()));
			} else if (exists(MapperS.of(fpmlCashSettlement).<CashPriceMethod>map("getCashPriceAlternateMethod", cashSettlement -> cashSettlement.getCashPriceAlternateMethod())).getOrDefault(false)) {
				fpmlCurrency.addAll(toBuilder(MapperS.of(fpmlCashSettlement).<CashPriceMethod>map("getCashPriceAlternateMethod", cashSettlement -> cashSettlement.getCashPriceAlternateMethod()).<Currency>map("getCashSettlementCurrency", cashPriceMethod -> cashPriceMethod.getCashSettlementCurrency()).getMulti()));
			} else if (exists(MapperS.of(fpmlCashSettlement).<CrossCurrencyMethod>map("getCrossCurrencyMethod", cashSettlement -> cashSettlement.getCrossCurrencyMethod())).getOrDefault(false)) {
				fpmlCurrency.addAll(toBuilder(MapperS.of(fpmlCashSettlement).<CrossCurrencyMethod>map("getCrossCurrencyMethod", cashSettlement -> cashSettlement.getCrossCurrencyMethod()).<Currency>mapC("getCashSettlementCurrency", crossCurrencyMethod -> crossCurrencyMethod.getCashSettlementCurrency()).getMulti()));
			} else {
				fpmlCurrency.addAll(toBuilder(Collections.<Currency>emptyList()));
			}
			
			return Optional.ofNullable(fpmlCurrency)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
