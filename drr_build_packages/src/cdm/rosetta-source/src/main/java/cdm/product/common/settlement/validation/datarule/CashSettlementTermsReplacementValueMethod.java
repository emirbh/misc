package cdm.product.common.settlement.validation.datarule;

import cdm.observable.asset.CashCollateralValuationMethod;
import cdm.observable.asset.PartyDeterminationEnum;
import cdm.observable.asset.ValuationMethod;
import cdm.product.common.settlement.CashSettlementMethodEnum;
import cdm.product.common.settlement.CashSettlementTerms;
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
@RosettaDataRule("CashSettlementTermsReplacementValueMethod")
@ImplementedBy(CashSettlementTermsReplacementValueMethod.Default.class)
public interface CashSettlementTermsReplacementValueMethod extends Validator<CashSettlementTerms> {
	
	String NAME = "CashSettlementTermsReplacementValueMethod";
	String DEFINITION = "if valuationMethod -> cashCollateralValuationMethod -> protectedParty exists then cashSettlementMethod = CashSettlementMethodEnum -> ReplacementValueFirmQuotations or cashSettlementMethod = CashSettlementMethodEnum -> ReplacementValueCalculationAgentDetermination";
	
	class Default implements CashSettlementTermsReplacementValueMethod {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashSettlementTerms cashSettlementTerms) {
			ComparisonResult result = executeDataRule(cashSettlementTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CashSettlementTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CashSettlementTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CashSettlementTerms cashSettlementTerms) {
			try {
				if (exists(MapperS.of(cashSettlementTerms).<ValuationMethod>map("getValuationMethod", _cashSettlementTerms -> _cashSettlementTerms.getValuationMethod()).<CashCollateralValuationMethod>map("getCashCollateralValuationMethod", valuationMethod -> valuationMethod.getCashCollateralValuationMethod()).<PartyDeterminationEnum>mapC("getProtectedParty", cashCollateralValuationMethod -> cashCollateralValuationMethod.getProtectedParty())).getOrDefault(false)) {
					return areEqual(MapperS.of(cashSettlementTerms).<CashSettlementMethodEnum>map("getCashSettlementMethod", _cashSettlementTerms -> _cashSettlementTerms.getCashSettlementMethod()), MapperS.of(CashSettlementMethodEnum.REPLACEMENT_VALUE_FIRM_QUOTATIONS), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cashSettlementTerms).<CashSettlementMethodEnum>map("getCashSettlementMethod", _cashSettlementTerms -> _cashSettlementTerms.getCashSettlementMethod()), MapperS.of(CashSettlementMethodEnum.REPLACEMENT_VALUE_CALCULATION_AGENT_DETERMINATION), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CashSettlementTermsReplacementValueMethod {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashSettlementTerms cashSettlementTerms) {
			return Collections.emptyList();
		}
	}
}
