package fpml.consolidated.variance.swaps.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.variance.swaps.VarianceOptionTransactionSupplement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("VarianceOptionTransactionSupplementChoice")
@ImplementedBy(VarianceOptionTransactionSupplementChoice.Default.class)
public interface VarianceOptionTransactionSupplementChoice extends Validator<VarianceOptionTransactionSupplement> {
	
	String NAME = "VarianceOptionTransactionSupplementChoice";
	String DEFINITION = "optional choice optionEntitlement, multiplier";
	
	class Default implements VarianceOptionTransactionSupplementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceOptionTransactionSupplement varianceOptionTransactionSupplement) {
			ComparisonResult result = executeDataRule(varianceOptionTransactionSupplement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "VarianceOptionTransactionSupplement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "VarianceOptionTransactionSupplement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(VarianceOptionTransactionSupplement varianceOptionTransactionSupplement) {
			try {
				return choice(MapperS.of(varianceOptionTransactionSupplement), Arrays.asList("optionEntitlement", "multiplier"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VarianceOptionTransactionSupplementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceOptionTransactionSupplement varianceOptionTransactionSupplement) {
			return Collections.emptyList();
		}
	}
}
