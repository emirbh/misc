package cdm.product.common.schedule.validation.datarule;

import cdm.base.datetime.PeriodExtendedEnum;
import cdm.product.common.schedule.ResetFrequency;
import cdm.product.common.schedule.WeeklyRollConventionEnum;
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
@RosettaDataRule("ResetFrequencyFpML_ird_49")
@ImplementedBy(ResetFrequencyFpML_ird_49.Default.class)
public interface ResetFrequencyFpML_ird_49 extends Validator<ResetFrequency> {
	
	String NAME = "ResetFrequencyFpML_ird_49";
	String DEFINITION = "if weeklyRollConvention exists then period = PeriodExtendedEnum -> W";
	
	class Default implements ResetFrequencyFpML_ird_49 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResetFrequency resetFrequency) {
			ComparisonResult result = executeDataRule(resetFrequency);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ResetFrequency", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ResetFrequency", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ResetFrequency resetFrequency) {
			try {
				if (exists(MapperS.of(resetFrequency).<WeeklyRollConventionEnum>map("getWeeklyRollConvention", _resetFrequency -> _resetFrequency.getWeeklyRollConvention())).getOrDefault(false)) {
					return areEqual(MapperS.of(resetFrequency).<PeriodExtendedEnum>map("getPeriod", _resetFrequency -> _resetFrequency.getPeriod()), MapperS.of(PeriodExtendedEnum.W), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ResetFrequencyFpML_ird_49 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResetFrequency resetFrequency) {
			return Collections.emptyList();
		}
	}
}
