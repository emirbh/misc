package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.Frequency;
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
@RosettaDataRule("FrequencyPositivePeriodMultiplier")
@ImplementedBy(FrequencyPositivePeriodMultiplier.Default.class)
public interface FrequencyPositivePeriodMultiplier extends Validator<Frequency> {
	
	String NAME = "FrequencyPositivePeriodMultiplier";
	String DEFINITION = "periodMultiplier > 0";
	
	class Default implements FrequencyPositivePeriodMultiplier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Frequency frequency) {
			ComparisonResult result = executeDataRule(frequency);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Frequency", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Frequency", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Frequency frequency) {
			try {
				return greaterThan(MapperS.of(frequency).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()), MapperS.of(0), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FrequencyPositivePeriodMultiplier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Frequency frequency) {
			return Collections.emptyList();
		}
	}
}
