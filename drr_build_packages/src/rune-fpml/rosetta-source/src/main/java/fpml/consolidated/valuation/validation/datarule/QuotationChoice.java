package fpml.consolidated.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.valuation.Quotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("QuotationChoice")
@ImplementedBy(QuotationChoice.Default.class)
public interface QuotationChoice extends Validator<Quotation> {
	
	String NAME = "QuotationChoice";
	String DEFINITION = "optional choice businessCenter, exchangeId";
	
	class Default implements QuotationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Quotation quotation) {
			ComparisonResult result = executeDataRule(quotation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Quotation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Quotation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Quotation quotation) {
			try {
				return choice(MapperS.of(quotation), Arrays.asList("businessCenter", "exchangeId"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements QuotationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Quotation quotation) {
			return Collections.emptyList();
		}
	}
}
