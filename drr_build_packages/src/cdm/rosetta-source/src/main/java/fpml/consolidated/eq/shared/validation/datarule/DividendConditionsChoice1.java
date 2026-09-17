package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.DividendConditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("DividendConditionsChoice1")
@ImplementedBy(DividendConditionsChoice1.Default.class)
public interface DividendConditionsChoice1 extends Validator<DividendConditions> {
	
	String NAME = "DividendConditionsChoice1";
	String DEFINITION = "optional choice currency, determinationMethod, currencyReference";
	
	class Default implements DividendConditionsChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendConditions dividendConditions) {
			ComparisonResult result = executeDataRule(dividendConditions);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendConditions", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendConditions", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DividendConditions dividendConditions) {
			try {
				return choice(MapperS.of(dividendConditions), Arrays.asList("currency", "determinationMethod", "currencyReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DividendConditionsChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendConditions dividendConditions) {
			return Collections.emptyList();
		}
	}
}
