package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.DerivativeCalculationMethod;
import fpml.consolidated.riskdef.DerivativeCalculationProcedure;
import fpml.consolidated.riskdef.PerturbationType;
import fpml.consolidated.shared.PricingStructureReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DerivativeCalculationProcedureValidator implements Validator<DerivativeCalculationProcedure> {

	private List<ComparisonResult> getComparisonResults(DerivativeCalculationProcedure o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("method", (DerivativeCalculationMethod) o.getMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("perturbationAmount", (BigDecimal) o.getPerturbationAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("averaged", (Boolean) o.getAveraged() != null ? 1 : 0, 0, 1), 
				checkCardinality("perturbationType", (PerturbationType) o.getPerturbationType() != null ? 1 : 0, 0, 1), 
				checkCardinality("derivativeFormula", (String) o.getDerivativeFormula() != null ? 1 : 0, 0, 1), 
				checkCardinality("replacementMarketInput", (PricingStructureReference) o.getReplacementMarketInput() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativeCalculationProcedure o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativeCalculationProcedure", ValidationResult.ValidationType.CARDINALITY, "DerivativeCalculationProcedure", path, "", res.getError());
				}
				return success("DerivativeCalculationProcedure", ValidationResult.ValidationType.CARDINALITY, "DerivativeCalculationProcedure", path, "");
			})
			.collect(toList());
	}

}
