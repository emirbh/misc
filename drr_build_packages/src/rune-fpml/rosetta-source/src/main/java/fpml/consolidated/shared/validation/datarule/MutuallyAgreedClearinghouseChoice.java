package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.MutuallyAgreedClearinghouse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("MutuallyAgreedClearinghouseChoice")
@ImplementedBy(MutuallyAgreedClearinghouseChoice.Default.class)
public interface MutuallyAgreedClearinghouseChoice extends Validator<MutuallyAgreedClearinghouse> {
	
	String NAME = "MutuallyAgreedClearinghouseChoice";
	String DEFINITION = "one-of";
	
	class Default implements MutuallyAgreedClearinghouseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MutuallyAgreedClearinghouse mutuallyAgreedClearinghouse) {
			ComparisonResult result = executeDataRule(mutuallyAgreedClearinghouse);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MutuallyAgreedClearinghouse", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MutuallyAgreedClearinghouse", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MutuallyAgreedClearinghouse mutuallyAgreedClearinghouse) {
			try {
				return choice(MapperS.of(mutuallyAgreedClearinghouse), Arrays.asList("partyReference", "identifier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MutuallyAgreedClearinghouseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MutuallyAgreedClearinghouse mutuallyAgreedClearinghouse) {
			return Collections.emptyList();
		}
	}
}
