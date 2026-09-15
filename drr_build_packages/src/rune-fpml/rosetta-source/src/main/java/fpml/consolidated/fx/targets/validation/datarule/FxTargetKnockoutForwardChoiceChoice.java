package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetKnockoutForwardChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxTargetKnockoutForwardChoiceChoice")
@ImplementedBy(FxTargetKnockoutForwardChoiceChoice.Default.class)
public interface FxTargetKnockoutForwardChoiceChoice extends Validator<FxTargetKnockoutForwardChoice> {
	
	String NAME = "FxTargetKnockoutForwardChoiceChoice";
	String DEFINITION = "optional choice constantPayoffRegion, linearPayoffRegion";
	
	class Default implements FxTargetKnockoutForwardChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetKnockoutForwardChoice fxTargetKnockoutForwardChoice) {
			ComparisonResult result = executeDataRule(fxTargetKnockoutForwardChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetKnockoutForwardChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetKnockoutForwardChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxTargetKnockoutForwardChoice fxTargetKnockoutForwardChoice) {
			try {
				return choice(MapperS.of(fxTargetKnockoutForwardChoice), Arrays.asList("constantPayoffRegion", "linearPayoffRegion"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetKnockoutForwardChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetKnockoutForwardChoice fxTargetKnockoutForwardChoice) {
			return Collections.emptyList();
		}
	}
}
