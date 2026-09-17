package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.CreditNotations;
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
@RosettaDataRule("CreditNotationsOneOf0")
@ImplementedBy(CreditNotationsOneOf0.Default.class)
public interface CreditNotationsOneOf0 extends Validator<CreditNotations> {
	
	String NAME = "CreditNotationsOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements CreditNotationsOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditNotations creditNotations) {
			ComparisonResult result = executeDataRule(creditNotations);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditNotations", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditNotations", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CreditNotations creditNotations) {
			try {
				return choice(MapperS.of(creditNotations), Arrays.asList("creditNotation", "creditNotations"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditNotationsOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditNotations creditNotations) {
			return Collections.emptyList();
		}
	}
}
