package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.product.common.settlement.CashSettlementMethodEnum;
import cdm.product.common.settlement.CashSettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.ird.CollateralizedCashPriceMethod;
import fpml.consolidated.ird.PartySelector;
import fpml.consolidated.shared.BenchmarkRate;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.SettlementRateSource;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCollateralizedCashPriceMethodToCashSettlementTerms.MapCollateralizedCashPriceMethodToCashSettlementTermsDefault.class)
public abstract class MapCollateralizedCashPriceMethodToCashSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashCollateralValuationMethod mapCashCollateralValuationMethod;
	@Inject protected MapValuationMethod mapValuationMethod;

	/**
	* @param fpmlCollateralizedCashPriceMethod 
	* @return cashSettlementTerms 
	*/
	public CashSettlementTerms evaluate(CollateralizedCashPriceMethod fpmlCollateralizedCashPriceMethod) {
		CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTermsBuilder = doEvaluate(fpmlCollateralizedCashPriceMethod);
		
		final CashSettlementTerms cashSettlementTerms;
		if (cashSettlementTermsBuilder == null) {
			cashSettlementTerms = null;
		} else {
			cashSettlementTerms = cashSettlementTermsBuilder.build();
			objectValidator.validate(CashSettlementTerms.class, cashSettlementTerms);
		}
		
		return cashSettlementTerms;
	}

	protected abstract CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(CollateralizedCashPriceMethod fpmlCollateralizedCashPriceMethod);

	public static class MapCollateralizedCashPriceMethodToCashSettlementTermsDefault extends MapCollateralizedCashPriceMethodToCashSettlementTerms {
		@Override
		protected CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(CollateralizedCashPriceMethod fpmlCollateralizedCashPriceMethod) {
			CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms = CashSettlementTerms.builder();
			return assignOutput(cashSettlementTerms, fpmlCollateralizedCashPriceMethod);
		}
		
		protected CashSettlementTerms.CashSettlementTermsBuilder assignOutput(CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms, CollateralizedCashPriceMethod fpmlCollateralizedCashPriceMethod) {
			if (exists(MapperS.of(fpmlCollateralizedCashPriceMethod)).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(CashSettlementTerms.builder()
					.setCashSettlementMethod(CashSettlementMethodEnum.COLLATERALIZED_CASH_PRICE_METHOD)
					.setValuationMethod(mapValuationMethod.evaluate(MapperS.of(fpmlCollateralizedCashPriceMethod).<SettlementRateSource>map("getSettlementRateSource", collateralizedCashPriceMethod -> collateralizedCashPriceMethod.getSettlementRateSource()).get(), MapperS.of(fpmlCollateralizedCashPriceMethod).<SettlementRateSource>map("getSettlementRateSource", collateralizedCashPriceMethod -> collateralizedCashPriceMethod.getSettlementRateSource()).<CashSettlementReferenceBanks>map("getCashSettlementReferenceBanks", settlementRateSource -> settlementRateSource.getCashSettlementReferenceBanks()).get(), MapperS.of(fpmlCollateralizedCashPriceMethod).<QuotationRateTypeEnum>map("getQuotationRateType", collateralizedCashPriceMethod -> collateralizedCashPriceMethod.getQuotationRateType()).get(), mapCashCollateralValuationMethod.evaluate(null, null, null, MapperS.of(fpmlCollateralizedCashPriceMethod).<BenchmarkRate>map("getAgreedDiscountRate", collateralizedCashPriceMethod -> collateralizedCashPriceMethod.getAgreedDiscountRate()).get(), Collections.<PartySelector>emptyList(), null)))
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
