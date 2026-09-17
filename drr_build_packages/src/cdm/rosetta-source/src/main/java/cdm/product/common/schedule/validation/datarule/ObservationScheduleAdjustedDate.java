package cdm.product.common.schedule.validation.datarule;

import cdm.base.datetime.BusinessDayAdjustments;
import cdm.product.common.schedule.ObservationDate;
import cdm.product.common.schedule.ObservationSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("ObservationScheduleAdjustedDate")
@ImplementedBy(ObservationScheduleAdjustedDate.Default.class)
public interface ObservationScheduleAdjustedDate extends Validator<ObservationSchedule> {
	
	String NAME = "ObservationScheduleAdjustedDate";
	String DEFINITION = "if observationDate -> adjustedDate is absent then observationDate -> unadjustedDate exists and dateAdjustments exists";
	
	class Default implements ObservationScheduleAdjustedDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationSchedule observationSchedule) {
			ComparisonResult result = executeDataRule(observationSchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ObservationSchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ObservationSchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ObservationSchedule observationSchedule) {
			try {
				if (notExists(MapperS.of(observationSchedule).<ObservationDate>mapC("getObservationDate", _observationSchedule -> _observationSchedule.getObservationDate()).<Date>map("getAdjustedDate", observationDate -> observationDate.getAdjustedDate())).getOrDefault(false)) {
					return exists(MapperS.of(observationSchedule).<ObservationDate>mapC("getObservationDate", _observationSchedule -> _observationSchedule.getObservationDate()).<Date>map("getUnadjustedDate", observationDate -> observationDate.getUnadjustedDate())).andNullSafe(exists(MapperS.of(observationSchedule).<BusinessDayAdjustments>map("getDateAdjustments", _observationSchedule -> _observationSchedule.getDateAdjustments())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ObservationScheduleAdjustedDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationSchedule observationSchedule) {
			return Collections.emptyList();
		}
	}
}
