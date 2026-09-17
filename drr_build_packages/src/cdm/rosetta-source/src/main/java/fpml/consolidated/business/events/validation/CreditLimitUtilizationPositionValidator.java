package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.CreditLimitUtilizationPosition;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditLimitUtilizationPositionValidator implements Validator<CreditLimitUtilizationPosition> {

	private List<ComparisonResult> getComparisonResults(CreditLimitUtilizationPosition o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("short", (BigDecimal) o.getShort() != null ? 1 : 0, 0, 1), 
				checkCardinality("long", (BigDecimal) o.getLong() != null ? 1 : 0, 0, 1), 
				checkCardinality("global", (BigDecimal) o.getGlobal() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditLimitUtilizationPosition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditLimitUtilizationPosition", ValidationResult.ValidationType.CARDINALITY, "CreditLimitUtilizationPosition", path, "", res.getError());
				}
				return success("CreditLimitUtilizationPosition", ValidationResult.ValidationType.CARDINALITY, "CreditLimitUtilizationPosition", path, "");
			})
			.collect(toList());
	}

}
