package cdm.ingest.fpml.confirmation.product.commodityswaption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommoditySwaption;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommoditySwaptionNonTransferableProduct.MapCommoditySwaptionNonTransferableProductDefault.class)
public abstract class MapCommoditySwaptionNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommoditySwaptionEconomicTerms mapCommoditySwaptionEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlCommoditySwaption 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(CommoditySwaption fpmlCommoditySwaption, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlCommoditySwaption, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CommoditySwaption fpmlCommoditySwaption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCommoditySwaptionNonTransferableProductDefault extends MapCommoditySwaptionNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CommoditySwaption fpmlCommoditySwaption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlCommoditySwaption, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, CommoditySwaption fpmlCommoditySwaption, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlCommoditySwaption).<ProductId>mapC("getProductId", commoditySwaption -> commoditySwaption.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlCommoditySwaption).<AssetClass>map("getPrimaryAssetClass", commoditySwaption -> commoditySwaption.getPrimaryAssetClass()).get(), MapperS.of(fpmlCommoditySwaption).<AssetClass>mapC("getSecondaryAssetClass", commoditySwaption -> commoditySwaption.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlCommoditySwaption).<ProductType>mapC("getProductType", commoditySwaption -> commoditySwaption.getProductType()).getMulti())))
				.setEconomicTerms(mapCommoditySwaptionEconomicTerms.evaluate(fpmlCommoditySwaption, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
