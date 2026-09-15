package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.ReportingExemption1__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ReportingExemption1__1TypeFormatValidator implements Validator<ReportingExemption1__1> {

	private List<ComparisonResult> getComparisonResults(ReportingExemption1__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("rsn", o.getRsn(), 1, of(4), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingExemption1__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingExemption1__1", ValidationResult.ValidationType.TYPE_FORMAT, "ReportingExemption1__1", path, "", res.getError());
				}
				return success("ReportingExemption1__1", ValidationResult.ValidationType.TYPE_FORMAT, "ReportingExemption1__1", path, "");
			})
			.collect(toList());
	}

}
