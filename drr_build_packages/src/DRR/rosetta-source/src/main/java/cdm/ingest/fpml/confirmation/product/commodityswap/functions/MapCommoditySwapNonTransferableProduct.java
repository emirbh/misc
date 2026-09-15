package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityLeg;
import fpml.consolidated.com.CommoditySwap;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommoditySwapNonTransferableProduct.MapCommoditySwapNonTransferableProductDefault.class)
public abstract class MapCommoditySwapNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommoditySwapEconomicTerms mapCommoditySwapEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlCommoditySwap 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(CommoditySwap fpmlCommoditySwap, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlCommoditySwap, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CommoditySwap fpmlCommoditySwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCommoditySwapNonTransferableProductDefault extends MapCommoditySwapNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CommoditySwap fpmlCommoditySwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlCommoditySwap, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, CommoditySwap fpmlCommoditySwap, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlCommoditySwap).<ProductId>mapC("getProductId", commoditySwap -> commoditySwap.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlCommoditySwap).<AssetClass>map("getPrimaryAssetClass", commoditySwap -> commoditySwap.getPrimaryAssetClass()).get(), MapperS.of(fpmlCommoditySwap).<AssetClass>mapC("getSecondaryAssetClass", commoditySwap -> commoditySwap.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlCommoditySwap).<ProductType>mapC("getProductType", commoditySwap -> commoditySwap.getProductType()).getMulti())))
				.setEconomicTerms(mapCommoditySwapEconomicTerms.evaluate(MapperS.of(fpmlCommoditySwap).<CommodityLeg>mapC("getCommoditySwapLeg", commoditySwap -> commoditySwap.getCommoditySwapLeg()).getMulti(), MapperS.of(fpmlCommoditySwap).<IdentifiedCurrency>map("getSettlementCurrency", commoditySwap -> commoditySwap.getSettlementCurrency()).get(), MapperS.of(fpmlCommoditySwap).<AdjustableOrRelativeDate>map("getEffectiveDate", commoditySwap -> commoditySwap.getEffectiveDate()).get(), MapperS.of(fpmlCommoditySwap).<AdjustableOrRelativeDate>map("getTerminationDate", commoditySwap -> commoditySwap.getTerminationDate()).get(), cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
