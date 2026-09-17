package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ClearingInstructions;
import fpml.consolidated.business.events.RequestedClearingAction;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingInstructionsValidator implements Validator<ClearingInstructions> {

	private List<ComparisonResult> getComparisonResults(ClearingInstructions o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("requestedClearingAction", (RequestedClearingAction) o.getRequestedClearingAction() != null ? 1 : 0, 0, 1), 
				checkCardinality("requestedClearingOrganizationPartyReference", (PartyReference) o.getRequestedClearingOrganizationPartyReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingInstructions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingInstructions", ValidationResult.ValidationType.CARDINALITY, "ClearingInstructions", path, "", res.getError());
				}
				return success("ClearingInstructions", ValidationResult.ValidationType.CARDINALITY, "ClearingInstructions", path, "");
			})
			.collect(toList());
	}

}
