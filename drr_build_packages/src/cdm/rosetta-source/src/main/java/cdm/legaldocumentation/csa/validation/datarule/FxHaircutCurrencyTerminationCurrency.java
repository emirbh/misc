package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.FxHaircutCurrency;
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
@RosettaDataRule("FxHaircutCurrencyTerminationCurrency")
@ImplementedBy(FxHaircutCurrencyTerminationCurrency.Default.class)
public interface FxHaircutCurrencyTerminationCurrency extends Validator<FxHaircutCurrency> {
	
	String NAME = "FxHaircutCurrencyTerminationCurrency";
	String DEFINITION = "if isTerminationCurrency = True then fxDesignatedCurrency is absent";
	
	class Default implements FxHaircutCurrencyTerminationCurrency {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxHaircutCurrency fxHaircutCurrency) {
			ComparisonResult result = executeDataRule(fxHaircutCurrency);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxHaircutCurrency", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxHaircutCurrency", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxHaircutCurrency fxHaircutCurrency) {
			try {
				if (areEqual(MapperS.of(fxHaircutCurrency).<Boolean>map("getIsTerminationCurrency", _fxHaircutCurrency -> _fxHaircutCurrency.getIsTerminationCurrency()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(fxHaircutCurrency).<FieldWithMetaString>map("getFxDesignatedCurrency", _fxHaircutCurrency -> _fxHaircutCurrency.getFxDesignatedCurrency()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxHaircutCurrencyTerminationCurrency {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxHaircutCurrency fxHaircutCurrency) {
			return Collections.emptyList();
		}
	}
}
