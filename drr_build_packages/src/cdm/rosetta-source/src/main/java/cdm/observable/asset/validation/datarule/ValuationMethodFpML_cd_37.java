package cdm.observable.asset.validation.datarule;

import cdm.base.math.UnitType;
import cdm.observable.asset.Money;
import cdm.observable.asset.ValuationMethod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("ValuationMethodFpML_cd_37")
@ImplementedBy(ValuationMethodFpML_cd_37.Default.class)
public interface ValuationMethodFpML_cd_37 extends Validator<ValuationMethod> {
	
	String NAME = "ValuationMethodFpML_cd_37";
	String DEFINITION = "if (quotationAmount -> unit -> currency exists and minimumQuotationAmount -> unit -> currency exists) and quotationAmount -> unit -> currency = minimumQuotationAmount -> unit -> currency then quotationAmount -> value > minimumQuotationAmount -> value";
	
	class Default implements ValuationMethodFpML_cd_37 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationMethod valuationMethod) {
			ComparisonResult result = executeDataRule(valuationMethod);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ValuationMethod", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ValuationMethod", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ValuationMethod valuationMethod) {
			try {
				if (exists(MapperS.of(valuationMethod).<Money>map("getQuotationAmount", _valuationMethod -> _valuationMethod.getQuotationAmount()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).andNullSafe(exists(MapperS.of(valuationMethod).<Money>map("getMinimumQuotationAmount", _valuationMethod -> _valuationMethod.getMinimumQuotationAmount()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()))).andNullSafe(areEqual(MapperS.of(valuationMethod).<Money>map("getQuotationAmount", _valuationMethod -> _valuationMethod.getQuotationAmount()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), MapperS.of(valuationMethod).<Money>map("getMinimumQuotationAmount", _valuationMethod -> _valuationMethod.getMinimumQuotationAmount()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), CardinalityOperator.All)).getOrDefault(false)) {
					return greaterThan(MapperS.of(valuationMethod).<Money>map("getQuotationAmount", _valuationMethod -> _valuationMethod.getQuotationAmount()).<BigDecimal>map("getValue", money -> money.getValue()), MapperS.of(valuationMethod).<Money>map("getMinimumQuotationAmount", _valuationMethod -> _valuationMethod.getMinimumQuotationAmount()).<BigDecimal>map("getValue", money -> money.getValue()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ValuationMethodFpML_cd_37 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationMethod valuationMethod) {
			return Collections.emptyList();
		}
	}
}
