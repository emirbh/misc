package cdm.legaldocumentation.csa.validation.datarule;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.legaldocumentation.csa.LegacyValuationTime;
import cdm.legaldocumentation.csa.ValuationTimeDayEnum;
import cdm.legaldocumentation.csa.ValuationTimeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("LegacyValuationTimeDayAndTime")
@ImplementedBy(LegacyValuationTimeDayAndTime.Default.class)
public interface LegacyValuationTimeDayAndTime extends Validator<LegacyValuationTime> {
	
	String NAME = "LegacyValuationTimeDayAndTime";
	String DEFINITION = "if day exists then time exists else time is absent and item -> location is absent and hourminutetime is absent and timezone is absent";
	
	class Default implements LegacyValuationTimeDayAndTime {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyValuationTime legacyValuationTime) {
			ComparisonResult result = executeDataRule(legacyValuationTime);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyValuationTime", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyValuationTime", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LegacyValuationTime legacyValuationTime) {
			try {
				if (exists(MapperS.of(legacyValuationTime).<ValuationTimeDayEnum>map("getDay", _legacyValuationTime -> _legacyValuationTime.getDay())).getOrDefault(false)) {
					return exists(MapperS.of(legacyValuationTime).<ValuationTimeEnum>map("getTime", _legacyValuationTime -> _legacyValuationTime.getTime()));
				}
				return notExists(MapperS.of(legacyValuationTime).<ValuationTimeEnum>map("getTime", _legacyValuationTime -> _legacyValuationTime.getTime())).andNullSafe(notExists(MapperS.of(legacyValuationTime).<BusinessCenterEnum>mapC("getLocation", _legacyValuationTime -> _legacyValuationTime.getLocation()))).andNullSafe(notExists(MapperS.of(legacyValuationTime).<LocalTime>map("getHourminutetime", _legacyValuationTime -> _legacyValuationTime.getHourminutetime()))).andNullSafe(notExists(MapperS.of(legacyValuationTime).<BusinessCenterEnum>map("getTimezone", _legacyValuationTime -> _legacyValuationTime.getTimezone())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegacyValuationTimeDayAndTime {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyValuationTime legacyValuationTime) {
			return Collections.emptyList();
		}
	}
}
