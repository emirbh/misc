package cdm.observable.asset.calculatedrate.validation;

import cdm.observable.asset.calculatedrate.CalculatedRateObservations;
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

public class CalculatedRateObservationsValidator implements Validator<CalculatedRateObservations> {

	private List<ComparisonResult> getComparisonResults(CalculatedRateObservations o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculatedRateObservations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculatedRateObservations", ValidationResult.ValidationType.CARDINALITY, "CalculatedRateObservations", path, "", res.getError());
				}
				return success("CalculatedRateObservations", ValidationResult.ValidationType.CARDINALITY, "CalculatedRateObservations", path, "");
			})
			.collect(toList());
	}

}
