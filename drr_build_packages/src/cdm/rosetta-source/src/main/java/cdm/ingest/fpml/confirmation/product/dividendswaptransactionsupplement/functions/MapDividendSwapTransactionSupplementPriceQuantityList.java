package cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions;

import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.dividend.swaps.DividendLeg;
import fpml.consolidated.dividend.swaps.DividendSwapTransactionSupplement;
import fpml.consolidated.dividend.swaps.FixedPaymentLeg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapDividendSwapTransactionSupplementPriceQuantityList.MapDividendSwapTransactionSupplementPriceQuantityListDefault.class)
public abstract class MapDividendSwapTransactionSupplementPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDividendLegToPriceQuantity mapDividendLegToPriceQuantity;
	@Inject protected MapFixedPaymentLegToPriceQuantity mapFixedPaymentLegToPriceQuantity;

	/**
	* @param fpmlDividendSwapTransactionSupplement 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlDividendSwapTransactionSupplement);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement);

	public static class MapDividendSwapTransactionSupplementPriceQuantityListDefault extends MapDividendSwapTransactionSupplementPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlDividendSwapTransactionSupplement);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement) {
			final PriceQuantity priceQuantity0 = mapFixedPaymentLegToPriceQuantity.evaluate(MapperS.of(fpmlDividendSwapTransactionSupplement).<FixedPaymentLeg>map("getFixedLeg", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getFixedLeg()).get());
			if (priceQuantity0 == null) {
				priceQuantityList.addAll(toBuilder(Collections.<PriceQuantity>emptyList()));
			} else {
				priceQuantityList.addAll(toBuilder(Collections.singletonList(priceQuantity0)));
			}
			
			final PriceQuantity priceQuantity1 = mapDividendLegToPriceQuantity.evaluate(MapperS.of(fpmlDividendSwapTransactionSupplement).<DividendLeg>map("getDividendLeg", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getDividendLeg()).get());
			if (priceQuantity1 == null) {
				priceQuantityList.addAll(toBuilder(Collections.<PriceQuantity>emptyList()));
			} else {
				priceQuantityList.addAll(toBuilder(Collections.singletonList(priceQuantity1)));
			}
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
