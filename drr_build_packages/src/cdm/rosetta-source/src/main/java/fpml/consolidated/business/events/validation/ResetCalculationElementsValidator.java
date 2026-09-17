package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.CashflowFixing;
import fpml.consolidated.business.events.ResetCalculationElements;
import fpml.consolidated.business.events.ResetCalculationPeriod;
import fpml.consolidated.shared.CashflowNotional;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ResetCalculationElementsValidator implements Validator<ResetCalculationElements> {

	private List<ComparisonResult> getComparisonResults(ResetCalculationElements o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notional", (CashflowNotional) o.getNotional() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculatedRate", (CashflowFixing) o.getCalculatedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriod", (ResetCalculationPeriod) o.getCalculationPeriod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResetCalculationElements o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ResetCalculationElements", ValidationResult.ValidationType.CARDINALITY, "ResetCalculationElements", path, "", res.getError());
				}
				return success("ResetCalculationElements", ValidationResult.ValidationType.CARDINALITY, "ResetCalculationElements", path, "");
			})
			.collect(toList());
	}

}
