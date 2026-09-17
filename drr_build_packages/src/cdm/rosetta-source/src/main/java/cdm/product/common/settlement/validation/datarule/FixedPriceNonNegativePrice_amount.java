package cdm.product.common.settlement.validation.datarule;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.common.settlement.FixedPrice;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("FixedPriceNonNegativePrice_amount")
@ImplementedBy(FixedPriceNonNegativePrice_amount.Default.class)
public interface FixedPriceNonNegativePrice_amount extends Validator<FixedPrice> {
	
	String NAME = "FixedPriceNonNegativePrice_amount";
	String DEFINITION = "if price -> value exists then price -> value >= 0.0";
	
	class Default implements FixedPriceNonNegativePrice_amount {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPrice fixedPrice) {
			ComparisonResult result = executeDataRule(fixedPrice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FixedPrice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FixedPrice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FixedPrice fixedPrice) {
			try {
				if (exists(MapperS.of(fixedPrice).<ReferenceWithMetaPriceSchedule>map("getPrice", _fixedPrice -> _fixedPrice.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule0 -> referenceWithMetaPriceSchedule0 == null ? null : referenceWithMetaPriceSchedule0.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(fixedPrice).<ReferenceWithMetaPriceSchedule>map("getPrice", _fixedPrice -> _fixedPrice.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule1 -> referenceWithMetaPriceSchedule1 == null ? null : referenceWithMetaPriceSchedule1.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()), MapperS.of(new BigDecimal("0.0")), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FixedPriceNonNegativePrice_amount {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPrice fixedPrice) {
			return Collections.emptyList();
		}
	}
}
