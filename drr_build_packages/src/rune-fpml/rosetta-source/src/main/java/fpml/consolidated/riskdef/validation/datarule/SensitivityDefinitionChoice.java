package fpml.consolidated.riskdef.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.DerivativeFormula;
import fpml.consolidated.riskdef.PricingParameterDerivative;
import fpml.consolidated.riskdef.SensitivityDefinition;
import fpml.consolidated.riskdef.TimeDimension;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SensitivityDefinitionChoice")
@ImplementedBy(SensitivityDefinitionChoice.Default.class)
public interface SensitivityDefinitionChoice extends Validator<SensitivityDefinition> {
	
	String NAME = "SensitivityDefinitionChoice";
	String DEFINITION = "if term exists then partialDerivative is absent and sensitivityDefinitionChoice is absent and formula is absent else sensitivityDefinitionChoice is absent or partialDerivative is absent and formula is absent";
	
	class Default implements SensitivityDefinitionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivityDefinition sensitivityDefinition) {
			ComparisonResult result = executeDataRule(sensitivityDefinition);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SensitivityDefinition", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SensitivityDefinition", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SensitivityDefinition sensitivityDefinition) {
			try {
				if (exists(MapperS.of(sensitivityDefinition).<TimeDimension>map("getTerm", _sensitivityDefinition -> _sensitivityDefinition.getTerm())).getOrDefault(false)) {
					return notExists(MapperS.of(sensitivityDefinition).<PricingParameterDerivative>mapC("getPartialDerivative", _sensitivityDefinition -> _sensitivityDefinition.getPartialDerivative())).andNullSafe(notExists(MapperS.of(sensitivityDefinition).<fpml.consolidated.riskdef.SensitivityDefinitionChoice>mapC("getSensitivityDefinitionChoice", _sensitivityDefinition -> _sensitivityDefinition.getSensitivityDefinitionChoice()))).andNullSafe(notExists(MapperS.of(sensitivityDefinition).<DerivativeFormula>map("getFormula", _sensitivityDefinition -> _sensitivityDefinition.getFormula())));
				}
				return notExists(MapperS.of(sensitivityDefinition).<fpml.consolidated.riskdef.SensitivityDefinitionChoice>mapC("getSensitivityDefinitionChoice", _sensitivityDefinition -> _sensitivityDefinition.getSensitivityDefinitionChoice())).orNullSafe(notExists(MapperS.of(sensitivityDefinition).<PricingParameterDerivative>mapC("getPartialDerivative", _sensitivityDefinition -> _sensitivityDefinition.getPartialDerivative())).andNullSafe(notExists(MapperS.of(sensitivityDefinition).<DerivativeFormula>map("getFormula", _sensitivityDefinition -> _sensitivityDefinition.getFormula()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SensitivityDefinitionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivityDefinition sensitivityDefinition) {
			return Collections.emptyList();
		}
	}
}
