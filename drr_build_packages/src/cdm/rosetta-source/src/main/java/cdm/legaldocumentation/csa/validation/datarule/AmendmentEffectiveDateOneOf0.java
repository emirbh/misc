package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.AmendmentEffectiveDate;
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
@RosettaDataRule("AmendmentEffectiveDateOneOf0")
@ImplementedBy(AmendmentEffectiveDateOneOf0.Default.class)
public interface AmendmentEffectiveDateOneOf0 extends Validator<AmendmentEffectiveDate> {
	
	String NAME = "AmendmentEffectiveDateOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements AmendmentEffectiveDateOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AmendmentEffectiveDate amendmentEffectiveDate) {
			ComparisonResult result = executeDataRule(amendmentEffectiveDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AmendmentEffectiveDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AmendmentEffectiveDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AmendmentEffectiveDate amendmentEffectiveDate) {
			try {
				return choice(MapperS.of(amendmentEffectiveDate), Arrays.asList("date", "specificDate", "customProvision"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AmendmentEffectiveDateOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AmendmentEffectiveDate amendmentEffectiveDate) {
			return Collections.emptyList();
		}
	}
}
