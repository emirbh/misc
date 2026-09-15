package drr.regulation.common.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.NonReportable;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NonReportableTypeFormatValidator implements Validator<NonReportable> {

	private List<ComparisonResult> getComparisonResults(NonReportable o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonReportable o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonReportable", ValidationResult.ValidationType.TYPE_FORMAT, "NonReportable", path, "", res.getError());
				}
				return success("NonReportable", ValidationResult.ValidationType.TYPE_FORMAT, "NonReportable", path, "");
			})
			.collect(toList());
	}

}
