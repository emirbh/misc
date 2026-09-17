package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityDeliveryPeriods;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityDeliveryPeriodsChoice")
@ImplementedBy(CommodityDeliveryPeriodsChoice.Default.class)
public interface CommodityDeliveryPeriodsChoice extends Validator<CommodityDeliveryPeriods> {
	
	String NAME = "CommodityDeliveryPeriodsChoice";
	String DEFINITION = "optional choice periods, periodsSchedule, calculationPeriodsReference, calculationPeriodsScheduleReference, calculationPeriodsDatesReference";
	
	class Default implements CommodityDeliveryPeriodsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDeliveryPeriods commodityDeliveryPeriods) {
			ComparisonResult result = executeDataRule(commodityDeliveryPeriods);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDeliveryPeriods", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDeliveryPeriods", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityDeliveryPeriods commodityDeliveryPeriods) {
			try {
				return choice(MapperS.of(commodityDeliveryPeriods), Arrays.asList("periods", "periodsSchedule", "calculationPeriodsReference", "calculationPeriodsScheduleReference", "calculationPeriodsDatesReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityDeliveryPeriodsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDeliveryPeriods commodityDeliveryPeriods) {
			return Collections.emptyList();
		}
	}
}
