package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.SingleValuationDate;
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
@RosettaDataRule("SingleValuationDateNonNegativeBusinessDays")
@ImplementedBy(SingleValuationDateNonNegativeBusinessDays.Default.class)
public interface SingleValuationDateNonNegativeBusinessDays extends Validator<SingleValuationDate> {
	
	String NAME = "SingleValuationDateNonNegativeBusinessDays";
	String DEFINITION = "if businessDays exists then businessDays >= 0";
	
	class Default implements SingleValuationDateNonNegativeBusinessDays {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SingleValuationDate singleValuationDate) {
			ComparisonResult result = executeDataRule(singleValuationDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SingleValuationDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SingleValuationDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SingleValuationDate singleValuationDate) {
			try {
				if (exists(MapperS.of(singleValuationDate).<Integer>map("getBusinessDays", _singleValuationDate -> _singleValuationDate.getBusinessDays())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(singleValuationDate).<Integer>map("getBusinessDays", _singleValuationDate -> _singleValuationDate.getBusinessDays()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SingleValuationDateNonNegativeBusinessDays {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SingleValuationDate singleValuationDate) {
			return Collections.emptyList();
		}
	}
}
