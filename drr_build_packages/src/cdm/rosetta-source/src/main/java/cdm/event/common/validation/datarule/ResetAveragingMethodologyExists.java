package cdm.event.common.validation.datarule;

import cdm.event.common.Reset;
import cdm.observable.event.metafields.ReferenceWithMetaObservation;
import cdm.product.template.AveragingCalculation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("ResetAveragingMethodologyExists")
@ImplementedBy(ResetAveragingMethodologyExists.Default.class)
public interface ResetAveragingMethodologyExists extends Validator<Reset> {
	
	String NAME = "ResetAveragingMethodologyExists";
	String DEFINITION = "if observations count > 1 then averagingMethodology exists";
	
	class Default implements ResetAveragingMethodologyExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Reset reset) {
			ComparisonResult result = executeDataRule(reset);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Reset", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Reset", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Reset reset) {
			try {
				if (greaterThan(MapperS.of(MapperS.of(reset).<ReferenceWithMetaObservation>mapC("getObservations", _reset -> _reset.getObservations()).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(reset).<AveragingCalculation>map("getAveragingMethodology", _reset -> _reset.getAveragingMethodology()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ResetAveragingMethodologyExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Reset reset) {
			return Collections.emptyList();
		}
	}
}
