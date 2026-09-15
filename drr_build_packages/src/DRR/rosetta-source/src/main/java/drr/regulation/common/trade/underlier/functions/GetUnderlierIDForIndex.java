package drr.regulation.common.trade.underlier.functions;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.util.IndexDeepPathUtil;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetUnderlierIDForIndex.GetUnderlierIDForIndexDefault.class)
public abstract class GetUnderlierIDForIndex implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IndexDeepPathUtil indexDeepPathUtil;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param product 
	* @return indexId 
	*/
	public List<String> evaluate(NonTransferableProduct product) {
		List<String> indexId = doEvaluate(product);
		
		return indexId;
	}

	protected abstract List<String> doEvaluate(NonTransferableProduct product);

	public static class GetUnderlierIDForIndexDefault extends GetUnderlierIDForIndex {
		@Override
		protected List<String> doEvaluate(NonTransferableProduct product) {
			List<String> indexId = new ArrayList<>();
			return assignOutput(indexId, product);
		}
		
		protected List<String> assignOutput(List<String> indexId, NonTransferableProduct product) {
			if (exists(MapperS.of(underlierForProduct.evaluate(product)).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Index>map("getIndex", observable -> observable.getIndex())).getOrDefault(false)) {
				indexId.addAll(MapperS.of(underlierForProduct.evaluate(product)).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetIdentifier>mapC("chooseIdentifier", index -> indexDeepPathUtil.chooseIdentifier(index)).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()).getMulti());
			} else if (exists(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation())).getOrDefault(false)) {
				indexId.addAll(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<AssetIdentifier>mapC("getIdentifier", creditIndex -> creditIndex.getIdentifier()).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()).getMulti());
			} else if (exists(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation())).getOrDefault(false)) {
				indexId.addAll(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<AssetIdentifier>mapC("getIdentifier", creditIndex -> creditIndex.getIdentifier()).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()).getMulti());
			} else {
				indexId.addAll(Collections.<String>emptyList());
			}
			
			return indexId;
		}
	}
}
