package iso20022.auth030.esma.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.DerivativePartyIdentification1Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("DerivativePartyIdentification1ChoiceChoice")
@ImplementedBy(DerivativePartyIdentification1ChoiceChoice.Default.class)
public interface DerivativePartyIdentification1ChoiceChoice extends Validator<DerivativePartyIdentification1Choice> {
	
	String NAME = "DerivativePartyIdentification1ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements DerivativePartyIdentification1ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativePartyIdentification1Choice derivativePartyIdentification1Choice) {
			ComparisonResult result = executeDataRule(derivativePartyIdentification1Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DerivativePartyIdentification1Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DerivativePartyIdentification1Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DerivativePartyIdentification1Choice derivativePartyIdentification1Choice) {
			try {
				return choice(MapperS.of(derivativePartyIdentification1Choice), Arrays.asList("ctry", "ctrySubDvsn", "lei"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DerivativePartyIdentification1ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativePartyIdentification1Choice derivativePartyIdentification1Choice) {
			return Collections.emptyList();
		}
	}
}
