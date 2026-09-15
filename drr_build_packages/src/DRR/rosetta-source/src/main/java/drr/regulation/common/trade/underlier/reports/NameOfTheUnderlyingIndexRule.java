package drr.regulation.common.trade.underlier.reports;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.InflationRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaInflationRateIndexEnum;
import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.Index;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.util.IndexDeepPathUtil;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.qualification.functions.Qualify_AssetClass_InterestRate;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.qualification.product.functions.IsIRSwaption;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.InterestRateLeg1;
import java.util.Collections;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NameOfTheUnderlyingIndexRule.NameOfTheUnderlyingIndexRuleDefault.class)
public abstract class NameOfTheUnderlyingIndexRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IndexDeepPathUtil indexDeepPathUtil;
	@Inject protected InterestRateLeg1 interestRateLeg1;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsIRSwaption isIRSwaption;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;
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

	public static class NameOfTheUnderlyingIndexRuleDefault extends NameOfTheUnderlyingIndexRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (ComparisonResult.ofNullSafe(MapperS.of(isCreditSwaption.evaluate(productForEvent.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isIRSwaption.evaluate(productForEvent.evaluate(item.get()))))).getOrDefault(false)) {
						return MapperS.of(underlierForProduct.evaluate(productForEvent.evaluate(item.get()))).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct());
					}
					return MapperS.of(productForEvent.evaluate(item.get()));
				});
			final MapperC<String> thenArg1 = thenArg0
				.mapSingleToList(item -> {
					if (exists(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation())).getOrDefault(false)) {
						return item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName()).<String>map("Type coercion", _fieldWithMetaString -> _fieldWithMetaString.getValue());
					}
					if (exists(MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation())).getOrDefault(false)) {
						return MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName()).<String>map("Type coercion", _fieldWithMetaString -> _fieldWithMetaString.getValue());
					}
					if (exists(MapperS.of(underlierForProduct.evaluate(item.get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Index>map("getIndex", observable -> observable.getIndex())).getOrDefault(false)) {
						if (areEqual(MapperS.of(underlierForProduct.evaluate(item.get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetIdentifier>mapC("chooseIdentifier", index -> indexDeepPathUtil.chooseIdentifier(index)).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.NAME), CardinalityOperator.Any).getOrDefault(false)) {
							final MapperC<AssetIdentifier> _thenArg0 = MapperS.of(underlierForProduct.evaluate(item.get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable2 -> referenceWithMetaObservable2 == null ? null : referenceWithMetaObservable2.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetIdentifier>mapC("chooseIdentifier", index -> indexDeepPathUtil.chooseIdentifier(index));
							final MapperC<AssetIdentifier> _thenArg1 = _thenArg0
								.filterItemNullSafe(_item -> areEqual(_item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.NAME), CardinalityOperator.All).get());
							return _thenArg1
								.mapItem(_item -> _item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())).<String>map("Type coercion", _fieldWithMetaString -> _fieldWithMetaString.getValue());
						}
						if (exists(MapperS.of(underlierForProduct.evaluate(item.get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable3 -> referenceWithMetaObservable3 == null ? null : referenceWithMetaObservable3.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaString>map("chooseName", index -> indexDeepPathUtil.chooseName(index))).getOrDefault(false)) {
							return MapperC.of(MapperS.of(underlierForProduct.evaluate(item.get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable4 -> referenceWithMetaObservable4 == null ? null : referenceWithMetaObservable4.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaString>map("chooseName", index -> indexDeepPathUtil.chooseName(index)).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()));
						}
						return MapperC.<String>ofNull();
					}
					if (exists(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex())).getOrDefault(false)) {
						final MapperC<AssetIdentifier> thenArg2 = item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetIdentifier>mapC("chooseIdentifier", index -> indexDeepPathUtil.chooseIdentifier(index));
						final MapperC<AssetIdentifier> thenArg3 = thenArg2
							.filterItemNullSafe(_item -> areEqual(_item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.NAME), CardinalityOperator.All).get());
						return thenArg3
							.mapItem(_item -> _item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())).<String>map("Type coercion", _fieldWithMetaString -> _fieldWithMetaString.getValue());
					}
					if (exists(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex())).getOrDefault(false)) {
						final MapperC<AssetIdentifier> thenArg4 = item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetIdentifier>mapC("chooseIdentifier", index -> indexDeepPathUtil.chooseIdentifier(index));
						final MapperC<AssetIdentifier> thenArg5 = thenArg4
							.filterItemNullSafe(_item -> areEqual(_item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.NAME), CardinalityOperator.All).get());
						return thenArg5
							.mapItem(_item -> _item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())).<String>map("Type coercion", _fieldWithMetaString -> _fieldWithMetaString.getValue());
					}
					if (areEqual(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).resultCount()), MapperS.of(2), CardinalityOperator.All).getOrDefault(false)) {
						return MapperC.of(item
							.mapSingleToItem(_item -> MapperS.of(interestRateLeg1.evaluate(_item.get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex == null ? null : referenceWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex()).<FloatingRateIndexEnum>map("Type coercion", _fieldWithMetaFloatingRateIndexEnum -> _fieldWithMetaFloatingRateIndexEnum == null ? null : _fieldWithMetaFloatingRateIndexEnum.getValue()).map("to-string", FloatingRateIndexEnum::toDisplayString)));
					}
					final Boolean _boolean = qualify_AssetClass_InterestRate.evaluate(economicTermsForProduct.evaluate(item.get()));
					if ((_boolean == null ? false : _boolean)) {
						final FieldWithMetaInflationRateIndexEnum fieldWithMetaInflationRateIndexEnum = MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", inflationRateSpecification -> inflationRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex()).<FieldWithMetaInflationRateIndexEnum>map("getInflationRateIndex", inflationIndex -> inflationIndex.getInflationRateIndex()).get();
						final FieldWithMetaFloatingRateIndexEnum fieldWithMetaFloatingRateIndexEnum = MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex()).get();
						return MapperC.of(Collections.singletonList((fieldWithMetaInflationRateIndexEnum == null ? MapperS.<InflationRateIndexEnum>ofNull() : MapperS.of(fieldWithMetaInflationRateIndexEnum.getValue())).map("to-string", InflationRateIndexEnum::toDisplayString).getOrDefault((fieldWithMetaFloatingRateIndexEnum == null ? MapperS.<FloatingRateIndexEnum>ofNull() : MapperS.of(fieldWithMetaFloatingRateIndexEnum.getValue())).map("to-string", FloatingRateIndexEnum::toDisplayString).get())));
					}
					return MapperC.<String>ofNull();
				});
			output = MapperS.of(distinctIgnoringPrecision(thenArg1).get()).get();
			
			return output;
		}
	}
}
