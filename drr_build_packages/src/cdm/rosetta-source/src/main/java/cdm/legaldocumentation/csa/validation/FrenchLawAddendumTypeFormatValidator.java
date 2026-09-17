package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.FrenchLawAddendum;
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

public class FrenchLawAddendumTypeFormatValidator implements Validator<FrenchLawAddendum> {

	private List<ComparisonResult> getComparisonResults(FrenchLawAddendum o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FrenchLawAddendum o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FrenchLawAddendum", ValidationResult.ValidationType.TYPE_FORMAT, "FrenchLawAddendum", path, "", res.getError());
				}
				return success("FrenchLawAddendum", ValidationResult.ValidationType.TYPE_FORMAT, "FrenchLawAddendum", path, "");
			})
			.collect(toList());
	}

}
