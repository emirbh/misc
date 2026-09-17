package cdm.product.asset.validation.datarule;

import cdm.product.asset.BoundedVariance;
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
@RosettaDataRule("BoundedVarianceNonNegativeBarriers")
@ImplementedBy(BoundedVarianceNonNegativeBarriers.Default.class)
public interface BoundedVarianceNonNegativeBarriers extends Validator<BoundedVariance> {
	
	String NAME = "BoundedVarianceNonNegativeBarriers";
	String DEFINITION = "if upperBarrier exists then upperBarrier >= 0 and if lowerBarrier exists then lowerBarrier >= 0";
	
	class Default implements BoundedVarianceNonNegativeBarriers {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BoundedVariance boundedVariance) {
			ComparisonResult result = executeDataRule(boundedVariance);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BoundedVariance", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BoundedVariance", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BoundedVariance boundedVariance) {
			try {
				if (exists(MapperS.of(boundedVariance).<BigDecimal>map("getUpperBarrier", _boundedVariance -> _boundedVariance.getUpperBarrier())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (exists(MapperS.of(boundedVariance).<BigDecimal>map("getLowerBarrier", _boundedVariance -> _boundedVariance.getLowerBarrier())).getOrDefault(false)) {
						ifThenElseResult = greaterThanEquals(MapperS.of(boundedVariance).<BigDecimal>map("getLowerBarrier", _boundedVariance -> _boundedVariance.getLowerBarrier()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All);
					} else {
						ifThenElseResult = ComparisonResult.ofEmpty();
					}
					return greaterThanEquals(MapperS.of(boundedVariance).<BigDecimal>map("getUpperBarrier", _boundedVariance -> _boundedVariance.getUpperBarrier()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).andNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BoundedVarianceNonNegativeBarriers {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BoundedVariance boundedVariance) {
			return Collections.emptyList();
		}
	}
}
