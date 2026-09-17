package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.OneWayProvisions;
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

public class OneWayProvisionsTypeFormatValidator implements Validator<OneWayProvisions> {

	private List<ComparisonResult> getComparisonResults(OneWayProvisions o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OneWayProvisions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OneWayProvisions", ValidationResult.ValidationType.TYPE_FORMAT, "OneWayProvisions", path, "", res.getError());
				}
				return success("OneWayProvisions", ValidationResult.ValidationType.TYPE_FORMAT, "OneWayProvisions", path, "");
			})
			.collect(toList());
	}

}
