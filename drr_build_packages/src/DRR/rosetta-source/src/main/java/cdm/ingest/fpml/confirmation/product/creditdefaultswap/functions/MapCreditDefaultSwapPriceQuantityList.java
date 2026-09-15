package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.cd.ProtectionTerms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCreditDefaultSwapPriceQuantityList.MapCreditDefaultSwapPriceQuantityListDefault.class)
public abstract class MapCreditDefaultSwapPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFeeLegToPriceQuantity mapFeeLegToPriceQuantity;
	@Inject protected MapProtectionTermsToPriceQuantity mapProtectionTermsToPriceQuantity;

	/**
	* @param fpmlCreditDefaultSwap 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(CreditDefaultSwap fpmlCreditDefaultSwap) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlCreditDefaultSwap);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap);

	public static class MapCreditDefaultSwapPriceQuantityListDefault extends MapCreditDefaultSwapPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlCreditDefaultSwap);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, CreditDefaultSwap fpmlCreditDefaultSwap) {
			final PriceQuantity priceQuantity0 = mapFeeLegToPriceQuantity.evaluate(MapperS.of(fpmlCreditDefaultSwap).<FeeLeg>map("getFeeLeg", creditDefaultSwap -> creditDefaultSwap.getFeeLeg()).get(), MapperS.of(fpmlCreditDefaultSwap).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultSwap -> creditDefaultSwap.getProtectionTerms()).getMulti());
			if (priceQuantity0 == null) {
				priceQuantityList.addAll(toBuilder(Collections.<PriceQuantity>emptyList()));
			} else {
				priceQuantityList.addAll(toBuilder(Collections.singletonList(priceQuantity0)));
			}
			
			final PriceQuantity priceQuantity1 = mapProtectionTermsToPriceQuantity.evaluate(MapperS.of(fpmlCreditDefaultSwap).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultSwap -> creditDefaultSwap.getProtectionTerms()).getMulti());
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
