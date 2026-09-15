package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.CalculationPeriodDatesReference;
import fpml.consolidated.ird.StubCalculationPeriodAmount;
import fpml.consolidated.shared.StubValue;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class StubCalculationPeriodAmountValidator implements Validator<StubCalculationPeriodAmount> {

	private List<ComparisonResult> getComparisonResults(StubCalculationPeriodAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationPeriodDatesReference", (CalculationPeriodDatesReference) o.getCalculationPeriodDatesReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialStub", (StubValue) o.getInitialStub() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalStub", (StubValue) o.getFinalStub() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StubCalculationPeriodAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StubCalculationPeriodAmount", ValidationResult.ValidationType.CARDINALITY, "StubCalculationPeriodAmount", path, "", res.getError());
				}
				return success("StubCalculationPeriodAmount", ValidationResult.ValidationType.CARDINALITY, "StubCalculationPeriodAmount", path, "");
			})
			.collect(toList());
	}

}
