package drr.regulation.common.emir.reports;

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
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
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
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(IndicatorOfTheUnderlyingIndexRule.IndicatorOfTheUnderlyingIndexRuleDefault.class)
public abstract class IndicatorOfTheUnderlyingIndexRule implements ReportFunction<TransactionReportInstruction, List<IndexEnum>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected GetIndexIndicatorFromFloatingRate getIndexIndicatorFromFloatingRate;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsFRA isFRA;
	@Inject protected IsIRSwaption isIRSwaption;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;
	@Inject protected UnderlierProductIdentifier underlierProductIdentifier;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<IndexEnum> evaluate(TransactionReportInstruction input) {
		List<IndexEnum> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<IndexEnum> doEvaluate(TransactionReportInstruction input);

	public static class IndicatorOfTheUnderlyingIndexRuleDefault extends IndicatorOfTheUnderlyingIndexRule {
		@Override
		protected List<IndexEnum> doEvaluate(TransactionReportInstruction input) {
			List<IndexEnum> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<IndexEnum> assignOutput(List<IndexEnum> output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (ComparisonResult.ofNullSafe(MapperS.of(isCreditSwaption.evaluate(productForEvent.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isIRSwaption.evaluate(productForEvent.evaluate(item.get()))))).getOrDefault(false)) {
						return MapperS.of(underlierForProduct.evaluate(productForEvent.evaluate(item.get()))).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct());
					}
					return MapperS.of(productForEvent.evaluate(item.get()));
				});
			final MapperC<String> thenArg1 = thenArg0
				.mapSingleToList(item -> {
					final Boolean _boolean = isFRA.evaluate(item.get());
					final MapperS<String> ifThenElseResult;
					if ((_boolean == null ? false : _boolean)) {
						ifThenElseResult = MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex())
							.first().<FloatingRateIndexEnum>map("Type coercion", fieldWithMetaFloatingRateIndexEnum -> fieldWithMetaFloatingRateIndexEnum == null ? null : fieldWithMetaFloatingRateIndexEnum.getValue()).map("to-string", FloatingRateIndexEnum::toDisplayString);
					} else {
						ifThenElseResult = MapperS.<String>ofNull();
					}
					return MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), AssetIdTypeEnum.NAME)).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()).getMulti().isEmpty() ? MapperC.of(ifThenElseResult) : MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), AssetIdTypeEnum.NAME)).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue());
				});
			output = thenArg1
				.mapItem(item -> MapperS.of(getIndexIndicatorFromFloatingRate.evaluate(item.get()))).getMulti();
			
			return output;
		}
	}
}
