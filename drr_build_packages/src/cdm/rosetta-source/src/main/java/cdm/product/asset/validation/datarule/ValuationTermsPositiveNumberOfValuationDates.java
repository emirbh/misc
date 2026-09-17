package cdm.product.asset.validation.datarule;

import cdm.product.asset.ValuationTerms;
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
@RosettaDataRule("ValuationTermsPositiveNumberOfValuationDates")
@ImplementedBy(ValuationTermsPositiveNumberOfValuationDates.Default.class)
public interface ValuationTermsPositiveNumberOfValuationDates extends Validator<ValuationTerms> {
	
	String NAME = "ValuationTermsPositiveNumberOfValuationDates";
	String DEFINITION = "if numberOfValuationDates exists then numberOfValuationDates > 0";
	
	class Default implements ValuationTermsPositiveNumberOfValuationDates {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationTerms valuationTerms) {
			ComparisonResult result = executeDataRule(valuationTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ValuationTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ValuationTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ValuationTerms valuationTerms) {
			try {
				if (exists(MapperS.of(valuationTerms).<Integer>map("getNumberOfValuationDates", _valuationTerms -> _valuationTerms.getNumberOfValuationDates())).getOrDefault(false)) {
					return greaterThan(MapperS.of(valuationTerms).<Integer>map("getNumberOfValuationDates", _valuationTerms -> _valuationTerms.getNumberOfValuationDates()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ValuationTermsPositiveNumberOfValuationDates {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationTerms valuationTerms) {
			return Collections.emptyList();
		}
	}
}
