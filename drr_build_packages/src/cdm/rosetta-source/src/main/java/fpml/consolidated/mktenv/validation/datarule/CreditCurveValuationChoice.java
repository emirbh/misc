package fpml.consolidated.mktenv.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.mktenv.CreditCurveValuation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CreditCurveValuationChoice")
@ImplementedBy(CreditCurveValuationChoice.Default.class)
public interface CreditCurveValuationChoice extends Validator<CreditCurveValuation> {
	
	String NAME = "CreditCurveValuationChoice";
	String DEFINITION = "optional choice recoveryRate, recoveryRateCurve";
	
	class Default implements CreditCurveValuationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditCurveValuation creditCurveValuation) {
			ComparisonResult result = executeDataRule(creditCurveValuation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditCurveValuation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditCurveValuation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CreditCurveValuation creditCurveValuation) {
			try {
				return choice(MapperS.of(creditCurveValuation), Arrays.asList("recoveryRate", "recoveryRateCurve"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditCurveValuationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditCurveValuation creditCurveValuation) {
			return Collections.emptyList();
		}
	}
}
