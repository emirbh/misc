package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityRelativeExpirationDates;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityRelativeExpirationDatesChoice")
@ImplementedBy(CommodityRelativeExpirationDatesChoice.Default.class)
public interface CommodityRelativeExpirationDatesChoice extends Validator<CommodityRelativeExpirationDates> {
	
	String NAME = "CommodityRelativeExpirationDatesChoice";
	String DEFINITION = "optional choice businessCentersReference, businessCenters";
	
	class Default implements CommodityRelativeExpirationDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityRelativeExpirationDates commodityRelativeExpirationDates) {
			ComparisonResult result = executeDataRule(commodityRelativeExpirationDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityRelativeExpirationDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityRelativeExpirationDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityRelativeExpirationDates commodityRelativeExpirationDates) {
			try {
				return choice(MapperS.of(commodityRelativeExpirationDates), Arrays.asList("businessCentersReference", "businessCenters"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityRelativeExpirationDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityRelativeExpirationDates commodityRelativeExpirationDates) {
			return Collections.emptyList();
		}
	}
}
