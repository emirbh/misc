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
import drr.base.trade.ReportablePriceSource;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetOtherUnderlierLeg2;
import drr.regulation.common.functions.GetUnderlierProductIdentifierLeg2;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingAssetPriceSourceLeg2Rule.UnderlyingAssetPriceSourceLeg2RuleDefault.class)
public abstract class UnderlyingAssetPriceSourceLeg2Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetOtherUnderlierLeg2 getOtherUnderlierLeg2;
	@Inject protected GetUnderlierProductIdentifierLeg2 getUnderlierProductIdentifierLeg2;
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

	public static class UnderlyingAssetPriceSourceLeg2RuleDefault extends UnderlyingAssetPriceSourceLeg2Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(reportableEvent -> {
					final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(productForEvent.evaluate(input));
					final MapperC<ReportablePriceSource> ifThenElseResult0;
					if (lessThanEquals(MapperS.of(MapperS.of(underlierForProduct.evaluate(thenArg0.get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<FieldWithMetaBasketConstituent>mapC("getBasketConstituent", basket -> basket.getBasketConstituent()).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult0 = thenArg0
							.mapSingleToList(item -> reportableEvent.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportablePriceSource>mapC("getUnderlyingAssetPriceSource", reportableInformation -> reportableInformation.getUnderlyingAssetPriceSource()));
					} else {
						ifThenElseResult0 = MapperC.<ReportablePriceSource>ofNull();
					}
					final MapperC<ReportablePriceSource> ifThenElseResult1;
					if (exists(MapperC.<AssetIdentifier>of(getUnderlierProductIdentifierLeg2.evaluate(productForEvent.evaluate(reportableEvent.get())))).andNullSafe(notEqual(MapperC.<AssetIdentifier>of(getUnderlierProductIdentifierLeg2.evaluate(productForEvent.evaluate(reportableEvent.get()))).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.All)).getOrDefault(false)) {
						ifThenElseResult1 = ifThenElseResult0
							.filterItemNullSafe(item -> areEqual(item.<AssetIdentifier>mapC("getAssetIdentifier", reportablePriceSource -> reportablePriceSource.getAssetIdentifier()), MapperC.<AssetIdentifier>of(getUnderlierProductIdentifierLeg2.evaluate(productForEvent.evaluate(reportableEvent.get()))), CardinalityOperator.All).get());
					} else if (exists(MapperS.of(getOtherUnderlierLeg2.evaluate(productForEvent.evaluate(reportableEvent.get())))).getOrDefault(false)) {
						ifThenElseResult1 = ifThenElseResult0
							.filterItemNullSafe(item -> areEqual(item.<String>map("getOtherId", reportablePriceSource -> reportablePriceSource.getOtherId()), MapperS.of(getOtherUnderlierLeg2.evaluate(productForEvent.evaluate(reportableEvent.get()))), CardinalityOperator.All).get());
					} else {
						ifThenElseResult1 = MapperC.<ReportablePriceSource>ofNull();
					}
					final MapperC<String> thenArg1 = ifThenElseResult1
						.mapItem(item -> item.<String>map("getUnderlyingAssetPriceSource", reportablePriceSource -> reportablePriceSource.getUnderlyingAssetPriceSource()));
					return MapperS.of(distinctIgnoringPrecision(thenArg1).get());
				}).get();
			
			return output;
		}
	}
}
