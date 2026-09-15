package drr.base.trade.quantity.functions;

import cdm.base.math.Measure;
import cdm.base.math.UnitType;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;


@ImplementedBy(CurrencyFromNotional.CurrencyFromNotionalDefault.class)
public abstract class CurrencyFromNotional implements RosettaFunction {

	/**
	* @param measure 
	* @return notionalCurrency 
	*/
	public ISOCurrencyCodeEnum evaluate(Measure measure) {
		ISOCurrencyCodeEnum notionalCurrency = doEvaluate(measure);
		
		return notionalCurrency;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(Measure measure);

	public static class CurrencyFromNotionalDefault extends CurrencyFromNotional {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(Measure measure) {
			ISOCurrencyCodeEnum notionalCurrency = null;
			return assignOutput(notionalCurrency, measure);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum notionalCurrency, Measure measure) {
			notionalCurrency = MapperS.of(measure).<UnitType>map("getUnit", _measure -> _measure.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()).checkedMap("to-enum", ISOCurrencyCodeEnum::fromDisplayName, IllegalArgumentException.class).get();
			
			return notionalCurrency;
		}
	}
}
