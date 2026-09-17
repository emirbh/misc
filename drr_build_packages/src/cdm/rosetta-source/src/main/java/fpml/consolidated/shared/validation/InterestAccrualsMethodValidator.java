package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.InterestAccrualsMethod;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestAccrualsMethodValidator implements Validator<InterestAccrualsMethod> {

	private List<ComparisonResult> getComparisonResults(InterestAccrualsMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRateCalculation", (FloatingRateCalculation) o.getFloatingRateCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRate", (BigDecimal) o.getFixedRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestAccrualsMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestAccrualsMethod", ValidationResult.ValidationType.CARDINALITY, "InterestAccrualsMethod", path, "", res.getError());
				}
				return success("InterestAccrualsMethod", ValidationResult.ValidationType.CARDINALITY, "InterestAccrualsMethod", path, "");
			})
			.collect(toList());
	}

}
