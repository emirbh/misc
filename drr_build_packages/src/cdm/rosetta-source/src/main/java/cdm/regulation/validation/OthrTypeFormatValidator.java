package cdm.regulation.validation;

import cdm.regulation.Othr;
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

public class OthrTypeFormatValidator implements Validator<Othr> {

	private List<ComparisonResult> getComparisonResults(Othr o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Othr o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Othr", ValidationResult.ValidationType.TYPE_FORMAT, "Othr", path, "", res.getError());
				}
				return success("Othr", ValidationResult.ValidationType.TYPE_FORMAT, "Othr", path, "");
			})
			.collect(toList());
	}

}
