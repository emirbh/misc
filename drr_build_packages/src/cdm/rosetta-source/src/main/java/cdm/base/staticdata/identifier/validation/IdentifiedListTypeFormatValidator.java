package cdm.base.staticdata.identifier.validation;

import cdm.base.staticdata.identifier.IdentifiedList;
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

public class IdentifiedListTypeFormatValidator implements Validator<IdentifiedList> {

	private List<ComparisonResult> getComparisonResults(IdentifiedList o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IdentifiedList o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IdentifiedList", ValidationResult.ValidationType.TYPE_FORMAT, "IdentifiedList", path, "", res.getError());
				}
				return success("IdentifiedList", ValidationResult.ValidationType.TYPE_FORMAT, "IdentifiedList", path, "");
			})
			.collect(toList());
	}

}
