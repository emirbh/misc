package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.RelevantUnderlyingDateReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RelevantUnderlyingDateReferenceValidator implements Validator<RelevantUnderlyingDateReference> {

	private List<ComparisonResult> getComparisonResults(RelevantUnderlyingDateReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelevantUnderlyingDateReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelevantUnderlyingDateReference", ValidationResult.ValidationType.CARDINALITY, "RelevantUnderlyingDateReference", path, "", res.getError());
				}
				return success("RelevantUnderlyingDateReference", ValidationResult.ValidationType.CARDINALITY, "RelevantUnderlyingDateReference", path, "");
			})
			.collect(toList());
	}

}
