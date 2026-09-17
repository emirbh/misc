package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.StubCalculationPeriod;
import fpml.consolidated.shared.Stub;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class StubCalculationPeriodValidator implements Validator<StubCalculationPeriod> {

	private List<ComparisonResult> getComparisonResults(StubCalculationPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialStub", (Stub) o.getInitialStub() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalStub", (Stub) o.getFinalStub() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StubCalculationPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StubCalculationPeriod", ValidationResult.ValidationType.CARDINALITY, "StubCalculationPeriod", path, "", res.getError());
				}
				return success("StubCalculationPeriod", ValidationResult.ValidationType.CARDINALITY, "StubCalculationPeriod", path, "");
			})
			.collect(toList());
	}

}
