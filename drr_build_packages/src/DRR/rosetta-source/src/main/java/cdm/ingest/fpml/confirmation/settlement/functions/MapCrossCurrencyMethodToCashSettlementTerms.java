package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.product.common.settlement.CashSettlementMethodEnum;
import cdm.product.common.settlement.CashSettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.ird.CrossCurrencyMethod;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCrossCurrencyMethodToCashSettlementTerms.MapCrossCurrencyMethodToCashSettlementTermsDefault.class)
public abstract class MapCrossCurrencyMethodToCashSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapValuationMethod mapValuationMethod;

	/**
	* @param fpmlCrossCurrencyMethod 
	* @return cashSettlementTerms 
	*/
	public CashSettlementTerms evaluate(CrossCurrencyMethod fpmlCrossCurrencyMethod) {
		CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTermsBuilder = doEvaluate(fpmlCrossCurrencyMethod);
		
		final CashSettlementTerms cashSettlementTerms;
		if (cashSettlementTermsBuilder == null) {
			cashSettlementTerms = null;
		} else {
			cashSettlementTerms = cashSettlementTermsBuilder.build();
			objectValidator.validate(CashSettlementTerms.class, cashSettlementTerms);
		}
		
		return cashSettlementTerms;
	}

	protected abstract CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(CrossCurrencyMethod fpmlCrossCurrencyMethod);

	public static class MapCrossCurrencyMethodToCashSettlementTermsDefault extends MapCrossCurrencyMethodToCashSettlementTerms {
		@Override
		protected CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(CrossCurrencyMethod fpmlCrossCurrencyMethod) {
			CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms = CashSettlementTerms.builder();
			return assignOutput(cashSettlementTerms, fpmlCrossCurrencyMethod);
		}
		
		protected CashSettlementTerms.CashSettlementTermsBuilder assignOutput(CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms, CrossCurrencyMethod fpmlCrossCurrencyMethod) {
			if (exists(MapperS.of(fpmlCrossCurrencyMethod)).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(CashSettlementTerms.builder()
					.setCashSettlementMethod(CashSettlementMethodEnum.CROSS_CURRENCY_METHOD)
					.setValuationMethod(mapValuationMethod.evaluate(null, null, MapperS.of(fpmlCrossCurrencyMethod).<QuotationRateTypeEnum>map("getQuotationRateType", crossCurrencyMethod -> crossCurrencyMethod.getQuotationRateType()).get(), null))
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
