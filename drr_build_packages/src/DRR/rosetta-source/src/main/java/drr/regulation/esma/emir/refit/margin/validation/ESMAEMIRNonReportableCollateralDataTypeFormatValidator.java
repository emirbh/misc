package drr.regulation.esma.emir.refit.margin.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRNonReportableCollateralData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ESMAEMIRNonReportableCollateralDataTypeFormatValidator implements Validator<ESMAEMIRNonReportableCollateralData> {

	private List<ComparisonResult> getComparisonResults(ESMAEMIRNonReportableCollateralData o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRNonReportableCollateralData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ESMAEMIRNonReportableCollateralData", ValidationResult.ValidationType.TYPE_FORMAT, "ESMAEMIRNonReportableCollateralData", path, "", res.getError());
				}
				return success("ESMAEMIRNonReportableCollateralData", ValidationResult.ValidationType.TYPE_FORMAT, "ESMAEMIRNonReportableCollateralData", path, "");
			})
			.collect(toList());
	}

}
