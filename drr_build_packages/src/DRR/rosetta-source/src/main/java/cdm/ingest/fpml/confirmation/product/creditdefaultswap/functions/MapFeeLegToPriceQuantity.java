package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFixedOrFloatingCalculationAmountToQuantityListWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapRateOptionToObservableWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CalculationAmount;
import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.cd.FixedAmountCalculation;
import fpml.consolidated.cd.FloatingAmountCalculation;
import fpml.consolidated.cd.PeriodicPayment;
import fpml.consolidated.cd.ProtectionTerms;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Money;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFeeLegToPriceQuantity.MapFeeLegToPriceQuantityDefault.class)
public abstract class MapFeeLegToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFixedOrFloatingAmountCalculationToPriceListWithLocation mapFixedOrFloatingAmountCalculationToPriceListWithLocation;
	@Inject protected MapFixedOrFloatingCalculationAmountToQuantityListWithLocation mapFixedOrFloatingCalculationAmountToQuantityListWithLocation;
	@Inject protected MapRateOptionToObservableWithLocation mapRateOptionToObservableWithLocation;

	/**
	* @param fpmlFeeLeg 
	* @param fpmlProtectionTerms 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlFeeLeg, fpmlProtectionTerms);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms);

	public static class MapFeeLegToPriceQuantityDefault extends MapFeeLegToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms) {
			if (fpmlProtectionTerms == null) {
				fpmlProtectionTerms = Collections.emptyList();
			}
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlFeeLeg, fpmlProtectionTerms);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms) {
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setPrice(new ArrayList(mapFixedOrFloatingAmountCalculationToPriceListWithLocation.evaluate(MapperS.of(fpmlFeeLeg).<PeriodicPayment>map("getPeriodicPayment", feeLeg -> feeLeg.getPeriodicPayment()).<FixedAmountCalculation>map("getFixedAmountCalculation", periodicPayment -> periodicPayment.getFixedAmountCalculation()).get(), MapperS.of(fpmlFeeLeg).<PeriodicPayment>map("getPeriodicPayment", feeLeg -> feeLeg.getPeriodicPayment()).<FloatingAmountCalculation>map("getFloatingAmountCalculation", periodicPayment -> periodicPayment.getFloatingAmountCalculation()).get(), MapperC.<ProtectionTerms>of(fpmlProtectionTerms).<Money>map("getCalculationAmount", protectionTerms -> protectionTerms.getCalculationAmount()).<Currency>map("getCurrency", money -> money.getCurrency())
					.first().get(), fpmlFeeLeg)))
				.setQuantity(new ArrayList(mapFixedOrFloatingCalculationAmountToQuantityListWithLocation.evaluate(MapperS.of(fpmlFeeLeg).<PeriodicPayment>map("getPeriodicPayment", feeLeg -> feeLeg.getPeriodicPayment()).<FixedAmountCalculation>map("getFixedAmountCalculation", periodicPayment -> periodicPayment.getFixedAmountCalculation()).<CalculationAmount>map("getCalculationAmount", fixedAmountCalculation -> fixedAmountCalculation.getCalculationAmount()).get(), MapperS.of(fpmlFeeLeg).<PeriodicPayment>map("getPeriodicPayment", feeLeg -> feeLeg.getPeriodicPayment()).<FloatingAmountCalculation>map("getFloatingAmountCalculation", periodicPayment -> periodicPayment.getFloatingAmountCalculation()).<CalculationAmount>map("getCalculationAmount", floatingAmountCalculation -> floatingAmountCalculation.getCalculationAmount()).get(), fpmlFeeLeg)))
				.setObservable(mapRateOptionToObservableWithLocation.evaluate(MapperS.of(fpmlFeeLeg).<PeriodicPayment>map("getPeriodicPayment", feeLeg -> feeLeg.getPeriodicPayment()).<FloatingAmountCalculation>map("getFloatingAmountCalculation", periodicPayment -> periodicPayment.getFloatingAmountCalculation()).<FloatingRateCalculation>map("getFloatingRate", floatingAmountCalculation -> floatingAmountCalculation.getFloatingRate()).get(), fpmlFeeLeg))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
