package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.EquityValuation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("EquityValuationChoice1")
@ImplementedBy(EquityValuationChoice1.Default.class)
public interface EquityValuationChoice1 extends Validator<EquityValuation> {
	
	String NAME = "EquityValuationChoice1";
	String DEFINITION = "optional choice futuresPriceValuation, optionsPriceValuation";
	
	class Default implements EquityValuationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityValuation equityValuation) {
			ComparisonResult result = executeDataRule(equityValuation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityValuation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityValuation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EquityValuation equityValuation) {
			try {
				return choice(MapperS.of(equityValuation), Arrays.asList("futuresPriceValuation", "optionsPriceValuation"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityValuationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityValuation equityValuation) {
			return Collections.emptyList();
		}
	}
}
