package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessDateRange;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("BusinessDateRangeChoice")
@ImplementedBy(BusinessDateRangeChoice.Default.class)
public interface BusinessDateRangeChoice extends Validator<BusinessDateRange> {
	
	String NAME = "BusinessDateRangeChoice";
	String DEFINITION = "optional choice businessCentersReference, businessCenters";
	
	class Default implements BusinessDateRangeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessDateRange businessDateRange) {
			ComparisonResult result = executeDataRule(businessDateRange);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BusinessDateRange", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BusinessDateRange", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BusinessDateRange businessDateRange) {
			try {
				return choice(MapperS.of(businessDateRange), Arrays.asList("businessCentersReference", "businessCenters"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BusinessDateRangeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessDateRange businessDateRange) {
			return Collections.emptyList();
		}
	}
}
