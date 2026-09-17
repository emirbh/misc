package cdm.ingest.fpml.confirmation.product.equityoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eqd.EquityOption;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityOptionNonTransferableProduct.MapEquityOptionNonTransferableProductDefault.class)
public abstract class MapEquityOptionNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEquityOptionEconomicTerms mapEquityOptionEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlEquityOption 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlEquityOption, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapEquityOptionNonTransferableProductDefault extends MapEquityOptionNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlEquityOption, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, EquityOption fpmlEquityOption, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlEquityOption).<ProductId>mapC("getProductId", equityOption -> equityOption.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlEquityOption).<AssetClass>map("getPrimaryAssetClass", equityOption -> equityOption.getPrimaryAssetClass()).get(), MapperS.of(fpmlEquityOption).<AssetClass>mapC("getSecondaryAssetClass", equityOption -> equityOption.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlEquityOption).<ProductType>mapC("getProductType", equityOption -> equityOption.getProductType()).getMulti())))
				.setEconomicTerms(mapEquityOptionEconomicTerms.evaluate(fpmlEquityOption, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
