package fpml.consolidated.valuation.fpmlreporting.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.valuation.fpmlreporting.ReportContents;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportContentsTypeFormatValidator implements Validator<ReportContents> {

	private List<ComparisonResult> getComparisonResults(ReportContents o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportContents o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportContents", ValidationResult.ValidationType.TYPE_FORMAT, "ReportContents", path, "", res.getError());
				}
				return success("ReportContents", ValidationResult.ValidationType.TYPE_FORMAT, "ReportContents", path, "");
			})
			.collect(toList());
	}

}
