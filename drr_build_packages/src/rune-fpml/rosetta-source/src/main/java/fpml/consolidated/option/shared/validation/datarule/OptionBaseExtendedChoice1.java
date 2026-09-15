package fpml.consolidated.option.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.OptionBaseExtended;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("OptionBaseExtendedChoice1")
@ImplementedBy(OptionBaseExtendedChoice1.Default.class)
public interface OptionBaseExtendedChoice1 extends Validator<OptionBaseExtended> {
	
	String NAME = "OptionBaseExtendedChoice1";
	String DEFINITION = "optional choice settlementAmount, settlementCurrency";
	
	class Default implements OptionBaseExtendedChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionBaseExtended optionBaseExtended) {
			ComparisonResult result = executeDataRule(optionBaseExtended);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionBaseExtended", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionBaseExtended", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OptionBaseExtended optionBaseExtended) {
			try {
				return choice(MapperS.of(optionBaseExtended), Arrays.asList("settlementAmount", "settlementCurrency"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionBaseExtendedChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionBaseExtended optionBaseExtended) {
			return Collections.emptyList();
		}
	}
}
