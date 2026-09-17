package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.ValuationDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("ValuationDateOneOf0")
@ImplementedBy(ValuationDateOneOf0.Default.class)
public interface ValuationDateOneOf0 extends Validator<ValuationDate> {
	
	String NAME = "ValuationDateOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements ValuationDateOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationDate valuationDate) {
			ComparisonResult result = executeDataRule(valuationDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ValuationDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ValuationDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ValuationDate valuationDate) {
			try {
				return choice(MapperS.of(valuationDate), Arrays.asList("singleValuationDate", "multipleValuationDates", "valuationDate", "fxFixingDate", "fxFixingSchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ValuationDateOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationDate valuationDate) {
			return Collections.emptyList();
		}
	}
}
