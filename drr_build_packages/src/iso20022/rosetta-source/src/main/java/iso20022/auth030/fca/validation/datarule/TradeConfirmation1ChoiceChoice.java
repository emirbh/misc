package iso20022.auth030.fca.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.TradeConfirmation1Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeConfirmation1ChoiceChoice")
@ImplementedBy(TradeConfirmation1ChoiceChoice.Default.class)
public interface TradeConfirmation1ChoiceChoice extends Validator<TradeConfirmation1Choice> {
	
	String NAME = "TradeConfirmation1ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements TradeConfirmation1ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeConfirmation1Choice tradeConfirmation1Choice) {
			ComparisonResult result = executeDataRule(tradeConfirmation1Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeConfirmation1Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeConfirmation1Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeConfirmation1Choice tradeConfirmation1Choice) {
			try {
				return choice(MapperS.of(tradeConfirmation1Choice), Arrays.asList("confd", "nonConfd"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeConfirmation1ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeConfirmation1Choice tradeConfirmation1Choice) {
			return Collections.emptyList();
		}
	}
}
