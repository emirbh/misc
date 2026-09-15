package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ReportableExecutionVenue;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportableExecutionVenueTypeFormatValidator implements Validator<ReportableExecutionVenue> {

	private List<ComparisonResult> getComparisonResults(ReportableExecutionVenue o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableExecutionVenue o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportableExecutionVenue", ValidationResult.ValidationType.TYPE_FORMAT, "ReportableExecutionVenue", path, "", res.getError());
				}
				return success("ReportableExecutionVenue", ValidationResult.ValidationType.TYPE_FORMAT, "ReportableExecutionVenue", path, "");
			})
			.collect(toList());
	}

}
