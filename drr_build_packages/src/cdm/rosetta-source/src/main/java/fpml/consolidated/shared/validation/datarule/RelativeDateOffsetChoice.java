package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RelativeDateOffsetChoice")
@ImplementedBy(RelativeDateOffsetChoice.Default.class)
public interface RelativeDateOffsetChoice extends Validator<RelativeDateOffset> {
	
	String NAME = "RelativeDateOffsetChoice";
	String DEFINITION = "optional choice businessCentersReference, businessCenters";
	
	class Default implements RelativeDateOffsetChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelativeDateOffset relativeDateOffset) {
			ComparisonResult result = executeDataRule(relativeDateOffset);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RelativeDateOffset", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RelativeDateOffset", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RelativeDateOffset relativeDateOffset) {
			try {
				return choice(MapperS.of(relativeDateOffset), Arrays.asList("businessCentersReference", "businessCenters"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RelativeDateOffsetChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelativeDateOffset relativeDateOffset) {
			return Collections.emptyList();
		}
	}
}
