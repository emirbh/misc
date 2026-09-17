package cdm.product.template.validation.datarule;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Underlier;
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
@RosettaDataRule("PerformancePayoutUnderlier")
@ImplementedBy(PerformancePayoutUnderlier.Default.class)
public interface PerformancePayoutUnderlier extends Validator<PerformancePayout> {
	
	String NAME = "PerformancePayoutUnderlier";
	String DEFINITION = "underlier -> Observable exists";
	
	class Default implements PerformancePayoutUnderlier {
	
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
				return exists(MapperS.of(performancePayout).<Underlier>map("getUnderlier", _performancePayout -> _performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PerformancePayoutUnderlier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PerformancePayout performancePayout) {
			return Collections.emptyList();
		}
	}
}
