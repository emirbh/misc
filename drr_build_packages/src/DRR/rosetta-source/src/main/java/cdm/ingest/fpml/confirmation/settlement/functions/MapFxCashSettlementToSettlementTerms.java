package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.common.functions.MapFxSpotRateSource;
import cdm.ingest.fpml.confirmation.common.functions.MapQuotedCurrencyPair;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrAdjustedOrRelativeDate;
import cdm.observable.asset.ValuationMethod;
import cdm.observable.asset.ValuationSource;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.FxFixingDate;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import cdm.product.common.settlement.ValuationDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxCashSettlement;
import fpml.consolidated.shared.FxFixing;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxCashSettlementToSettlementTerms.MapFxCashSettlementToSettlementTermsDefault.class)
public abstract class MapFxCashSettlementToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrAdjustedOrRelativeDate mapAdjustableOrAdjustedOrRelativeDate;
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapFxSpotRateSource mapFxSpotRateSource;
	@Inject protected MapQuotedCurrencyPair mapQuotedCurrencyPair;

	/**
	* @param fpmlFxCashSettlement 
	* @param valueDate 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(FxCashSettlement fpmlFxCashSettlement, Date valueDate) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlFxCashSettlement, valueDate);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(FxCashSettlement fpmlFxCashSettlement, Date valueDate);

	protected abstract MapperS<SettlementTypeEnum> settlementType(FxCashSettlement fpmlFxCashSettlement, Date valueDate);

	public static class MapFxCashSettlementToSettlementTermsDefault extends MapFxCashSettlementToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(FxCashSettlement fpmlFxCashSettlement, Date valueDate) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlFxCashSettlement, valueDate);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, FxCashSettlement fpmlFxCashSettlement, Date valueDate) {
			final CashSettlementTerms cashSettlementTerms = CashSettlementTerms.builder()
				.setCashSettlementMethod(null)
				.setValuationMethod(ValuationMethod.builder()
					.setValuationSource(ValuationSource.builder()
						.setQuotedCurrencyPairValue(mapQuotedCurrencyPair.evaluate(MapperS.of(fpmlFxCashSettlement).<FxFixing>mapC("getFixing", fxCashSettlement -> fxCashSettlement.getFixing()).<QuotedCurrencyPair>map("getQuotedCurrencyPair", fxFixing -> fxFixing.getQuotedCurrencyPair())
							.first().get()))
						.setInformationSource(mapFxSpotRateSource.evaluate(MapperS.of(fpmlFxCashSettlement).<FxFixing>mapC("getFixing", fxCashSettlement -> fxCashSettlement.getFixing()).<FxSpotRateSource>map("getFxSpotRateSource", fxFixing -> fxFixing.getFxSpotRateSource())
							.first().get()))
						.setReferenceBanks(null)
						.build())
					.setQuotationMethod(null)
					.setCashCollateralValuationMethod(null)
					.build())
				.setValuationDate(ValuationDate.builder()
					.setFxFixingDate(FxFixingDate.builder()
						.setPeriod(null)
						.setPeriodMultiplier(null)
						.setFxFixingDate(AdjustableOrRelativeDate.builder()
							.setAdjustableDate(AdjustableDate.builder()
								.setAdjustedDateValue(MapperS.of(fpmlFxCashSettlement).<FxFixing>mapC("getFixing", fxCashSettlement -> fxCashSettlement.getFixing()).<ZonedDateTime>map("getFixingDate", fxFixing -> fxFixing.getFixingDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate()))
									.first().get())
								.build())
							.build())
						.build())
					.build())
				.setValuationTime(null)
				.build();
			settlementTerms = toBuilder(SettlementTerms.builder()
				.setSettlementType(settlementType(fpmlFxCashSettlement, valueDate).get())
				.setSettlementCurrency(mapCurrency.evaluate(MapperS.of(fpmlFxCashSettlement).<Currency>map("getSettlementCurrency", fxCashSettlement -> fxCashSettlement.getSettlementCurrency()).get()))
				.setSettlementDate(SettlementDate.builder()
					.setAdjustableOrRelativeDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(null, MapperS.of(fpmlFxCashSettlement).<fpml.consolidated.shared.AdjustableDate>map("getSettlementDate", fxCashSettlement -> fxCashSettlement.getSettlementDate()).get(), null))
					.setValueDate(valueDate)
					.build())
				.setCashSettlementTerms((cashSettlementTerms == null ? Collections.<CashSettlementTerms>emptyList() : Collections.singletonList(cashSettlementTerms)))
				.build());
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<SettlementTypeEnum> settlementType(FxCashSettlement fpmlFxCashSettlement, Date valueDate) {
			if (exists(MapperS.of(fpmlFxCashSettlement)).getOrDefault(false)) {
				return MapperS.of(SettlementTypeEnum.CASH);
			}
			return MapperS.<SettlementTypeEnum>ofNull();
		}
	}
}
