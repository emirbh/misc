package cdm.ingest.fpml.confirmation.product.genericproduct.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.generic.GenericProduct;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapGenericProductNonTransferableProduct.MapGenericProductNonTransferableProductDefault.class)
public abstract class MapGenericProductNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapGenericProductEconomicTerms mapGenericProductEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlGenericProduct 
	* @param cdmCounterpartyList 
	* @param fpmlpartyTradeInformationList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(GenericProduct fpmlGenericProduct, List<? extends Counterparty> cdmCounterpartyList, List<? extends PartyTradeInformation> fpmlpartyTradeInformationList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlGenericProduct, cdmCounterpartyList, fpmlpartyTradeInformationList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(GenericProduct fpmlGenericProduct, List<? extends Counterparty> cdmCounterpartyList, List<? extends PartyTradeInformation> fpmlpartyTradeInformationList);

	public static class MapGenericProductNonTransferableProductDefault extends MapGenericProductNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(GenericProduct fpmlGenericProduct, List<? extends Counterparty> cdmCounterpartyList, List<? extends PartyTradeInformation> fpmlpartyTradeInformationList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			if (fpmlpartyTradeInformationList == null) {
				fpmlpartyTradeInformationList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlGenericProduct, cdmCounterpartyList, fpmlpartyTradeInformationList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, GenericProduct fpmlGenericProduct, List<? extends Counterparty> cdmCounterpartyList, List<? extends PartyTradeInformation> fpmlpartyTradeInformationList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlGenericProduct).<ProductId>mapC("getProductId", genericProduct -> genericProduct.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlGenericProduct).<AssetClass>map("getPrimaryAssetClass", genericProduct -> genericProduct.getPrimaryAssetClass()).get(), MapperS.of(fpmlGenericProduct).<AssetClass>mapC("getSecondaryAssetClass", genericProduct -> genericProduct.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlGenericProduct).<ProductType>mapC("getProductType", genericProduct -> genericProduct.getProductType()).getMulti())))
				.setEconomicTerms(mapGenericProductEconomicTerms.evaluate(fpmlGenericProduct, cdmCounterpartyList, fpmlpartyTradeInformationList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
