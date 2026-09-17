package cdm.regulation.validation;

import cdm.regulation.SchmeNm;
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

public class SchmeNmTypeFormatValidator implements Validator<SchmeNm> {

	private List<ComparisonResult> getComparisonResults(SchmeNm o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SchmeNm o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SchmeNm", ValidationResult.ValidationType.TYPE_FORMAT, "SchmeNm", path, "", res.getError());
				}
				return success("SchmeNm", ValidationResult.ValidationType.TYPE_FORMAT, "SchmeNm", path, "");
			})
			.collect(toList());
	}

}
