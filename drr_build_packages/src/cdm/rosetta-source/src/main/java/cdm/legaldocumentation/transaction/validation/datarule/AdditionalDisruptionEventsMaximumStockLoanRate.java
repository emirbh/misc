package cdm.legaldocumentation.transaction.validation.datarule;

import cdm.legaldocumentation.transaction.AdditionalDisruptionEvents;
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
@RosettaDataRule("AdditionalDisruptionEventsMaximumStockLoanRate")
@ImplementedBy(AdditionalDisruptionEventsMaximumStockLoanRate.Default.class)
public interface AdditionalDisruptionEventsMaximumStockLoanRate extends Validator<AdditionalDisruptionEvents> {
	
	String NAME = "AdditionalDisruptionEventsMaximumStockLoanRate";
	String DEFINITION = "if maximumStockLoanRate exists then maximumStockLoanRate >= 0 and maximumStockLoanRate <= 1";
	
	class Default implements AdditionalDisruptionEventsMaximumStockLoanRate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalDisruptionEvents additionalDisruptionEvents) {
			ComparisonResult result = executeDataRule(additionalDisruptionEvents);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalDisruptionEvents", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalDisruptionEvents", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdditionalDisruptionEvents additionalDisruptionEvents) {
			try {
				if (exists(MapperS.of(additionalDisruptionEvents).<BigDecimal>map("getMaximumStockLoanRate", _additionalDisruptionEvents -> _additionalDisruptionEvents.getMaximumStockLoanRate())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(additionalDisruptionEvents).<BigDecimal>map("getMaximumStockLoanRate", _additionalDisruptionEvents -> _additionalDisruptionEvents.getMaximumStockLoanRate()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).andNullSafe(lessThanEquals(MapperS.of(additionalDisruptionEvents).<BigDecimal>map("getMaximumStockLoanRate", _additionalDisruptionEvents -> _additionalDisruptionEvents.getMaximumStockLoanRate()), MapperS.of(BigDecimal.valueOf(1)), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdditionalDisruptionEventsMaximumStockLoanRate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalDisruptionEvents additionalDisruptionEvents) {
			return Collections.emptyList();
		}
	}
}
