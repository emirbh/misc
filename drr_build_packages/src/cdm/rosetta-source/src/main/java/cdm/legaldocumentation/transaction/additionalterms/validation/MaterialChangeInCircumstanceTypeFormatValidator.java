package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.MaterialChangeInCircumstance;
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

public class MaterialChangeInCircumstanceTypeFormatValidator implements Validator<MaterialChangeInCircumstance> {

	private List<ComparisonResult> getComparisonResults(MaterialChangeInCircumstance o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MaterialChangeInCircumstance o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MaterialChangeInCircumstance", ValidationResult.ValidationType.TYPE_FORMAT, "MaterialChangeInCircumstance", path, "", res.getError());
				}
				return success("MaterialChangeInCircumstance", ValidationResult.ValidationType.TYPE_FORMAT, "MaterialChangeInCircumstance", path, "");
			})
			.collect(toList());
	}

}
