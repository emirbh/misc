package cdm.legaldocumentation.common.validation.datarule;

import cdm.legaldocumentation.common.Agreement;
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
@RosettaDataRule("AgreementOneOf0")
@ImplementedBy(AgreementOneOf0.Default.class)
public interface AgreementOneOf0 extends Validator<Agreement> {
	
	String NAME = "AgreementOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements AgreementOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Agreement agreement) {
			ComparisonResult result = executeDataRule(agreement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Agreement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Agreement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Agreement agreement) {
			try {
				return choice(MapperS.of(agreement), Arrays.asList("creditSupportAgreementElections", "collateralTransferAgreementElections", "securityAgreementElections", "masterAgreementSchedule", "transactionAdditionalTerms", "masterAgreementElections"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AgreementOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Agreement agreement) {
			return Collections.emptyList();
		}
	}
}
