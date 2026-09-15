package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.InterestLeg;
import fpml.consolidated.eq.shared.ReturnLeg;
import fpml.consolidated.eq.shared.ReturnSwap;
import fpml.consolidated.shared.DirectionalLeg;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapReturnSwapPriceQuantityList.MapReturnSwapPriceQuantityListDefault.class)
public abstract class MapReturnSwapPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapInterestLegToPriceQuantity mapInterestLegToPriceQuantity;
	@Inject protected MapReturnLegToPriceQuantity mapReturnLegToPriceQuantity;

	/**
	* @param fpmlReturnSwap 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(ReturnSwap fpmlReturnSwap) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlReturnSwap);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(ReturnSwap fpmlReturnSwap);

	protected abstract MapperS<? extends ReturnLeg> returnLeg(ReturnSwap fpmlReturnSwap);

	public static class MapReturnSwapPriceQuantityListDefault extends MapReturnSwapPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(ReturnSwap fpmlReturnSwap) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlReturnSwap);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, ReturnSwap fpmlReturnSwap) {
			priceQuantityList.addAll(toBuilder(MapperS.of(fpmlReturnSwap).<DirectionalLeg>mapC("getReturnSwapLeg", returnSwap -> returnSwap.getReturnSwapLeg())
				.mapItem(item -> {
					final DirectionalLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<PriceQuantity>ofNull();
					}
					if (switchArgument instanceof InterestLeg) {
						final InterestLeg interestLeg = (InterestLeg) switchArgument;
						return MapperS.of(mapInterestLegToPriceQuantity.evaluate(interestLeg, returnLeg(fpmlReturnSwap).get()));
					}
					if (switchArgument instanceof ReturnLeg) {
						final ReturnLeg _returnLeg = (ReturnLeg) switchArgument;
						return MapperS.of(mapReturnLegToPriceQuantity.evaluate(_returnLeg));
					}
					return MapperS.<PriceQuantity>ofNull();
				}).getMulti()));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReturnLeg> returnLeg(ReturnSwap fpmlReturnSwap) {
			final MapperC<ReturnLeg> thenArg = MapperS.of(fpmlReturnSwap).<DirectionalLeg>mapC("getReturnSwapLeg", returnSwap -> returnSwap.getReturnSwapLeg())
				.mapItem(item -> {
					final DirectionalLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<ReturnLeg>ofNull();
					}
					if (switchArgument instanceof ReturnLeg) {
						final ReturnLeg _returnLeg = (ReturnLeg) switchArgument;
						return MapperS.of(_returnLeg);
					}
					return MapperS.<ReturnLeg>ofNull();
				});
			return MapperS.of(thenArg.get());
		}
	}
}
