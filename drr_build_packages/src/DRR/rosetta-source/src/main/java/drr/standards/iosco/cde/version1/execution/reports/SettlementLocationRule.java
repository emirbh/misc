package drr.standards.iosco.cde.version1.execution.reports;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.PayoutLegWithAuxiliary;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SettlementLocationRule.SettlementLocationRuleDefault.class)
public abstract class SettlementLocationRule implements ReportFunction<PayoutLegWithAuxiliary, ISOCountryCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected SettlementTermsRule settlementTermsRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCountryCodeEnum evaluate(PayoutLegWithAuxiliary input) {
		ISOCountryCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCountryCodeEnum doEvaluate(PayoutLegWithAuxiliary input);

	public static class SettlementLocationRuleDefault extends SettlementLocationRule {
		@Override
		protected ISOCountryCodeEnum doEvaluate(PayoutLegWithAuxiliary input) {
			ISOCountryCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCountryCodeEnum assignOutput(ISOCountryCodeEnum output, PayoutLegWithAuxiliary input) {
			output = MapperS.of(settlementTermsRule.evaluate(input))
				.mapSingleToItem(item -> {
					if (areEqual(item.<SettlementTypeEnum>map("getSettlementType", settlementTerms -> settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH), CardinalityOperator.All).orNullSafe(exists(item.<CashSettlementTerms>mapC("getCashSettlementTerms", settlementTerms -> settlementTerms.getCashSettlementTerms()))).andNullSafe(areEqual(item.<FieldWithMetaString>map("getSettlementCurrency", settlementTerms -> settlementTerms.getSettlementCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()), MapperS.of("CNH"), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(ISOCountryCodeEnum.HK);
					}
					return MapperS.<ISOCountryCodeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
