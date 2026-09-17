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
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("PriceScheduleCurrencyUnitForInterestRate")
@ImplementedBy(PriceScheduleCurrencyUnitForInterestRate.Default.class)
public interface PriceScheduleCurrencyUnitForInterestRate extends Validator<PriceSchedule> {
	
	String NAME = "PriceScheduleCurrencyUnitForInterestRate";
	String DEFINITION = "if priceType = PriceTypeEnum -> InterestRate then unit -> currency exists";
	
	class Default implements PriceScheduleCurrencyUnitForInterestRate {
	
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
				if (areEqual(MapperS.of(priceSchedule).<PriceTypeEnum>map("getPriceType", _priceSchedule -> _priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.INTEREST_RATE), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(priceSchedule).<UnitType>map("getUnit", _priceSchedule -> _priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PriceScheduleCurrencyUnitForInterestRate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceSchedule priceSchedule) {
			return Collections.emptyList();
		}
	}
}
