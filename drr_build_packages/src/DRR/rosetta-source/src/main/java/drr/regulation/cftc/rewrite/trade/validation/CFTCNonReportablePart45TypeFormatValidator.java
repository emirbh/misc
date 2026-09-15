package drr.regulation.cftc.rewrite.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart45;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CFTCNonReportablePart45TypeFormatValidator implements Validator<CFTCNonReportablePart45> {

	private List<ComparisonResult> getComparisonResults(CFTCNonReportablePart45 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCNonReportablePart45 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CFTCNonReportablePart45", ValidationResult.ValidationType.TYPE_FORMAT, "CFTCNonReportablePart45", path, "", res.getError());
				}
				return success("CFTCNonReportablePart45", ValidationResult.ValidationType.TYPE_FORMAT, "CFTCNonReportablePart45", path, "");
			})
			.collect(toList());
	}

}
