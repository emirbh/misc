package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.InterconnectionPoint;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterconnectionPointValidator implements Validator<InterconnectionPoint> {

	private List<ComparisonResult> getComparisonResults(InterconnectionPoint o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("interconnectionPointScheme", (String) o.getInterconnectionPointScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterconnectionPoint o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterconnectionPoint", ValidationResult.ValidationType.CARDINALITY, "InterconnectionPoint", path, "", res.getError());
				}
				return success("InterconnectionPoint", ValidationResult.ValidationType.CARDINALITY, "InterconnectionPoint", path, "");
			})
			.collect(toList());
	}

}
