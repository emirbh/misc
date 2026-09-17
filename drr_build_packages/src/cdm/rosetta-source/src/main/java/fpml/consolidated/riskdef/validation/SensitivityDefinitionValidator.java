package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.DerivativeFormula;
import fpml.consolidated.riskdef.SensitivityDefinition;
import fpml.consolidated.riskdef.TimeDimension;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SensitivityDefinitionValidator implements Validator<SensitivityDefinition> {

	private List<ComparisonResult> getComparisonResults(SensitivityDefinition o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationScenarioReference", (ValuationScenarioReference) o.getValuationScenarioReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("formula", (DerivativeFormula) o.getFormula() != null ? 1 : 0, 0, 1), 
				checkCardinality("term", (TimeDimension) o.getTerm() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivityDefinition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SensitivityDefinition", ValidationResult.ValidationType.CARDINALITY, "SensitivityDefinition", path, "", res.getError());
				}
				return success("SensitivityDefinition", ValidationResult.ValidationType.CARDINALITY, "SensitivityDefinition", path, "");
			})
			.collect(toList());
	}

}
