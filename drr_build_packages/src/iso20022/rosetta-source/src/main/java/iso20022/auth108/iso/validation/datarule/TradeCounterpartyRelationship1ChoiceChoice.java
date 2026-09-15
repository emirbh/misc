package iso20022.auth108.iso.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.TradeCounterpartyRelationship1Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeCounterpartyRelationship1ChoiceChoice")
@ImplementedBy(TradeCounterpartyRelationship1ChoiceChoice.Default.class)
public interface TradeCounterpartyRelationship1ChoiceChoice extends Validator<TradeCounterpartyRelationship1Choice> {
	
	String NAME = "TradeCounterpartyRelationship1ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements TradeCounterpartyRelationship1ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeCounterpartyRelationship1Choice tradeCounterpartyRelationship1Choice) {
			ComparisonResult result = executeDataRule(tradeCounterpartyRelationship1Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeCounterpartyRelationship1Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeCounterpartyRelationship1Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeCounterpartyRelationship1Choice tradeCounterpartyRelationship1Choice) {
			try {
				return choice(MapperS.of(tradeCounterpartyRelationship1Choice), Arrays.asList("cd", "prtry"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeCounterpartyRelationship1ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeCounterpartyRelationship1Choice tradeCounterpartyRelationship1Choice) {
			return Collections.emptyList();
		}
	}
}
