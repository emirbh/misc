package drr.base.margin.functions;

import cdm.base.math.UnitType;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.event.common.CollateralBalance;
import cdm.event.common.HaircutIndicatorEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.standards.iso.functions.ConvertNonISOToISOCurrency;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetMarginCurrency.GetMarginCurrencyDefault.class)
public abstract class GetMarginCurrency implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ConvertNonISOToISOCurrency convertNonISOToISOCurrency;
	@Inject protected GetMarginValue getMarginValue;

	/**
	* @param partyCollateralBalances 
	* @return marginCurrency 
	*/
	public ISOCurrencyCodeEnum evaluate(List<? extends CollateralBalance> partyCollateralBalances) {
		ISOCurrencyCodeEnum marginCurrency = doEvaluate(partyCollateralBalances);
		
		return marginCurrency;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(List<? extends CollateralBalance> partyCollateralBalances);

	public static class GetMarginCurrencyDefault extends GetMarginCurrency {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(List<? extends CollateralBalance> partyCollateralBalances) {
			if (partyCollateralBalances == null) {
				partyCollateralBalances = Collections.emptyList();
			}
			ISOCurrencyCodeEnum marginCurrency = null;
			return assignOutput(marginCurrency, partyCollateralBalances);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum marginCurrency, List<? extends CollateralBalance> partyCollateralBalances) {
			if (areEqual(MapperS.of(getMarginValue.evaluate(partyCollateralBalances, HaircutIndicatorEnum.PRE_HAIRCUT)).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), MapperS.of(getMarginValue.evaluate(partyCollateralBalances, HaircutIndicatorEnum.POST_HAIRCUT)).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), CardinalityOperator.All).getOrDefault(false)) {
				final MapperS<FieldWithMetaString> thenArg = MapperS.of(getMarginValue.evaluate(partyCollateralBalances, HaircutIndicatorEnum.PRE_HAIRCUT)).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency());
				marginCurrency = thenArg
					.mapSingleToItem(item -> {
						final FieldWithMetaString fieldWithMetaString = item.get();
						return MapperS.of(convertNonISOToISOCurrency.evaluate((fieldWithMetaString == null ? null : fieldWithMetaString.getValue())));
					}).get();
			} else {
				marginCurrency = null;
			}
			
			return marginCurrency;
		}
	}
}
