package cdm.product.asset.validation.datarule;

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
@RosettaDataRule("VarianceCapFloorPositiveUnadjustedVarianceCap")
@ImplementedBy(VarianceCapFloorPositiveUnadjustedVarianceCap.Default.class)
public interface VarianceCapFloorPositiveUnadjustedVarianceCap extends Validator<VarianceCapFloor> {
	
	String NAME = "VarianceCapFloorPositiveUnadjustedVarianceCap";
	String DEFINITION = "if unadjustedVarianceCap exists then unadjustedVarianceCap > 0";
	
	class Default implements VarianceCapFloorPositiveUnadjustedVarianceCap {
	
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
				if (exists(MapperS.of(varianceCapFloor).<BigDecimal>map("getUnadjustedVarianceCap", _varianceCapFloor -> _varianceCapFloor.getUnadjustedVarianceCap())).getOrDefault(false)) {
					return greaterThan(MapperS.of(varianceCapFloor).<BigDecimal>map("getUnadjustedVarianceCap", _varianceCapFloor -> _varianceCapFloor.getUnadjustedVarianceCap()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VarianceCapFloorPositiveUnadjustedVarianceCap {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceCapFloor varianceCapFloor) {
			return Collections.emptyList();
		}
	}
}
