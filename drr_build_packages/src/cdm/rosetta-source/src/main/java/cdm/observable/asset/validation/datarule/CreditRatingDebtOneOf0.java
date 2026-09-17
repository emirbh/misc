package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.CreditRatingDebt;
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
@RosettaDataRule("CreditRatingDebtOneOf0")
@ImplementedBy(CreditRatingDebtOneOf0.Default.class)
public interface CreditRatingDebtOneOf0 extends Validator<CreditRatingDebt> {
	
	String NAME = "CreditRatingDebtOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements CreditRatingDebtOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditRatingDebt creditRatingDebt) {
			ComparisonResult result = executeDataRule(creditRatingDebt);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditRatingDebt", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditRatingDebt", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CreditRatingDebt creditRatingDebt) {
			try {
				return choice(MapperS.of(creditRatingDebt), Arrays.asList("debtType", "debtTypes"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditRatingDebtOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditRatingDebt creditRatingDebt) {
			return Collections.emptyList();
		}
	}
}
