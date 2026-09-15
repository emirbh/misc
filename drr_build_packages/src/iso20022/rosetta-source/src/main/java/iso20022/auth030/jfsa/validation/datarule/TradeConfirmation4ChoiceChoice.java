package iso20022.auth030.jfsa.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.TradeConfirmation4Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeConfirmation4ChoiceChoice")
@ImplementedBy(TradeConfirmation4ChoiceChoice.Default.class)
public interface TradeConfirmation4ChoiceChoice extends Validator<TradeConfirmation4Choice> {
	
	String NAME = "TradeConfirmation4ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements TradeConfirmation4ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeConfirmation4Choice tradeConfirmation4Choice) {
			ComparisonResult result = executeDataRule(tradeConfirmation4Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeConfirmation4Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeConfirmation4Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeConfirmation4Choice tradeConfirmation4Choice) {
			try {
				return choice(MapperS.of(tradeConfirmation4Choice), Arrays.asList("confd", "nonConfd"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeConfirmation4ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeConfirmation4Choice tradeConfirmation4Choice) {
			return Collections.emptyList();
		}
	}
}
