package cdm.ingest.fpml.confirmation.product.commodityswaption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.product.commodityswap.functions.MapCommoditySwapEconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.com.CommodityLeg;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.IdentifiedCurrency;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapUnderlierNonTransferableProduct.MapUnderlierNonTransferableProductDefault.class)
public abstract class MapUnderlierNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommoditySwapEconomicTerms mapCommoditySwapEconomicTerms;

	/**
	* @param fpmlCommoditySwapLegList 
	* @param fpmlSettlementCurrency 
	* @param fpmlEffectiveDate 
	* @param fpmlTerminationDate 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(List<? extends CommodityLeg> fpmlCommoditySwapLegList, IdentifiedCurrency fpmlSettlementCurrency, AdjustableOrRelativeDate fpmlEffectiveDate, AdjustableOrRelativeDate fpmlTerminationDate, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlCommoditySwapLegList, fpmlSettlementCurrency, fpmlEffectiveDate, fpmlTerminationDate, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(List<? extends CommodityLeg> fpmlCommoditySwapLegList, IdentifiedCurrency fpmlSettlementCurrency, AdjustableOrRelativeDate fpmlEffectiveDate, AdjustableOrRelativeDate fpmlTerminationDate, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapUnderlierNonTransferableProductDefault extends MapUnderlierNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(List<? extends CommodityLeg> fpmlCommoditySwapLegList, IdentifiedCurrency fpmlSettlementCurrency, AdjustableOrRelativeDate fpmlEffectiveDate, AdjustableOrRelativeDate fpmlTerminationDate, List<? extends Counterparty> cdmCounterpartyList) {
			if (fpmlCommoditySwapLegList == null) {
				fpmlCommoditySwapLegList = Collections.emptyList();
			}
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlCommoditySwapLegList, fpmlSettlementCurrency, fpmlEffectiveDate, fpmlTerminationDate, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, List<? extends CommodityLeg> fpmlCommoditySwapLegList, IdentifiedCurrency fpmlSettlementCurrency, AdjustableOrRelativeDate fpmlEffectiveDate, AdjustableOrRelativeDate fpmlTerminationDate, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setEconomicTerms(mapCommoditySwapEconomicTerms.evaluate(fpmlCommoditySwapLegList, fpmlSettlementCurrency, fpmlEffectiveDate, fpmlTerminationDate, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
