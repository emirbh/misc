package fpml.consolidated.ird.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.Swaption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SwaptionChoice")
@ImplementedBy(SwaptionChoice.Default.class)
public interface SwaptionChoice extends Validator<Swaption> {
	
	String NAME = "SwaptionChoice";
	String DEFINITION = "optional choice cashSettlement, physicalSettlement";
	
	class Default implements SwaptionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Swaption swaption) {
			ComparisonResult result = executeDataRule(swaption);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Swaption", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Swaption", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Swaption swaption) {
			try {
				return choice(MapperS.of(swaption), Arrays.asList("cashSettlement", "physicalSettlement"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SwaptionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Swaption swaption) {
			return Collections.emptyList();
		}
	}
}
