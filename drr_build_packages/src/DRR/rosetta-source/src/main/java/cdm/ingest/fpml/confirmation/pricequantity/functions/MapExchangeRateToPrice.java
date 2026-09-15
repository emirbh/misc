package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.observable.asset.PriceComposite;
import cdm.observable.asset.PriceOperandEnum;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapExchangeRateToPrice.MapExchangeRateToPriceDefault.class)
public abstract class MapExchangeRateToPrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlExchangeRate 
	* @return price 
	*/
	public PriceSchedule evaluate(ExchangeRate fpmlExchangeRate) {
		PriceSchedule.PriceScheduleBuilder priceBuilder = doEvaluate(fpmlExchangeRate);
		
		final PriceSchedule price;
		if (priceBuilder == null) {
			price = null;
		} else {
			price = priceBuilder.build();
			objectValidator.validate(PriceSchedule.class, price);
		}
		
		return price;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(ExchangeRate fpmlExchangeRate);

	protected abstract MapperS<BigDecimal> rate(ExchangeRate fpmlExchangeRate);

	protected abstract MapperS<BigDecimal> spotRate(ExchangeRate fpmlExchangeRate);

	protected abstract MapperS<BigDecimal> forwardPoints(ExchangeRate fpmlExchangeRate);

	protected abstract MapperS<? extends QuotedCurrencyPair> quotedCurrencyPair(ExchangeRate fpmlExchangeRate);

	protected abstract MapperS<? extends Currency> fpmlCurrency(ExchangeRate fpmlExchangeRate);

	protected abstract MapperS<? extends Currency> fpmlPerCurrency(ExchangeRate fpmlExchangeRate);

	public static class MapExchangeRateToPriceDefault extends MapExchangeRateToPrice {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(ExchangeRate fpmlExchangeRate) {
			PriceSchedule.PriceScheduleBuilder price = PriceSchedule.builder();
			return assignOutput(price, fpmlExchangeRate);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder price, ExchangeRate fpmlExchangeRate) {
			if (exists(rate(fpmlExchangeRate)).getOrDefault(false)) {
				PriceComposite ifThenElseResult = null;
				if (exists(spotRate(fpmlExchangeRate)).andNullSafe(exists(forwardPoints(fpmlExchangeRate))).getOrDefault(false)) {
					ifThenElseResult = PriceComposite.builder()
						.setBaseValue(spotRate(fpmlExchangeRate).get())
						.setOperand(forwardPoints(fpmlExchangeRate).get())
						.setArithmeticOperator(ArithmeticOperationEnum.ADD)
						.setOperandType(PriceOperandEnum.FORWARD_POINT)
						.build();
				}
				price = toBuilder(PriceSchedule.builder()
					.setValue(rate(fpmlExchangeRate).get())
					.setUnit(UnitType.builder()
						.setCurrency(mapCurrency.evaluate(fpmlCurrency(fpmlExchangeRate).get()))
						.build())
					.setPerUnitOf(UnitType.builder()
						.setCurrency(mapCurrency.evaluate(fpmlPerCurrency(fpmlExchangeRate).get()))
						.build())
					.setPriceType(PriceTypeEnum.EXCHANGE_RATE)
					.setComposite(ifThenElseResult)
					.build());
			} else {
				price = null;
			}
			
			return Optional.ofNullable(price)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<BigDecimal> rate(ExchangeRate fpmlExchangeRate) {
			return MapperS.of(fpmlExchangeRate).<BigDecimal>map("getRate", exchangeRate -> exchangeRate.getRate());
		}
		
		@Override
		protected MapperS<BigDecimal> spotRate(ExchangeRate fpmlExchangeRate) {
			return MapperS.of(fpmlExchangeRate).<BigDecimal>map("getSpotRate", exchangeRate -> exchangeRate.getSpotRate());
		}
		
		@Override
		protected MapperS<BigDecimal> forwardPoints(ExchangeRate fpmlExchangeRate) {
			return MapperS.of(fpmlExchangeRate).<BigDecimal>map("getForwardPoints", exchangeRate -> exchangeRate.getForwardPoints());
		}
		
		@Override
		protected MapperS<? extends QuotedCurrencyPair> quotedCurrencyPair(ExchangeRate fpmlExchangeRate) {
			return MapperS.of(fpmlExchangeRate).<QuotedCurrencyPair>map("getQuotedCurrencyPair", exchangeRate -> exchangeRate.getQuotedCurrencyPair());
		}
		
		@Override
		protected MapperS<? extends Currency> fpmlCurrency(ExchangeRate fpmlExchangeRate) {
			if (areEqual(quotedCurrencyPair(fpmlExchangeRate).<QuoteBasisEnum>map("getQuoteBasis", _quotedCurrencyPair -> _quotedCurrencyPair.getQuoteBasis()), MapperS.of(QuoteBasisEnum.CURRENCY_1_PER_CURRENCY_2), CardinalityOperator.All).getOrDefault(false)) {
				return quotedCurrencyPair(fpmlExchangeRate).<Currency>map("getCurrency1", _quotedCurrencyPair -> _quotedCurrencyPair.getCurrency1());
			}
			return quotedCurrencyPair(fpmlExchangeRate).<Currency>map("getCurrency2", _quotedCurrencyPair -> _quotedCurrencyPair.getCurrency2());
		}
		
		@Override
		protected MapperS<? extends Currency> fpmlPerCurrency(ExchangeRate fpmlExchangeRate) {
			if (areEqual(quotedCurrencyPair(fpmlExchangeRate).<QuoteBasisEnum>map("getQuoteBasis", _quotedCurrencyPair -> _quotedCurrencyPair.getQuoteBasis()), MapperS.of(QuoteBasisEnum.CURRENCY_1_PER_CURRENCY_2), CardinalityOperator.All).getOrDefault(false)) {
				return quotedCurrencyPair(fpmlExchangeRate).<Currency>map("getCurrency2", _quotedCurrencyPair -> _quotedCurrencyPair.getCurrency2());
			}
			return quotedCurrencyPair(fpmlExchangeRate).<Currency>map("getCurrency1", _quotedCurrencyPair -> _quotedCurrencyPair.getCurrency1());
		}
	}
}
