package cdm.observable.asset.calculatedrate.validation;

import cdm.observable.asset.calculatedrate.CalculatedRateObservationDatesAndWeights;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CalculatedRateObservationDatesAndWeightsValidator implements Validator<CalculatedRateObservationDatesAndWeights> {

	private List<ComparisonResult> getComparisonResults(CalculatedRateObservationDatesAndWeights o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculatedRateObservationDatesAndWeights o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculatedRateObservationDatesAndWeights", ValidationResult.ValidationType.CARDINALITY, "CalculatedRateObservationDatesAndWeights", path, "", res.getError());
				}
				return success("CalculatedRateObservationDatesAndWeights", ValidationResult.ValidationType.CARDINALITY, "CalculatedRateObservationDatesAndWeights", path, "");
			})
			.collect(toList());
	}

}
