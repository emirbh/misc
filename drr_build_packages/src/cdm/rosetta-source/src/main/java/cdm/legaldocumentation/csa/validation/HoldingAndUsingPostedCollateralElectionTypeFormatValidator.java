package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.HoldingAndUsingPostedCollateralElection;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class HoldingAndUsingPostedCollateralElectionTypeFormatValidator implements Validator<HoldingAndUsingPostedCollateralElection> {

	private List<ComparisonResult> getComparisonResults(HoldingAndUsingPostedCollateralElection o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, HoldingAndUsingPostedCollateralElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("HoldingAndUsingPostedCollateralElection", ValidationResult.ValidationType.TYPE_FORMAT, "HoldingAndUsingPostedCollateralElection", path, "", res.getError());
				}
				return success("HoldingAndUsingPostedCollateralElection", ValidationResult.ValidationType.TYPE_FORMAT, "HoldingAndUsingPostedCollateralElection", path, "");
			})
			.collect(toList());
	}

}
