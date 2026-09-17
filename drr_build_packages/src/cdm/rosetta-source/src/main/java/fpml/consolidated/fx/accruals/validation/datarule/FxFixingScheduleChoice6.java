package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxFixingSchedule;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.ObservationFrequency;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxFixingScheduleChoice6")
@ImplementedBy(FxFixingScheduleChoice6.Default.class)
public interface FxFixingScheduleChoice6 extends Validator<FxFixingSchedule> {
	
	String NAME = "FxFixingScheduleChoice6";
	String DEFINITION = "if dateAdjustments exists then optional choice fixingDate, numberOfFixings and if fixingDate exists then if observationFrequency exists then startDate exists or endDate exists else startDate is absent and endDate is absent and if numberOfFixings exists then observationFrequency exists and (endDate exists or startDate exists) and if fixingDate is absent and numberOfFixings is absent then if observationFrequency exists then startDate exists or endDate exists else startDate is absent and endDate is absent";
	
	class Default implements FxFixingScheduleChoice6 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingSchedule fxFixingSchedule) {
			ComparisonResult result = executeDataRule(fxFixingSchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingSchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingSchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxFixingSchedule fxFixingSchedule) {
			try {
				if (exists(MapperS.of(fxFixingSchedule).<BusinessDayAdjustments>map("getDateAdjustments", _fxFixingSchedule -> _fxFixingSchedule.getDateAdjustments())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult2;
					if (exists(MapperS.of(fxFixingSchedule).<ZonedDateTime>mapC("getFixingDate", _fxFixingSchedule -> _fxFixingSchedule.getFixingDate())).getOrDefault(false)) {
						if (exists(MapperS.of(fxFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxFixingSchedule -> _fxFixingSchedule.getObservationFrequency())).getOrDefault(false)) {
							ifThenElseResult2 = exists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getStartDate", _fxFixingSchedule -> _fxFixingSchedule.getStartDate())).orNullSafe(exists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getEndDate", _fxFixingSchedule -> _fxFixingSchedule.getEndDate())));
						} else {
							final ComparisonResult ifThenElseResult1;
							if (exists(MapperS.of(fxFixingSchedule).<Integer>map("getNumberOfFixings", _fxFixingSchedule -> _fxFixingSchedule.getNumberOfFixings())).getOrDefault(false)) {
								final ComparisonResult ifThenElseResult0;
								if (notExists(MapperS.of(fxFixingSchedule).<ZonedDateTime>mapC("getFixingDate", _fxFixingSchedule -> _fxFixingSchedule.getFixingDate())).andNullSafe(notExists(MapperS.of(fxFixingSchedule).<Integer>map("getNumberOfFixings", _fxFixingSchedule -> _fxFixingSchedule.getNumberOfFixings()))).getOrDefault(false)) {
									if (exists(MapperS.of(fxFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxFixingSchedule -> _fxFixingSchedule.getObservationFrequency())).getOrDefault(false)) {
										ifThenElseResult0 = exists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getStartDate", _fxFixingSchedule -> _fxFixingSchedule.getStartDate())).orNullSafe(exists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getEndDate", _fxFixingSchedule -> _fxFixingSchedule.getEndDate())));
									} else {
										ifThenElseResult0 = notExists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getStartDate", _fxFixingSchedule -> _fxFixingSchedule.getStartDate())).andNullSafe(notExists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getEndDate", _fxFixingSchedule -> _fxFixingSchedule.getEndDate())));
									}
								} else {
									ifThenElseResult0 = ComparisonResult.ofEmpty();
								}
								ifThenElseResult1 = exists(MapperS.of(fxFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxFixingSchedule -> _fxFixingSchedule.getObservationFrequency())).andNullSafe(exists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getEndDate", _fxFixingSchedule -> _fxFixingSchedule.getEndDate())).orNullSafe(exists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getStartDate", _fxFixingSchedule -> _fxFixingSchedule.getStartDate())))).andNullSafe(ifThenElseResult0);
							} else {
								ifThenElseResult1 = ComparisonResult.ofEmpty();
							}
							ifThenElseResult2 = notExists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getStartDate", _fxFixingSchedule -> _fxFixingSchedule.getStartDate())).andNullSafe(notExists(MapperS.of(fxFixingSchedule).<ZonedDateTime>map("getEndDate", _fxFixingSchedule -> _fxFixingSchedule.getEndDate()))).andNullSafe(ifThenElseResult1);
						}
					} else {
						ifThenElseResult2 = ComparisonResult.ofEmpty();
					}
					return choice(MapperS.of(fxFixingSchedule), Arrays.asList("fixingDate", "numberOfFixings"), ChoiceRuleValidationMethod.OPTIONAL).andNullSafe(ifThenElseResult2);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxFixingScheduleChoice6 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingSchedule fxFixingSchedule) {
			return Collections.emptyList();
		}
	}
}
