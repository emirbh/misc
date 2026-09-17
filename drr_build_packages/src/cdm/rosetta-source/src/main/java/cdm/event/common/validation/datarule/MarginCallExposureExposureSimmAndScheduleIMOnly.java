package cdm.event.common.validation.datarule;

import cdm.event.common.Exposure;
import cdm.event.common.MarginCallExposure;
import cdm.event.common.RegMarginTypeEnum;
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
@RosettaDataRule("MarginCallExposureExposureSimmAndScheduleIMOnly")
@ImplementedBy(MarginCallExposureExposureSimmAndScheduleIMOnly.Default.class)
public interface MarginCallExposureExposureSimmAndScheduleIMOnly extends Validator<MarginCallExposure> {
	
	String NAME = "MarginCallExposureExposureSimmAndScheduleIMOnly";
	String DEFINITION = "if simmIMExposure exists and scheduleGridIMExposure exists then regMarginType = RegMarginTypeEnum -> RegIM";
	
	class Default implements MarginCallExposureExposureSimmAndScheduleIMOnly {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginCallExposure marginCallExposure) {
			ComparisonResult result = executeDataRule(marginCallExposure);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MarginCallExposure", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MarginCallExposure", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MarginCallExposure marginCallExposure) {
			try {
				if (exists(MapperS.of(marginCallExposure).<Exposure>map("getSimmIMExposure", _marginCallExposure -> _marginCallExposure.getSimmIMExposure())).andNullSafe(exists(MapperS.of(marginCallExposure).<Exposure>map("getScheduleGridIMExposure", _marginCallExposure -> _marginCallExposure.getScheduleGridIMExposure()))).getOrDefault(false)) {
					return areEqual(MapperS.of(marginCallExposure).<RegMarginTypeEnum>map("getRegMarginType", _marginCallExposure -> _marginCallExposure.getRegMarginType()), MapperS.of(RegMarginTypeEnum.REG_IM), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MarginCallExposureExposureSimmAndScheduleIMOnly {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginCallExposure marginCallExposure) {
			return Collections.emptyList();
		}
	}
}
