package drr.standards.iosco.cde.version1.valuation.functions;

import cdm.base.math.UnitType;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.event.common.Valuation;
import cdm.observable.asset.Money;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.standards.iso.functions.ConvertNonISOToISOCurrency;
import javax.inject.Inject;


@ImplementedBy(ValuationCurrencyFromValuation.ValuationCurrencyFromValuationDefault.class)
public abstract class ValuationCurrencyFromValuation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ConvertNonISOToISOCurrency convertNonISOToISOCurrency;

	/**
	* @param valuation 
	* @return valuationCurrency 
	*/
	public ISOCurrencyCodeEnum evaluate(Valuation valuation) {
		ISOCurrencyCodeEnum valuationCurrency = doEvaluate(valuation);
		
		return valuationCurrency;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(Valuation valuation);

	public static class ValuationCurrencyFromValuationDefault extends ValuationCurrencyFromValuation {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(Valuation valuation) {
			ISOCurrencyCodeEnum valuationCurrency = null;
			return assignOutput(valuationCurrency, valuation);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum valuationCurrency, Valuation valuation) {
			final MapperS<FieldWithMetaString> thenArg = MapperS.of(valuation).<Money>map("getAmount", _valuation -> _valuation.getAmount()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency());
			valuationCurrency = thenArg
				.mapSingleToItem(item -> {
					final FieldWithMetaString fieldWithMetaString = item.get();
					return MapperS.of(convertNonISOToISOCurrency.evaluate((fieldWithMetaString == null ? null : fieldWithMetaString.getValue())));
				}).get();
			
			return valuationCurrency;
		}
	}
}
