package cdm.ingest.fpml.confirmation.product.equityforward.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eqd.EquityForward;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityForwardNonTransferableProduct.MapEquityForwardNonTransferableProductDefault.class)
public abstract class MapEquityForwardNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEquityForwardEconomicTerms mapEquityForwardEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlEquityForward 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(EquityForward fpmlEquityForward, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlEquityForward, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(EquityForward fpmlEquityForward, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapEquityForwardNonTransferableProductDefault extends MapEquityForwardNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(EquityForward fpmlEquityForward, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlEquityForward, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, EquityForward fpmlEquityForward, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlEquityForward).<ProductId>mapC("getProductId", equityForward -> equityForward.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlEquityForward).<AssetClass>map("getPrimaryAssetClass", equityForward -> equityForward.getPrimaryAssetClass()).get(), MapperS.of(fpmlEquityForward).<AssetClass>mapC("getSecondaryAssetClass", equityForward -> equityForward.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlEquityForward).<ProductType>mapC("getProductType", equityForward -> equityForward.getProductType()).getMulti())))
				.setEconomicTerms(mapEquityForwardEconomicTerms.evaluate(fpmlEquityForward, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
