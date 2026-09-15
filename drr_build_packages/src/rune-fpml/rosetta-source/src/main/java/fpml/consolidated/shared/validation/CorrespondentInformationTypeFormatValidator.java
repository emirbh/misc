package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.CorrespondentInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CorrespondentInformationTypeFormatValidator implements Validator<CorrespondentInformation> {

	private List<ComparisonResult> getComparisonResults(CorrespondentInformation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrespondentInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrespondentInformation", ValidationResult.ValidationType.TYPE_FORMAT, "CorrespondentInformation", path, "", res.getError());
				}
				return success("CorrespondentInformation", ValidationResult.ValidationType.TYPE_FORMAT, "CorrespondentInformation", path, "");
			})
			.collect(toList());
	}

}
