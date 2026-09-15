package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommoditySwaptionUnderlying;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommoditySwaptionUnderlyingChoice")
@ImplementedBy(CommoditySwaptionUnderlyingChoice.Default.class)
public interface CommoditySwaptionUnderlyingChoice extends Validator<CommoditySwaptionUnderlying> {
	
	String NAME = "CommoditySwaptionUnderlyingChoice";
	String DEFINITION = "optional choice commoditySwapLeg, weatherLeg";
	
	class Default implements CommoditySwaptionUnderlyingChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommoditySwaptionUnderlying commoditySwaptionUnderlying) {
			ComparisonResult result = executeDataRule(commoditySwaptionUnderlying);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommoditySwaptionUnderlying", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommoditySwaptionUnderlying", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommoditySwaptionUnderlying commoditySwaptionUnderlying) {
			try {
				return choice(MapperS.of(commoditySwaptionUnderlying), Arrays.asList("commoditySwapLeg", "weatherLeg"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommoditySwaptionUnderlyingChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommoditySwaptionUnderlying commoditySwaptionUnderlying) {
			return Collections.emptyList();
		}
	}
}
