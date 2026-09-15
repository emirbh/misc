package drr.standards.iosco.cde.version1.execution.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.standards.iso.functions.ConvertNonISOToISOCurrency;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SettlementCurrencyRule.SettlementCurrencyRuleDefault.class)
public abstract class SettlementCurrencyRule implements ReportFunction<PayoutLegWithAuxiliary, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ConvertNonISOToISOCurrency convertNonISOToISOCurrency;
	@Inject protected SettlementTermsRule settlementTermsRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCurrencyCodeEnum evaluate(PayoutLegWithAuxiliary input) {
		ISOCurrencyCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(PayoutLegWithAuxiliary input);

	public static class SettlementCurrencyRuleDefault extends SettlementCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(PayoutLegWithAuxiliary input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, PayoutLegWithAuxiliary input) {
			final MapperS<SettlementTerms> thenArg0 = MapperS.of(settlementTermsRule.evaluate(input));
			final MapperS<FieldWithMetaString> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					if (areEqual(item.<SettlementTypeEnum>map("getSettlementType", settlementTerms -> settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH), CardinalityOperator.All).orNullSafe(exists(item.<CashSettlementTerms>mapC("getCashSettlementTerms", settlementTerms -> settlementTerms.getCashSettlementTerms()))).getOrDefault(false)) {
						return item.<FieldWithMetaString>map("getSettlementCurrency", settlementTerms -> settlementTerms.getSettlementCurrency());
					}
					return MapperS.<FieldWithMetaString>ofNull();
				});
			output = thenArg1
				.mapSingleToItem(item -> {
					final FieldWithMetaString fieldWithMetaString = item.get();
					return MapperS.of(convertNonISOToISOCurrency.evaluate((fieldWithMetaString == null ? null : fieldWithMetaString.getValue())));
				}).get();
			
			return output;
		}
	}
}
