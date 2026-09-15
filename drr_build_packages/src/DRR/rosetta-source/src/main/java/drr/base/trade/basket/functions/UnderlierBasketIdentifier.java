package drr.base.trade.basket.functions;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.observable.asset.Basket;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import javax.inject.Inject;


@ImplementedBy(UnderlierBasketIdentifier.UnderlierBasketIdentifierDefault.class)
public abstract class UnderlierBasketIdentifier implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CreditBasketIdentifier creditBasketIdentifier;

	/**
	* @param underlier 
	* @return identifier 
	*/
	public String evaluate(Underlier underlier) {
		String identifier = doEvaluate(underlier);
		
		return identifier;
	}

	protected abstract String doEvaluate(Underlier underlier);

	public static class UnderlierBasketIdentifierDefault extends UnderlierBasketIdentifier {
		@Override
		protected String doEvaluate(Underlier underlier) {
			String identifier = null;
			return assignOutput(identifier, underlier);
		}
		
		protected String assignOutput(String identifier, Underlier underlier) {
			final MapperS<Underlier> switchArgument = MapperS.of(underlier);
			if (switchArgument.get() == null) {
				identifier = null;
			} else if (switchArgument.<ReferenceWithMetaObservable>map("getObservable", _underlier -> _underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).get() != null) {
				final MapperS<Basket> basket = switchArgument.<ReferenceWithMetaObservable>map("getObservable", _underlier -> _underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Basket>map("getBasket", observable -> observable.getBasket());
				final FieldWithMetaString fieldWithMetaString = basket.<AssetIdentifier>mapC("getIdentifier", _basket -> _basket.getIdentifier()).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())
					.first().get();
				if (fieldWithMetaString == null) {
					identifier = null;
				} else {
					identifier = fieldWithMetaString.getValue();
				}
			} else if (switchArgument.<Product>map("getProduct", _underlier -> _underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get() != null) {
				final MapperS<NonTransferableProduct> nonTransferableProduct = switchArgument.<Product>map("getProduct", _underlier -> _underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct());
				identifier = creditBasketIdentifier.evaluate(nonTransferableProduct.<EconomicTerms>map("getEconomicTerms", _nonTransferableProduct -> _nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).get());
			} else {
				identifier = null;
			}
			
			return identifier;
		}
	}
}
