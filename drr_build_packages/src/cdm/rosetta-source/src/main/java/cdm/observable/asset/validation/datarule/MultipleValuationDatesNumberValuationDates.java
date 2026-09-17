package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.MultipleValuationDates;
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
@RosettaDataRule("MultipleValuationDatesNumberValuationDates")
@ImplementedBy(MultipleValuationDatesNumberValuationDates.Default.class)
public interface MultipleValuationDatesNumberValuationDates extends Validator<MultipleValuationDates> {
	
	String NAME = "MultipleValuationDatesNumberValuationDates";
	String DEFINITION = "if numberValuationDates exists then numberValuationDates >= 0";
	
	class Default implements MultipleValuationDatesNumberValuationDates {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultipleValuationDates multipleValuationDates) {
			ComparisonResult result = executeDataRule(multipleValuationDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MultipleValuationDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MultipleValuationDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MultipleValuationDates multipleValuationDates) {
			try {
				if (exists(MapperS.of(multipleValuationDates).<Integer>map("getNumberValuationDates", _multipleValuationDates -> _multipleValuationDates.getNumberValuationDates())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(multipleValuationDates).<Integer>map("getNumberValuationDates", _multipleValuationDates -> _multipleValuationDates.getNumberValuationDates()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MultipleValuationDatesNumberValuationDates {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultipleValuationDates multipleValuationDates) {
			return Collections.emptyList();
		}
	}
}
