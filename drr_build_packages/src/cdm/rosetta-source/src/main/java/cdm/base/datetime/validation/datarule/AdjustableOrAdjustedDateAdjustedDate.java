package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.AdjustableOrAdjustedDate;
import cdm.base.datetime.BusinessDayAdjustments;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("AdjustableOrAdjustedDateAdjustedDate")
@ImplementedBy(AdjustableOrAdjustedDateAdjustedDate.Default.class)
public interface AdjustableOrAdjustedDateAdjustedDate extends Validator<AdjustableOrAdjustedDate> {
	
	String NAME = "AdjustableOrAdjustedDateAdjustedDate";
	String DEFINITION = "if adjustedDate is absent then unadjustedDate exists and dateAdjustments exists";
	
	class Default implements AdjustableOrAdjustedDateAdjustedDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOrAdjustedDate adjustableOrAdjustedDate) {
			ComparisonResult result = executeDataRule(adjustableOrAdjustedDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableOrAdjustedDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableOrAdjustedDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdjustableOrAdjustedDate adjustableOrAdjustedDate) {
			try {
				if (notExists(MapperS.of(adjustableOrAdjustedDate).<FieldWithMetaDate>map("getAdjustedDate", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getAdjustedDate())).getOrDefault(false)) {
					return exists(MapperS.of(adjustableOrAdjustedDate).<Date>map("getUnadjustedDate", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getUnadjustedDate())).andNullSafe(exists(MapperS.of(adjustableOrAdjustedDate).<BusinessDayAdjustments>map("getDateAdjustments", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getDateAdjustments())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableOrAdjustedDateAdjustedDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOrAdjustedDate adjustableOrAdjustedDate) {
			return Collections.emptyList();
		}
	}
}
