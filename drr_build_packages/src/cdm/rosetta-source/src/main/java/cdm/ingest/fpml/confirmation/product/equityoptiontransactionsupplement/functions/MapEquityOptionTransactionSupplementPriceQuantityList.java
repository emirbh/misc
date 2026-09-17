package cdm.ingest.fpml.confirmation.product.equityoptiontransactionsupplement.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapEquityDerivativeBaseQuantityListWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eqd.EquityOptionTransactionSupplement;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapEquityOptionTransactionSupplementPriceQuantityList.MapEquityOptionTransactionSupplementPriceQuantityListDefault.class)
public abstract class MapEquityOptionTransactionSupplementPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEquityDerivativeBaseQuantityListWithLocation mapEquityDerivativeBaseQuantityListWithLocation;
	@Inject protected MapUnderlyerToObservableWithLocation mapUnderlyerToObservableWithLocation;

	/**
	* @param fpmlEquityOptionTransactionSupplement 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlEquityOptionTransactionSupplement);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement);

	public static class MapEquityOptionTransactionSupplementPriceQuantityListDefault extends MapEquityOptionTransactionSupplementPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlEquityOptionTransactionSupplement);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement) {
			final PriceQuantity priceQuantity = PriceQuantity.builder()
				.setQuantity(new ArrayList(mapEquityDerivativeBaseQuantityListWithLocation.evaluate(fpmlEquityOptionTransactionSupplement, MapperS.of(fpmlEquityOptionTransactionSupplement).<BigDecimal>map("getNumberOfOptions", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getNumberOfOptions()).get(), MapperS.of(fpmlEquityOptionTransactionSupplement).<BigDecimal>map("getOptionEntitlement", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getOptionEntitlement()).get(), null)))
				.setObservable(mapUnderlyerToObservableWithLocation.evaluate(MapperS.of(fpmlEquityOptionTransactionSupplement).<Underlyer>map("getUnderlyer", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getUnderlyer()).get()))
				.build();
			if (priceQuantity == null) {
				priceQuantityList.addAll(toBuilder(Collections.<PriceQuantity>emptyList()));
			} else {
				priceQuantityList.addAll(toBuilder(Collections.singletonList(priceQuantity)));
			}
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
