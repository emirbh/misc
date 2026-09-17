package cdm.product.asset.validation.datarule;

import cdm.product.asset.BoundedVariance;
import cdm.product.asset.VarianceCapFloor;
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
@RosettaDataRule("VarianceCapFloorCapFloorApplicability")
@ImplementedBy(VarianceCapFloorCapFloorApplicability.Default.class)
public interface VarianceCapFloorCapFloorApplicability extends Validator<VarianceCapFloor> {
	
	String NAME = "VarianceCapFloorCapFloorApplicability";
	String DEFINITION = "if varianceCap = True then unadjustedVarianceCap exists or boundedVariance exists else unadjustedVarianceCap is absent and boundedVariance is absent";
	
	class Default implements VarianceCapFloorCapFloorApplicability {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceCapFloor varianceCapFloor) {
			ComparisonResult result = executeDataRule(varianceCapFloor);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "VarianceCapFloor", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "VarianceCapFloor", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(VarianceCapFloor varianceCapFloor) {
			try {
				if (areEqual(MapperS.of(varianceCapFloor).<Boolean>map("getVarianceCap", _varianceCapFloor -> _varianceCapFloor.getVarianceCap()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(varianceCapFloor).<BigDecimal>map("getUnadjustedVarianceCap", _varianceCapFloor -> _varianceCapFloor.getUnadjustedVarianceCap())).orNullSafe(exists(MapperS.of(varianceCapFloor).<BoundedVariance>map("getBoundedVariance", _varianceCapFloor -> _varianceCapFloor.getBoundedVariance())));
				}
				return notExists(MapperS.of(varianceCapFloor).<BigDecimal>map("getUnadjustedVarianceCap", _varianceCapFloor -> _varianceCapFloor.getUnadjustedVarianceCap())).andNullSafe(notExists(MapperS.of(varianceCapFloor).<BoundedVariance>map("getBoundedVariance", _varianceCapFloor -> _varianceCapFloor.getBoundedVariance())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VarianceCapFloorCapFloorApplicability {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceCapFloor varianceCapFloor) {
			return Collections.emptyList();
		}
	}
}
