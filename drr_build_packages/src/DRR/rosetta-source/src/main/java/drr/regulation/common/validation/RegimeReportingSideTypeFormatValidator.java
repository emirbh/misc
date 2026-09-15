package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.RegimeReportingSide;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegimeReportingSideTypeFormatValidator implements Validator<RegimeReportingSide> {

	private List<ComparisonResult> getComparisonResults(RegimeReportingSide o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegimeReportingSide o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegimeReportingSide", ValidationResult.ValidationType.TYPE_FORMAT, "RegimeReportingSide", path, "", res.getError());
				}
				return success("RegimeReportingSide", ValidationResult.ValidationType.TYPE_FORMAT, "RegimeReportingSide", path, "");
			})
			.collect(toList());
	}

}
