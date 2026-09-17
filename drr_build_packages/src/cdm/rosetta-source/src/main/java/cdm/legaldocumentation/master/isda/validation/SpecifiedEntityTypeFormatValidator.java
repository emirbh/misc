package cdm.legaldocumentation.master.isda.validation;

import cdm.legaldocumentation.master.isda.SpecifiedEntity;
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

public class SpecifiedEntityTypeFormatValidator implements Validator<SpecifiedEntity> {

	private List<ComparisonResult> getComparisonResults(SpecifiedEntity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecifiedEntity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SpecifiedEntity", ValidationResult.ValidationType.TYPE_FORMAT, "SpecifiedEntity", path, "", res.getError());
				}
				return success("SpecifiedEntity", ValidationResult.ValidationType.TYPE_FORMAT, "SpecifiedEntity", path, "");
			})
			.collect(toList());
	}

}
