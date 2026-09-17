package cdm.observable.asset.validation.datarule;

import cdm.base.math.UnitType;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
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
@RosettaDataRule("PriceScheduleUnitOfAmountExists")
@ImplementedBy(PriceScheduleUnitOfAmountExists.Default.class)
public interface PriceScheduleUnitOfAmountExists extends Validator<PriceSchedule> {
	
	String NAME = "PriceScheduleUnitOfAmountExists";
	String DEFINITION = "if priceType = PriceTypeEnum -> Variance or priceType = PriceTypeEnum -> Volatility or priceType = PriceTypeEnum -> Correlation then unit is absent and perUnitOf is absent else unit exists and perUnitOf exists";
	
	class Default implements PriceScheduleUnitOfAmountExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceSchedule priceSchedule) {
			ComparisonResult result = executeDataRule(priceSchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceSchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceSchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PriceSchedule priceSchedule) {
			try {
				if (areEqual(MapperS.of(priceSchedule).<PriceTypeEnum>map("getPriceType", _priceSchedule -> _priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.VARIANCE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(priceSchedule).<PriceTypeEnum>map("getPriceType", _priceSchedule -> _priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.VOLATILITY), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(priceSchedule).<PriceTypeEnum>map("getPriceType", _priceSchedule -> _priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.CORRELATION), CardinalityOperator.All)).getOrDefault(false)) {
					return notExists(MapperS.of(priceSchedule).<UnitType>map("getUnit", _priceSchedule -> _priceSchedule.getUnit())).andNullSafe(notExists(MapperS.of(priceSchedule).<UnitType>map("getPerUnitOf", _priceSchedule -> _priceSchedule.getPerUnitOf())));
				}
				return exists(MapperS.of(priceSchedule).<UnitType>map("getUnit", _priceSchedule -> _priceSchedule.getUnit())).andNullSafe(exists(MapperS.of(priceSchedule).<UnitType>map("getPerUnitOf", _priceSchedule -> _priceSchedule.getPerUnitOf())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PriceScheduleUnitOfAmountExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceSchedule priceSchedule) {
			return Collections.emptyList();
		}
	}
}
