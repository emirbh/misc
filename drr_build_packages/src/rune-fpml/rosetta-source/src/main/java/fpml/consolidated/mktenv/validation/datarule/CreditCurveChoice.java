package fpml.consolidated.mktenv.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.mktenv.CreditCurve;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CreditCurveChoice")
@ImplementedBy(CreditCurveChoice.Default.class)
public interface CreditCurveChoice extends Validator<CreditCurve> {
	
	String NAME = "CreditCurveChoice";
	String DEFINITION = "optional choice referenceEntity, creditEntityReference";
	
	class Default implements CreditCurveChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditCurve creditCurve) {
			ComparisonResult result = executeDataRule(creditCurve);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditCurve", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditCurve", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CreditCurve creditCurve) {
			try {
				return choice(MapperS.of(creditCurve), Arrays.asList("referenceEntity", "creditEntityReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditCurveChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditCurve creditCurve) {
			return Collections.emptyList();
		}
	}
}
