package cdm.product.common.schedule.validation;

import cdm.product.asset.StubValue;
import cdm.product.common.schedule.StubPeriod;
import cdm.product.common.schedule.metafields.ReferenceWithMetaCalculationPeriodDates;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class StubPeriodValidator implements Validator<StubPeriod> {

	private List<ComparisonResult> getComparisonResults(StubPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationPeriodDatesReference", (ReferenceWithMetaCalculationPeriodDates) o.getCalculationPeriodDatesReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("initialStub", (StubValue) o.getInitialStub() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalStub", (StubValue) o.getFinalStub() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StubPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StubPeriod", ValidationResult.ValidationType.CARDINALITY, "StubPeriod", path, "", res.getError());
				}
				return success("StubPeriod", ValidationResult.ValidationType.CARDINALITY, "StubPeriod", path, "");
			})
			.collect(toList());
	}

}
