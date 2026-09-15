package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.common.functions.MapInformationSource;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenterTime;
import cdm.ingest.fpml.confirmation.datetime.functions.MapZoneDateTimeToDate;
import cdm.observable.asset.FxSpotRateSource;
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
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.FxAmericanExercise;
import fpml.consolidated.fx.FxEuropeanExercise;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxCashSettlement;
import fpml.consolidated.shared.FxFixing;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxOptionToSettlementTerms.MapFxOptionToSettlementTermsDefault.class)
public abstract class MapFxOptionToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapInformationSource mapInformationSource;
	@Inject protected MapZoneDateTimeToDate mapZoneDateTimeToDate;

	/**
	* @param fpmlFxOption 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(FxOption fpmlFxOption) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlFxOption);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(FxOption fpmlFxOption);

	protected abstract MapperS<ZonedDateTime> EuropeanExercise(FxOption fpmlFxOption);

	protected abstract MapperS<ZonedDateTime> AmericanExercise(FxOption fpmlFxOption);

	protected abstract MapperS<ZonedDateTime> settlementDate(FxOption fpmlFxOption);

	protected abstract MapperS<SettlementTypeEnum> settlementType(FxOption fpmlFxOption);

	public static class MapFxOptionToSettlementTermsDefault extends MapFxOptionToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(FxOption fpmlFxOption) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlFxOption);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, FxOption fpmlFxOption) {
			if (exists(settlementDate(fpmlFxOption)).getOrDefault(false)) {
				final MapperC<FxFixing> thenArg = MapperS.of(fpmlFxOption).<FxCashSettlement>map("getCashSettlement", fxOption -> fxOption.getCashSettlement()).<FxFixing>mapC("getFixing", fxCashSettlement -> fxCashSettlement.getFixing());
				settlementTerms = toBuilder(SettlementTerms.builder()
					.setSettlementDate(SettlementDate.builder()
						.setValueDate(mapZoneDateTimeToDate.evaluate(settlementDate(fpmlFxOption).get()))
						.build())
					.setSettlementType(settlementType(fpmlFxOption).get())
					.setSettlementCurrency(mapCurrency.evaluate(MapperS.of(fpmlFxOption).<FxCashSettlement>map("getCashSettlement", fxOption -> fxOption.getCashSettlement()).<Currency>map("getSettlementCurrency", fxCashSettlement -> fxCashSettlement.getSettlementCurrency()).get()))
					.setCashSettlementTerms(thenArg
						.mapItem(item -> {
							final MapperS<QuotedCurrencyPair> _thenArg = item.<QuotedCurrencyPair>map("getQuotedCurrencyPair", fxFixing -> fxFixing.getQuotedCurrencyPair());
							return MapperS.of(CashSettlementTerms.builder()
								.setValuationMethod(ValuationMethod.builder()
									.setValuationSource(ValuationSource.builder()
										.setQuotedCurrencyPairValue(_thenArg
											.mapSingleToItem(_item -> MapperS.of(cdm.observable.asset.QuotedCurrencyPair.builder()
												.setCurrency1(mapCurrency.evaluate(_item.<Currency>map("getCurrency1", quotedCurrencyPair -> quotedCurrencyPair.getCurrency1()).get()))
												.setCurrency2(mapCurrency.evaluate(_item.<Currency>map("getCurrency2", quotedCurrencyPair -> quotedCurrencyPair.getCurrency2()).get()))
												.setQuoteBasis(_item.<QuoteBasisEnum>map("getQuoteBasis", quotedCurrencyPair -> quotedCurrencyPair.getQuoteBasis()).checkedMap("to-enum", e -> cdm.observable.asset.QuoteBasisEnum.valueOf(e.name()), IllegalArgumentException.class).get())
												.build())).get())
										.setInformationSource(FxSpotRateSource.builder()
											.setPrimarySource(mapInformationSource.evaluate(item.<fpml.consolidated.shared.FxSpotRateSource>map("getFxSpotRateSource", fxFixing -> fxFixing.getFxSpotRateSource()).<InformationSource>map("getPrimaryRateSource", fxSpotRateSource -> fxSpotRateSource.getPrimaryRateSource()).get()))
											.build())
										.build())
									.build())
								.setValuationDate(ValuationDate.builder()
									.setFxFixingDate(FxFixingDate.builder()
										.setPeriod(null)
										.setPeriodMultiplier(null)
										.setFxFixingDate(AdjustableOrRelativeDate.builder()
											.setAdjustableDate(AdjustableDate.builder()
												.setAdjustedDateValue(item.<ZonedDateTime>map("getFixingDate", fxFixing -> fxFixing.getFixingDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
												.build())
											.build())
										.build())
									.build())
								.setValuationTime(mapBusinessCenterTime.evaluate(item.<fpml.consolidated.shared.FxSpotRateSource>map("getFxSpotRateSource", fxFixing -> fxFixing.getFxSpotRateSource()).<BusinessCenterTime>map("getFixingTime", fxSpotRateSource -> fxSpotRateSource.getFixingTime()).get()))
								.build());
						}).getMulti())
					.build());
			} else {
				settlementTerms = null;
			}
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<ZonedDateTime> EuropeanExercise(FxOption fpmlFxOption) {
			return MapperS.of(fpmlFxOption).<FxEuropeanExercise>map("getEuropeanExercise", fxOption -> fxOption.getEuropeanExercise()).<ZonedDateTime>map("getValueDate", fxEuropeanExercise -> fxEuropeanExercise.getValueDate());
		}
		
		@Override
		protected MapperS<ZonedDateTime> AmericanExercise(FxOption fpmlFxOption) {
			return MapperS.of(fpmlFxOption).<FxAmericanExercise>map("getAmericanExercise", fxOption -> fxOption.getAmericanExercise()).<ZonedDateTime>map("getLatestValueDate", fxAmericanExercise -> fxAmericanExercise.getLatestValueDate());
		}
		
		@Override
		protected MapperS<ZonedDateTime> settlementDate(FxOption fpmlFxOption) {
			if (exists(EuropeanExercise(fpmlFxOption)).getOrDefault(false)) {
				return EuropeanExercise(fpmlFxOption);
			}
			if (exists(AmericanExercise(fpmlFxOption)).getOrDefault(false)) {
				return AmericanExercise(fpmlFxOption);
			}
			return MapperS.<ZonedDateTime>ofNull();
		}
		
		@Override
		protected MapperS<SettlementTypeEnum> settlementType(FxOption fpmlFxOption) {
			if (exists(MapperS.of(fpmlFxOption).<FxCashSettlement>map("getCashSettlement", fxOption -> fxOption.getCashSettlement())).getOrDefault(false)) {
				return MapperS.of(SettlementTypeEnum.CASH);
			}
			return MapperS.<SettlementTypeEnum>ofNull();
		}
	}
}
