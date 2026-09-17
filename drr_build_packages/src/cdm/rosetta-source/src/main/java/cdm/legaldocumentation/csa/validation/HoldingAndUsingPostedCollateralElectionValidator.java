package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.EligibilityToHoldCollateral;
import cdm.legaldocumentation.csa.HoldingAndUsingPostedCollateralElection;
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

public class HoldingAndUsingPostedCollateralElectionValidator implements Validator<HoldingAndUsingPostedCollateralElection> {

	private List<ComparisonResult> getComparisonResults(HoldingAndUsingPostedCollateralElection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (CounterpartyRoleEnum) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("eligibilityToHoldCollateral", (EligibilityToHoldCollateral) o.getEligibilityToHoldCollateral() != null ? 1 : 0, 1, 1), 
				checkCardinality("useOfPostedCollateral", (Boolean) o.getUseOfPostedCollateral() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, HoldingAndUsingPostedCollateralElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("HoldingAndUsingPostedCollateralElection", ValidationResult.ValidationType.CARDINALITY, "HoldingAndUsingPostedCollateralElection", path, "", res.getError());
				}
				return success("HoldingAndUsingPostedCollateralElection", ValidationResult.ValidationType.CARDINALITY, "HoldingAndUsingPostedCollateralElection", path, "");
			})
			.collect(toList());
	}

}
