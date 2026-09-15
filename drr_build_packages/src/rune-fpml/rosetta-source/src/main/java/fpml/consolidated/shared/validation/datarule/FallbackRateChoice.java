package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.CalculationParameters;
import fpml.consolidated.shared.FallbackRate;
import fpml.consolidated.shared.FloatingRateIndex;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FallbackRateChoice")
@ImplementedBy(FallbackRateChoice.Default.class)
public interface FallbackRateChoice extends Validator<FallbackRate> {
	
	String NAME = "FallbackRateChoice";
	String DEFINITION = "floatingRateIndex exists or effectiveDate exists and calculationParameters is absent and spreadAdjustment is absent";
	
	class Default implements FallbackRateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FallbackRate fallbackRate) {
			ComparisonResult result = executeDataRule(fallbackRate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FallbackRate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FallbackRate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FallbackRate fallbackRate) {
			try {
				return exists(MapperS.of(fallbackRate).<FloatingRateIndex>map("getFloatingRateIndex", _fallbackRate -> _fallbackRate.getFloatingRateIndex())).orNullSafe(exists(MapperS.of(fallbackRate).<ZonedDateTime>map("getEffectiveDate", _fallbackRate -> _fallbackRate.getEffectiveDate())).andNullSafe(notExists(MapperS.of(fallbackRate).<CalculationParameters>map("getCalculationParameters", _fallbackRate -> _fallbackRate.getCalculationParameters()))).andNullSafe(notExists(MapperS.of(fallbackRate).<BigDecimal>map("getSpreadAdjustment", _fallbackRate -> _fallbackRate.getSpreadAdjustment()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FallbackRateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FallbackRate fallbackRate) {
			return Collections.emptyList();
		}
	}
}
