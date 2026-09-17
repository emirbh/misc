package cdm.product.asset.validation.datarule;

import cdm.product.asset.FloatingRateDefinition;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("FloatingRateDefinitionFloatingRateMultiplier")
@ImplementedBy(FloatingRateDefinitionFloatingRateMultiplier.Default.class)
public interface FloatingRateDefinitionFloatingRateMultiplier extends Validator<FloatingRateDefinition> {
	
	String NAME = "FloatingRateDefinitionFloatingRateMultiplier";
	String DEFINITION = "if floatingRateMultiplier exists then floatingRateMultiplier <> 1";
	
	class Default implements FloatingRateDefinitionFloatingRateMultiplier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateDefinition floatingRateDefinition) {
			ComparisonResult result = executeDataRule(floatingRateDefinition);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingRateDefinition", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingRateDefinition", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FloatingRateDefinition floatingRateDefinition) {
			try {
				if (exists(MapperS.of(floatingRateDefinition).<BigDecimal>map("getFloatingRateMultiplier", _floatingRateDefinition -> _floatingRateDefinition.getFloatingRateMultiplier())).getOrDefault(false)) {
					return notEqual(MapperS.of(floatingRateDefinition).<BigDecimal>map("getFloatingRateMultiplier", _floatingRateDefinition -> _floatingRateDefinition.getFloatingRateMultiplier()), MapperS.of(BigDecimal.valueOf(1)), CardinalityOperator.Any);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FloatingRateDefinitionFloatingRateMultiplier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateDefinition floatingRateDefinition) {
			return Collections.emptyList();
		}
	}
}
