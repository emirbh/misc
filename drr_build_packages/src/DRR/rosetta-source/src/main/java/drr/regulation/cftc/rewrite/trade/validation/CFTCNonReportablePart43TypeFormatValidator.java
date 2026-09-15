package drr.regulation.cftc.rewrite.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart43;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CFTCNonReportablePart43TypeFormatValidator implements Validator<CFTCNonReportablePart43> {

	private List<ComparisonResult> getComparisonResults(CFTCNonReportablePart43 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCNonReportablePart43 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CFTCNonReportablePart43", ValidationResult.ValidationType.TYPE_FORMAT, "CFTCNonReportablePart43", path, "", res.getError());
				}
				return success("CFTCNonReportablePart43", ValidationResult.ValidationType.TYPE_FORMAT, "CFTCNonReportablePart43", path, "");
			})
			.collect(toList());
	}

}
