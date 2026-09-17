package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.OptionExpiry;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("OptionExpiryChoice")
@ImplementedBy(OptionExpiryChoice.Default.class)
public interface OptionExpiryChoice extends Validator<OptionExpiry> {
	
	String NAME = "OptionExpiryChoice";
	String DEFINITION = "optional choice originalTrade, tradeIdentifier";
	
	class Default implements OptionExpiryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExpiry optionExpiry) {
			ComparisonResult result = executeDataRule(optionExpiry);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExpiry", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExpiry", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OptionExpiry optionExpiry) {
			try {
				return choice(MapperS.of(optionExpiry), Arrays.asList("originalTrade", "tradeIdentifier"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionExpiryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExpiry optionExpiry) {
			return Collections.emptyList();
		}
	}
}
