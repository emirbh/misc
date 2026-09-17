package cdm.margin.schedule.validation.datarule;

import cdm.base.math.UnitType;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("StandardizedScheduleTradeInfoSameCurrencies")
@ImplementedBy(StandardizedScheduleTradeInfoSameCurrencies.Default.class)
public interface StandardizedScheduleTradeInfoSameCurrencies extends Validator<StandardizedScheduleTradeInfo> {
	
	String NAME = "StandardizedScheduleTradeInfoSameCurrencies";
	String DEFINITION = "grossInitialMargin -> unit -> currency = markToMarketValue -> unit -> currency";
	
	class Default implements StandardizedScheduleTradeInfoSameCurrencies {
	
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
				return areEqual(MapperS.of(standardizedScheduleTradeInfo).<Money>map("getGrossInitialMargin", _standardizedScheduleTradeInfo -> _standardizedScheduleTradeInfo.getGrossInitialMargin()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), MapperS.of(standardizedScheduleTradeInfo).<Money>map("getMarkToMarketValue", _standardizedScheduleTradeInfo -> _standardizedScheduleTradeInfo.getMarkToMarketValue()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StandardizedScheduleTradeInfoSameCurrencies {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, StandardizedScheduleTradeInfo standardizedScheduleTradeInfo) {
			return Collections.emptyList();
		}
	}
}
