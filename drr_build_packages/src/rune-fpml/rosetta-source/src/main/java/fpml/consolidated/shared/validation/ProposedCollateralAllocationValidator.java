package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProposedCollateralAllocation;
import fpml.consolidated.shared.ProposedCollateralAllocationChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ProposedCollateralAllocationValidator implements Validator<ProposedCollateralAllocation> {

	private List<ComparisonResult> getComparisonResults(ProposedCollateralAllocation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("allocationPartyReference", (PartyReference) o.getAllocationPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationAccountReference", (AccountReference) o.getAllocationAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("proposedCollateralAllocationChoice", (List<? extends ProposedCollateralAllocationChoice>) o.getProposedCollateralAllocationChoice() == null ? 0 : o.getProposedCollateralAllocationChoice().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProposedCollateralAllocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProposedCollateralAllocation", ValidationResult.ValidationType.CARDINALITY, "ProposedCollateralAllocation", path, "", res.getError());
				}
				return success("ProposedCollateralAllocation", ValidationResult.ValidationType.CARDINALITY, "ProposedCollateralAllocation", path, "");
			})
			.collect(toList());
	}

}
