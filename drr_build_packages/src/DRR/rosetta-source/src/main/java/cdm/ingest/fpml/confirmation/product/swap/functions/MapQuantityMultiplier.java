package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.common.functions.MapFxSpotRateSource;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenterTime;
import cdm.ingest.fpml.confirmation.datetime.functions.MapRelativeDateOffset;
import cdm.product.common.settlement.QuantityMultiplier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.Calculation;
import fpml.consolidated.ird.FxLinkedNotionalSchedule;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapQuantityMultiplier.MapQuantityMultiplierDefault.class)
public abstract class MapQuantityMultiplier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapFxSpotRateSource mapFxSpotRateSource;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;

	/**
	* @param fpmlCalculation 
	* @return quantityMultiplier 
	*/
	public QuantityMultiplier evaluate(Calculation fpmlCalculation) {
		QuantityMultiplier.QuantityMultiplierBuilder quantityMultiplierBuilder = doEvaluate(fpmlCalculation);
		
		final QuantityMultiplier quantityMultiplier;
		if (quantityMultiplierBuilder == null) {
			quantityMultiplier = null;
		} else {
			quantityMultiplier = quantityMultiplierBuilder.build();
			objectValidator.validate(QuantityMultiplier.class, quantityMultiplier);
		}
		
		return quantityMultiplier;
	}

	protected abstract QuantityMultiplier.QuantityMultiplierBuilder doEvaluate(Calculation fpmlCalculation);

	public static class MapQuantityMultiplierDefault extends MapQuantityMultiplier {
		@Override
		protected QuantityMultiplier.QuantityMultiplierBuilder doEvaluate(Calculation fpmlCalculation) {
			QuantityMultiplier.QuantityMultiplierBuilder quantityMultiplier = QuantityMultiplier.builder();
			return assignOutput(quantityMultiplier, fpmlCalculation);
		}
		
		protected QuantityMultiplier.QuantityMultiplierBuilder assignOutput(QuantityMultiplier.QuantityMultiplierBuilder quantityMultiplier, Calculation fpmlCalculation) {
			final MapperS<FxLinkedNotionalSchedule> thenArg = MapperS.of(fpmlCalculation).<FxLinkedNotionalSchedule>map("getFxLinkedNotionalSchedule", calculation -> calculation.getFxLinkedNotionalSchedule());
			quantityMultiplier = toBuilder(QuantityMultiplier.builder()
				.setFxLinkedNotionalSchedule(thenArg
					.mapSingleToItem(item -> MapperS.of(cdm.product.common.schedule.FxLinkedNotionalSchedule.builder()
						.setVaryingNotionalCurrency(mapCurrency.evaluate(item.<Currency>map("getVaryingNotionalCurrency", fxLinkedNotionalSchedule -> fxLinkedNotionalSchedule.getVaryingNotionalCurrency()).get()))
						.setVaryingNotionalFixingDates(mapRelativeDateOffset.evaluate(item.<RelativeDateOffset>map("getVaryingNotionalFixingDates", fxLinkedNotionalSchedule -> fxLinkedNotionalSchedule.getVaryingNotionalFixingDates()).get()))
						.setFxSpotRateSource(mapFxSpotRateSource.evaluate(item.<FxSpotRateSource>map("getFxSpotRateSource", fxLinkedNotionalSchedule -> fxLinkedNotionalSchedule.getFxSpotRateSource()).get()))
						.setVaryingNotionalInterimExchangePaymentDates(mapRelativeDateOffset.evaluate(item.<RelativeDateOffset>map("getVaryingNotionalInterimExchangePaymentDates", fxLinkedNotionalSchedule -> fxLinkedNotionalSchedule.getVaryingNotionalInterimExchangePaymentDates()).get()))
						.setFixingTime(mapBusinessCenterTime.evaluate(item.<FxSpotRateSource>map("getFxSpotRateSource", fxLinkedNotionalSchedule -> fxLinkedNotionalSchedule.getFxSpotRateSource()).<BusinessCenterTime>map("getFixingTime", fxSpotRateSource -> fxSpotRateSource.getFixingTime()).get()))
						.build())).get())
				.build());
			
			return Optional.ofNullable(quantityMultiplier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
