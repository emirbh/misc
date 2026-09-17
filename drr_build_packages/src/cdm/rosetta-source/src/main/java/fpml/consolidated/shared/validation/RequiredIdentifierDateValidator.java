package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.RequiredIdentifierDate;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RequiredIdentifierDateValidator implements Validator<RequiredIdentifierDate> {

	private List<ComparisonResult> getComparisonResults(RequiredIdentifierDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (ZonedDateTime) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequiredIdentifierDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RequiredIdentifierDate", ValidationResult.ValidationType.CARDINALITY, "RequiredIdentifierDate", path, "", res.getError());
				}
				return success("RequiredIdentifierDate", ValidationResult.ValidationType.CARDINALITY, "RequiredIdentifierDate", path, "");
			})
			.collect(toList());
	}

}
