package drr.regulation.common.emir.reports;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.CommodityLocationIdentifierTypeEnum;
import cdm.base.staticdata.identifier.LocationIdentifier;
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
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DeliveryPointOrZoneRule.DeliveryPointOrZoneRuleDefault.class)
public abstract class DeliveryPointOrZoneRule implements ReportFunction<TransactionReportInstruction, List<String>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_Commodity_Option qualify_Commodity_Option;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<String> evaluate(TransactionReportInstruction input) {
		List<String> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<String> doEvaluate(TransactionReportInstruction input);

	public static class DeliveryPointOrZoneRuleDefault extends DeliveryPointOrZoneRule {
		@Override
		protected List<String> doEvaluate(TransactionReportInstruction input) {
			List<String> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<String> assignOutput(List<String> output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			final MapperS<EconomicTerms> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(economicTermsForProduct.evaluate(item.get())));
			final MapperS<AssetDeliveryInformation> thenArg2 = thenArg1
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
					return MapperS.<AssetDeliveryInformation>ofNull();
				});
			final MapperC<LocationIdentifier> thenArg3 = thenArg2
				.mapSingleToList(item -> item.<LocationIdentifier>mapC("getLocation", assetDeliveryInformation -> assetDeliveryInformation.getLocation()));
			final MapperC<LocationIdentifier> thenArg4 = thenArg3
				.filterItemNullSafe(item -> areEqual(item.<CommodityLocationIdentifierTypeEnum>map("getLocationIdentifierType", locationIdentifier -> locationIdentifier.getLocationIdentifierType()), MapperS.of(CommodityLocationIdentifierTypeEnum.DELIVERY_POINT), CardinalityOperator.All).get());
			final MapperListOfLists<FieldWithMetaString> thenArg5 = thenArg4
				.mapItemToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", locationIdentifier -> locationIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
			output = thenArg5
				.flattenList().<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()).getMulti();
			
			return output;
		}
	}
}
