package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.GasProduct;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("GasProductChoice")
@ImplementedBy(GasProductChoice.Default.class)
public interface GasProductChoice extends Validator<GasProduct> {
	
	String NAME = "GasProductChoice";
	String DEFINITION = "optional choice calorificValue, quality";
	
	class Default implements GasProductChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasProduct gasProduct) {
			ComparisonResult result = executeDataRule(gasProduct);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GasProduct", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "GasProduct", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(GasProduct gasProduct) {
			try {
				return choice(MapperS.of(gasProduct), Arrays.asList("calorificValue", "quality"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements GasProductChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasProduct gasProduct) {
			return Collections.emptyList();
		}
	}
}
