package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ReportableInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportableInformationTypeFormatValidator implements Validator<ReportableInformation> {

	private List<ComparisonResult> getComparisonResults(ReportableInformation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportableInformation", ValidationResult.ValidationType.TYPE_FORMAT, "ReportableInformation", path, "", res.getError());
				}
				return success("ReportableInformation", ValidationResult.ValidationType.TYPE_FORMAT, "ReportableInformation", path, "");
			})
			.collect(toList());
	}

}
