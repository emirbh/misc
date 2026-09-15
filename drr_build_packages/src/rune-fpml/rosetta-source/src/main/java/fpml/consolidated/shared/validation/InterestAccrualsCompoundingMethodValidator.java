package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.CompoundingMethodEnum;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.InterestAccrualsCompoundingMethod;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestAccrualsCompoundingMethodValidator implements Validator<InterestAccrualsCompoundingMethod> {

	private List<ComparisonResult> getComparisonResults(InterestAccrualsCompoundingMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRateCalculation", (FloatingRateCalculation) o.getFloatingRateCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRate", (BigDecimal) o.getFixedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("compoundingMethod", (CompoundingMethodEnum) o.getCompoundingMethod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestAccrualsCompoundingMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestAccrualsCompoundingMethod", ValidationResult.ValidationType.CARDINALITY, "InterestAccrualsCompoundingMethod", path, "", res.getError());
				}
				return success("InterestAccrualsCompoundingMethod", ValidationResult.ValidationType.CARDINALITY, "InterestAccrualsCompoundingMethod", path, "");
			})
			.collect(toList());
	}

}
