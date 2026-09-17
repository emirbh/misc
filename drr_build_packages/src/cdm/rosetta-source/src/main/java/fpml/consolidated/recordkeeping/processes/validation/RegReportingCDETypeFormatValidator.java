package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.RegReportingCDE;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegReportingCDETypeFormatValidator implements Validator<RegReportingCDE> {

	private List<ComparisonResult> getComparisonResults(RegReportingCDE o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegReportingCDE o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegReportingCDE", ValidationResult.ValidationType.TYPE_FORMAT, "RegReportingCDE", path, "", res.getError());
				}
				return success("RegReportingCDE", ValidationResult.ValidationType.TYPE_FORMAT, "RegReportingCDE", path, "");
			})
			.collect(toList());
	}

}
