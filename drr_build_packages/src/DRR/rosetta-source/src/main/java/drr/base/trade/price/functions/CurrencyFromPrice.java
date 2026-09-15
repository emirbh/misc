package drr.base.trade.price.functions;

import cdm.base.math.UnitType;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.observable.asset.PriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.price.PriceNotationEnum;
import drr.standards.iso.functions.ConvertNonISOToISOCurrency;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CurrencyFromPrice.CurrencyFromPriceDefault.class)
public abstract class CurrencyFromPrice implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ConvertNonISOToISOCurrency convertNonISOToISOCurrency;
	@Inject protected NotationFromPrice notationFromPrice;

	/**
	* @param price 
	* @return currency 
	*/
	public ISOCurrencyCodeEnum evaluate(PriceSchedule price) {
		ISOCurrencyCodeEnum currency = doEvaluate(price);
		
		return currency;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(PriceSchedule price);

	public static class CurrencyFromPriceDefault extends CurrencyFromPrice {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(PriceSchedule price) {
			ISOCurrencyCodeEnum currency = null;
			return assignOutput(currency, price);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum currency, PriceSchedule price) {
			final MapperS<PriceSchedule> thenArg0 = MapperS.of(price);
			final MapperS<FieldWithMetaString> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(notationFromPrice.evaluate(item.get())), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
						return item.<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency());
					}
					return MapperS.<FieldWithMetaString>ofNull();
				});
			currency = thenArg1
				.mapSingleToItem(item -> {
					final FieldWithMetaString fieldWithMetaString = item.get();
					return MapperS.of(convertNonISOToISOCurrency.evaluate((fieldWithMetaString == null ? null : fieldWithMetaString.getValue())));
				}).get();
			
			return currency;
		}
	}
}
