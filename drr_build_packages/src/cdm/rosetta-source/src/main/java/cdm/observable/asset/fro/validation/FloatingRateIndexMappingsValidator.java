package cdm.observable.asset.fro.validation;

import cdm.observable.asset.fro.FloatingRateIndexMap;
import cdm.observable.asset.fro.FloatingRateIndexMappings;
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

public class FloatingRateIndexMappingsValidator implements Validator<FloatingRateIndexMappings> {

	private List<ComparisonResult> getComparisonResults(FloatingRateIndexMappings o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("mapsTo", (FloatingRateIndexMap) o.getMapsTo() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateIndexMappings o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateIndexMappings", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexMappings", path, "", res.getError());
				}
				return success("FloatingRateIndexMappings", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexMappings", path, "");
			})
			.collect(toList());
	}

}
