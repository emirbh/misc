package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.product.common.settlement.CashSettlementMethodEnum;
import cdm.product.common.settlement.CashSettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.ird.CashPriceMethod;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCashPriceMethodToCashSettlementTerms.MapCashPriceMethodToCashSettlementTermsDefault.class)
public abstract class MapCashPriceMethodToCashSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapValuationMethod mapValuationMethod;

	/**
	* @param fpmlCashPriceMethod 
	* @param cdmCashSettlementMethod 
	* @return cashSettlementTerms 
	*/
	public CashSettlementTerms evaluate(CashPriceMethod fpmlCashPriceMethod, CashSettlementMethodEnum cdmCashSettlementMethod) {
		CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTermsBuilder = doEvaluate(fpmlCashPriceMethod, cdmCashSettlementMethod);
		
		final CashSettlementTerms cashSettlementTerms;
		if (cashSettlementTermsBuilder == null) {
			cashSettlementTerms = null;
		} else {
			cashSettlementTerms = cashSettlementTermsBuilder.build();
			objectValidator.validate(CashSettlementTerms.class, cashSettlementTerms);
		}
		
		return cashSettlementTerms;
	}

	protected abstract CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(CashPriceMethod fpmlCashPriceMethod, CashSettlementMethodEnum cdmCashSettlementMethod);

	public static class MapCashPriceMethodToCashSettlementTermsDefault extends MapCashPriceMethodToCashSettlementTerms {
		@Override
		protected CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(CashPriceMethod fpmlCashPriceMethod, CashSettlementMethodEnum cdmCashSettlementMethod) {
			CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms = CashSettlementTerms.builder();
			return assignOutput(cashSettlementTerms, fpmlCashPriceMethod, cdmCashSettlementMethod);
		}
		
		protected CashSettlementTerms.CashSettlementTermsBuilder assignOutput(CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms, CashPriceMethod fpmlCashPriceMethod, CashSettlementMethodEnum cdmCashSettlementMethod) {
			if (exists(MapperS.of(fpmlCashPriceMethod)).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(CashSettlementTerms.builder()
					.setCashSettlementMethod(cdmCashSettlementMethod)
					.setValuationMethod(mapValuationMethod.evaluate(null, MapperS.of(fpmlCashPriceMethod).<CashSettlementReferenceBanks>map("getCashSettlementReferenceBanks", cashPriceMethod -> cashPriceMethod.getCashSettlementReferenceBanks()).get(), MapperS.of(fpmlCashPriceMethod).<QuotationRateTypeEnum>map("getQuotationRateType", cashPriceMethod -> cashPriceMethod.getQuotationRateType()).get(), null))
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
