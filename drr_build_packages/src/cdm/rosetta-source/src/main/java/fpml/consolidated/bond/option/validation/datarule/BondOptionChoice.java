package fpml.consolidated.bond.option.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.bond.option.BondOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("BondOptionChoice")
@ImplementedBy(BondOptionChoice.Default.class)
public interface BondOptionChoice extends Validator<BondOption> {
	
	String NAME = "BondOptionChoice";
	String DEFINITION = "required choice bond, convertibleBond";
	
	class Default implements BondOptionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BondOption bondOption) {
			ComparisonResult result = executeDataRule(bondOption);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BondOption", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BondOption", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BondOption bondOption) {
			try {
				return choice(MapperS.of(bondOption), Arrays.asList("bond", "convertibleBond"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BondOptionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BondOption bondOption) {
			return Collections.emptyList();
		}
	}
}
