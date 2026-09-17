package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.CashflowFixing;
import fpml.consolidated.shared.Rounding;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CashflowFixingValidator implements Validator<CashflowFixing> {

	private List<ComparisonResult> getComparisonResults(CashflowFixing o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculatedValue", (BigDecimal) o.getCalculatedValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiplier", (BigDecimal) o.getMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("spread", (BigDecimal) o.getSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("negativeInterestRate", (Boolean) o.getNegativeInterestRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("rounding", (Rounding) o.getRounding() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashflowFixing o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CashflowFixing", ValidationResult.ValidationType.CARDINALITY, "CashflowFixing", path, "", res.getError());
				}
				return success("CashflowFixing", ValidationResult.ValidationType.CARDINALITY, "CashflowFixing", path, "");
			})
			.collect(toList());
	}

}
