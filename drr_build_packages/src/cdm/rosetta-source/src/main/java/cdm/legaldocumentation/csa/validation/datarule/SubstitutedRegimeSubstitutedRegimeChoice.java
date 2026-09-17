package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.SubstitutedRegime;
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
@RosettaDataRule("SubstitutedRegimeSubstitutedRegimeChoice")
@ImplementedBy(SubstitutedRegimeSubstitutedRegimeChoice.Default.class)
public interface SubstitutedRegimeSubstitutedRegimeChoice extends Validator<SubstitutedRegime> {
	
	String NAME = "SubstitutedRegimeSubstitutedRegimeChoice";
	String DEFINITION = "required choice regime, additionalRegime";
	
	class Default implements SubstitutedRegimeSubstitutedRegimeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SubstitutedRegime substitutedRegime) {
			ComparisonResult result = executeDataRule(substitutedRegime);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SubstitutedRegime", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SubstitutedRegime", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SubstitutedRegime substitutedRegime) {
			try {
				return choice(MapperS.of(substitutedRegime), Arrays.asList("regime", "additionalRegime"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SubstitutedRegimeSubstitutedRegimeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SubstitutedRegime substitutedRegime) {
			return Collections.emptyList();
		}
	}
}
