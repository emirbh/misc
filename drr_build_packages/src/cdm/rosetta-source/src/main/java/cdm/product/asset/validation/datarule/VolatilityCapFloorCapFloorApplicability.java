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
@RosettaDataRule("VolatilityCapFloorCapFloorApplicability")
@ImplementedBy(VolatilityCapFloorCapFloorApplicability.Default.class)
public interface VolatilityCapFloorCapFloorApplicability extends Validator<VolatilityCapFloor> {
	
	String NAME = "VolatilityCapFloorCapFloorApplicability";
	String DEFINITION = "if applicable = True then totalVolatilityCap exists or volatilityCapFactor exists else totalVolatilityCap is absent and volatilityCapFactor is absent";
	
	class Default implements VolatilityCapFloorCapFloorApplicability {
	
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
				if (areEqual(MapperS.of(volatilityCapFloor).<Boolean>map("getApplicable", _volatilityCapFloor -> _volatilityCapFloor.getApplicable()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(volatilityCapFloor).<BigDecimal>map("getTotalVolatilityCap", _volatilityCapFloor -> _volatilityCapFloor.getTotalVolatilityCap())).orNullSafe(exists(MapperS.of(volatilityCapFloor).<BigDecimal>map("getVolatilityCapFactor", _volatilityCapFloor -> _volatilityCapFloor.getVolatilityCapFactor())));
				}
				return notExists(MapperS.of(volatilityCapFloor).<BigDecimal>map("getTotalVolatilityCap", _volatilityCapFloor -> _volatilityCapFloor.getTotalVolatilityCap())).andNullSafe(notExists(MapperS.of(volatilityCapFloor).<BigDecimal>map("getVolatilityCapFactor", _volatilityCapFloor -> _volatilityCapFloor.getVolatilityCapFactor())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VolatilityCapFloorCapFloorApplicability {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityCapFloor volatilityCapFloor) {
			return Collections.emptyList();
		}
	}
}
