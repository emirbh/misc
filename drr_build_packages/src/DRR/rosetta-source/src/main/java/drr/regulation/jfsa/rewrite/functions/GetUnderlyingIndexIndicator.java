package drr.regulation.jfsa.rewrite.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.qualification.functions.Qualify_BaseProduct_IRSwap;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.qualification.product.functions.IsFRA;
import drr.base.qualification.product.functions.IsIRSwaption;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.base.trade.underlier.functions.UnderlierProductIdentifier;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetIndexIndicatorFromFloatingRate;
import drr.standards.iso.IndexEnum;
import javax.inject.Inject;


@ImplementedBy(GetUnderlyingIndexIndicator.GetUnderlyingIndexIndicatorDefault.class)
public abstract class GetUnderlyingIndexIndicator implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected GetIndexIndicatorFromFloatingRate getIndexIndicatorFromFloatingRate;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsFRA isFRA;
	@Inject protected IsIRSwaption isIRSwaption;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_BaseProduct_IRSwap qualify_BaseProduct_IRSwap;
	@Inject protected UnderlierForProduct underlierForProduct;
	@Inject protected UnderlierProductIdentifier underlierProductIdentifier;

	/**
	* @param transaction 
	* @return result 
	*/
	public IndexEnum evaluate(TransactionReportInstruction transaction) {
		IndexEnum result = doEvaluate(transaction);
		
		return result;
	}

	protected abstract IndexEnum doEvaluate(TransactionReportInstruction transaction);

	public static class GetUnderlyingIndexIndicatorDefault extends GetUnderlyingIndexIndicator {
		@Override
		protected IndexEnum doEvaluate(TransactionReportInstruction transaction) {
			IndexEnum result = null;
			return assignOutput(result, transaction);
		}
		
		protected IndexEnum assignOutput(IndexEnum result, TransactionReportInstruction transaction) {
			final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(productForEvent.evaluate(transaction));
			final MapperS<NonTransferableProduct> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					if (ComparisonResult.ofNullSafe(MapperS.of(isCreditSwaption.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isIRSwaption.evaluate(item.get())))).getOrDefault(false)) {
						return MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct());
					}
					return item;
				});
			final MapperS<String> thenArg2 = thenArg1
				.mapSingleToItem(item -> {
					final Boolean boolean0 = isFRA.evaluate(item.get());
					final String ifThenElseResult;
					if ((boolean0 == null ? false : boolean0)) {
						ifThenElseResult = MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex())
							.first().<FloatingRateIndexEnum>map("Type coercion", fieldWithMetaFloatingRateIndexEnum0 -> fieldWithMetaFloatingRateIndexEnum0 == null ? null : fieldWithMetaFloatingRateIndexEnum0.getValue()).map("to-string", FloatingRateIndexEnum::toDisplayString).get();
					} else {
						final Boolean boolean1 = qualify_BaseProduct_IRSwap.evaluate(economicTermsForProduct.evaluate(item.get()));
						if ((boolean1 == null ? false : boolean1)) {
							ifThenElseResult = MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex())
								.first().<FloatingRateIndexEnum>map("Type coercion", fieldWithMetaFloatingRateIndexEnum1 -> fieldWithMetaFloatingRateIndexEnum1 == null ? null : fieldWithMetaFloatingRateIndexEnum1.getValue()).map("to-string", FloatingRateIndexEnum::toDisplayString).get();
						} else {
							ifThenElseResult = null;
						}
					}
					return MapperS.of(MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), AssetIdTypeEnum.NAME)).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())
						.first().<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()).getOrDefault(ifThenElseResult));
				});
			result = thenArg2
				.mapSingleToItem(item -> MapperS.of(getIndexIndicatorFromFloatingRate.evaluate(item.get()))).get();
			
			return result;
		}
	}
}
