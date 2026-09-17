package fpml.consolidated.cd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.ReferenceObligationChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ReferenceObligationChoiceChoice")
@ImplementedBy(ReferenceObligationChoiceChoice.Default.class)
public interface ReferenceObligationChoiceChoice extends Validator<ReferenceObligationChoice> {
	
	String NAME = "ReferenceObligationChoiceChoice";
	String DEFINITION = "optional choice guarantor, guarantorReference";
	
	class Default implements ReferenceObligationChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceObligationChoice referenceObligationChoice) {
			ComparisonResult result = executeDataRule(referenceObligationChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferenceObligationChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferenceObligationChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReferenceObligationChoice referenceObligationChoice) {
			try {
				return choice(MapperS.of(referenceObligationChoice), Arrays.asList("guarantor", "guarantorReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReferenceObligationChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceObligationChoice referenceObligationChoice) {
			return Collections.emptyList();
		}
	}
}
