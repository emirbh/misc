package drr.regulation.common.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.metafields.ReferenceWithMetaResolvablePriceQuantity;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.EconomicTermsForProduct;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(InterestRateLeg1CrossCurrency.InterestRateLeg1CrossCurrencyDefault.class)
public abstract class InterestRateLeg1CrossCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;

	/**
	* @param product 
	* @return interestRateLeg1 
	*/
	public InterestRatePayout evaluate(NonTransferableProduct product) {
		InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1Builder = doEvaluate(product);
		
		final InterestRatePayout interestRateLeg1;
		if (interestRateLeg1Builder == null) {
			interestRateLeg1 = null;
		} else {
			interestRateLeg1 = interestRateLeg1Builder.build();
			objectValidator.validate(InterestRatePayout.class, interestRateLeg1);
		}
		
		return interestRateLeg1;
	}

	protected abstract InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product);

	protected abstract MapperC<? extends InterestRatePayout> InterestRatePayouts(NonTransferableProduct product);

	public static class InterestRateLeg1CrossCurrencyDefault extends InterestRateLeg1CrossCurrency {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(NonTransferableProduct product) {
			InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1 = InterestRatePayout.builder();
			return assignOutput(interestRateLeg1, product);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRateLeg1, NonTransferableProduct product) {
			if (exists(InterestRatePayouts(product).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule())).getOrDefault(false)) {
				interestRateLeg1 = toBuilder(InterestRatePayouts(product)
					.min(item -> item.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue())).get());
			} else if (exists(InterestRatePayouts(product).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaResolvablePriceQuantity>map("getQuantityReference", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantityReference())).getOrDefault(false)) {
				interestRateLeg1 = toBuilder(InterestRatePayouts(product)
					.min(item -> item.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaResolvablePriceQuantity>map("getQuantityReference", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantityReference()).<ResolvablePriceQuantity>map("Type coercion", referenceWithMetaResolvablePriceQuantity -> referenceWithMetaResolvablePriceQuantity == null ? null : referenceWithMetaResolvablePriceQuantity.getValue()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue())).get());
			} else {
				interestRateLeg1 = null;
			}
			
			return Optional.ofNullable(interestRateLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> InterestRatePayouts(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout());
		}
	}
}
