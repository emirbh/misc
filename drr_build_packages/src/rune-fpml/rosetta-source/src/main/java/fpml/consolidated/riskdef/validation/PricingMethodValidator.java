package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AnyAssetReference;
import fpml.consolidated.riskdef.PricingMethod;
import fpml.consolidated.shared.PricingStructureReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PricingMethodValidator implements Validator<PricingMethod> {

	private List<ComparisonResult> getComparisonResults(PricingMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("assetReference", (AnyAssetReference) o.getAssetReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingInputReference", (PricingStructureReference) o.getPricingInputReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingMethod", ValidationResult.ValidationType.CARDINALITY, "PricingMethod", path, "", res.getError());
				}
				return success("PricingMethod", ValidationResult.ValidationType.CARDINALITY, "PricingMethod", path, "");
			})
			.collect(toList());
	}

}
