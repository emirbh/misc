package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.CreditLimitUtilization;
import fpml.consolidated.business.events.LimitApplicable;
import fpml.consolidated.business.events.LimitType;
import fpml.consolidated.business.events.Velocity;
import fpml.consolidated.shared.Currency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LimitApplicableValidator implements Validator<LimitApplicable> {

	private List<ComparisonResult> getComparisonResults(LimitApplicable o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("limitType", (LimitType) o.getLimitType() != null ? 1 : 0, 1, 1), 
				checkCardinality("clipSize", (Integer) o.getClipSize() != null ? 1 : 0, 1, 1), 
				checkCardinality("amountUtilized", (Integer) o.getAmountUtilized() != null ? 1 : 0, 0, 1), 
				checkCardinality("utilization", (CreditLimitUtilization) o.getUtilization() != null ? 1 : 0, 0, 1), 
				checkCardinality("amountRemaining", (Integer) o.getAmountRemaining() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("velocity", (Velocity) o.getVelocity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LimitApplicable o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LimitApplicable", ValidationResult.ValidationType.CARDINALITY, "LimitApplicable", path, "", res.getError());
				}
				return success("LimitApplicable", ValidationResult.ValidationType.CARDINALITY, "LimitApplicable", path, "");
			})
			.collect(toList());
	}

}
