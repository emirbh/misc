package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityNotionalQuantityScheduleChoice1")
@ImplementedBy(CommodityNotionalQuantityScheduleChoice1.Default.class)
public interface CommodityNotionalQuantityScheduleChoice1 extends Validator<CommodityNotionalQuantitySchedule> {
	
	String NAME = "CommodityNotionalQuantityScheduleChoice1";
	String DEFINITION = "optional choice calculationPeriodsReference, calculationPeriodsScheduleReference, calculationPeriodsDatesReference";
	
	class Default implements CommodityNotionalQuantityScheduleChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityNotionalQuantitySchedule commodityNotionalQuantitySchedule) {
			ComparisonResult result = executeDataRule(commodityNotionalQuantitySchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityNotionalQuantitySchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityNotionalQuantitySchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityNotionalQuantitySchedule commodityNotionalQuantitySchedule) {
			try {
				return choice(MapperS.of(commodityNotionalQuantitySchedule), Arrays.asList("calculationPeriodsReference", "calculationPeriodsScheduleReference", "calculationPeriodsDatesReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityNotionalQuantityScheduleChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityNotionalQuantitySchedule commodityNotionalQuantitySchedule) {
			return Collections.emptyList();
		}
	}
}
