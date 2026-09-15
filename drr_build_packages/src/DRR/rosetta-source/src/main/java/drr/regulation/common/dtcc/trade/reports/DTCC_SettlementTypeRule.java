package drr.regulation.common.dtcc.trade.reports;

import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.execution.reports.SettlementTermsRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_SettlementTypeRule.DTCC_SettlementTypeRuleDefault.class)
public abstract class DTCC_SettlementTypeRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;
	@Inject protected SettlementTermsRule settlementTermsRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class DTCC_SettlementTypeRuleDefault extends DTCC_SettlementTypeRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get()))));
			final MapperS<SettlementTerms> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(settlementTermsRule.evaluate(item.get())));
			output = thenArg1
				.mapSingleToItem(item -> {
					if (areEqual(item.<SettlementTypeEnum>map("getSettlementType", settlementTerms -> settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH), CardinalityOperator.All).orNullSafe(exists(item.<CashSettlementTerms>mapC("getCashSettlementTerms", settlementTerms -> settlementTerms.getCashSettlementTerms()))).getOrDefault(false)) {
						return MapperS.of("Cash");
					}
					if (areEqual(item.<SettlementTypeEnum>map("getSettlementType", settlementTerms -> settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.PHYSICAL), CardinalityOperator.All).orNullSafe(exists(item.<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", settlementTerms -> settlementTerms.getPhysicalSettlementTerms()))).getOrDefault(false)) {
						return MapperS.of("Physical");
					}
					if (areEqual(item.<SettlementTypeEnum>map("getSettlementType", settlementTerms -> settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH_OR_PHYSICAL), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("CashOrPhysical");
					}
					if (areEqual(item.<SettlementTypeEnum>map("getSettlementType", settlementTerms -> settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.ELECTION), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("Election");
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
