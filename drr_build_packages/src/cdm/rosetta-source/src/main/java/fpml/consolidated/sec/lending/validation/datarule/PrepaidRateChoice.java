package fpml.consolidated.sec.lending.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.sec.lending.PrepaidRate;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PrepaidRateChoice")
@ImplementedBy(PrepaidRateChoice.Default.class)
public interface PrepaidRateChoice extends Validator<PrepaidRate> {
	
	String NAME = "PrepaidRateChoice";
	String DEFINITION = "if fixedRate exists then floatingRateIndex is absent and indexTenor is absent else if floatingRateIndex exists then fixedRate is absent else False";
	
	class Default implements PrepaidRateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrepaidRate prepaidRate) {
			ComparisonResult result = executeDataRule(prepaidRate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PrepaidRate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PrepaidRate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PrepaidRate prepaidRate) {
			try {
				if (exists(MapperS.of(prepaidRate).<BigDecimal>map("getFixedRate", _prepaidRate -> _prepaidRate.getFixedRate())).getOrDefault(false)) {
					return notExists(MapperS.of(prepaidRate).<FloatingRateIndex>map("getFloatingRateIndex", _prepaidRate -> _prepaidRate.getFloatingRateIndex())).andNullSafe(notExists(MapperS.of(prepaidRate).<Period>map("getIndexTenor", _prepaidRate -> _prepaidRate.getIndexTenor())));
				}
				if (exists(MapperS.of(prepaidRate).<FloatingRateIndex>map("getFloatingRateIndex", _prepaidRate -> _prepaidRate.getFloatingRateIndex())).getOrDefault(false)) {
					return notExists(MapperS.of(prepaidRate).<BigDecimal>map("getFixedRate", _prepaidRate -> _prepaidRate.getFixedRate()));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PrepaidRateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrepaidRate prepaidRate) {
			return Collections.emptyList();
		}
	}
}
