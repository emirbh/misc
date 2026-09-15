package drr.regulation.common.emir.reports;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.CommodityLocationIdentifierTypeEnum;
import cdm.base.staticdata.identifier.LocationIdentifier;
import cdm.event.common.Trade;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.asset.CommodityPayout;
import cdm.product.qualification.functions.Qualify_Commodity_Option;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(InterconnectionPointRule.InterconnectionPointRuleDefault.class)
public abstract class InterconnectionPointRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected Qualify_Commodity_Option qualify_Commodity_Option;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;
	@Inject protected TradeForEvent tradeForEvent;

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

	public static class InterconnectionPointRuleDefault extends InterconnectionPointRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<Trade> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(tradeForEvent.evaluate(item.get())));
			final MapperS<NonTransferableProduct> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(productForTrade.evaluate(item.get())));
			final MapperS<EconomicTerms> thenArg2 = thenArg1
				.mapSingleToItem(item -> MapperS.of(economicTermsForProduct.evaluate(item.get())));
			final MapperS<AssetDeliveryInformation> thenArg3 = thenArg2
				.mapSingleToItem(item -> {
					if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(item.get())))).getOrDefault(false)) {
						return item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<AssetDeliveryInformation>map("getDelivery", commodityPayout -> commodityPayout.getDelivery())
							.first();
					}
					final Boolean boolean0 = qualify_Commodity_Swaption.evaluate(item.get());
					if ((boolean0 == null ? false : boolean0)) {
						return MapperS.of(economicTermsForProduct.evaluate(item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<AssetDeliveryInformation>map("getDelivery", commodityPayout -> commodityPayout.getDelivery())
							.first();
					}
					final Boolean boolean1 = qualify_Commodity_Option.evaluate(item.get());
					if ((boolean1 == null ? false : boolean1)) {
						return MapperS.of(item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<AssetDeliveryInformation>map("getDelivery", optionPayout -> optionPayout.getDelivery()).get());
					}
					if (exists(item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity())).getOrDefault(false)) {
						return MapperS.of(item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<AssetDeliveryInformation>map("getDelivery", settlementPayout -> settlementPayout.getDelivery()).get());
					}
					return MapperS.of(item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).get()).<AssetDeliveryInformation>map("getDelivery", commodityPayout -> commodityPayout.getDelivery());
				});
			final MapperC<LocationIdentifier> thenArg4 = thenArg3
				.mapSingleToList(item -> item.<LocationIdentifier>mapC("getLocation", assetDeliveryInformation -> assetDeliveryInformation.getLocation()));
			final MapperC<LocationIdentifier> thenArg5 = thenArg4
				.filterItemNullSafe(item -> areEqual(item.<CommodityLocationIdentifierTypeEnum>map("getLocationIdentifierType", locationIdentifier -> locationIdentifier.getLocationIdentifierType()), MapperS.of(CommodityLocationIdentifierTypeEnum.INTERCONNECTION_POINT), CardinalityOperator.All).get());
			final MapperS<LocationIdentifier> thenArg6 = MapperS.of(thenArg5.get());
			final MapperC<FieldWithMetaString> thenArg7 = thenArg6
				.mapSingleToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", locationIdentifier -> locationIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
			final FieldWithMetaString fieldWithMetaString = MapperS.of(thenArg7.get()).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
