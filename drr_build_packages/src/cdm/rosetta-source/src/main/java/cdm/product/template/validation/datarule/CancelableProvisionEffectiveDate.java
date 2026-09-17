package cdm.product.template.validation.datarule;

import cdm.product.template.CancelableProvision;
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
@RosettaDataRule("CancelableProvisionEffectiveDate")
@ImplementedBy(CancelableProvisionEffectiveDate.Default.class)
public interface CancelableProvisionEffectiveDate extends Validator<CancelableProvision> {
	
	String NAME = "CancelableProvisionEffectiveDate";
	String DEFINITION = "optional choice effectiveDate, effectivePeriod";
	
	class Default implements CancelableProvisionEffectiveDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CancelableProvision cancelableProvision) {
			ComparisonResult result = executeDataRule(cancelableProvision);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CancelableProvision", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CancelableProvision", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CancelableProvision cancelableProvision) {
			try {
				return choice(MapperS.of(cancelableProvision), Arrays.asList("effectiveDate", "effectivePeriod"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CancelableProvisionEffectiveDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CancelableProvision cancelableProvision) {
			return Collections.emptyList();
		}
	}
}
