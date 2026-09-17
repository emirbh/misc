package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityDigitalOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityDigitalOptionChoice0")
@ImplementedBy(CommodityDigitalOptionChoice0.Default.class)
public interface CommodityDigitalOptionChoice0 extends Validator<CommodityDigitalOption> {
	
	String NAME = "CommodityDigitalOptionChoice0";
	String DEFINITION = "optional choice calculationPeriodsSchedule, calculationPeriods";
	
	class Default implements CommodityDigitalOptionChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDigitalOption commodityDigitalOption) {
			ComparisonResult result = executeDataRule(commodityDigitalOption);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDigitalOption", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDigitalOption", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityDigitalOption commodityDigitalOption) {
			try {
				return choice(MapperS.of(commodityDigitalOption), Arrays.asList("calculationPeriodsSchedule", "calculationPeriods"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityDigitalOptionChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDigitalOption commodityDigitalOption) {
			return Collections.emptyList();
		}
	}
}
