package cdm.product.common.schedule.validation.datarule;

import cdm.product.common.schedule.InitialFixingDate;
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
@RosettaDataRule("InitialFixingDateOneOf0")
@ImplementedBy(InitialFixingDateOneOf0.Default.class)
public interface InitialFixingDateOneOf0 extends Validator<InitialFixingDate> {
	
	String NAME = "InitialFixingDateOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements InitialFixingDateOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InitialFixingDate initialFixingDate) {
			ComparisonResult result = executeDataRule(initialFixingDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InitialFixingDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InitialFixingDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(InitialFixingDate initialFixingDate) {
			try {
				return choice(MapperS.of(initialFixingDate), Arrays.asList("relativeDateOffset", "initialFixingDate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InitialFixingDateOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InitialFixingDate initialFixingDate) {
			return Collections.emptyList();
		}
	}
}
