package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxFixingObservation;
import fpml.consolidated.fx.accruals.FxWeightedFixingSchedule;
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
@RosettaDataRule("FxWeightedFixingScheduleChoice6")
@ImplementedBy(FxWeightedFixingScheduleChoice6.Default.class)
public interface FxWeightedFixingScheduleChoice6 extends Validator<FxWeightedFixingSchedule> {
	
	String NAME = "FxWeightedFixingScheduleChoice6";
	String DEFINITION = "if dateAdjustments exists then optional choice fixing, numberOfFixings and if fixing exists then if observationFrequency exists then startDate exists or endDate exists else startDate is absent and endDate is absent and if numberOfFixings exists then observationFrequency exists and (endDate exists or startDate exists) and if fixing is absent and numberOfFixings is absent then if observationFrequency exists then startDate exists or endDate exists else startDate is absent and endDate is absent";
	
	class Default implements FxWeightedFixingScheduleChoice6 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxWeightedFixingSchedule fxWeightedFixingSchedule) {
			ComparisonResult result = executeDataRule(fxWeightedFixingSchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxWeightedFixingSchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxWeightedFixingSchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxWeightedFixingSchedule fxWeightedFixingSchedule) {
			try {
				if (exists(MapperS.of(fxWeightedFixingSchedule).<BusinessDayAdjustments>map("getDateAdjustments", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getDateAdjustments())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult2;
					if (exists(MapperS.of(fxWeightedFixingSchedule).<FxFixingObservation>mapC("getFixing", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getFixing())).getOrDefault(false)) {
						if (exists(MapperS.of(fxWeightedFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getObservationFrequency())).getOrDefault(false)) {
							ifThenElseResult2 = exists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getStartDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getStartDate())).orNullSafe(exists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getEndDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getEndDate())));
						} else {
							final ComparisonResult ifThenElseResult1;
							if (exists(MapperS.of(fxWeightedFixingSchedule).<Integer>map("getNumberOfFixings", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getNumberOfFixings())).getOrDefault(false)) {
								final ComparisonResult ifThenElseResult0;
								if (notExists(MapperS.of(fxWeightedFixingSchedule).<FxFixingObservation>mapC("getFixing", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getFixing())).andNullSafe(notExists(MapperS.of(fxWeightedFixingSchedule).<Integer>map("getNumberOfFixings", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getNumberOfFixings()))).getOrDefault(false)) {
									if (exists(MapperS.of(fxWeightedFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getObservationFrequency())).getOrDefault(false)) {
										ifThenElseResult0 = exists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getStartDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getStartDate())).orNullSafe(exists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getEndDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getEndDate())));
									} else {
										ifThenElseResult0 = notExists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getStartDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getStartDate())).andNullSafe(notExists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getEndDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getEndDate())));
									}
								} else {
									ifThenElseResult0 = ComparisonResult.ofEmpty();
								}
								ifThenElseResult1 = exists(MapperS.of(fxWeightedFixingSchedule).<ObservationFrequency>map("getObservationFrequency", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getObservationFrequency())).andNullSafe(exists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getEndDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getEndDate())).orNullSafe(exists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getStartDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getStartDate())))).andNullSafe(ifThenElseResult0);
							} else {
								ifThenElseResult1 = ComparisonResult.ofEmpty();
							}
							ifThenElseResult2 = notExists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getStartDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getStartDate())).andNullSafe(notExists(MapperS.of(fxWeightedFixingSchedule).<ZonedDateTime>map("getEndDate", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getEndDate()))).andNullSafe(ifThenElseResult1);
						}
					} else {
						ifThenElseResult2 = ComparisonResult.ofEmpty();
					}
					return choice(MapperS.of(fxWeightedFixingSchedule), Arrays.asList("fixing", "numberOfFixings"), ChoiceRuleValidationMethod.OPTIONAL).andNullSafe(ifThenElseResult2);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxWeightedFixingScheduleChoice6 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxWeightedFixingSchedule fxWeightedFixingSchedule) {
			return Collections.emptyList();
		}
	}
}
