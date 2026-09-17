package cdm.product.collateral.validation;

import cdm.product.collateral.EligibleCollateralSpecificationInstruction;
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

public class EligibleCollateralSpecificationInstructionTypeFormatValidator implements Validator<EligibleCollateralSpecificationInstruction> {

	private List<ComparisonResult> getComparisonResults(EligibleCollateralSpecificationInstruction o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EligibleCollateralSpecificationInstruction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EligibleCollateralSpecificationInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "EligibleCollateralSpecificationInstruction", path, "", res.getError());
				}
				return success("EligibleCollateralSpecificationInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "EligibleCollateralSpecificationInstruction", path, "");
			})
			.collect(toList());
	}

}
