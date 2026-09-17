package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.EligibilityToHoldCollateral;
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

public class EligibilityToHoldCollateralTypeFormatValidator implements Validator<EligibilityToHoldCollateral> {

	private List<ComparisonResult> getComparisonResults(EligibilityToHoldCollateral o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EligibilityToHoldCollateral o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EligibilityToHoldCollateral", ValidationResult.ValidationType.TYPE_FORMAT, "EligibilityToHoldCollateral", path, "", res.getError());
				}
				return success("EligibilityToHoldCollateral", ValidationResult.ValidationType.TYPE_FORMAT, "EligibilityToHoldCollateral", path, "");
			})
			.collect(toList());
	}

}
