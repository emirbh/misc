package cdm.product.asset.validation.datarule;

import cdm.product.asset.CorrelationReturnTerms;
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
@RosettaDataRule("CorrelationReturnTermsPositiveNumberOfDataSeries")
@ImplementedBy(CorrelationReturnTermsPositiveNumberOfDataSeries.Default.class)
public interface CorrelationReturnTermsPositiveNumberOfDataSeries extends Validator<CorrelationReturnTerms> {
	
	String NAME = "CorrelationReturnTermsPositiveNumberOfDataSeries";
	String DEFINITION = "if numberOfDataSeries exists then numberOfDataSeries > 0";
	
	class Default implements CorrelationReturnTermsPositiveNumberOfDataSeries {
	
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
				if (exists(MapperS.of(correlationReturnTerms).<Integer>map("getNumberOfDataSeries", _correlationReturnTerms -> _correlationReturnTerms.getNumberOfDataSeries())).getOrDefault(false)) {
					return greaterThan(MapperS.of(correlationReturnTerms).<Integer>map("getNumberOfDataSeries", _correlationReturnTerms -> _correlationReturnTerms.getNumberOfDataSeries()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CorrelationReturnTermsPositiveNumberOfDataSeries {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationReturnTerms correlationReturnTerms) {
			return Collections.emptyList();
		}
	}
}
