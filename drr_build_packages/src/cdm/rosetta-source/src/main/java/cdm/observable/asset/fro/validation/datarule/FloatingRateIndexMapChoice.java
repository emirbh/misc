package cdm.observable.asset.fro.validation.datarule;

import cdm.observable.asset.fro.FloatingRateIndexMap;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("FloatingRateIndexMapChoice")
@ImplementedBy(FloatingRateIndexMapChoice.Default.class)
public interface FloatingRateIndexMapChoice extends Validator<FloatingRateIndexMap> {
	
	String NAME = "FloatingRateIndexMapChoice";
	String DEFINITION = "optional choice identifier, contractualDefinitionIdentifier";
	
	class Default implements FloatingRateIndexMapChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateIndexMap floatingRateIndexMap) {
			ComparisonResult result = executeDataRule(floatingRateIndexMap);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingRateIndexMap", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingRateIndexMap", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FloatingRateIndexMap floatingRateIndexMap) {
			try {
				return choice(MapperS.of(floatingRateIndexMap), Arrays.asList("identifier", "contractualDefinitionIdentifier"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FloatingRateIndexMapChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateIndexMap floatingRateIndexMap) {
			return Collections.emptyList();
		}
	}
}
