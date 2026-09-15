package fpml.consolidated.sec.lending.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.sec.lending.SecLendRebateCalculation;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.Schedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecLendRebateCalculationValidator implements Validator<SecLendRebateCalculation> {

	private List<ComparisonResult> getComparisonResults(SecLendRebateCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fixedRateSchedule", (Schedule) o.getFixedRateSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateCalculation", (FloatingRateCalculation) o.getFloatingRateCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("resetFrequency", (Frequency) o.getResetFrequency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecLendRebateCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecLendRebateCalculation", ValidationResult.ValidationType.CARDINALITY, "SecLendRebateCalculation", path, "", res.getError());
				}
				return success("SecLendRebateCalculation", ValidationResult.ValidationType.CARDINALITY, "SecLendRebateCalculation", path, "");
			})
			.collect(toList());
	}

}
