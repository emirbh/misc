package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.ingest.fpml.confirmation.datetime.functions.MapPeriod;
import cdm.observable.asset.InterpolationMethodEnum;
import cdm.product.template.OptionStrike;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.bond.option.MakeWholeAmount;
import fpml.consolidated.bond.option.ReferenceSwapCurve;
import fpml.consolidated.bond.option.SwapCurveValuation;
import fpml.consolidated.fpmlenum.QuotationSideEnum;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.InterpolationMethod;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOptionStrikeReferenceSwapCurve.MapOptionStrikeReferenceSwapCurveDefault.class)
public abstract class MapOptionStrikeReferenceSwapCurve implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriod mapPeriod;

	/**
	* @param fpmlReferenceSwapCurve 
	* @return referenceSwapCurve 
	*/
	public OptionStrike evaluate(ReferenceSwapCurve fpmlReferenceSwapCurve) {
		OptionStrike.OptionStrikeBuilder referenceSwapCurveBuilder = doEvaluate(fpmlReferenceSwapCurve);
		
		final OptionStrike referenceSwapCurve;
		if (referenceSwapCurveBuilder == null) {
			referenceSwapCurve = null;
		} else {
			referenceSwapCurve = referenceSwapCurveBuilder.build();
			objectValidator.validate(OptionStrike.class, referenceSwapCurve);
		}
		
		return referenceSwapCurve;
	}

	protected abstract OptionStrike.OptionStrikeBuilder doEvaluate(ReferenceSwapCurve fpmlReferenceSwapCurve);

	public static class MapOptionStrikeReferenceSwapCurveDefault extends MapOptionStrikeReferenceSwapCurve {
		@Override
		protected OptionStrike.OptionStrikeBuilder doEvaluate(ReferenceSwapCurve fpmlReferenceSwapCurve) {
			OptionStrike.OptionStrikeBuilder referenceSwapCurve = OptionStrike.builder();
			return assignOutput(referenceSwapCurve, fpmlReferenceSwapCurve);
		}
		
		protected OptionStrike.OptionStrikeBuilder assignOutput(OptionStrike.OptionStrikeBuilder referenceSwapCurve, ReferenceSwapCurve fpmlReferenceSwapCurve) {
			final MapperS<SwapCurveValuation> thenArg0 = MapperS.of(fpmlReferenceSwapCurve).<SwapCurveValuation>map("getSwapUnwindValue", _referenceSwapCurve -> _referenceSwapCurve.getSwapUnwindValue());
			final MapperS<MakeWholeAmount> thenArg1 = MapperS.of(fpmlReferenceSwapCurve).<MakeWholeAmount>map("getMakeWholeAmount", _referenceSwapCurve -> _referenceSwapCurve.getMakeWholeAmount());
			referenceSwapCurve = toBuilder(OptionStrike.builder()
				.setReferenceSwapCurve(cdm.observable.asset.ReferenceSwapCurve.builder()
					.setSwapUnwindValue(thenArg0
						.mapSingleToItem(item -> MapperS.of(cdm.observable.asset.SwapCurveValuation.builder()
							.setFloatingRateIndex(item.<FloatingRateIndex>map("getFloatingRateIndex", swapCurveValuation -> swapCurveValuation.getFloatingRateIndex()).<String>map("getValue", floatingRateIndex -> floatingRateIndex.getValue()).checkedMap("to-enum", FloatingRateIndexEnum::fromDisplayName, IllegalArgumentException.class).get())
							.setIndexTenor(mapPeriod.evaluate(item.<Period>map("getIndexTenor", swapCurveValuation -> swapCurveValuation.getIndexTenor()).get()))
							.setSpread(item.<BigDecimal>map("getSpread", swapCurveValuation -> swapCurveValuation.getSpread()).get())
							.setSide(item.<QuotationSideEnum>map("getSide", swapCurveValuation -> swapCurveValuation.getSide()).checkedMap("to-enum", e -> cdm.observable.asset.QuotationSideEnum.valueOf(e.name()), IllegalArgumentException.class).get())
							.build())).get())
					.setMakeWholeAmount(thenArg1
						.mapSingleToItem(item -> MapperS.of(cdm.observable.asset.MakeWholeAmount.builder()
							.setFloatingRateIndex(item.<FloatingRateIndex>map("getFloatingRateIndex", makeWholeAmount -> makeWholeAmount.getFloatingRateIndex()).<String>map("getValue", floatingRateIndex -> floatingRateIndex.getValue()).checkedMap("to-enum", FloatingRateIndexEnum::fromDisplayName, IllegalArgumentException.class).get())
							.setIndexTenor(mapPeriod.evaluate(item.<Period>map("getIndexTenor", makeWholeAmount -> makeWholeAmount.getIndexTenor()).get()))
							.setSpread(item.<BigDecimal>map("getSpread", makeWholeAmount -> makeWholeAmount.getSpread()).get())
							.setSide(item.<QuotationSideEnum>map("getSide", makeWholeAmount -> makeWholeAmount.getSide()).checkedMap("to-enum", e -> cdm.observable.asset.QuotationSideEnum.valueOf(e.name()), IllegalArgumentException.class).get())
							.setInterpolationMethod(item.<InterpolationMethod>map("getInterpolationMethod", makeWholeAmount -> makeWholeAmount.getInterpolationMethod()).<String>map("getValue", interpolationMethod -> interpolationMethod.getValue()).checkedMap("to-enum", InterpolationMethodEnum::fromDisplayName, IllegalArgumentException.class).get())
							.setEarlyCallDateValue(item.<IdentifiedDate>map("getEarlyCallDate", makeWholeAmount -> makeWholeAmount.getEarlyCallDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
							.build())).get())
					.build())
				.build());
			
			return Optional.ofNullable(referenceSwapCurve)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
