package drr.base.trade.price.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("PriceFormatOneOf0")
@ImplementedBy(PriceFormatOneOf0.Default.class)
public interface PriceFormatOneOf0 extends Validator<PriceFormat> {
	
	String NAME = "PriceFormatOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements PriceFormatOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceFormat priceFormat) {
			ComparisonResult result = executeDataRule(priceFormat);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceFormat", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceFormat", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PriceFormat priceFormat) {
			try {
				return choice(MapperS.of(priceFormat), Arrays.asList("monetary", "decimal", "percentage", "basis"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PriceFormatOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceFormat priceFormat) {
			return Collections.emptyList();
		}
	}
}
