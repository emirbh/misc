package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapDateReferenceToDividendPaymentDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapDividendPaymentDate;
import cdm.ingest.fpml.confirmation.other.functions.MapDividendAmountTypeEnum;
import cdm.ingest.fpml.confirmation.other.functions.MapDividendEntitlementEnum;
import cdm.ingest.fpml.confirmation.other.functions.MapDividendPeriodEnum;
import cdm.product.asset.DividendPayoutRatio;
import cdm.product.asset.DividendPeriod;
import cdm.product.asset.DividendReturnTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.DividendPayout;
import fpml.consolidated.eq.shared.DividendConditions;
import fpml.consolidated.eq.shared.DividendPaymentDate;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.fpmlenum.DividendAmountTypeEnum;
import fpml.consolidated.fpmlenum.DividendCompositionEnum;
import fpml.consolidated.fpmlenum.DividendEntitlementEnum;
import fpml.consolidated.fpmlenum.DividendPeriodEnum;
import fpml.consolidated.fpmlenum.NonCashDividendTreatmentEnum;
import fpml.consolidated.shared.DateReference;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.IdentifiedCurrencyReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReturnSwapDividendReturnTerms.MapReturnSwapDividendReturnTermsDefault.class)
public abstract class MapReturnSwapDividendReturnTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDateReferenceToDividendPaymentDate mapDateReferenceToDividendPaymentDate;
	@Inject protected MapDividendAmountTypeEnum mapDividendAmountTypeEnum;
	@Inject protected MapDividendCurrency mapDividendCurrency;
	@Inject protected MapDividendEntitlementEnum mapDividendEntitlementEnum;
	@Inject protected MapDividendPaymentDate mapDividendPaymentDate;
	@Inject protected MapDividendPeriodEnum mapDividendPeriodEnum;

	/**
	* @param fpmlDividendPayout 
	* @param fpmlDividendConditions 
	* @param fpmlEquityValuation 
	* @return dividendReturnTerms 
	*/
	public DividendReturnTerms evaluate(DividendPayout fpmlDividendPayout, DividendConditions fpmlDividendConditions, EquityValuation fpmlEquityValuation) {
		DividendReturnTerms.DividendReturnTermsBuilder dividendReturnTermsBuilder = doEvaluate(fpmlDividendPayout, fpmlDividendConditions, fpmlEquityValuation);
		
		final DividendReturnTerms dividendReturnTerms;
		if (dividendReturnTermsBuilder == null) {
			dividendReturnTerms = null;
		} else {
			dividendReturnTerms = dividendReturnTermsBuilder.build();
			objectValidator.validate(DividendReturnTerms.class, dividendReturnTerms);
		}
		
		return dividendReturnTerms;
	}

	protected abstract DividendReturnTerms.DividendReturnTermsBuilder doEvaluate(DividendPayout fpmlDividendPayout, DividendConditions fpmlDividendConditions, EquityValuation fpmlEquityValuation);

	public static class MapReturnSwapDividendReturnTermsDefault extends MapReturnSwapDividendReturnTerms {
		@Override
		protected DividendReturnTerms.DividendReturnTermsBuilder doEvaluate(DividendPayout fpmlDividendPayout, DividendConditions fpmlDividendConditions, EquityValuation fpmlEquityValuation) {
			DividendReturnTerms.DividendReturnTermsBuilder dividendReturnTerms = DividendReturnTerms.builder();
			return assignOutput(dividendReturnTerms, fpmlDividendPayout, fpmlDividendConditions, fpmlEquityValuation);
		}
		
		protected DividendReturnTerms.DividendReturnTermsBuilder assignOutput(DividendReturnTerms.DividendReturnTermsBuilder dividendReturnTerms, DividendPayout fpmlDividendPayout, DividendConditions fpmlDividendConditions, EquityValuation fpmlEquityValuation) {
			dividendReturnTerms = toBuilder(MapperS.of(fpmlDividendConditions)
				.mapSingleToItem(item -> {
					final DividendPayoutRatio dividendPayoutRatio = DividendPayoutRatio.builder()
						.setTotalRatio(MapperS.of(fpmlDividendPayout).<BigDecimal>map("getDividendPayoutRatio", dividendPayout -> dividendPayout.getDividendPayoutRatio()).get())
						.setCashRatio(MapperS.of(fpmlDividendConditions).<BigDecimal>map("getDeclaredCashDividendPercentage", dividendConditions -> dividendConditions.getDeclaredCashDividendPercentage()).get())
						.setNonCashRatio(MapperS.of(fpmlDividendConditions).<BigDecimal>map("getDeclaredCashEquivalentDividendPercentage", dividendConditions -> dividendConditions.getDeclaredCashEquivalentDividendPercentage()).get())
						.build();
					final DividendPeriod dividendPeriod = DividendPeriod.builder()
						.setStartDate(mapDateReferenceToDividendPaymentDate.evaluate(item.<DateReference>map("getDividendPeriodEffectiveDate", dividendConditions -> dividendConditions.getDividendPeriodEffectiveDate()).get()))
						.setEndDate(mapDateReferenceToDividendPaymentDate.evaluate(item.<DateReference>map("getDividendPeriodEndDate", dividendConditions -> dividendConditions.getDividendPeriodEndDate()).get()))
						.setDividendPaymentDate(mapDividendPaymentDate.evaluate(item.<DividendPaymentDate>map("getDividendPaymentDate", dividendConditions -> dividendConditions.getDividendPaymentDate()).get()))
						.setDateAdjustments(null)
						.build();
					return MapperS.of(DividendReturnTerms.builder()
						.setDividendPayoutRatio((dividendPayoutRatio == null ? Collections.<DividendPayoutRatio>emptyList() : Collections.singletonList(dividendPayoutRatio)))
						.setFirstOrSecondPeriod(mapDividendPeriodEnum.evaluate(item.<DividendPeriodEnum>map("getDividendPeriod", dividendConditions -> dividendConditions.getDividendPeriod()).map("to-string", DividendPeriodEnum::toDisplayString).get()))
						.setDividendReinvestment(item.<Boolean>map("getDividendReinvestment", dividendConditions -> dividendConditions.getDividendReinvestment()).get())
						.setDividendEntitlement(mapDividendEntitlementEnum.evaluate(item.<DividendEntitlementEnum>map("getDividendEntitlement", dividendConditions -> dividendConditions.getDividendEntitlement()).map("to-string", DividendEntitlementEnum::toDisplayString).get()))
						.setExcessDividendAmount(mapDividendAmountTypeEnum.evaluate(item.<DividendAmountTypeEnum>map("getExcessDividendAmount", dividendConditions -> dividendConditions.getExcessDividendAmount()).map("to-string", DividendAmountTypeEnum::toDisplayString).get()))
						.setDividendCurrency(mapDividendCurrency.evaluate(item.<IdentifiedCurrency>map("getCurrency", dividendConditions -> dividendConditions.getCurrency()).get(), item.<DeterminationMethod>map("getDeterminationMethod", dividendConditions -> dividendConditions.getDeterminationMethod()).get(), item.<IdentifiedCurrencyReference>map("getCurrencyReference", dividendConditions -> dividendConditions.getCurrencyReference()).get()))
						.setDividendComposition(MapperS.of(fpmlDividendConditions).<DividendCompositionEnum>map("getDividendComposition", dividendConditions -> dividendConditions.getDividendComposition()).checkedMap("to-enum", e -> cdm.product.asset.DividendCompositionEnum.valueOf(e.name()), IllegalArgumentException.class).get())
						.setNonCashDividendTreatment(MapperS.of(fpmlDividendConditions).<NonCashDividendTreatmentEnum>map("getNonCashDividendTreatment", dividendConditions -> dividendConditions.getNonCashDividendTreatment()).checkedMap("to-enum", e -> cdm.product.asset.NonCashDividendTreatmentEnum.valueOf(e.name()), IllegalArgumentException.class).get())
						.setDividendPeriod((dividendPeriod == null ? Collections.<DividendPeriod>emptyList() : Collections.singletonList(dividendPeriod)))
						.build());
				}).get());
			
			return Optional.ofNullable(dividendReturnTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
