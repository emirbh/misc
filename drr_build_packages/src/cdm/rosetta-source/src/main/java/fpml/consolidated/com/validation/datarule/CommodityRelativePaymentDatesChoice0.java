package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityRelativePaymentDatesChoice0")
@ImplementedBy(CommodityRelativePaymentDatesChoice0.Default.class)
public interface CommodityRelativePaymentDatesChoice0 extends Validator<CommodityRelativePaymentDates> {
	
	String NAME = "CommodityRelativePaymentDatesChoice0";
	String DEFINITION = "optional choice businessCentersReference, businessCenters";
	
	class Default implements CommodityRelativePaymentDatesChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityRelativePaymentDates commodityRelativePaymentDates) {
			ComparisonResult result = executeDataRule(commodityRelativePaymentDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityRelativePaymentDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityRelativePaymentDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityRelativePaymentDates commodityRelativePaymentDates) {
			try {
				return choice(MapperS.of(commodityRelativePaymentDates), Arrays.asList("businessCentersReference", "businessCenters"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityRelativePaymentDatesChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityRelativePaymentDates commodityRelativePaymentDates) {
			return Collections.emptyList();
		}
	}
}
