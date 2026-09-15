package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.ProposedCollateralAllocation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ProposedCollateralAllocationTypeFormatValidator implements Validator<ProposedCollateralAllocation> {

	private List<ComparisonResult> getComparisonResults(ProposedCollateralAllocation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProposedCollateralAllocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProposedCollateralAllocation", ValidationResult.ValidationType.TYPE_FORMAT, "ProposedCollateralAllocation", path, "", res.getError());
				}
				return success("ProposedCollateralAllocation", ValidationResult.ValidationType.TYPE_FORMAT, "ProposedCollateralAllocation", path, "");
			})
			.collect(toList());
	}

}
