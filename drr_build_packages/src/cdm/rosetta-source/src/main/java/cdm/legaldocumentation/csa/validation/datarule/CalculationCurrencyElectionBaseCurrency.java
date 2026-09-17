package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.CalculationCurrencyElection;
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
@RosettaDataRule("CalculationCurrencyElectionBaseCurrency")
@ImplementedBy(CalculationCurrencyElectionBaseCurrency.Default.class)
public interface CalculationCurrencyElectionBaseCurrency extends Validator<CalculationCurrencyElection> {
	
	String NAME = "CalculationCurrencyElectionBaseCurrency";
	String DEFINITION = "if isBaseCurrency = True then currency is absent else currency exists";
	
	class Default implements CalculationCurrencyElectionBaseCurrency {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationCurrencyElection calculationCurrencyElection) {
			ComparisonResult result = executeDataRule(calculationCurrencyElection);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationCurrencyElection", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationCurrencyElection", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CalculationCurrencyElection calculationCurrencyElection) {
			try {
				if (areEqual(MapperS.of(calculationCurrencyElection).<Boolean>map("getIsBaseCurrency", _calculationCurrencyElection -> _calculationCurrencyElection.getIsBaseCurrency()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(calculationCurrencyElection).<FieldWithMetaString>map("getCurrency", _calculationCurrencyElection -> _calculationCurrencyElection.getCurrency()));
				}
				return exists(MapperS.of(calculationCurrencyElection).<FieldWithMetaString>map("getCurrency", _calculationCurrencyElection -> _calculationCurrencyElection.getCurrency()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationCurrencyElectionBaseCurrency {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationCurrencyElection calculationCurrencyElection) {
			return Collections.emptyList();
		}
	}
}
