package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.BusinessCenters;
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
@RosettaDataRule("BusinessCentersBusinessCentersChoice")
@ImplementedBy(BusinessCentersBusinessCentersChoice.Default.class)
public interface BusinessCentersBusinessCentersChoice extends Validator<BusinessCenters> {
	
	String NAME = "BusinessCentersBusinessCentersChoice";
	String DEFINITION = "required choice businessCenter, businessCentersReference, commodityBusinessCalendar";
	
	class Default implements BusinessCentersBusinessCentersChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessCenters businessCenters) {
			ComparisonResult result = executeDataRule(businessCenters);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BusinessCenters", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BusinessCenters", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BusinessCenters businessCenters) {
			try {
				return choice(MapperS.of(businessCenters), Arrays.asList("businessCenter", "businessCentersReference", "commodityBusinessCalendar"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BusinessCentersBusinessCentersChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessCenters businessCenters) {
			return Collections.emptyList();
		}
	}
}
