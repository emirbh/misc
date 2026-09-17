package cdm.product.template.validation.datarule;

import cdm.product.template.Product;
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
@RosettaDataRule("ProductChoice")
@ImplementedBy(ProductChoice.Default.class)
public interface ProductChoice extends Validator<Product> {
	
	String NAME = "ProductChoice";
	String DEFINITION = "";
	
	class Default implements ProductChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Product product) {
			ComparisonResult result = executeDataRule(product);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Product", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Product", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Product product) {
			try {
				return choice(MapperS.of(product), Arrays.asList("TransferableProduct", "NonTransferableProduct"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ProductChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Product product) {
			return Collections.emptyList();
		}
	}
}
