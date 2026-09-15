package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.AdjustableDateOrRelativeDateSequence;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.RelativeDateSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AdjustableDateOrRelativeDateSequenceValidator implements Validator<AdjustableDateOrRelativeDateSequence> {

	private List<ComparisonResult> getComparisonResults(AdjustableDateOrRelativeDateSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustableDate", (AdjustableDate) o.getAdjustableDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeDateSequence", (RelativeDateSequence) o.getRelativeDateSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDateOrRelativeDateSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableDateOrRelativeDateSequence", ValidationResult.ValidationType.CARDINALITY, "AdjustableDateOrRelativeDateSequence", path, "", res.getError());
				}
				return success("AdjustableDateOrRelativeDateSequence", ValidationResult.ValidationType.CARDINALITY, "AdjustableDateOrRelativeDateSequence", path, "");
			})
			.collect(toList());
	}

}
