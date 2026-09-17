package cdm.ingest.fpml.confirmation.product.commodityoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityOption;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityOptionNonTransferableProduct.MapCommodityOptionNonTransferableProductDefault.class)
public abstract class MapCommodityOptionNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityOptionEconomicTerms mapCommodityOptionEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlCommodityOption 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlCommodityOption, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCommodityOptionNonTransferableProductDefault extends MapCommodityOptionNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlCommodityOption, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlCommodityOption).<ProductId>mapC("getProductId", commodityOption -> commodityOption.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlCommodityOption).<AssetClass>map("getPrimaryAssetClass", commodityOption -> commodityOption.getPrimaryAssetClass()).get(), MapperS.of(fpmlCommodityOption).<AssetClass>mapC("getSecondaryAssetClass", commodityOption -> commodityOption.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlCommodityOption).<ProductType>mapC("getProductType", commodityOption -> commodityOption.getProductType()).getMulti())))
				.setEconomicTerms(mapCommodityOptionEconomicTerms.evaluate(fpmlCommodityOption, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
