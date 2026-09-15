package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.AmountAdjustmentEnum;
import fpml.consolidated.loan.Adjustment;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AdjustmentValidator implements Validator<Adjustment> {

	private List<ComparisonResult> getComparisonResults(Adjustment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("adjustmentType", (AmountAdjustmentEnum) o.getAdjustmentType() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (MoneyWithParticipantShare) o.getAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Adjustment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Adjustment", ValidationResult.ValidationType.CARDINALITY, "Adjustment", path, "", res.getError());
				}
				return success("Adjustment", ValidationResult.ValidationType.CARDINALITY, "Adjustment", path, "");
			})
			.collect(toList());
	}

}
