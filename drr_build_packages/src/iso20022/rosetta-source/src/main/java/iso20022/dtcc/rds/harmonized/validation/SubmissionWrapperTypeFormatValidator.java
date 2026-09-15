package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.SubmissionWrapper;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SubmissionWrapperTypeFormatValidator implements Validator<SubmissionWrapper> {

	private List<ComparisonResult> getComparisonResults(SubmissionWrapper o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SubmissionWrapper o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SubmissionWrapper", ValidationResult.ValidationType.TYPE_FORMAT, "SubmissionWrapper", path, "", res.getError());
				}
				return success("SubmissionWrapper", ValidationResult.ValidationType.TYPE_FORMAT, "SubmissionWrapper", path, "");
			})
			.collect(toList());
	}

}
