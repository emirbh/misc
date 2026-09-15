package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityFixedPriceSchedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityFixedPriceScheduleChoice1")
@ImplementedBy(CommodityFixedPriceScheduleChoice1.Default.class)
public interface CommodityFixedPriceScheduleChoice1 extends Validator<CommodityFixedPriceSchedule> {
	
	String NAME = "CommodityFixedPriceScheduleChoice1";
	String DEFINITION = "optional choice calculationPeriodsReference, calculationPeriodsScheduleReference, calculationPeriodsDatesReference";
	
	class Default implements CommodityFixedPriceScheduleChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFixedPriceSchedule commodityFixedPriceSchedule) {
			ComparisonResult result = executeDataRule(commodityFixedPriceSchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFixedPriceSchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFixedPriceSchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityFixedPriceSchedule commodityFixedPriceSchedule) {
			try {
				return choice(MapperS.of(commodityFixedPriceSchedule), Arrays.asList("calculationPeriodsReference", "calculationPeriodsScheduleReference", "calculationPeriodsDatesReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityFixedPriceScheduleChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFixedPriceSchedule commodityFixedPriceSchedule) {
			return Collections.emptyList();
		}
	}
}
