package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ReportableJurisdictionInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportableJurisdictionInformationTypeFormatValidator implements Validator<ReportableJurisdictionInformation> {

	private List<ComparisonResult> getComparisonResults(ReportableJurisdictionInformation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableJurisdictionInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportableJurisdictionInformation", ValidationResult.ValidationType.TYPE_FORMAT, "ReportableJurisdictionInformation", path, "", res.getError());
				}
				return success("ReportableJurisdictionInformation", ValidationResult.ValidationType.TYPE_FORMAT, "ReportableJurisdictionInformation", path, "");
			})
			.collect(toList());
	}

}
