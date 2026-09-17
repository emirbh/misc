package cdm.product.asset.validation.datarule;

import cdm.product.asset.VolatilityCapFloor;
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
@RosettaDataRule("VolatilityCapFloorPositiveCaps")
@ImplementedBy(VolatilityCapFloorPositiveCaps.Default.class)
public interface VolatilityCapFloorPositiveCaps extends Validator<VolatilityCapFloor> {
	
	String NAME = "VolatilityCapFloorPositiveCaps";
	String DEFINITION = "if totalVolatilityCap exists then totalVolatilityCap >= 0 and if volatilityCapFactor exists then volatilityCapFactor >= 0";
	
	class Default implements VolatilityCapFloorPositiveCaps {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityCapFloor volatilityCapFloor) {
			ComparisonResult result = executeDataRule(volatilityCapFloor);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "VolatilityCapFloor", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "VolatilityCapFloor", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(VolatilityCapFloor volatilityCapFloor) {
			try {
				if (exists(MapperS.of(volatilityCapFloor).<BigDecimal>map("getTotalVolatilityCap", _volatilityCapFloor -> _volatilityCapFloor.getTotalVolatilityCap())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (exists(MapperS.of(volatilityCapFloor).<BigDecimal>map("getVolatilityCapFactor", _volatilityCapFloor -> _volatilityCapFloor.getVolatilityCapFactor())).getOrDefault(false)) {
						ifThenElseResult = greaterThanEquals(MapperS.of(volatilityCapFloor).<BigDecimal>map("getVolatilityCapFactor", _volatilityCapFloor -> _volatilityCapFloor.getVolatilityCapFactor()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All);
					} else {
						ifThenElseResult = ComparisonResult.ofEmpty();
					}
					return greaterThanEquals(MapperS.of(volatilityCapFloor).<BigDecimal>map("getTotalVolatilityCap", _volatilityCapFloor -> _volatilityCapFloor.getTotalVolatilityCap()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).andNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VolatilityCapFloorPositiveCaps {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityCapFloor volatilityCapFloor) {
			return Collections.emptyList();
		}
	}
}
