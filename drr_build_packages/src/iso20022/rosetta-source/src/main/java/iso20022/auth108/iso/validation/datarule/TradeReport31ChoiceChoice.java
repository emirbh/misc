package iso20022.auth108.iso.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.TradeReport31Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeReport31ChoiceChoice")
@ImplementedBy(TradeReport31ChoiceChoice.Default.class)
public interface TradeReport31ChoiceChoice extends Validator<TradeReport31Choice> {
	
	String NAME = "TradeReport31ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements TradeReport31ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReport31Choice tradeReport31Choice) {
			ComparisonResult result = executeDataRule(tradeReport31Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeReport31Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeReport31Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeReport31Choice tradeReport31Choice) {
			try {
				return choice(MapperS.of(tradeReport31Choice), Arrays.asList("new", "mrgnUpd", "err", "crrctn"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeReport31ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReport31Choice tradeReport31Choice) {
			return Collections.emptyList();
		}
	}
}
