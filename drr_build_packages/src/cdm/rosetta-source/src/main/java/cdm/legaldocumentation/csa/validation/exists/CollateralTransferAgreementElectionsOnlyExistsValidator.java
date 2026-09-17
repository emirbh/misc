package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.AdditionalRepresentations;
import cdm.legaldocumentation.csa.BaseAndEligibleCurrency;
import cdm.legaldocumentation.csa.CalculationAndTiming;
import cdm.legaldocumentation.csa.CollateralTransferAgreementElections;
import cdm.legaldocumentation.csa.ConditionsPrecedent;
import cdm.legaldocumentation.csa.CreditSupportObligations;
import cdm.legaldocumentation.csa.CustodyArrangements;
import cdm.legaldocumentation.csa.DisputeResolution;
import cdm.legaldocumentation.csa.FinalReturns;
import cdm.legaldocumentation.csa.FxHaircutCurrency;
import cdm.legaldocumentation.csa.GeneralSimmElections;
import cdm.legaldocumentation.csa.JurisdictionRelatedTerms;
import cdm.legaldocumentation.csa.MinimumTransferAmountAmendment;
import cdm.legaldocumentation.csa.OneWayProvisions;
import cdm.legaldocumentation.csa.PledgeeRepresentativeRider;
import cdm.legaldocumentation.csa.PostingObligations;
import cdm.legaldocumentation.csa.ProcessAgent;
import cdm.legaldocumentation.csa.Regime;
import cdm.legaldocumentation.csa.RightsEvents;
import cdm.legaldocumentation.csa.SensitivityMethodologies;
import cdm.legaldocumentation.csa.SubstitutedRegime;
import cdm.legaldocumentation.csa.Substitution;
import cdm.legaldocumentation.csa.TerminationCurrencyAmendment;
import cdm.product.collateral.ContactElection;
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

public class CollateralTransferAgreementElectionsOnlyExistsValidator implements ValidatorWithArg<CollateralTransferAgreementElections, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CollateralTransferAgreementElections> ValidationResult<CollateralTransferAgreementElections> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("creditSupportObligations", ExistenceChecker.isSet((CreditSupportObligations) o.getCreditSupportObligations()))
				.put("calculationAndTiming", ExistenceChecker.isSet((CalculationAndTiming) o.getCalculationAndTiming()))
				.put("conditionsPrecedent", ExistenceChecker.isSet((ConditionsPrecedent) o.getConditionsPrecedent()))
				.put("substitution", ExistenceChecker.isSet((Substitution) o.getSubstitution()))
				.put("disputeResolution", ExistenceChecker.isSet((DisputeResolution) o.getDisputeResolution()))
				.put("rightsEvents", ExistenceChecker.isSet((RightsEvents) o.getRightsEvents()))
				.put("custodyArrangements", ExistenceChecker.isSet((CustodyArrangements) o.getCustodyArrangements()))
				.put("additionalRepresentations", ExistenceChecker.isSet((AdditionalRepresentations) o.getAdditionalRepresentations()))
				.put("demandsAndNotices", ExistenceChecker.isSet((ContactElection) o.getDemandsAndNotices()))
				.put("addressesForTransfer", ExistenceChecker.isSet((ContactElection) o.getAddressesForTransfer()))
				.put("otherCsa", ExistenceChecker.isSet((String) o.getOtherCsa()))
				.put("terminationCurrencyAmendment", ExistenceChecker.isSet((TerminationCurrencyAmendment) o.getTerminationCurrencyAmendment()))
				.put("minimumTransferAmountAmendment", ExistenceChecker.isSet((MinimumTransferAmountAmendment) o.getMinimumTransferAmountAmendment()))
				.put("interpretationTerms", ExistenceChecker.isSet((String) o.getInterpretationTerms()))
				.put("processAgent", ExistenceChecker.isSet((ProcessAgent) o.getProcessAgent()))
				.put("jurisdictionRelatedTerms", ExistenceChecker.isSet((JurisdictionRelatedTerms) o.getJurisdictionRelatedTerms()))
				.put("additionalAmendments", ExistenceChecker.isSet((String) o.getAdditionalAmendments()))
				.put("additionalBespokeTerms", ExistenceChecker.isSet((String) o.getAdditionalBespokeTerms()))
				.put("pledgeeRepresentativeRider", ExistenceChecker.isSet((PledgeeRepresentativeRider) o.getPledgeeRepresentativeRider()))
				.put("finalReturns", ExistenceChecker.isSet((FinalReturns) o.getFinalReturns()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralTransferAgreementElections", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralTransferAgreementElections", path, "");
		}
		return failure("CollateralTransferAgreementElections", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralTransferAgreementElections", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
