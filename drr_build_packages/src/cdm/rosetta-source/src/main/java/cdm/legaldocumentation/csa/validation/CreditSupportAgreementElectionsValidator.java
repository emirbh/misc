package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.AdditionalRepresentations;
import cdm.legaldocumentation.csa.AppropriatedCollateralValuation;
import cdm.legaldocumentation.csa.BaseAndEligibleCurrency;
import cdm.legaldocumentation.csa.CalculationAndTiming;
import cdm.legaldocumentation.csa.CollateralValueMethod;
import cdm.legaldocumentation.csa.ConditionsPrecedent;
import cdm.legaldocumentation.csa.CoveredTransactions;
import cdm.legaldocumentation.csa.CreditSupportAgreementElections;
import cdm.legaldocumentation.csa.CreditSupportObligations;
import cdm.legaldocumentation.csa.CustodyArrangements;
import cdm.legaldocumentation.csa.DatedAsOfDate;
import cdm.legaldocumentation.csa.DisputeResolution;
import cdm.legaldocumentation.csa.FxHaircutCurrency;
import cdm.legaldocumentation.csa.GeneralSimmElections;
import cdm.legaldocumentation.csa.HoldingAndUsingPostedCollateral;
import cdm.legaldocumentation.csa.JurisdictionRelatedTerms;
import cdm.legaldocumentation.csa.MinimumTransferAmountAmendment;
import cdm.legaldocumentation.csa.OneWayProvisions;
import cdm.legaldocumentation.csa.OtherAgreements;
import cdm.legaldocumentation.csa.OtherEligibleAndPostedSupport;
import cdm.legaldocumentation.csa.PostingObligations;
import cdm.legaldocumentation.csa.ProcessAgent;
import cdm.legaldocumentation.csa.Regime;
import cdm.legaldocumentation.csa.RightsEvents;
import cdm.legaldocumentation.csa.SecurityInterestForObligations;
import cdm.legaldocumentation.csa.SensitivityMethodologies;
import cdm.legaldocumentation.csa.SinglePostingParty;
import cdm.legaldocumentation.csa.Substitution;
import cdm.legaldocumentation.csa.TerminationCurrencyAmendment;
import cdm.product.collateral.ContactElection;
import cdm.product.collateral.DistributionAndInterestPayment;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditSupportAgreementElectionsValidator implements Validator<CreditSupportAgreementElections> {

	private List<ComparisonResult> getComparisonResults(CreditSupportAgreementElections o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("regime", (Regime) o.getRegime() != null ? 1 : 0, 1, 1), 
				checkCardinality("oneWayProvisions", (OneWayProvisions) o.getOneWayProvisions() != null ? 1 : 0, 1, 1), 
				checkCardinality("generalSimmElections", (GeneralSimmElections) o.getGeneralSimmElections() != null ? 1 : 0, 0, 1), 
				checkCardinality("identifiedCrossCurrencySwap", (Boolean) o.getIdentifiedCrossCurrencySwap() != null ? 1 : 0, 0, 1), 
				checkCardinality("sensitivityMethodologies", (SensitivityMethodologies) o.getSensitivityMethodologies() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxHaircutCurrency", (FxHaircutCurrency) o.getFxHaircutCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("postingObligations", (PostingObligations) o.getPostingObligations() != null ? 1 : 0, 1, 1), 
				checkCardinality("baseAndEligibleCurrency", (BaseAndEligibleCurrency) o.getBaseAndEligibleCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("additionalObligations", (String) o.getAdditionalObligations() != null ? 1 : 0, 0, 1), 
				checkCardinality("coveredTransactions", (CoveredTransactions) o.getCoveredTransactions() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditSupportObligations", (CreditSupportObligations) o.getCreditSupportObligations() != null ? 1 : 0, 1, 1), 
				checkCardinality("exchangeDate", (String) o.getExchangeDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationAndTiming", (CalculationAndTiming) o.getCalculationAndTiming() != null ? 1 : 0, 1, 1), 
				checkCardinality("conditionsPrecedent", (ConditionsPrecedent) o.getConditionsPrecedent() != null ? 1 : 0, 0, 1), 
				checkCardinality("substitution", (Substitution) o.getSubstitution() != null ? 1 : 0, 1, 1), 
				checkCardinality("disputeResolution", (DisputeResolution) o.getDisputeResolution() != null ? 1 : 0, 1, 1), 
				checkCardinality("holdingAndUsingPostedCollateral", (HoldingAndUsingPostedCollateral) o.getHoldingAndUsingPostedCollateral() != null ? 1 : 0, 1, 1), 
				checkCardinality("rightsEvents", (RightsEvents) o.getRightsEvents() != null ? 1 : 0, 1, 1), 
				checkCardinality("custodyArrangements", (CustodyArrangements) o.getCustodyArrangements() != null ? 1 : 0, 0, 1), 
				checkCardinality("distributionAndInterestPayment", (DistributionAndInterestPayment) o.getDistributionAndInterestPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditSupportOffsets", (Boolean) o.getCreditSupportOffsets() != null ? 1 : 0, 1, 1), 
				checkCardinality("additionalRepresentations", (AdditionalRepresentations) o.getAdditionalRepresentations() != null ? 1 : 0, 1, 1), 
				checkCardinality("otherEligibleAndPostedSupport", (OtherEligibleAndPostedSupport) o.getOtherEligibleAndPostedSupport() != null ? 1 : 0, 1, 1), 
				checkCardinality("demandsAndNotices", (ContactElection) o.getDemandsAndNotices() != null ? 1 : 0, 0, 1), 
				checkCardinality("addressesForTransfer", (ContactElection) o.getAddressesForTransfer() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherAgreements", (OtherAgreements) o.getOtherAgreements() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationCurrencyAmendment", (TerminationCurrencyAmendment) o.getTerminationCurrencyAmendment() != null ? 1 : 0, 1, 1), 
				checkCardinality("minimumTransferAmountAmendment", (MinimumTransferAmountAmendment) o.getMinimumTransferAmountAmendment() != null ? 1 : 0, 1, 1), 
				checkCardinality("interpretationTerms", (String) o.getInterpretationTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("processAgent", (ProcessAgent) o.getProcessAgent() != null ? 1 : 0, 0, 1), 
				checkCardinality("appropriatedCollateralValuation", (AppropriatedCollateralValuation) o.getAppropriatedCollateralValuation() != null ? 1 : 0, 0, 1), 
				checkCardinality("jurisdictionRelatedTerms", (JurisdictionRelatedTerms) o.getJurisdictionRelatedTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalAmendments", (String) o.getAdditionalAmendments() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalBespokeTerms", (String) o.getAdditionalBespokeTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("trustSchemeAddendum", (Boolean) o.getTrustSchemeAddendum() != null ? 1 : 0, 1, 1), 
				checkCardinality("securityInterestForObligations", (SecurityInterestForObligations) o.getSecurityInterestForObligations() != null ? 1 : 0, 1, 1), 
				checkCardinality("singlePostingParty", (SinglePostingParty) o.getSinglePostingParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("datedAsOfDate", (DatedAsOfDate) o.getDatedAsOfDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("cass", (String) o.getCass() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherCSA", (String) o.getOtherCSA() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyAdditionalRepresentations", (String) o.getLegacyAdditionalRepresentations() != null ? 1 : 0, 0, 1), 
				checkCardinality("value", (CollateralValueMethod) o.getValue() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportAgreementElections o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportAgreementElections", ValidationResult.ValidationType.CARDINALITY, "CreditSupportAgreementElections", path, "", res.getError());
				}
				return success("CreditSupportAgreementElections", ValidationResult.ValidationType.CARDINALITY, "CreditSupportAgreementElections", path, "");
			})
			.collect(toList());
	}

}
