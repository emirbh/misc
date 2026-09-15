package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessCentersOrReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("BusinessCentersOrReferenceChoice")
@ImplementedBy(BusinessCentersOrReferenceChoice.Default.class)
public interface BusinessCentersOrReferenceChoice extends Validator<BusinessCentersOrReference> {
	
	String NAME = "BusinessCentersOrReferenceChoice";
	String DEFINITION = "one-of";
	
	class Default implements BusinessCentersOrReferenceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessCentersOrReference businessCentersOrReference) {
			ComparisonResult result = executeDataRule(businessCentersOrReference);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BusinessCentersOrReference", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BusinessCentersOrReference", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BusinessCentersOrReference businessCentersOrReference) {
			try {
				return choice(MapperS.of(businessCentersOrReference), Arrays.asList("businessCentersReference", "businessCenters"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BusinessCentersOrReferenceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessCentersOrReference businessCentersOrReference) {
			return Collections.emptyList();
		}
	}
}
