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
import drr.standards.iosco.cde.version3.collateral.reports.CollateralPortfolioCodeRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CollateralPortfolioCodeVariationMarginRule.CollateralPortfolioCodeVariationMarginRuleDefault.class)
public abstract class CollateralPortfolioCodeVariationMarginRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CollateralPortfolioCodeRule collateralPortfolioCodeRule;
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

	public static class CollateralPortfolioCodeVariationMarginRuleDefault extends CollateralPortfolioCodeVariationMarginRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			final FieldWithMetaString fieldWithMetaString = thenArg
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(tradeForEvent.evaluate(item.get())).<Collateral>map("getCollateral", trade -> trade.getCollateral()).<ReferenceWithMetaCollateralPortfolio>mapC("getCollateralPortfolio", collateral -> collateral.getCollateralPortfolio()).<CollateralPortfolio>map("Type coercion", _referenceWithMetaCollateralPortfolio -> _referenceWithMetaCollateralPortfolio.getValue()).<Identifier>map("getPortfolioIdentifier", collateralPortfolio -> collateralPortfolio.getPortfolioIdentifier())).getOrDefault(false)) {
						final MapperC<ReferenceWithMetaCollateralPortfolio> thenArg0 = MapperS.of(tradeForEvent.evaluate(item.get())).<Collateral>map("getCollateral", trade -> trade.getCollateral()).<ReferenceWithMetaCollateralPortfolio>mapC("getCollateralPortfolio", collateral -> collateral.getCollateralPortfolio());
						final MapperC<ReferenceWithMetaCollateralPortfolio> thenArg1 = thenArg0
							.filterItemNullSafe(_item -> areEqual(_item.<CollateralPortfolio>map("Type coercion", _referenceWithMetaCollateralPortfolio -> _referenceWithMetaCollateralPortfolio == null ? null : _referenceWithMetaCollateralPortfolio.getValue()).<ReferenceWithMetaLegalAgreement>map("getLegalAgreement", collateralPortfolio -> collateralPortfolio.getLegalAgreement()).<LegalAgreement>map("Type coercion", referenceWithMetaLegalAgreement -> referenceWithMetaLegalAgreement == null ? null : referenceWithMetaLegalAgreement.getValue()).<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<CollateralMarginTypeEnum>map("getCreditSupportAgreementMarginType", agreementName -> agreementName.getCreditSupportAgreementMarginType()), MapperS.of(CollateralMarginTypeEnum.VARIATION_MARGIN), CardinalityOperator.All).get());
						final MapperS<ReferenceWithMetaCollateralPortfolio> thenArg2 = MapperS.of(thenArg1.get());
						return thenArg2.<CollateralPortfolio>map("Type coercion", referenceWithMetaCollateralPortfolio -> referenceWithMetaCollateralPortfolio == null ? null : referenceWithMetaCollateralPortfolio.getValue()).<Identifier>map("getPortfolioIdentifier", collateralPortfolio -> collateralPortfolio.getPortfolioIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier())
							.last();
					}
					if (exists(MapperS.of(tradeForEvent.evaluate(item.get())).<Collateral>map("getCollateral", trade -> trade.getCollateral()).<Identifier>mapC("getPortfolioIdentifier", collateral -> collateral.getPortfolioIdentifier())).getOrDefault(false)) {
						final String string = collateralPortfolioCodeRule.evaluate(item.get());
						return string == null ? MapperS.<FieldWithMetaString>ofNull() : MapperS.of(FieldWithMetaString.builder().setValue(string).build());
					}
					return MapperS.<FieldWithMetaString>ofNull();
				}).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
