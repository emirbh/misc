package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.PhysicalSwapLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PhysicalSwapLegTypeFormatValidator implements Validator<PhysicalSwapLeg> {

	private List<ComparisonResult> getComparisonResults(PhysicalSwapLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSwapLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PhysicalSwapLeg", ValidationResult.ValidationType.TYPE_FORMAT, "PhysicalSwapLeg", path, "", res.getError());
				}
				return success("PhysicalSwapLeg", ValidationResult.ValidationType.TYPE_FORMAT, "PhysicalSwapLeg", path, "");
			})
			.collect(toList());
	}

}
