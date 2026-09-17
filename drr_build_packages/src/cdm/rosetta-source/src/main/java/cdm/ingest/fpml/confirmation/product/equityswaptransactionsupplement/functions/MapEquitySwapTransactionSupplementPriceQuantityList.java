package cdm.ingest.fpml.confirmation.product.equityswaptransactionsupplement.functions;

import cdm.ingest.fpml.confirmation.product.returnswap.functions.MapInterestLegToPriceQuantity;
import cdm.ingest.fpml.confirmation.product.returnswap.functions.MapReturnLegToPriceQuantity;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.InterestLeg;
import fpml.consolidated.eq.shared.ReturnLeg;
import fpml.consolidated.fpmlreturn.swaps.EquitySwapTransactionSupplement;
import fpml.consolidated.shared.DirectionalLeg;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapEquitySwapTransactionSupplementPriceQuantityList.MapEquitySwapTransactionSupplementPriceQuantityListDefault.class)
public abstract class MapEquitySwapTransactionSupplementPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapInterestLegToPriceQuantity mapInterestLegToPriceQuantity;
	@Inject protected MapReturnLegToPriceQuantity mapReturnLegToPriceQuantity;

	/**
	* @param fpmlEquitySwapTransactionSupplement 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlEquitySwapTransactionSupplement);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement);

	protected abstract MapperS<? extends ReturnLeg> returnLeg(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement);

	public static class MapEquitySwapTransactionSupplementPriceQuantityListDefault extends MapEquitySwapTransactionSupplementPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlEquitySwapTransactionSupplement);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement) {
			priceQuantityList.addAll(toBuilder(MapperS.of(fpmlEquitySwapTransactionSupplement).<DirectionalLeg>mapC("getReturnSwapLeg", equitySwapTransactionSupplement -> equitySwapTransactionSupplement.getReturnSwapLeg())
				.mapItem(item -> {
					final DirectionalLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<PriceQuantity>ofNull();
					}
					if (switchArgument instanceof InterestLeg) {
						final InterestLeg interestLeg = (InterestLeg) switchArgument;
						return MapperS.of(mapInterestLegToPriceQuantity.evaluate(interestLeg, returnLeg(fpmlEquitySwapTransactionSupplement).get()));
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
		protected MapperS<? extends ReturnLeg> returnLeg(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement) {
			final MapperC<ReturnLeg> thenArg = MapperS.of(fpmlEquitySwapTransactionSupplement).<DirectionalLeg>mapC("getReturnSwapLeg", equitySwapTransactionSupplement -> equitySwapTransactionSupplement.getReturnSwapLeg())
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
