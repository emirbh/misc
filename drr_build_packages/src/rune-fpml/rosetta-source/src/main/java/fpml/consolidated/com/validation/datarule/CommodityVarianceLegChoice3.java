package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityVarianceLeg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityVarianceLegChoice3")
@ImplementedBy(CommodityVarianceLegChoice3.Default.class)
public interface CommodityVarianceLegChoice3 extends Validator<CommodityVarianceLeg> {
	
	String NAME = "CommodityVarianceLegChoice3";
	String DEFINITION = "optional choice notionalAmount, notionalAmountReference";
	
	class Default implements CommodityVarianceLegChoice3 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityVarianceLeg commodityVarianceLeg) {
			ComparisonResult result = executeDataRule(commodityVarianceLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityVarianceLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityVarianceLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityVarianceLeg commodityVarianceLeg) {
			try {
				return choice(MapperS.of(commodityVarianceLeg), Arrays.asList("notionalAmount", "notionalAmountReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityVarianceLegChoice3 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityVarianceLeg commodityVarianceLeg) {
			return Collections.emptyList();
		}
	}
}
