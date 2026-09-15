package fpml.consolidated.asset.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.BasicQuotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("BasicQuotationChoice")
@ImplementedBy(BasicQuotationChoice.Default.class)
public interface BasicQuotationChoice extends Validator<BasicQuotation> {
	
	String NAME = "BasicQuotationChoice";
	String DEFINITION = "optional choice businessCenter, exchangeId";
	
	class Default implements BasicQuotationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasicQuotation basicQuotation) {
			ComparisonResult result = executeDataRule(basicQuotation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BasicQuotation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BasicQuotation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BasicQuotation basicQuotation) {
			try {
				return choice(MapperS.of(basicQuotation), Arrays.asList("businessCenter", "exchangeId"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BasicQuotationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasicQuotation basicQuotation) {
			return Collections.emptyList();
		}
	}
}
