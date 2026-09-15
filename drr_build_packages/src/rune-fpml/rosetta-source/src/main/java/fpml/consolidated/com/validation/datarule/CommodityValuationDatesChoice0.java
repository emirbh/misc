package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityValuationDates;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityValuationDatesChoice0")
@ImplementedBy(CommodityValuationDatesChoice0.Default.class)
public interface CommodityValuationDatesChoice0 extends Validator<CommodityValuationDates> {
	
	String NAME = "CommodityValuationDatesChoice0";
	String DEFINITION = "optional choice calculationPeriodsReference, calculationPeriodsScheduleReference, calculationPeriodsDatesReference";
	
	class Default implements CommodityValuationDatesChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityValuationDates commodityValuationDates) {
			ComparisonResult result = executeDataRule(commodityValuationDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityValuationDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityValuationDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityValuationDates commodityValuationDates) {
			try {
				return choice(MapperS.of(commodityValuationDates), Arrays.asList("calculationPeriodsReference", "calculationPeriodsScheduleReference", "calculationPeriodsDatesReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityValuationDatesChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityValuationDates commodityValuationDates) {
			return Collections.emptyList();
		}
	}
}
