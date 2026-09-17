package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.DayTypeEnum;
import cdm.base.datetime.Offset;
import cdm.base.datetime.PeriodEnum;
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
@RosettaDataRule("OffsetDayType")
@ImplementedBy(OffsetDayType.Default.class)
public interface OffsetDayType extends Validator<Offset> {
	
	String NAME = "OffsetDayType";
	String DEFINITION = "if period <> PeriodEnum -> D or periodMultiplier = 0 then dayType is absent";
	
	class Default implements OffsetDayType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Offset offset) {
			ComparisonResult result = executeDataRule(offset);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Offset", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Offset", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Offset offset) {
			try {
				if (notEqual(MapperS.of(offset).<PeriodEnum>map("getPeriod", _offset -> _offset.getPeriod()), MapperS.of(PeriodEnum.D), CardinalityOperator.Any).orNullSafe(areEqual(MapperS.of(offset).<Integer>map("getPeriodMultiplier", _offset -> _offset.getPeriodMultiplier()), MapperS.of(0), CardinalityOperator.All)).getOrDefault(false)) {
					return notExists(MapperS.of(offset).<DayTypeEnum>map("getDayType", _offset -> _offset.getDayType()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OffsetDayType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Offset offset) {
			return Collections.emptyList();
		}
	}
}
