package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.product.common.settlement.CashSettlementMethodEnum;
import cdm.product.common.settlement.CashSettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.PartySelector;
import fpml.consolidated.ird.ReplacementValueFirmQuotationsMethod;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapReplacementValueFirmQuotationsMethodToCashSettlementTerms.MapReplacementValueFirmQuotationsMethodToCashSettlementTermsDefault.class)
public abstract class MapReplacementValueFirmQuotationsMethodToCashSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashCollateralValuationMethod mapCashCollateralValuationMethod;
	@Inject protected MapValuationMethod mapValuationMethod;

	/**
	* @param fpmlReplacementValueFirmQuotationsMethod 
	* @return cashSettlementTerms 
	*/
	public CashSettlementTerms evaluate(ReplacementValueFirmQuotationsMethod fpmlReplacementValueFirmQuotationsMethod) {
		CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTermsBuilder = doEvaluate(fpmlReplacementValueFirmQuotationsMethod);
		
		final CashSettlementTerms cashSettlementTerms;
		if (cashSettlementTermsBuilder == null) {
			cashSettlementTerms = null;
		} else {
			cashSettlementTerms = cashSettlementTermsBuilder.build();
			objectValidator.validate(CashSettlementTerms.class, cashSettlementTerms);
		}
		
		return cashSettlementTerms;
	}

	protected abstract CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(ReplacementValueFirmQuotationsMethod fpmlReplacementValueFirmQuotationsMethod);

	public static class MapReplacementValueFirmQuotationsMethodToCashSettlementTermsDefault extends MapReplacementValueFirmQuotationsMethodToCashSettlementTerms {
		@Override
		protected CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(ReplacementValueFirmQuotationsMethod fpmlReplacementValueFirmQuotationsMethod) {
			CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms = CashSettlementTerms.builder();
			return assignOutput(cashSettlementTerms, fpmlReplacementValueFirmQuotationsMethod);
		}
		
		protected CashSettlementTerms.CashSettlementTermsBuilder assignOutput(CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms, ReplacementValueFirmQuotationsMethod fpmlReplacementValueFirmQuotationsMethod) {
			if (exists(MapperS.of(fpmlReplacementValueFirmQuotationsMethod)).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(CashSettlementTerms.builder()
					.setCashSettlementMethod(CashSettlementMethodEnum.REPLACEMENT_VALUE_FIRM_QUOTATIONS)
					.setValuationMethod(mapValuationMethod.evaluate(null, MapperS.of(fpmlReplacementValueFirmQuotationsMethod).<CashSettlementReferenceBanks>map("getCashSettlementReferenceBanks", replacementValueFirmQuotationsMethod -> replacementValueFirmQuotationsMethod.getCashSettlementReferenceBanks()).get(), null, mapCashCollateralValuationMethod.evaluate(null, MapperS.of(fpmlReplacementValueFirmQuotationsMethod).<Currency>map("getCashCollateralCurrency", replacementValueFirmQuotationsMethod -> replacementValueFirmQuotationsMethod.getCashCollateralCurrency()).get(), null, null, MapperS.of(fpmlReplacementValueFirmQuotationsMethod).<PartySelector>map("getProtectedParty", replacementValueFirmQuotationsMethod -> replacementValueFirmQuotationsMethod.getProtectedParty()).getMulti(), MapperS.of(fpmlReplacementValueFirmQuotationsMethod).<Boolean>map("getPrescribedDocumentationAdjustment", replacementValueFirmQuotationsMethod -> replacementValueFirmQuotationsMethod.getPrescribedDocumentationAdjustment()).get())))
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
