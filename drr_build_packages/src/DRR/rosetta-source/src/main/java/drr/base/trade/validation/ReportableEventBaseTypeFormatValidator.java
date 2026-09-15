package drr.base.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.ReportableEventBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportableEventBaseTypeFormatValidator implements Validator<ReportableEventBase> {

	private List<ComparisonResult> getComparisonResults(ReportableEventBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableEventBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportableEventBase", ValidationResult.ValidationType.TYPE_FORMAT, "ReportableEventBase", path, "", res.getError());
				}
				return success("ReportableEventBase", ValidationResult.ValidationType.TYPE_FORMAT, "ReportableEventBase", path, "");
			})
			.collect(toList());
	}

}
