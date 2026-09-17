package fpml.consolidated.repo.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.AdjustableOffset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("AdjustableOffsetChoice")
@ImplementedBy(AdjustableOffsetChoice.Default.class)
public interface AdjustableOffsetChoice extends Validator<AdjustableOffset> {
	
	String NAME = "AdjustableOffsetChoice";
	String DEFINITION = "optional choice businessCentersReference, businessCenters";
	
	class Default implements AdjustableOffsetChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOffset adjustableOffset) {
			ComparisonResult result = executeDataRule(adjustableOffset);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableOffset", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableOffset", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdjustableOffset adjustableOffset) {
			try {
				return choice(MapperS.of(adjustableOffset), Arrays.asList("businessCentersReference", "businessCenters"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableOffsetChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOffset adjustableOffset) {
			return Collections.emptyList();
		}
	}
}
