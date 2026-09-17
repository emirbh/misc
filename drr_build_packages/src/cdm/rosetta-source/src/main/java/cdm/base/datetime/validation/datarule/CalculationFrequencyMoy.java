package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.CalculationFrequency;
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
@RosettaDataRule("CalculationFrequencyMoy")
@ImplementedBy(CalculationFrequencyMoy.Default.class)
public interface CalculationFrequencyMoy extends Validator<CalculationFrequency> {
	
	String NAME = "CalculationFrequencyMoy";
	String DEFINITION = "if monthOfYear exists then monthOfYear <= 12";
	
	class Default implements CalculationFrequencyMoy {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationFrequency calculationFrequency) {
			ComparisonResult result = executeDataRule(calculationFrequency);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationFrequency", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationFrequency", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CalculationFrequency calculationFrequency) {
			try {
				if (exists(MapperS.of(calculationFrequency).<BigDecimal>map("getMonthOfYear", _calculationFrequency -> _calculationFrequency.getMonthOfYear())).getOrDefault(false)) {
					return lessThanEquals(MapperS.of(calculationFrequency).<BigDecimal>map("getMonthOfYear", _calculationFrequency -> _calculationFrequency.getMonthOfYear()), MapperS.of(BigDecimal.valueOf(12)), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationFrequencyMoy {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationFrequency calculationFrequency) {
			return Collections.emptyList();
		}
	}
}
