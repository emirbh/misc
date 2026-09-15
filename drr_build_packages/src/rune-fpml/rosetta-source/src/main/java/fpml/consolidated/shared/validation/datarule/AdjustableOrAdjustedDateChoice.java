package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableOrAdjustedDate;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("AdjustableOrAdjustedDateChoice")
@ImplementedBy(AdjustableOrAdjustedDateChoice.Default.class)
public interface AdjustableOrAdjustedDateChoice extends Validator<AdjustableOrAdjustedDate> {
	
	String NAME = "AdjustableOrAdjustedDateChoice";
	String DEFINITION = "unadjustedDate exists or adjustedDate exists and dateAdjustments is absent";
	
	class Default implements AdjustableOrAdjustedDateChoice {
	
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
				return exists(MapperS.of(adjustableOrAdjustedDate).<IdentifiedDate>map("getUnadjustedDate", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getUnadjustedDate())).orNullSafe(exists(MapperS.of(adjustableOrAdjustedDate).<IdentifiedDate>map("getAdjustedDate", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getAdjustedDate())).andNullSafe(notExists(MapperS.of(adjustableOrAdjustedDate).<BusinessDayAdjustments>map("getDateAdjustments", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getDateAdjustments()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableOrAdjustedDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOrAdjustedDate adjustableOrAdjustedDate) {
			return Collections.emptyList();
		}
	}
}
