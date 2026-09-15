package drr.standards.iosco.cde.version3.underlier.reports;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.observable.asset.Basket;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportablePriceSource;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetOtherUnderlierLeg1;
import drr.regulation.common.functions.GetUnderlierProductIdentifierLeg1;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingAssetPriceSourceLeg1Rule.UnderlyingAssetPriceSourceLeg1RuleDefault.class)
public abstract class UnderlyingAssetPriceSourceLeg1Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetOtherUnderlierLeg1 getOtherUnderlierLeg1;
	@Inject protected GetUnderlierProductIdentifierLeg1 getUnderlierProductIdentifierLeg1;
	@Inject protected ProductForEvent productForEvent;
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

	public static class UnderlyingAssetPriceSourceLeg1RuleDefault extends UnderlyingAssetPriceSourceLeg1Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(reportableEvent -> {
					final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(productForEvent.evaluate(input));
					final MapperS<String> ifThenElseResult1;
					if (lessThanEquals(MapperS.of(MapperS.of(underlierForProduct.evaluate(thenArg0.get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<FieldWithMetaBasketConstituent>mapC("getBasketConstituent", basket -> basket.getBasketConstituent()).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
						final MapperC<ReportablePriceSource> thenArg1 = thenArg0
							.mapSingleToList(item -> reportableEvent.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportablePriceSource>mapC("getUnderlyingAssetPriceSource", reportableInformation -> reportableInformation.getUnderlyingAssetPriceSource()));
						final MapperC<ReportablePriceSource> ifThenElseResult0;
						if (exists(MapperC.<AssetIdentifier>of(getUnderlierProductIdentifierLeg1.evaluate(productForEvent.evaluate(reportableEvent.get())))).andNullSafe(notEqual(MapperC.<AssetIdentifier>of(getUnderlierProductIdentifierLeg1.evaluate(productForEvent.evaluate(reportableEvent.get()))).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.All)).getOrDefault(false)) {
							ifThenElseResult0 = thenArg1
								.filterItemNullSafe(item -> areEqual(item.<AssetIdentifier>mapC("getAssetIdentifier", reportablePriceSource -> reportablePriceSource.getAssetIdentifier()).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), MapperC.<AssetIdentifier>of(getUnderlierProductIdentifierLeg1.evaluate(productForEvent.evaluate(reportableEvent.get()))).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), CardinalityOperator.All).get());
						} else if (exists(MapperS.of(getOtherUnderlierLeg1.evaluate(productForEvent.evaluate(reportableEvent.get())))).getOrDefault(false)) {
							ifThenElseResult0 = thenArg1
								.filterItemNullSafe(item -> areEqual(item.<String>map("getOtherId", reportablePriceSource -> reportablePriceSource.getOtherId()), MapperS.of(getOtherUnderlierLeg1.evaluate(productForEvent.evaluate(reportableEvent.get()))), CardinalityOperator.All).get());
						} else {
							ifThenElseResult0 = MapperC.<ReportablePriceSource>ofNull();
						}
						final MapperC<String> thenArg2 = ifThenElseResult0
							.mapItem(item -> item.<String>map("getUnderlyingAssetPriceSource", reportablePriceSource -> reportablePriceSource.getUnderlyingAssetPriceSource()));
						ifThenElseResult1 = MapperS.of(distinctIgnoringPrecision(thenArg2).get());
					} else {
						ifThenElseResult1 = MapperS.<String>ofNull();
					}
					return ifThenElseResult1;
				}).get();
			
			return output;
		}
	}
}
