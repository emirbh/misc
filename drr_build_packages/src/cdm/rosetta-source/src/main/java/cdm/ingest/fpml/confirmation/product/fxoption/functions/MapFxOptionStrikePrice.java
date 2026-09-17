package cdm.ingest.fpml.confirmation.product.fxoption.functions;

import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceComposite;
import cdm.observable.asset.PriceTypeEnum;
import cdm.product.template.OptionStrike;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.StrikeQuoteBasisEnum;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.fx.FxStrikePrice;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxOptionStrikePrice.MapFxOptionStrikePriceDefault.class)
public abstract class MapFxOptionStrikePrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlFxOption 
	* @return strike 
	*/
	public OptionStrike evaluate(FxOption fpmlFxOption) {
		OptionStrike.OptionStrikeBuilder strikeBuilder = doEvaluate(fpmlFxOption);
		
		final OptionStrike strike;
		if (strikeBuilder == null) {
			strike = null;
		} else {
			strike = strikeBuilder.build();
			objectValidator.validate(OptionStrike.class, strike);
		}
		
		return strike;
	}

	protected abstract OptionStrike.OptionStrikeBuilder doEvaluate(FxOption fpmlFxOption);

	protected abstract MapperS<? extends UnitType> priceUnits(FxOption fpmlFxOption);

	protected abstract MapperS<? extends UnitType> perUnitOf(FxOption fpmlFxOption);

	public static class MapFxOptionStrikePriceDefault extends MapFxOptionStrikePrice {
		@Override
		protected OptionStrike.OptionStrikeBuilder doEvaluate(FxOption fpmlFxOption) {
			OptionStrike.OptionStrikeBuilder strike = OptionStrike.builder();
			return assignOutput(strike, fpmlFxOption);
		}
		
		protected OptionStrike.OptionStrikeBuilder assignOutput(OptionStrike.OptionStrikeBuilder strike, FxOption fpmlFxOption) {
			strike = toBuilder(OptionStrike.builder()
				.setStrikePrice(Price.builder()
					.setValue(MapperS.of(fpmlFxOption).<FxStrikePrice>map("getStrike", fxOption -> fxOption.getStrike()).<BigDecimal>map("getRate", fxStrikePrice -> fxStrikePrice.getRate()).get())
					.setUnit(priceUnits(fpmlFxOption).get())
					.setPerUnitOf(perUnitOf(fpmlFxOption).get())
					.setPriceType(PriceTypeEnum.EXCHANGE_RATE)
					.setComposite(PriceComposite.builder()
						.setBaseValue(MapperS.of(fpmlFxOption).<BigDecimal>map("getSpotRate", fxOption -> fxOption.getSpotRate()).get())
						.setOperand(null)
						.setArithmeticOperator(null)
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(strike)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends UnitType> priceUnits(FxOption fpmlFxOption) {
			final Currency ifThenElseResult;
			if (areEqual(MapperS.of(fpmlFxOption).<FxStrikePrice>map("getStrike", fxOption -> fxOption.getStrike()).<StrikeQuoteBasisEnum>map("getStrikeQuoteBasis", fxStrikePrice -> fxStrikePrice.getStrikeQuoteBasis()), MapperS.of(StrikeQuoteBasisEnum.CALL_CURRENCY_PER_PUT_CURRENCY), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(fpmlFxOption).<NonNegativeMoney>map("getCallCurrencyAmount", fxOption -> fxOption.getCallCurrencyAmount()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get();
			} else {
				ifThenElseResult = MapperS.of(fpmlFxOption).<NonNegativeMoney>map("getPutCurrencyAmount", fxOption -> fxOption.getPutCurrencyAmount()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get();
			}
			return MapperS.of(UnitType.builder()
				.setCurrency(mapCurrency.evaluate(ifThenElseResult))
				.build());
		}
		
		@Override
		protected MapperS<? extends UnitType> perUnitOf(FxOption fpmlFxOption) {
			final Currency ifThenElseResult;
			if (areEqual(MapperS.of(fpmlFxOption).<FxStrikePrice>map("getStrike", fxOption -> fxOption.getStrike()).<StrikeQuoteBasisEnum>map("getStrikeQuoteBasis", fxStrikePrice -> fxStrikePrice.getStrikeQuoteBasis()), MapperS.of(StrikeQuoteBasisEnum.CALL_CURRENCY_PER_PUT_CURRENCY), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(fpmlFxOption).<NonNegativeMoney>map("getPutCurrencyAmount", fxOption -> fxOption.getPutCurrencyAmount()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get();
			} else {
				ifThenElseResult = MapperS.of(fpmlFxOption).<NonNegativeMoney>map("getCallCurrencyAmount", fxOption -> fxOption.getCallCurrencyAmount()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get();
			}
			return MapperS.of(UnitType.builder()
				.setCurrency(mapCurrency.evaluate(ifThenElseResult))
				.build());
		}
	}
}
