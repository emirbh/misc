package cdm.observable.asset.fro.validation;

import cdm.observable.asset.fro.FloatingRateIndexExternalMap;
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

public class FloatingRateIndexExternalMapValidator implements Validator<FloatingRateIndexExternalMap> {

	private List<ComparisonResult> getComparisonResults(FloatingRateIndexExternalMap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("externalId", (String) o.getExternalId() != null ? 1 : 0, 1, 1), 
				checkCardinality("externalStandard", (String) o.getExternalStandard() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateIndexExternalMap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateIndexExternalMap", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexExternalMap", path, "", res.getError());
				}
				return success("FloatingRateIndexExternalMap", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexExternalMap", path, "");
			})
			.collect(toList());
	}

}
