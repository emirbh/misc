package drr.regulation.csa.rewrite.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.trade.CSANonReportable;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CSANonReportableTypeFormatValidator implements Validator<CSANonReportable> {

	private List<ComparisonResult> getComparisonResults(CSANonReportable o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSANonReportable o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CSANonReportable", ValidationResult.ValidationType.TYPE_FORMAT, "CSANonReportable", path, "", res.getError());
				}
				return success("CSANonReportable", ValidationResult.ValidationType.TYPE_FORMAT, "CSANonReportable", path, "");
			})
			.collect(toList());
	}

}
