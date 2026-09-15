package iso20022.auth108.fca.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.fca.TradeReport31Choice__1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeReport31Choice__1Choice")
@ImplementedBy(TradeReport31Choice__1Choice.Default.class)
public interface TradeReport31Choice__1Choice extends Validator<TradeReport31Choice__1> {
	
	String NAME = "TradeReport31Choice__1Choice";
	String DEFINITION = "one-of";
	
	class Default implements TradeReport31Choice__1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReport31Choice__1 tradeReport31Choice__1) {
			ComparisonResult result = executeDataRule(tradeReport31Choice__1);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeReport31Choice__1", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeReport31Choice__1", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeReport31Choice__1 tradeReport31Choice__1) {
			try {
				return choice(MapperS.of(tradeReport31Choice__1), Arrays.asList("mrgnUpd", "crrctn"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeReport31Choice__1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReport31Choice__1 tradeReport31Choice__1) {
			return Collections.emptyList();
		}
	}
}
