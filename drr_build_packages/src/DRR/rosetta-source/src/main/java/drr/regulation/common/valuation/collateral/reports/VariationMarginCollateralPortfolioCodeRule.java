package drr.regulation.common.valuation.collateral.reports;

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
import drr.regulation.common.ValuationReportInstruction;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(VariationMarginCollateralPortfolioCodeRule.VariationMarginCollateralPortfolioCodeRuleDefault.class)
public abstract class VariationMarginCollateralPortfolioCodeRule implements ReportFunction<ValuationReportInstruction, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(ValuationReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(ValuationReportInstruction input);

	public static class VariationMarginCollateralPortfolioCodeRuleDefault extends VariationMarginCollateralPortfolioCodeRule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			final MapperC<ReferenceWithMetaCollateralPortfolio> thenArg0 = MapperS.of(input)
				.mapSingleToList(item -> item.<Collateral>map("getCollateralDetails", valuationReportInstruction -> valuationReportInstruction.getCollateralDetails()).<ReferenceWithMetaCollateralPortfolio>mapC("getCollateralPortfolio", collateral -> collateral.getCollateralPortfolio()));
			final MapperC<ReferenceWithMetaCollateralPortfolio> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<CollateralPortfolio>map("Type coercion", _referenceWithMetaCollateralPortfolio -> _referenceWithMetaCollateralPortfolio == null ? null : _referenceWithMetaCollateralPortfolio.getValue()).<ReferenceWithMetaLegalAgreement>map("getLegalAgreement", collateralPortfolio -> collateralPortfolio.getLegalAgreement()).<LegalAgreement>map("Type coercion", referenceWithMetaLegalAgreement -> referenceWithMetaLegalAgreement == null ? null : referenceWithMetaLegalAgreement.getValue()).<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<CollateralMarginTypeEnum>map("getCreditSupportAgreementMarginType", agreementName -> agreementName.getCreditSupportAgreementMarginType()), MapperS.of(CollateralMarginTypeEnum.VARIATION_MARGIN), CardinalityOperator.All).get());
			final MapperS<ReferenceWithMetaCollateralPortfolio> thenArg2 = MapperS.of(thenArg1.get());
			final FieldWithMetaString fieldWithMetaString = thenArg2.<CollateralPortfolio>map("Type coercion", referenceWithMetaCollateralPortfolio -> referenceWithMetaCollateralPortfolio == null ? null : referenceWithMetaCollateralPortfolio.getValue()).<Identifier>map("getPortfolioIdentifier", collateralPortfolio -> collateralPortfolio.getPortfolioIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier())
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
