package cdm.legaldocumentation.csa.validation.exists;

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
import cdm.legaldocumentation.csa.SubstitutedRegime;
import cdm.legaldocumentation.csa.Substitution;
import cdm.legaldocumentation.csa.TerminationCurrencyAmendment;
import cdm.product.collateral.ContactElection;
import cdm.product.collateral.DistributionAndInterestPayment;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditSupportAgreementElectionsOnlyExistsValidator implements ValidatorWithArg<CreditSupportAgreementElections, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditSupportAgreementElections> ValidationResult<CreditSupportAgreementElections> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("regime", ExistenceChecker.isSet((Regime) o.getRegime()))
				.put("oneWayProvisions", ExistenceChecker.isSet((OneWayProvisions) o.getOneWayProvisions()))
				.put("generalSimmElections", ExistenceChecker.isSet((GeneralSimmElections) o.getGeneralSimmElections()))
				.put("identifiedCrossCurrencySwap", ExistenceChecker.isSet((Boolean) o.getIdentifiedCrossCurrencySwap()))
				.put("sensitivityMethodologies", ExistenceChecker.isSet((SensitivityMethodologies) o.getSensitivityMethodologies()))
				.put("fxHaircutCurrency", ExistenceChecker.isSet((FxHaircutCurrency) o.getFxHaircutCurrency()))
				.put("postingObligations", ExistenceChecker.isSet((PostingObligations) o.getPostingObligations()))
				.put("substitutedRegime", ExistenceChecker.isSet((List<? extends SubstitutedRegime>) o.getSubstitutedRegime()))
				.put("baseAndEligibleCurrency", ExistenceChecker.isSet((BaseAndEligibleCurrency) o.getBaseAndEligibleCurrency()))
				.put("additionalObligations", ExistenceChecker.isSet((String) o.getAdditionalObligations()))
				.put("coveredTransactions", ExistenceChecker.isSet((CoveredTransactions) o.getCoveredTransactions()))
				.put("creditSupportObligations", ExistenceChecker.isSet((CreditSupportObligations) o.getCreditSupportObligations()))
				.put("exchangeDate", ExistenceChecker.isSet((String) o.getExchangeDate()))
				.put("calculationAndTiming", ExistenceChecker.isSet((CalculationAndTiming) o.getCalculationAndTiming()))
				.put("conditionsPrecedent", ExistenceChecker.isSet((ConditionsPrecedent) o.getConditionsPrecedent()))
				.put("substitution", ExistenceChecker.isSet((Substitution) o.getSubstitution()))
				.put("disputeResolution", ExistenceChecker.isSet((DisputeResolution) o.getDisputeResolution()))
				.put("holdingAndUsingPostedCollateral", ExistenceChecker.isSet((HoldingAndUsingPostedCollateral) o.getHoldingAndUsingPostedCollateral()))
				.put("rightsEvents", ExistenceChecker.isSet((RightsEvents) o.getRightsEvents()))
				.put("custodyArrangements", ExistenceChecker.isSet((CustodyArrangements) o.getCustodyArrangements()))
				.put("distributionAndInterestPayment", ExistenceChecker.isSet((DistributionAndInterestPayment) o.getDistributionAndInterestPayment()))
				.put("creditSupportOffsets", ExistenceChecker.isSet((Boolean) o.getCreditSupportOffsets()))
				.put("additionalRepresentations", ExistenceChecker.isSet((AdditionalRepresentations) o.getAdditionalRepresentations()))
				.put("otherEligibleAndPostedSupport", ExistenceChecker.isSet((OtherEligibleAndPostedSupport) o.getOtherEligibleAndPostedSupport()))
				.put("demandsAndNotices", ExistenceChecker.isSet((ContactElection) o.getDemandsAndNotices()))
				.put("addressesForTransfer", ExistenceChecker.isSet((ContactElection) o.getAddressesForTransfer()))
				.put("otherAgreements", ExistenceChecker.isSet((OtherAgreements) o.getOtherAgreements()))
				.put("terminationCurrencyAmendment", ExistenceChecker.isSet((TerminationCurrencyAmendment) o.getTerminationCurrencyAmendment()))
				.put("minimumTransferAmountAmendment", ExistenceChecker.isSet((MinimumTransferAmountAmendment) o.getMinimumTransferAmountAmendment()))
				.put("interpretationTerms", ExistenceChecker.isSet((String) o.getInterpretationTerms()))
				.put("processAgent", ExistenceChecker.isSet((ProcessAgent) o.getProcessAgent()))
				.put("appropriatedCollateralValuation", ExistenceChecker.isSet((AppropriatedCollateralValuation) o.getAppropriatedCollateralValuation()))
				.put("jurisdictionRelatedTerms", ExistenceChecker.isSet((JurisdictionRelatedTerms) o.getJurisdictionRelatedTerms()))
				.put("additionalAmendments", ExistenceChecker.isSet((String) o.getAdditionalAmendments()))
				.put("additionalBespokeTerms", ExistenceChecker.isSet((String) o.getAdditionalBespokeTerms()))
				.put("trustSchemeAddendum", ExistenceChecker.isSet((Boolean) o.getTrustSchemeAddendum()))
				.put("securityInterestForObligations", ExistenceChecker.isSet((SecurityInterestForObligations) o.getSecurityInterestForObligations()))
				.put("singlePostingParty", ExistenceChecker.isSet((SinglePostingParty) o.getSinglePostingParty()))
				.put("datedAsOfDate", ExistenceChecker.isSet((DatedAsOfDate) o.getDatedAsOfDate()))
				.put("cass", ExistenceChecker.isSet((String) o.getCass()))
				.put("otherCSA", ExistenceChecker.isSet((String) o.getOtherCSA()))
				.put("legacyAdditionalRepresentations", ExistenceChecker.isSet((String) o.getLegacyAdditionalRepresentations()))
				.put("value", ExistenceChecker.isSet((CollateralValueMethod) o.getValue()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditSupportAgreementElections", ValidationResult.ValidationType.ONLY_EXISTS, "CreditSupportAgreementElections", path, "");
		}
		return failure("CreditSupportAgreementElections", ValidationResult.ValidationType.ONLY_EXISTS, "CreditSupportAgreementElections", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
