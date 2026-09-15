package drr.regulation.fca.ukemir.refit.margin.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRNonReportableCollateralData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FCAUKEMIRNonReportableCollateralDataTypeFormatValidator implements Validator<FCAUKEMIRNonReportableCollateralData> {

	private List<ComparisonResult> getComparisonResults(FCAUKEMIRNonReportableCollateralData o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRNonReportableCollateralData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FCAUKEMIRNonReportableCollateralData", ValidationResult.ValidationType.TYPE_FORMAT, "FCAUKEMIRNonReportableCollateralData", path, "", res.getError());
				}
				return success("FCAUKEMIRNonReportableCollateralData", ValidationResult.ValidationType.TYPE_FORMAT, "FCAUKEMIRNonReportableCollateralData", path, "");
			})
			.collect(toList());
	}

}
