package cdm.product.template.validation;

import cdm.product.template.Knock;
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

public class KnockValidator implements Validator<Knock> {

	private List<ComparisonResult> getComparisonResults(Knock o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Knock o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Knock", ValidationResult.ValidationType.CARDINALITY, "Knock", path, "", res.getError());
				}
				return success("Knock", ValidationResult.ValidationType.CARDINALITY, "Knock", path, "");
			})
			.collect(toList());
	}

}
