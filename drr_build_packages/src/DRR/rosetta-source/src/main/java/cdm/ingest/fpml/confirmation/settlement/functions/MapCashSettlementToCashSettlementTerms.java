package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenterTime;
import cdm.ingest.fpml.confirmation.datetime.functions.MapRelativeDateOffset;
import cdm.product.common.settlement.CashSettlementMethodEnum;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.ValuationDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CashPriceMethod;
import fpml.consolidated.ird.CashSettlement;
import fpml.consolidated.ird.CollateralizedCashPriceMethod;
import fpml.consolidated.ird.CrossCurrencyMethod;
import fpml.consolidated.ird.MidMarketValuation;
import fpml.consolidated.ird.MidMarketValuationMethod;
import fpml.consolidated.ird.ReplacementValue;
import fpml.consolidated.ird.ReplacementValueCalculationAgentDeterminationMethod;
import fpml.consolidated.ird.ReplacementValueFirmQuotationsMethod;
import fpml.consolidated.ird.YieldCurveMethod;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCashSettlementToCashSettlementTerms.MapCashSettlementToCashSettlementTermsDefault.class)
public abstract class MapCashSettlementToCashSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapCashPriceMethodToCashSettlementTerms mapCashPriceMethodToCashSettlementTerms;
	@Inject protected MapCollateralizedCashPriceMethodToCashSettlementTerms mapCollateralizedCashPriceMethodToCashSettlementTerms;
	@Inject protected MapCrossCurrencyMethodToCashSettlementTerms mapCrossCurrencyMethodToCashSettlementTerms;
	@Inject protected MapMidMarketValuationMethodToCashSettlementTerms mapMidMarketValuationMethodToCashSettlementTerms;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;
	@Inject protected MapReplacementValueCalculationAgentDeterminationMethodToCashSettlementTerms mapReplacementValueCalculationAgentDeterminationMethodToCashSettlementTerms;
	@Inject protected MapReplacementValueFirmQuotationsMethodToCashSettlementTerms mapReplacementValueFirmQuotationsMethodToCashSettlementTerms;
	@Inject protected MapYieldCurveMethodToCashSettlementTerms mapYieldCurveMethodToCashSettlementTerms;

	/**
	* @param fpmlCashSettlement 
	* @return cashSettlementTerms 
	*/
	public CashSettlementTerms evaluate(CashSettlement fpmlCashSettlement) {
		CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTermsBuilder = doEvaluate(fpmlCashSettlement);
		
		final CashSettlementTerms cashSettlementTerms;
		if (cashSettlementTermsBuilder == null) {
			cashSettlementTerms = null;
		} else {
			cashSettlementTerms = cashSettlementTermsBuilder.build();
			objectValidator.validate(CashSettlementTerms.class, cashSettlementTerms);
		}
		
		return cashSettlementTerms;
	}

	protected abstract CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(CashSettlement fpmlCashSettlement);

	public static class MapCashSettlementToCashSettlementTermsDefault extends MapCashSettlementToCashSettlementTerms {
		@Override
		protected CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(CashSettlement fpmlCashSettlement) {
			CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms = CashSettlementTerms.builder();
			return assignOutput(cashSettlementTerms, fpmlCashSettlement);
		}
		
		protected CashSettlementTerms.CashSettlementTermsBuilder assignOutput(CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms, CashSettlement fpmlCashSettlement) {
			if (exists(MapperS.of(fpmlCashSettlement).<MidMarketValuation>map("getMidMarketValuation", cashSettlement -> cashSettlement.getMidMarketValuation()).<MidMarketValuationMethod>map("getIndicativeQuotations", midMarketValuation -> midMarketValuation.getIndicativeQuotations())).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(mapMidMarketValuationMethodToCashSettlementTerms.evaluate(MapperS.of(fpmlCashSettlement).<MidMarketValuation>map("getMidMarketValuation", cashSettlement -> cashSettlement.getMidMarketValuation()).<MidMarketValuationMethod>map("getIndicativeQuotations", midMarketValuation -> midMarketValuation.getIndicativeQuotations()).get(), CashSettlementMethodEnum.MID_MARKET_INDICATIVE_QUOTATIONS), () -> CashSettlementTerms.builder());
			} else if (exists(MapperS.of(fpmlCashSettlement).<MidMarketValuation>map("getMidMarketValuation", cashSettlement -> cashSettlement.getMidMarketValuation()).<MidMarketValuationMethod>map("getIndicativeQuotationsAlternate", midMarketValuation -> midMarketValuation.getIndicativeQuotationsAlternate())).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(mapMidMarketValuationMethodToCashSettlementTerms.evaluate(MapperS.of(fpmlCashSettlement).<MidMarketValuation>map("getMidMarketValuation", cashSettlement -> cashSettlement.getMidMarketValuation()).<MidMarketValuationMethod>map("getIndicativeQuotationsAlternate", midMarketValuation -> midMarketValuation.getIndicativeQuotationsAlternate()).get(), CashSettlementMethodEnum.MID_MARKET_INDICATIVE_QUOTATIONS_ALTERNATE), () -> CashSettlementTerms.builder());
			} else if (exists(MapperS.of(fpmlCashSettlement).<MidMarketValuation>map("getMidMarketValuation", cashSettlement -> cashSettlement.getMidMarketValuation()).<MidMarketValuationMethod>map("getCalculationAgentDetermination", midMarketValuation -> midMarketValuation.getCalculationAgentDetermination())).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(mapMidMarketValuationMethodToCashSettlementTerms.evaluate(MapperS.of(fpmlCashSettlement).<MidMarketValuation>map("getMidMarketValuation", cashSettlement -> cashSettlement.getMidMarketValuation()).<MidMarketValuationMethod>map("getCalculationAgentDetermination", midMarketValuation -> midMarketValuation.getCalculationAgentDetermination()).get(), CashSettlementMethodEnum.MID_MARKET_CALCULATION_AGENT_DETERMINATION), () -> CashSettlementTerms.builder());
			} else if (exists(MapperS.of(fpmlCashSettlement).<ReplacementValue>map("getReplacementValue", cashSettlement -> cashSettlement.getReplacementValue()).<ReplacementValueFirmQuotationsMethod>map("getFirmQuotations", replacementValue -> replacementValue.getFirmQuotations())).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(mapReplacementValueFirmQuotationsMethodToCashSettlementTerms.evaluate(MapperS.of(fpmlCashSettlement).<ReplacementValue>map("getReplacementValue", cashSettlement -> cashSettlement.getReplacementValue()).<ReplacementValueFirmQuotationsMethod>map("getFirmQuotations", replacementValue -> replacementValue.getFirmQuotations()).get()), () -> CashSettlementTerms.builder());
			} else if (exists(MapperS.of(fpmlCashSettlement).<ReplacementValue>map("getReplacementValue", cashSettlement -> cashSettlement.getReplacementValue()).<ReplacementValueCalculationAgentDeterminationMethod>map("getCalculationAgentDetermination", replacementValue -> replacementValue.getCalculationAgentDetermination())).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(mapReplacementValueCalculationAgentDeterminationMethodToCashSettlementTerms.evaluate(MapperS.of(fpmlCashSettlement).<ReplacementValue>map("getReplacementValue", cashSettlement -> cashSettlement.getReplacementValue()).<ReplacementValueCalculationAgentDeterminationMethod>map("getCalculationAgentDetermination", replacementValue -> replacementValue.getCalculationAgentDetermination()).get()), () -> CashSettlementTerms.builder());
			} else if (exists(MapperS.of(fpmlCashSettlement).<YieldCurveMethod>map("getParYieldCurveUnadjustedMethod", cashSettlement -> cashSettlement.getParYieldCurveUnadjustedMethod())).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(mapYieldCurveMethodToCashSettlementTerms.evaluate(MapperS.of(fpmlCashSettlement).<YieldCurveMethod>map("getParYieldCurveUnadjustedMethod", cashSettlement -> cashSettlement.getParYieldCurveUnadjustedMethod()).get(), CashSettlementMethodEnum.PAR_YIELD_CURVE_UNADJUSTED_METHOD), () -> CashSettlementTerms.builder());
			} else if (exists(MapperS.of(fpmlCashSettlement).<CollateralizedCashPriceMethod>map("getCollateralizedCashPriceMethod", cashSettlement -> cashSettlement.getCollateralizedCashPriceMethod())).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(mapCollateralizedCashPriceMethodToCashSettlementTerms.evaluate(MapperS.of(fpmlCashSettlement).<CollateralizedCashPriceMethod>map("getCollateralizedCashPriceMethod", cashSettlement -> cashSettlement.getCollateralizedCashPriceMethod()).get()), () -> CashSettlementTerms.builder());
			} else if (exists(MapperS.of(fpmlCashSettlement).<CashPriceMethod>map("getCashPriceMethod", cashSettlement -> cashSettlement.getCashPriceMethod())).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(mapCashPriceMethodToCashSettlementTerms.evaluate(MapperS.of(fpmlCashSettlement).<CashPriceMethod>map("getCashPriceMethod", cashSettlement -> cashSettlement.getCashPriceMethod()).get(), CashSettlementMethodEnum.CASH_PRICE_METHOD), () -> CashSettlementTerms.builder());
			} else if (exists(MapperS.of(fpmlCashSettlement).<CashPriceMethod>map("getCashPriceAlternateMethod", cashSettlement -> cashSettlement.getCashPriceAlternateMethod())).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(mapCashPriceMethodToCashSettlementTerms.evaluate(MapperS.of(fpmlCashSettlement).<CashPriceMethod>map("getCashPriceAlternateMethod", cashSettlement -> cashSettlement.getCashPriceAlternateMethod()).get(), CashSettlementMethodEnum.CASH_PRICE_ALTERNATE_METHOD), () -> CashSettlementTerms.builder());
			} else if (exists(MapperS.of(fpmlCashSettlement).<YieldCurveMethod>map("getParYieldCurveAdjustedMethod", cashSettlement -> cashSettlement.getParYieldCurveAdjustedMethod())).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(mapYieldCurveMethodToCashSettlementTerms.evaluate(MapperS.of(fpmlCashSettlement).<YieldCurveMethod>map("getParYieldCurveAdjustedMethod", cashSettlement -> cashSettlement.getParYieldCurveAdjustedMethod()).get(), CashSettlementMethodEnum.PAR_YIELD_CURVE_ADJUSTED_METHOD), () -> CashSettlementTerms.builder());
			} else if (exists(MapperS.of(fpmlCashSettlement).<YieldCurveMethod>map("getZeroCouponYieldAdjustedMethod", cashSettlement -> cashSettlement.getZeroCouponYieldAdjustedMethod())).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(mapYieldCurveMethodToCashSettlementTerms.evaluate(MapperS.of(fpmlCashSettlement).<YieldCurveMethod>map("getZeroCouponYieldAdjustedMethod", cashSettlement -> cashSettlement.getZeroCouponYieldAdjustedMethod()).get(), CashSettlementMethodEnum.ZERO_COUPON_YIELD_ADJUSTED_METHOD), () -> CashSettlementTerms.builder());
			} else if (exists(MapperS.of(fpmlCashSettlement).<CrossCurrencyMethod>map("getCrossCurrencyMethod", cashSettlement -> cashSettlement.getCrossCurrencyMethod())).getOrDefault(false)) {
				cashSettlementTerms = toBuilder(mapCrossCurrencyMethodToCashSettlementTerms.evaluate(MapperS.of(fpmlCashSettlement).<CrossCurrencyMethod>map("getCrossCurrencyMethod", cashSettlement -> cashSettlement.getCrossCurrencyMethod()).get()), () -> CashSettlementTerms.builder());
			} else {
				cashSettlementTerms = null;
			}
			
			cashSettlementTerms
				.setValuationDate(ValuationDate.builder()
					.setValuationDate(mapRelativeDateOffset.evaluate(MapperS.of(fpmlCashSettlement).<RelativeDateOffset>map("getCashSettlementValuationDate", cashSettlement -> cashSettlement.getCashSettlementValuationDate()).get()))
					.build());
			
			cashSettlementTerms
				.setValuationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlCashSettlement).<BusinessCenterTime>map("getCashSettlementValuationTime", cashSettlement -> cashSettlement.getCashSettlementValuationTime()).get()));
			
			cashSettlementTerms
				.getOrCreateMeta().setExternalKey(MapperS.of(fpmlCashSettlement).<String>map("getId", cashSettlement -> cashSettlement.getId()).get());
			
			return Optional.ofNullable(cashSettlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
