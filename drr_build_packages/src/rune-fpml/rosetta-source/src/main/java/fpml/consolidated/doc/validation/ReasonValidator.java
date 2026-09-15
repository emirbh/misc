package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ProblemLocation;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.doc.ReasonCode;
import fpml.consolidated.doc.Validation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReasonValidator implements Validator<Reason> {

	private List<ComparisonResult> getComparisonResults(Reason o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reasonCode", (ReasonCode) o.getReasonCode() != null ? 1 : 0, 0, 1), 
				checkCardinality("location", (ProblemLocation) o.getLocation() != null ? 1 : 0, 0, 1), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("validationRuleId", (Validation) o.getValidationRuleId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Reason o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Reason", ValidationResult.ValidationType.CARDINALITY, "Reason", path, "", res.getError());
				}
				return success("Reason", ValidationResult.ValidationType.CARDINALITY, "Reason", path, "");
			})
			.collect(toList());
	}

}
