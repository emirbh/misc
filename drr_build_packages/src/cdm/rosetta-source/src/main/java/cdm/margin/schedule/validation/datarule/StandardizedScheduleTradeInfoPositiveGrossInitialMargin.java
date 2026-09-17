package cdm.margin.schedule.validation.datarule;

import cdm.margin.schedule.StandardizedScheduleTradeInfo;
import cdm.observable.asset.Money;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("StandardizedScheduleTradeInfoPositiveGrossInitialMargin")
@ImplementedBy(StandardizedScheduleTradeInfoPositiveGrossInitialMargin.Default.class)
public interface StandardizedScheduleTradeInfoPositiveGrossInitialMargin extends Validator<StandardizedScheduleTradeInfo> {
	
	String NAME = "StandardizedScheduleTradeInfoPositiveGrossInitialMargin";
	String DEFINITION = "grossInitialMargin -> value > 0";
	
	class Default implements StandardizedScheduleTradeInfoPositiveGrossInitialMargin {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, StandardizedScheduleTradeInfo standardizedScheduleTradeInfo) {
			ComparisonResult result = executeDataRule(standardizedScheduleTradeInfo);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StandardizedScheduleTradeInfo", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "StandardizedScheduleTradeInfo", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(StandardizedScheduleTradeInfo standardizedScheduleTradeInfo) {
			try {
				return greaterThan(MapperS.of(standardizedScheduleTradeInfo).<Money>map("getGrossInitialMargin", _standardizedScheduleTradeInfo -> _standardizedScheduleTradeInfo.getGrossInitialMargin()).<BigDecimal>map("getValue", money -> money.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StandardizedScheduleTradeInfoPositiveGrossInitialMargin {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, StandardizedScheduleTradeInfo standardizedScheduleTradeInfo) {
			return Collections.emptyList();
		}
	}
}
