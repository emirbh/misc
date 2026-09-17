package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.product.common.settlement.CashSettlementMethodEnum;
import cdm.product.common.settlement.CashSettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.CsaTypeEnum;
import fpml.consolidated.ird.MidMarketValuationMethod;
import fpml.consolidated.ird.PartySelector;
import fpml.consolidated.shared.BenchmarkRate;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapMidMarketValuationMethodToCashSettlementTerms.MapMidMarketValuationMethodToCashSettlementTermsDefault.class)
public abstract class MapMidMarketValuationMethodToCashSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashCollateralValuationMethod mapCashCollateralValuationMethod;
	@Inject protected MapValuationMethod mapValuationMethod;

	/**
	* @param fpmlMidMarketValuationMethod 
	* @param cdmCashSettlementMethod 
	* @return cashSettlementTerms 
	*/
	public CashSettlementTerms evaluate(MidMarketValuationMethod fpmlMidMarketValuationMethod, CashSettlementMethodEnum cdmCashSettlementMethod) {
		CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTermsBuilder = doEvaluate(fpmlMidMarketValuationMethod, cdmCashSettlementMethod);
		
		final CashSettlementTerms cashSettlementTerms;
		if (cashSettlementTermsBuilder == null) {
			cashSettlementTerms = null;
		} else {
			cashSettlementTerms = cashSettlementTermsBuilder.build();
			objectValidator.validate(CashSettlementTerms.class, cashSettlementTerms);
		}
		
		return cashSettlementTerms;
	}

	protected abstract CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(MidMarketValuationMethod fpmlMidMarketValuationMethod, CashSettlementMethodEnum cdmCashSettlementMethod);

	public static class MapMidMarketValuationMethodToCashSettlementTermsDefault extends MapMidMarketValuationMethodToCashSettlementTerms {
		@Override
		protected CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(MidMarketValuationMethod fpmlMidMarketValuationMethod, CashSettlementMethodEnum cdmCashSettlementMethod) {
			CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms = CashSettlementTerms.builder();
			return assignOutput(cashSettlementTerms, fpmlMidMarketValuationMethod, cdmCashSettlementMethod);
		}
		
		protected CashSettlementTerms.CashSettlementTermsBuilder assignOutput(CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms, MidMarketValuationMethod fpmlMidMarketValuationMethod, CashSettlementMethodEnum cdmCashSettlementMethod) {
			if (exists(MapperS.of(fpmlMidMarketValuationMethod)).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(CashSettlementTerms.builder()
					.setCashSettlementMethod(cdmCashSettlementMethod)
					.setValuationMethod(mapValuationMethod.evaluate(null, MapperS.of(fpmlMidMarketValuationMethod).<CashSettlementReferenceBanks>map("getCashSettlementReferenceBanks", midMarketValuationMethod -> midMarketValuationMethod.getCashSettlementReferenceBanks()).get(), null, mapCashCollateralValuationMethod.evaluate(MapperS.of(fpmlMidMarketValuationMethod).<CsaTypeEnum>map("getApplicableCsa", midMarketValuationMethod -> midMarketValuationMethod.getApplicableCsa()).get(), MapperS.of(fpmlMidMarketValuationMethod).<Currency>map("getCashCollateralCurrency", midMarketValuationMethod -> midMarketValuationMethod.getCashCollateralCurrency()).get(), MapperS.of(fpmlMidMarketValuationMethod).<BenchmarkRate>map("getCashCollateralInterestRate", midMarketValuationMethod -> midMarketValuationMethod.getCashCollateralInterestRate()).get(), MapperS.of(fpmlMidMarketValuationMethod).<BenchmarkRate>map("getAgreedDiscountRate", midMarketValuationMethod -> midMarketValuationMethod.getAgreedDiscountRate()).get(), Collections.<PartySelector>emptyList(), null)))
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
