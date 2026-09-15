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
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsCommodityForward_SingleIndex.IsCommodityForward_SingleIndexDefault.class)
public abstract class IsCommodityForward_SingleIndex implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IndexDeepPathUtil indexDeepPathUtil;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;

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

	protected abstract MapperS<? extends Underlier> forwardUnderlier(NonTransferableProduct product);

	public static class IsCommodityForward_SingleIndexDefault extends IsCommodityForward_SingleIndex {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(qualify_Commodity_Forward.evaluate(economicTerms(product).get())), MapperS.of(true), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(economicTerms(product).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).<SettlementTypeEnum>map("getSettlementType", settlementTerms -> settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(forwardUnderlier(product).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()).get()).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISDACRP), CardinalityOperator.All).orNullSafe(areEqual(forwardUnderlier(product).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetClassEnum>map("chooseAssetClass", index -> indexDeepPathUtil.chooseAssetClass(index)), MapperS.of(AssetClassEnum.COMMODITY), CardinalityOperator.All))).get();
			
			return result;
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product));
		}
		
		@Override
		protected MapperS<? extends Underlier> forwardUnderlier(NonTransferableProduct product) {
			return MapperS.of(economicTerms(product).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier());
		}
	}
}
