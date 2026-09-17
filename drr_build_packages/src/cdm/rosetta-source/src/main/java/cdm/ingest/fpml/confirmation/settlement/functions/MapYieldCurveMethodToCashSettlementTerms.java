package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.product.common.settlement.CashSettlementMethodEnum;
import cdm.product.common.settlement.CashSettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.ird.YieldCurveMethod;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.SettlementRateSource;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapYieldCurveMethodToCashSettlementTerms.MapYieldCurveMethodToCashSettlementTermsDefault.class)
public abstract class MapYieldCurveMethodToCashSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapValuationMethod mapValuationMethod;

	/**
	* @param fpmlParYieldCurveUnadjustedMethod 
	* @param cdmCashSettlementMethod 
	* @return cashSettlementTerms 
	*/
	public CashSettlementTerms evaluate(YieldCurveMethod fpmlParYieldCurveUnadjustedMethod, CashSettlementMethodEnum cdmCashSettlementMethod) {
		CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTermsBuilder = doEvaluate(fpmlParYieldCurveUnadjustedMethod, cdmCashSettlementMethod);
		
		final CashSettlementTerms cashSettlementTerms;
		if (cashSettlementTermsBuilder == null) {
			cashSettlementTerms = null;
		} else {
			cashSettlementTerms = cashSettlementTermsBuilder.build();
			objectValidator.validate(CashSettlementTerms.class, cashSettlementTerms);
		}
		
		return cashSettlementTerms;
	}

	protected abstract CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(YieldCurveMethod fpmlParYieldCurveUnadjustedMethod, CashSettlementMethodEnum cdmCashSettlementMethod);

	public static class MapYieldCurveMethodToCashSettlementTermsDefault extends MapYieldCurveMethodToCashSettlementTerms {
		@Override
		protected CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(YieldCurveMethod fpmlParYieldCurveUnadjustedMethod, CashSettlementMethodEnum cdmCashSettlementMethod) {
			CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms = CashSettlementTerms.builder();
			return assignOutput(cashSettlementTerms, fpmlParYieldCurveUnadjustedMethod, cdmCashSettlementMethod);
		}
		
		protected CashSettlementTerms.CashSettlementTermsBuilder assignOutput(CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms, YieldCurveMethod fpmlParYieldCurveUnadjustedMethod, CashSettlementMethodEnum cdmCashSettlementMethod) {
			if (exists(MapperS.of(fpmlParYieldCurveUnadjustedMethod)).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(CashSettlementTerms.builder()
					.setCashSettlementMethod(cdmCashSettlementMethod)
					.setValuationMethod(mapValuationMethod.evaluate(MapperS.of(fpmlParYieldCurveUnadjustedMethod).<SettlementRateSource>map("getSettlementRateSource", yieldCurveMethod -> yieldCurveMethod.getSettlementRateSource()).get(), MapperS.of(fpmlParYieldCurveUnadjustedMethod).<SettlementRateSource>map("getSettlementRateSource", yieldCurveMethod -> yieldCurveMethod.getSettlementRateSource()).<CashSettlementReferenceBanks>map("getCashSettlementReferenceBanks", settlementRateSource -> settlementRateSource.getCashSettlementReferenceBanks()).get(), MapperS.of(fpmlParYieldCurveUnadjustedMethod).<QuotationRateTypeEnum>map("getQuotationRateType", yieldCurveMethod -> yieldCurveMethod.getQuotationRateType()).get(), null))
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
