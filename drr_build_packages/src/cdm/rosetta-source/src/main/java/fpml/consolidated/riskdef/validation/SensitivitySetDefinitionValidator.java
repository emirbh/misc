package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.QuotationCharacteristics;
import fpml.consolidated.riskdef.DerivativeCalculationProcedure;
import fpml.consolidated.riskdef.PricingInputType;
import fpml.consolidated.riskdef.SensitivitySetDefinition;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import fpml.consolidated.shared.PricingStructureReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SensitivitySetDefinitionValidator implements Validator<SensitivitySetDefinition> {

	private List<ComparisonResult> getComparisonResults(SensitivitySetDefinition o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("sensitivityCharacteristics", (QuotationCharacteristics) o.getSensitivityCharacteristics() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationScenarioReference", (ValuationScenarioReference) o.getValuationScenarioReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingInputType", (PricingInputType) o.getPricingInputType() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingInputReference", (PricingStructureReference) o.getPricingInputReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("scale", (BigDecimal) o.getScale() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationProcedure", (DerivativeCalculationProcedure) o.getCalculationProcedure() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivitySetDefinition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SensitivitySetDefinition", ValidationResult.ValidationType.CARDINALITY, "SensitivitySetDefinition", path, "", res.getError());
				}
				return success("SensitivitySetDefinition", ValidationResult.ValidationType.CARDINALITY, "SensitivitySetDefinition", path, "");
			})
			.collect(toList());
	}

}
