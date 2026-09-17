package cdm.product.asset.validation.datarule;

import cdm.base.datetime.daycount.metafields.FieldWithMetaDayCountFractionEnum;
import cdm.product.asset.DiscountingMethod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("DiscountingMethodDiscountRate")
@ImplementedBy(DiscountingMethodDiscountRate.Default.class)
public interface DiscountingMethodDiscountRate extends Validator<DiscountingMethod> {
	
	String NAME = "DiscountingMethodDiscountRate";
	String DEFINITION = "if discountRateDayCountFraction exists then discountRate exists";
	
	class Default implements DiscountingMethodDiscountRate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DiscountingMethod discountingMethod) {
			ComparisonResult result = executeDataRule(discountingMethod);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DiscountingMethod", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DiscountingMethod", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DiscountingMethod discountingMethod) {
			try {
				if (exists(MapperS.of(discountingMethod).<FieldWithMetaDayCountFractionEnum>map("getDiscountRateDayCountFraction", _discountingMethod -> _discountingMethod.getDiscountRateDayCountFraction())).getOrDefault(false)) {
					return exists(MapperS.of(discountingMethod).<BigDecimal>map("getDiscountRate", _discountingMethod -> _discountingMethod.getDiscountRate()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DiscountingMethodDiscountRate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DiscountingMethod discountingMethod) {
			return Collections.emptyList();
		}
	}
}
