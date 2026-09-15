package drr.base.trade.price.functions;

import cdm.base.math.UnitType;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.price.PriceNotationEnum;
import drr.standards.iso.functions.ConvertNonISOToISOCurrency;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CurrencyPairOrCurrencyFromPrice.CurrencyPairOrCurrencyFromPriceDefault.class)
public abstract class CurrencyPairOrCurrencyFromPrice implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ConvertNonISOToISOCurrency convertNonISOToISOCurrency;
	@Inject protected NotationFromPrice notationFromPrice;

	/**
	* @param price 
	* @param defaultSingleCurrency 
	* @return currency 
	*/
	public String evaluate(PriceSchedule price, Boolean defaultSingleCurrency) {
		String currency = doEvaluate(price, defaultSingleCurrency);
		
		return currency;
	}

	protected abstract String doEvaluate(PriceSchedule price, Boolean defaultSingleCurrency);

	public static class CurrencyPairOrCurrencyFromPriceDefault extends CurrencyPairOrCurrencyFromPrice {
		@Override
		protected String doEvaluate(PriceSchedule price, Boolean defaultSingleCurrency) {
			String currency = null;
			return assignOutput(currency, price, defaultSingleCurrency);
		}
		
		protected String assignOutput(String currency, PriceSchedule price, Boolean defaultSingleCurrency) {
			final MapperS<PriceSchedule> thenArg0 = MapperS.of(price);
			final MapperS<PriceSchedule> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(notationFromPrice.evaluate(item.get())), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(price);
					}
					return MapperS.<PriceSchedule>ofNull();
				});
			currency = thenArg1
				.mapSingleToItem(item -> {
					if (areEqual(item.<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.EXCHANGE_RATE), CardinalityOperator.All).andNullSafe(exists(item.<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()))).andNullSafe(exists(item.<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()))).getOrDefault(false)) {
						final FieldWithMetaString fieldWithMetaString0 = item.<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
						final FieldWithMetaString fieldWithMetaString1 = item.<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
						return MapperMaths.<String, String, String>add(MapperMaths.<String, String, String>add(MapperS.of(convertNonISOToISOCurrency.evaluate((fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()))).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of("/")), MapperS.of(convertNonISOToISOCurrency.evaluate((fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()))).map("to-string", ISOCurrencyCodeEnum::toDisplayString));
					}
					if (areEqual(MapperS.of(defaultSingleCurrency), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						final FieldWithMetaString fieldWithMetaString2 = item.<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
						return MapperS.of(convertNonISOToISOCurrency.evaluate((fieldWithMetaString2 == null ? null : fieldWithMetaString2.getValue()))).map("to-string", ISOCurrencyCodeEnum::toDisplayString);
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return currency;
		}
	}
}
