package drr.base.qualification.product.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.util.IndexDeepPathUtil;
import cdm.product.asset.CommodityPayout;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsCommoditySwap_SingleIndex.IsCommoditySwap_SingleIndexDefault.class)
public abstract class IsCommoditySwap_SingleIndex implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IndexDeepPathUtil indexDeepPathUtil;
	@Inject protected IsCommoditySwap isCommoditySwap;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product);

	protected abstract MapperC<? extends Underlier> commodityUnderlier(NonTransferableProduct product);

	public static class IsCommoditySwap_SingleIndexDefault extends IsCommoditySwap_SingleIndex {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(isCommoditySwap.evaluate(product)), MapperS.of(true), CardinalityOperator.All).andNullSafe(areEqual(economicTerms(product).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<SettlementTerms>map("getSettlementTerms", commodityPayout -> commodityPayout.getSettlementTerms()).<SettlementTypeEnum>map("getSettlementType", settlementTerms -> settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH), CardinalityOperator.All)).andNullSafe(areEqual(commodityUnderlier(product).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISDACRP), CardinalityOperator.All).orNullSafe(areEqual(commodityUnderlier(product).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetClassEnum>map("chooseAssetClass", index -> indexDeepPathUtil.chooseAssetClass(index)), MapperS.of(AssetClassEnum.COMMODITY), CardinalityOperator.Any))).get();
			
			return result;
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product));
		}
		
		@Override
		protected MapperC<? extends Underlier> commodityUnderlier(NonTransferableProduct product) {
			return economicTerms(product).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier());
		}
	}
}
