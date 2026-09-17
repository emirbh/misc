package fpml.consolidated.mktenv.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.mktenv.VolatilityRepresentation;
import fpml.consolidated.mktenv.YieldCurveReference;
import fpml.consolidated.shared.Currency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VolatilityRepresentationValidator implements Validator<VolatilityRepresentation> {

	private List<ComparisonResult> getComparisonResults(VolatilityRepresentation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("asset", (AssetReference) o.getAsset() != null ? 1 : 0, 0, 1), 
				checkCardinality("yieldCurveReference", (YieldCurveReference) o.getYieldCurveReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityRepresentation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityRepresentation", ValidationResult.ValidationType.CARDINALITY, "VolatilityRepresentation", path, "", res.getError());
				}
				return success("VolatilityRepresentation", ValidationResult.ValidationType.CARDINALITY, "VolatilityRepresentation", path, "");
			})
			.collect(toList());
	}

}
