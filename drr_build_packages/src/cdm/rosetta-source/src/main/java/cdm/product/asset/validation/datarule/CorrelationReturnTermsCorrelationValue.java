package cdm.product.asset.validation.datarule;

import cdm.observable.asset.Price;
import cdm.product.asset.CorrelationReturnTerms;
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
@RosettaDataRule("CorrelationReturnTermsCorrelationValue")
@ImplementedBy(CorrelationReturnTermsCorrelationValue.Default.class)
public interface CorrelationReturnTermsCorrelationValue extends Validator<CorrelationReturnTerms> {
	
	String NAME = "CorrelationReturnTermsCorrelationValue";
	String DEFINITION = "correlationStrikePrice -> value > -1 and correlationStrikePrice -> value < 1";
	
	class Default implements CorrelationReturnTermsCorrelationValue {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationReturnTerms correlationReturnTerms) {
			ComparisonResult result = executeDataRule(correlationReturnTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CorrelationReturnTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CorrelationReturnTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CorrelationReturnTerms correlationReturnTerms) {
			try {
				return greaterThan(MapperS.of(correlationReturnTerms).<Price>map("getCorrelationStrikePrice", _correlationReturnTerms -> _correlationReturnTerms.getCorrelationStrikePrice()).<BigDecimal>map("getValue", price -> price.getValue()), MapperS.of(BigDecimal.valueOf(-1)), CardinalityOperator.All).andNullSafe(lessThan(MapperS.of(correlationReturnTerms).<Price>map("getCorrelationStrikePrice", _correlationReturnTerms -> _correlationReturnTerms.getCorrelationStrikePrice()).<BigDecimal>map("getValue", price -> price.getValue()), MapperS.of(BigDecimal.valueOf(1)), CardinalityOperator.All));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CorrelationReturnTermsCorrelationValue {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationReturnTerms correlationReturnTerms) {
			return Collections.emptyList();
		}
	}
}
