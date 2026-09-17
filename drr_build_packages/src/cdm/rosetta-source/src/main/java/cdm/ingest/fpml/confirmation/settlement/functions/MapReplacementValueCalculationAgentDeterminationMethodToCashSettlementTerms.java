package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.product.common.settlement.CashSettlementMethodEnum;
import cdm.product.common.settlement.CashSettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.PartySelector;
import fpml.consolidated.ird.ReplacementValueCalculationAgentDeterminationMethod;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapReplacementValueCalculationAgentDeterminationMethodToCashSettlementTerms.MapReplacementValueCalculationAgentDeterminationMethodToCashSettlementTermsDefault.class)
public abstract class MapReplacementValueCalculationAgentDeterminationMethodToCashSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashCollateralValuationMethod mapCashCollateralValuationMethod;
	@Inject protected MapValuationMethod mapValuationMethod;

	/**
	* @param fpmlReplacementValueCalculationAgentDeterminationMethod 
	* @return cashSettlementTerms 
	*/
	public CashSettlementTerms evaluate(ReplacementValueCalculationAgentDeterminationMethod fpmlReplacementValueCalculationAgentDeterminationMethod) {
		CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTermsBuilder = doEvaluate(fpmlReplacementValueCalculationAgentDeterminationMethod);
		
		final CashSettlementTerms cashSettlementTerms;
		if (cashSettlementTermsBuilder == null) {
			cashSettlementTerms = null;
		} else {
			cashSettlementTerms = cashSettlementTermsBuilder.build();
			objectValidator.validate(CashSettlementTerms.class, cashSettlementTerms);
		}
		
		return cashSettlementTerms;
	}

	protected abstract CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(ReplacementValueCalculationAgentDeterminationMethod fpmlReplacementValueCalculationAgentDeterminationMethod);

	public static class MapReplacementValueCalculationAgentDeterminationMethodToCashSettlementTermsDefault extends MapReplacementValueCalculationAgentDeterminationMethodToCashSettlementTerms {
		@Override
		protected CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(ReplacementValueCalculationAgentDeterminationMethod fpmlReplacementValueCalculationAgentDeterminationMethod) {
			CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms = CashSettlementTerms.builder();
			return assignOutput(cashSettlementTerms, fpmlReplacementValueCalculationAgentDeterminationMethod);
		}
		
		protected CashSettlementTerms.CashSettlementTermsBuilder assignOutput(CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms, ReplacementValueCalculationAgentDeterminationMethod fpmlReplacementValueCalculationAgentDeterminationMethod) {
			if (exists(MapperS.of(fpmlReplacementValueCalculationAgentDeterminationMethod)).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(CashSettlementTerms.builder()
					.setCashSettlementMethod(CashSettlementMethodEnum.REPLACEMENT_VALUE_CALCULATION_AGENT_DETERMINATION)
					.setValuationMethod(mapValuationMethod.evaluate(null, MapperS.of(fpmlReplacementValueCalculationAgentDeterminationMethod).<CashSettlementReferenceBanks>map("getCashSettlementReferenceBanks", replacementValueCalculationAgentDeterminationMethod -> replacementValueCalculationAgentDeterminationMethod.getCashSettlementReferenceBanks()).get(), null, mapCashCollateralValuationMethod.evaluate(null, MapperS.of(fpmlReplacementValueCalculationAgentDeterminationMethod).<Currency>map("getCashCollateralCurrency", replacementValueCalculationAgentDeterminationMethod -> replacementValueCalculationAgentDeterminationMethod.getCashCollateralCurrency()).get(), null, null, MapperS.of(fpmlReplacementValueCalculationAgentDeterminationMethod).<PartySelector>map("getProtectedParty", replacementValueCalculationAgentDeterminationMethod -> replacementValueCalculationAgentDeterminationMethod.getProtectedParty()).getMulti(), null)))
					.build());
			} else {
				cashSettlementTerms = null;
			}
			
			return Optional.ofNullable(cashSettlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
