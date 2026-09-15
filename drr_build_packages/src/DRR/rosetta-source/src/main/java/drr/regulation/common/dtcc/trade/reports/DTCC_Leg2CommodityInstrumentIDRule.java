package drr.regulation.common.dtcc.trade.reports;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.CommodityLeg2;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_Leg2CommodityInstrumentIDRule.DTCC_Leg2CommodityInstrumentIDRuleDefault.class)
public abstract class DTCC_Leg2CommodityInstrumentIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityLeg2 commodityLeg2;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class DTCC_Leg2CommodityInstrumentIDRuleDefault extends DTCC_Leg2CommodityInstrumentIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			final MapperS<Commodity> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					final Boolean _boolean = qualify_Commodity_Swaption.evaluate(economicTermsForProduct.evaluate(item.get()));
					if ((_boolean == null ? false : _boolean)) {
						return MapperS.of(commodityLeg2.evaluate(MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get())).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTermsForProduct.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTermsForProduct.evaluate(item.get()))))).getOrDefault(false)) {
						return MapperS.of(commodityLeg2.evaluate(item.get())).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
					}
					return MapperS.<Commodity>ofNull();
				});
			final MapperC<AssetIdentifier> thenArg2 = thenArg1
				.mapSingleToList(item -> item.<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()));
			final MapperC<AssetIdentifier> thenArg3 = thenArg2
				.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISDACRP), CardinalityOperator.All).get());
			final MapperS<AssetIdentifier> thenArg4 = MapperS.of(thenArg3.get());
			final FieldWithMetaString fieldWithMetaString = thenArg4
				.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
