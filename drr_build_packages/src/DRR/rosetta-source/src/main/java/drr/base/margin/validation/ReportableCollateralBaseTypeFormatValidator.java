package drr.base.margin.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.margin.ReportableCollateralBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportableCollateralBaseTypeFormatValidator implements Validator<ReportableCollateralBase> {

	private List<ComparisonResult> getComparisonResults(ReportableCollateralBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableCollateralBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportableCollateralBase", ValidationResult.ValidationType.TYPE_FORMAT, "ReportableCollateralBase", path, "", res.getError());
				}
				return success("ReportableCollateralBase", ValidationResult.ValidationType.TYPE_FORMAT, "ReportableCollateralBase", path, "");
			})
			.collect(toList());
	}

}
