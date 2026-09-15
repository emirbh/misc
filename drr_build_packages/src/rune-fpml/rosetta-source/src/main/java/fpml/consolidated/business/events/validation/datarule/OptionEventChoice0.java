package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.OptionEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("OptionEventChoice0")
@ImplementedBy(OptionEventChoice0.Default.class)
public interface OptionEventChoice0 extends Validator<OptionEvent> {
	
	String NAME = "OptionEventChoice0";
	String DEFINITION = "optional choice originalTrade, tradeIdentifier";
	
	class Default implements OptionEventChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionEvent optionEvent) {
			ComparisonResult result = executeDataRule(optionEvent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionEvent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionEvent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OptionEvent optionEvent) {
			try {
				return choice(MapperS.of(optionEvent), Arrays.asList("originalTrade", "tradeIdentifier"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionEventChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionEvent optionEvent) {
			return Collections.emptyList();
		}
	}
}
