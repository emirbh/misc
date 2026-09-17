package cdm.base.math.validation;

import cdm.base.math.MeasureBase;
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

public class MeasureBaseTypeFormatValidator implements Validator<MeasureBase> {

	private List<ComparisonResult> getComparisonResults(MeasureBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MeasureBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MeasureBase", ValidationResult.ValidationType.TYPE_FORMAT, "MeasureBase", path, "", res.getError());
				}
				return success("MeasureBase", ValidationResult.ValidationType.TYPE_FORMAT, "MeasureBase", path, "");
			})
			.collect(toList());
	}

}
