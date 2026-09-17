package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.Account;
import cdm.legaldocumentation.csa.AppropriatedCollateralValuation;
import cdm.legaldocumentation.csa.EnforcementEvent;
import cdm.legaldocumentation.csa.ExecutionTerms;
import cdm.legaldocumentation.csa.JurisdictionRelatedTerms;
import cdm.legaldocumentation.csa.ProcessAgent;
import cdm.legaldocumentation.csa.SecurityAgreementElections;
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

public class SecurityAgreementElectionsValidator implements Validator<SecurityAgreementElections> {

	private List<ComparisonResult> getComparisonResults(SecurityAgreementElections o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("pledgedAccount", (Account) o.getPledgedAccount() != null ? 1 : 0, 0, 1), 
				checkCardinality("enforcementEvent", (EnforcementEvent) o.getEnforcementEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryInLieuRight", (Boolean) o.getDeliveryInLieuRight() != null ? 1 : 0, 0, 1), 
				checkCardinality("fullDischarge", (Boolean) o.getFullDischarge() != null ? 1 : 0, 0, 1), 
				checkCardinality("appropriatedCollateralValuation", (AppropriatedCollateralValuation) o.getAppropriatedCollateralValuation() != null ? 1 : 0, 0, 1), 
				checkCardinality("processAgent", (ProcessAgent) o.getProcessAgent() != null ? 1 : 0, 0, 1), 
				checkCardinality("jurisdictionRelatedTerms", (JurisdictionRelatedTerms) o.getJurisdictionRelatedTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalAmendments", (String) o.getAdditionalAmendments() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalBespokeTerms", (String) o.getAdditionalBespokeTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionTerms", (ExecutionTerms) o.getExecutionTerms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityAgreementElections o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecurityAgreementElections", ValidationResult.ValidationType.CARDINALITY, "SecurityAgreementElections", path, "", res.getError());
				}
				return success("SecurityAgreementElections", ValidationResult.ValidationType.CARDINALITY, "SecurityAgreementElections", path, "");
			})
			.collect(toList());
	}

}
