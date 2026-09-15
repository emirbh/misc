package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.MarginReportData7;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MarginReportData7TypeFormatValidator implements Validator<MarginReportData7> {

	private List<ComparisonResult> getComparisonResults(MarginReportData7 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginReportData7 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MarginReportData7", ValidationResult.ValidationType.TYPE_FORMAT, "MarginReportData7", path, "", res.getError());
				}
				return success("MarginReportData7", ValidationResult.ValidationType.TYPE_FORMAT, "MarginReportData7", path, "");
			})
			.collect(toList());
	}

}
