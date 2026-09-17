package cdm.observable.asset.fro.validation;

import cdm.observable.asset.fro.FloatingRateIndexCalculationDefaults;
import cdm.observable.asset.fro.FloatingRateIndexDefinition;
import cdm.observable.asset.fro.FloatingRateIndexExternalMappings;
import cdm.observable.asset.fro.FloatingRateIndexIdentification;
import cdm.observable.asset.fro.FloatingRateIndexMappings;
import cdm.observable.asset.fro.FroHistory;
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

public class FloatingRateIndexDefinitionValidator implements Validator<FloatingRateIndexDefinition> {

	private List<ComparisonResult> getComparisonResults(FloatingRateIndexDefinition o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fro", (FloatingRateIndexIdentification) o.getFro() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculationDefaults", (FloatingRateIndexCalculationDefaults) o.getCalculationDefaults() != null ? 1 : 0, 0, 1), 
				checkCardinality("definitionalSource", (String) o.getDefinitionalSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("designatedMaturityApplicable", (Boolean) o.getDesignatedMaturityApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("mappings", (FloatingRateIndexMappings) o.getMappings() != null ? 1 : 0, 0, 1), 
				checkCardinality("externalMappings", (FloatingRateIndexExternalMappings) o.getExternalMappings() != null ? 1 : 0, 0, 1), 
				checkCardinality("inLoan", (Boolean) o.getInLoan() != null ? 1 : 0, 0, 1), 
				checkCardinality("history", (FroHistory) o.getHistory() != null ? 1 : 0, 0, 1), 
				checkCardinality("deprecationReason", (String) o.getDeprecationReason() != null ? 1 : 0, 0, 1), 
				checkCardinality("fpmlDescription", (String) o.getFpmlDescription() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateIndexDefinition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateIndexDefinition", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexDefinition", path, "", res.getError());
				}
				return success("FloatingRateIndexDefinition", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexDefinition", path, "");
			})
			.collect(toList());
	}

}
