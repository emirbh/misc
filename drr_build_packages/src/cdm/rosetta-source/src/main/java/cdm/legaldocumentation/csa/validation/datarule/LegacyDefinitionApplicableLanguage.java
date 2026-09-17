package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.LegacyDefinition;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("LegacyDefinitionApplicableLanguage")
@ImplementedBy(LegacyDefinitionApplicableLanguage.Default.class)
public interface LegacyDefinitionApplicableLanguage extends Validator<LegacyDefinition> {
	
	String NAME = "LegacyDefinitionApplicableLanguage";
	String DEFINITION = "if isApplicable = False then additionalLanguage exists";
	
	class Default implements LegacyDefinitionApplicableLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyDefinition legacyDefinition) {
			ComparisonResult result = executeDataRule(legacyDefinition);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyDefinition", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyDefinition", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LegacyDefinition legacyDefinition) {
			try {
				if (areEqual(MapperS.of(legacyDefinition).<Boolean>map("getIsApplicable", _legacyDefinition -> _legacyDefinition.getIsApplicable()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(legacyDefinition).<String>map("getAdditionalLanguage", _legacyDefinition -> _legacyDefinition.getAdditionalLanguage()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegacyDefinitionApplicableLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyDefinition legacyDefinition) {
			return Collections.emptyList();
		}
	}
}
