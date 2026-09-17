package cdm.observable.asset.fro.validation;

import cdm.observable.asset.fro.FloatingRateIndexExternalMap;
import cdm.observable.asset.fro.FloatingRateIndexExternalMappings;
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

public class FloatingRateIndexExternalMappingsValidator implements Validator<FloatingRateIndexExternalMappings> {

	private List<ComparisonResult> getComparisonResults(FloatingRateIndexExternalMappings o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isoCode", (FloatingRateIndexExternalMap) o.getIsoCode() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateIndexExternalMappings o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateIndexExternalMappings", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexExternalMappings", path, "", res.getError());
				}
				return success("FloatingRateIndexExternalMappings", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexExternalMappings", path, "");
			})
			.collect(toList());
	}

}
