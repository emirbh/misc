package cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions;

import cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions.MapFeeLegToPriceQuantity;
import cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions.MapProtectionTermsToPriceQuantity;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.cd.ProtectionTerms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCreditDefaultSwapOptionPriceQuantityList.MapCreditDefaultSwapOptionPriceQuantityListDefault.class)
public abstract class MapCreditDefaultSwapOptionPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFeeLegToPriceQuantity mapFeeLegToPriceQuantity;
	@Inject protected MapProtectionTermsToPriceQuantity mapProtectionTermsToPriceQuantity;

	/**
	* @param fpmlCreditDefaultSwapOption 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlCreditDefaultSwapOption);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption);

	public static class MapCreditDefaultSwapOptionPriceQuantityListDefault extends MapCreditDefaultSwapOptionPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlCreditDefaultSwapOption);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, CreditDefaultSwapOption fpmlCreditDefaultSwapOption) {
			final PriceQuantity priceQuantity0 = mapFeeLegToPriceQuantity.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<CreditDefaultSwap>map("getCreditDefaultSwap", creditDefaultSwapOption -> creditDefaultSwapOption.getCreditDefaultSwap()).<FeeLeg>map("getFeeLeg", creditDefaultSwap -> creditDefaultSwap.getFeeLeg()).get(), MapperS.of(fpmlCreditDefaultSwapOption).<CreditDefaultSwap>map("getCreditDefaultSwap", creditDefaultSwapOption -> creditDefaultSwapOption.getCreditDefaultSwap()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultSwap -> creditDefaultSwap.getProtectionTerms()).getMulti());
			if (priceQuantity0 == null) {
				priceQuantityList.addAll(toBuilder(Collections.<PriceQuantity>emptyList()));
			} else {
				priceQuantityList.addAll(toBuilder(Collections.singletonList(priceQuantity0)));
			}
			
			final PriceQuantity priceQuantity1 = mapProtectionTermsToPriceQuantity.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<CreditDefaultSwap>map("getCreditDefaultSwap", creditDefaultSwapOption -> creditDefaultSwapOption.getCreditDefaultSwap()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultSwap -> creditDefaultSwap.getProtectionTerms()).getMulti());
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
