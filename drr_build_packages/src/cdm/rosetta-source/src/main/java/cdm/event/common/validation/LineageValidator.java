package cdm.event.common.validation;

import cdm.event.common.Lineage;
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

public class LineageValidator implements Validator<Lineage> {

	private List<ComparisonResult> getComparisonResults(Lineage o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Lineage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Lineage", ValidationResult.ValidationType.CARDINALITY, "Lineage", path, "", res.getError());
				}
				return success("Lineage", ValidationResult.ValidationType.CARDINALITY, "Lineage", path, "");
			})
			.collect(toList());
	}

}
