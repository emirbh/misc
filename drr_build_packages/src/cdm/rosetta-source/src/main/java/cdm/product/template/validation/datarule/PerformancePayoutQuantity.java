package cdm.product.template.validation.datarule;

import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.PerformancePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("PerformancePayoutQuantity")
@ImplementedBy(PerformancePayoutQuantity.Default.class)
public interface PerformancePayoutQuantity extends Validator<PerformancePayout> {
	
	String NAME = "PerformancePayoutQuantity";
	String DEFINITION = "priceQuantity exists";
	
	class Default implements PerformancePayoutQuantity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PerformancePayout performancePayout) {
			ComparisonResult result = executeDataRule(performancePayout);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PerformancePayout", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PerformancePayout", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PerformancePayout performancePayout) {
			try {
				return exists(MapperS.of(performancePayout).<ResolvablePriceQuantity>map("getPriceQuantity", _performancePayout -> _performancePayout.getPriceQuantity()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PerformancePayoutQuantity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PerformancePayout performancePayout) {
			return Collections.emptyList();
		}
	}
}
