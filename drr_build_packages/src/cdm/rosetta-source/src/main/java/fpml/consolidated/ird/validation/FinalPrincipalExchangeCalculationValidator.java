package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.FinalPrincipalExchangeCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FinalPrincipalExchangeCalculationValidator implements Validator<FinalPrincipalExchangeCalculation> {

	private List<ComparisonResult> getComparisonResults(FinalPrincipalExchangeCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floored", (Boolean) o.getFloored() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinalPrincipalExchangeCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FinalPrincipalExchangeCalculation", ValidationResult.ValidationType.CARDINALITY, "FinalPrincipalExchangeCalculation", path, "", res.getError());
				}
				return success("FinalPrincipalExchangeCalculation", ValidationResult.ValidationType.CARDINALITY, "FinalPrincipalExchangeCalculation", path, "");
			})
			.collect(toList());
	}

}
