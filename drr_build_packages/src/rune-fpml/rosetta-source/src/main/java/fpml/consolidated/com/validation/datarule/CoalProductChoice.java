package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CoalProduct;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CoalProductChoice")
@ImplementedBy(CoalProductChoice.Default.class)
public interface CoalProductChoice extends Validator<CoalProduct> {
	
	String NAME = "CoalProductChoice";
	String DEFINITION = "optional choice ^type, coalProductSpecifications";
	
	class Default implements CoalProductChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalProduct coalProduct) {
			ComparisonResult result = executeDataRule(coalProduct);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalProduct", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalProduct", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CoalProduct coalProduct) {
			try {
				return choice(MapperS.of(coalProduct), Arrays.asList("type", "coalProductSpecifications"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CoalProductChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalProduct coalProduct) {
			return Collections.emptyList();
		}
	}
}
