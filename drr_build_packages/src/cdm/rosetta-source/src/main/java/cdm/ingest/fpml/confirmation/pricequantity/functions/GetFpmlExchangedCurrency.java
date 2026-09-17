package cdm.ingest.fpml.confirmation.pricequantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetFpmlExchangedCurrency.GetFpmlExchangedCurrencyDefault.class)
public abstract class GetFpmlExchangedCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlExchangeRate 
	* @param fpmlExchangedCurrency1 
	* @param fpmlExchangedCurrency2 
	* @return fpmlExchangedCurrency 
	*/
	public Payment evaluate(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2) {
		Payment.PaymentBuilder fpmlExchangedCurrencyBuilder = doEvaluate(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2);
		
		final Payment fpmlExchangedCurrency;
		if (fpmlExchangedCurrencyBuilder == null) {
			fpmlExchangedCurrency = null;
		} else {
			fpmlExchangedCurrency = fpmlExchangedCurrencyBuilder.build();
			objectValidator.validate(Payment.class, fpmlExchangedCurrency);
		}
		
		return fpmlExchangedCurrency;
	}

	protected abstract Payment.PaymentBuilder doEvaluate(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2);

	protected abstract MapperS<? extends QuotedCurrencyPair> quotedCurrencyPair(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2);

	protected abstract MapperS<? extends Currency> currency(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2);

	public static class GetFpmlExchangedCurrencyDefault extends GetFpmlExchangedCurrency {
		@Override
		protected Payment.PaymentBuilder doEvaluate(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2) {
			Payment.PaymentBuilder fpmlExchangedCurrency = Payment.builder();
			return assignOutput(fpmlExchangedCurrency, fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2);
		}
		
		protected Payment.PaymentBuilder assignOutput(Payment.PaymentBuilder fpmlExchangedCurrency, ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2) {
			if (areEqual(MapperS.of(fpmlExchangedCurrency1).<NonNegativeMoney>map("getPaymentAmount", payment -> payment.getPaymentAmount()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()), currency(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2), CardinalityOperator.All).getOrDefault(false)) {
				fpmlExchangedCurrency = toBuilder(fpmlExchangedCurrency1);
			} else if (areEqual(MapperS.of(fpmlExchangedCurrency2).<NonNegativeMoney>map("getPaymentAmount", payment -> payment.getPaymentAmount()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()), currency(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2), CardinalityOperator.All).getOrDefault(false)) {
				fpmlExchangedCurrency = toBuilder(fpmlExchangedCurrency2);
			} else {
				fpmlExchangedCurrency = null;
			}
			
			return Optional.ofNullable(fpmlExchangedCurrency)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends QuotedCurrencyPair> quotedCurrencyPair(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2) {
			return MapperS.of(fpmlExchangeRate).<QuotedCurrencyPair>map("getQuotedCurrencyPair", exchangeRate -> exchangeRate.getQuotedCurrencyPair());
		}
		
		@Override
		protected MapperS<? extends Currency> currency(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2) {
			if (areEqual(quotedCurrencyPair(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2).<QuoteBasisEnum>map("getQuoteBasis", _quotedCurrencyPair -> _quotedCurrencyPair.getQuoteBasis()), MapperS.of(QuoteBasisEnum.CURRENCY_2_PER_CURRENCY_1), CardinalityOperator.All).getOrDefault(false)) {
				return quotedCurrencyPair(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2).<Currency>map("getCurrency1", _quotedCurrencyPair -> _quotedCurrencyPair.getCurrency1());
			}
			return quotedCurrencyPair(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2).<Currency>map("getCurrency2", _quotedCurrencyPair -> _quotedCurrencyPair.getCurrency2());
		}
	}
}
