package cdm.product.common.schedule.validation.datarule;

import cdm.base.datetime.Offset;
import cdm.product.common.schedule.ResetDates;
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
@RosettaDataRule("ResetDatesRateCutOffDaysOffset")
@ImplementedBy(ResetDatesRateCutOffDaysOffset.Default.class)
public interface ResetDatesRateCutOffDaysOffset extends Validator<ResetDates> {
	
	String NAME = "ResetDatesRateCutOffDaysOffset";
	String DEFINITION = "if rateCutOffDaysOffset exists then rateCutOffDaysOffset -> periodMultiplier < 0";
	
	class Default implements ResetDatesRateCutOffDaysOffset {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResetDates resetDates) {
			ComparisonResult result = executeDataRule(resetDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ResetDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ResetDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ResetDates resetDates) {
			try {
				if (exists(MapperS.of(resetDates).<Offset>map("getRateCutOffDaysOffset", _resetDates -> _resetDates.getRateCutOffDaysOffset())).getOrDefault(false)) {
					return lessThan(MapperS.of(resetDates).<Offset>map("getRateCutOffDaysOffset", _resetDates -> _resetDates.getRateCutOffDaysOffset()).<Integer>map("getPeriodMultiplier", offset -> offset.getPeriodMultiplier()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ResetDatesRateCutOffDaysOffset {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResetDates resetDates) {
			return Collections.emptyList();
		}
	}
}
