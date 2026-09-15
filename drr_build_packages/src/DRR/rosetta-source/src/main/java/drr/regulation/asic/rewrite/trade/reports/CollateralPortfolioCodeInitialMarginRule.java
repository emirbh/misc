package drr.regulation.asic.rewrite.trade.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.Identifier;
import cdm.event.common.CollateralPortfolio;
import cdm.event.common.metafields.ReferenceWithMetaCollateralPortfolio;
import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.legaldocumentation.common.metafields.ReferenceWithMetaLegalAgreement;
import cdm.product.collateral.Collateral;
import cdm.product.collateral.CollateralMarginTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CollateralPortfolioCodeInitialMarginRule.CollateralPortfolioCodeInitialMarginRuleDefault.class)
public abstract class CollateralPortfolioCodeInitialMarginRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected TradeForEvent tradeForEvent;

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

	public static class CollateralPortfolioCodeInitialMarginRuleDefault extends CollateralPortfolioCodeInitialMarginRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			final MapperC<ReferenceWithMetaCollateralPortfolio> thenArg1 = thenArg0
				.mapSingleToList(item -> MapperS.of(tradeForEvent.evaluate(item.get())).<Collateral>map("getCollateral", trade -> trade.getCollateral()).<ReferenceWithMetaCollateralPortfolio>mapC("getCollateralPortfolio", collateral -> collateral.getCollateralPortfolio()));
			final MapperC<ReferenceWithMetaCollateralPortfolio> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(item.<CollateralPortfolio>map("Type coercion", _referenceWithMetaCollateralPortfolio -> _referenceWithMetaCollateralPortfolio == null ? null : _referenceWithMetaCollateralPortfolio.getValue()).<ReferenceWithMetaLegalAgreement>map("getLegalAgreement", collateralPortfolio -> collateralPortfolio.getLegalAgreement()).<LegalAgreement>map("Type coercion", referenceWithMetaLegalAgreement -> referenceWithMetaLegalAgreement == null ? null : referenceWithMetaLegalAgreement.getValue()).<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<CollateralMarginTypeEnum>map("getCreditSupportAgreementMarginType", agreementName -> agreementName.getCreditSupportAgreementMarginType()), MapperS.of(CollateralMarginTypeEnum.INITIAL_MARGIN), CardinalityOperator.All).get());
			final MapperS<ReferenceWithMetaCollateralPortfolio> thenArg3 = MapperS.of(thenArg2.get());
			final FieldWithMetaString fieldWithMetaString = thenArg3.<CollateralPortfolio>map("Type coercion", referenceWithMetaCollateralPortfolio -> referenceWithMetaCollateralPortfolio == null ? null : referenceWithMetaCollateralPortfolio.getValue()).<Identifier>map("getPortfolioIdentifier", collateralPortfolio -> collateralPortfolio.getPortfolioIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier())
				.last().get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
