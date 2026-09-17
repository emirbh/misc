package cdm.regulation.validation;

import cdm.regulation.RefRate;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RefRateTypeFormatValidator implements Validator<RefRate> {

	private List<ComparisonResult> getComparisonResults(RefRate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RefRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RefRate", ValidationResult.ValidationType.TYPE_FORMAT, "RefRate", path, "", res.getError());
				}
				return success("RefRate", ValidationResult.ValidationType.TYPE_FORMAT, "RefRate", path, "");
			})
			.collect(toList());
	}

}
