package fpml.consolidated.option.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.AveragingPeriod;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("AveragingPeriodChoice")
@ImplementedBy(AveragingPeriodChoice.Default.class)
public interface AveragingPeriodChoice extends Validator<AveragingPeriod> {
	
	String NAME = "AveragingPeriodChoice";
	String DEFINITION = "optional choice averagingDateTimes, averagingObservations";
	
	class Default implements AveragingPeriodChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AveragingPeriod averagingPeriod) {
			ComparisonResult result = executeDataRule(averagingPeriod);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AveragingPeriod", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AveragingPeriod", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AveragingPeriod averagingPeriod) {
			try {
				return choice(MapperS.of(averagingPeriod), Arrays.asList("averagingDateTimes", "averagingObservations"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AveragingPeriodChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AveragingPeriod averagingPeriod) {
			return Collections.emptyList();
		}
	}
}
