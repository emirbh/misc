package cdm.ingest.fpml.confirmation.product.fxsingleleg.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxSingleLeg;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxSingleLegNonTransferableProduct.MapFxSingleLegNonTransferableProductDefault.class)
public abstract class MapFxSingleLegNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxSingleLegEconomicTerms mapFxSingleLegEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlFxSingleLeg 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(FxSingleLeg fpmlFxSingleLeg, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlFxSingleLeg, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(FxSingleLeg fpmlFxSingleLeg, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxSingleLegNonTransferableProductDefault extends MapFxSingleLegNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(FxSingleLeg fpmlFxSingleLeg, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlFxSingleLeg, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, FxSingleLeg fpmlFxSingleLeg, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlFxSingleLeg).<ProductId>mapC("getProductId", fxSingleLeg -> fxSingleLeg.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlFxSingleLeg).<AssetClass>map("getPrimaryAssetClass", fxSingleLeg -> fxSingleLeg.getPrimaryAssetClass()).get(), MapperS.of(fpmlFxSingleLeg).<AssetClass>mapC("getSecondaryAssetClass", fxSingleLeg -> fxSingleLeg.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlFxSingleLeg).<ProductType>mapC("getProductType", fxSingleLeg -> fxSingleLeg.getProductType()).getMulti())))
				.setEconomicTerms(mapFxSingleLegEconomicTerms.evaluate(fpmlFxSingleLeg, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
