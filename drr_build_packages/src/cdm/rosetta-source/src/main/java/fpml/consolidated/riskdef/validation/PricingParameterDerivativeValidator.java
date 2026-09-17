package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.riskdef.AssetOrTermPointOrPricingStructureReference;
import fpml.consolidated.riskdef.DerivativeCalculationProcedure;
import fpml.consolidated.riskdef.PricingParameterDerivative;
import fpml.consolidated.riskdef.TermPointReference;
import fpml.consolidated.shared.PricingStructureReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PricingParameterDerivativeValidator implements Validator<PricingParameterDerivative> {

	private List<ComparisonResult> getComparisonResults(PricingParameterDerivative o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("parameterReference", (AssetOrTermPointOrPricingStructureReference) o.getParameterReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("assetReference", (AssetReference) o.getAssetReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("termPointReference", (TermPointReference) o.getTermPointReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingStructureReference", (PricingStructureReference) o.getPricingStructureReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationProcedure", (DerivativeCalculationProcedure) o.getCalculationProcedure() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingParameterDerivative o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingParameterDerivative", ValidationResult.ValidationType.CARDINALITY, "PricingParameterDerivative", path, "", res.getError());
				}
				return success("PricingParameterDerivative", ValidationResult.ValidationType.CARDINALITY, "PricingParameterDerivative", path, "");
			})
			.collect(toList());
	}

}
