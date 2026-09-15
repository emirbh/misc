package iso20022.auth108.iso.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.TradeData55Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeData55ChoiceChoice")
@ImplementedBy(TradeData55ChoiceChoice.Default.class)
public interface TradeData55ChoiceChoice extends Validator<TradeData55Choice> {
	
	String NAME = "TradeData55ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements TradeData55ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeData55Choice tradeData55Choice) {
			ComparisonResult result = executeDataRule(tradeData55Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeData55Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeData55Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeData55Choice tradeData55Choice) {
			try {
				return choice(MapperS.of(tradeData55Choice), Arrays.asList("dataSetActn", "rpt"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeData55ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeData55Choice tradeData55Choice) {
			return Collections.emptyList();
		}
	}
}
