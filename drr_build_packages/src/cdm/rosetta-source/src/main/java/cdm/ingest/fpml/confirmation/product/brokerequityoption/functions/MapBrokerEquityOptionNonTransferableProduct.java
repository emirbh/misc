package cdm.ingest.fpml.confirmation.product.brokerequityoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eqd.BrokerEquityOption;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBrokerEquityOptionNonTransferableProduct.MapBrokerEquityOptionNonTransferableProductDefault.class)
public abstract class MapBrokerEquityOptionNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBrokerEquityOptionEconomicTerms mapBrokerEquityOptionEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlBrokerEquityOption 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlBrokerEquityOption, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapBrokerEquityOptionNonTransferableProductDefault extends MapBrokerEquityOptionNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlBrokerEquityOption, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, BrokerEquityOption fpmlBrokerEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlBrokerEquityOption).<ProductId>mapC("getProductId", brokerEquityOption -> brokerEquityOption.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlBrokerEquityOption).<AssetClass>map("getPrimaryAssetClass", brokerEquityOption -> brokerEquityOption.getPrimaryAssetClass()).get(), MapperS.of(fpmlBrokerEquityOption).<AssetClass>mapC("getSecondaryAssetClass", brokerEquityOption -> brokerEquityOption.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlBrokerEquityOption).<ProductType>mapC("getProductType", brokerEquityOption -> brokerEquityOption.getProductType()).getMulti())))
				.setEconomicTerms(mapBrokerEquityOptionEconomicTerms.evaluate(fpmlBrokerEquityOption, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
