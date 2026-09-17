package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.CollateralValueAllocation;
import fpml.consolidated.shared.ProposedCollateralAllocationChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ProposedCollateralAllocationChoiceValidator implements Validator<ProposedCollateralAllocationChoice> {

	private List<ComparisonResult> getComparisonResults(ProposedCollateralAllocationChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("collateralValueAllocation", (CollateralValueAllocation) o.getCollateralValueAllocation() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProposedCollateralAllocationChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProposedCollateralAllocationChoice", ValidationResult.ValidationType.CARDINALITY, "ProposedCollateralAllocationChoice", path, "", res.getError());
				}
				return success("ProposedCollateralAllocationChoice", ValidationResult.ValidationType.CARDINALITY, "ProposedCollateralAllocationChoice", path, "");
			})
			.collect(toList());
	}

}
