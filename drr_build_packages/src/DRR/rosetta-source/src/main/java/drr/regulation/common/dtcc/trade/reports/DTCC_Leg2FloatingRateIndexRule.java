package drr.regulation.common.dtcc.trade.reports;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.InflationRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaInflationRateIndexEnum;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.RateSpecification;
import cdm.product.qualification.functions.Qualify_AssetClass_InterestRate;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.InterestRateLeg2;
import drr.regulation.common.functions.ProductOrUnderlierProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_Leg2FloatingRateIndexRule.DTCC_Leg2FloatingRateIndexRuleDefault.class)
public abstract class DTCC_Leg2FloatingRateIndexRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected InterestRateLeg2 interestRateLeg2;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected ProductOrUnderlierProduct productOrUnderlierProduct;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;

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

	public static class DTCC_Leg2FloatingRateIndexRuleDefault extends DTCC_Leg2FloatingRateIndexRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			final MapperS<NonTransferableProduct> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> qualify_AssetClass_InterestRate.evaluate(economicTermsForProduct.evaluate(item.get())));
			final MapperS<NonTransferableProduct> thenArg2 = thenArg1
				.mapSingleToItem(item -> MapperS.of(productOrUnderlierProduct.evaluate(item.get())));
			output = thenArg2
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(interestRateLeg2.evaluate(item.get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex0 -> referenceWithMetaInterestRateIndex0 == null ? null : referenceWithMetaInterestRateIndex0.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaString>map("getName", floatingRateIndex -> floatingRateIndex.getName())).orNullSafe(exists(MapperS.of(interestRateLeg2.evaluate(item.get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", inflationRateSpecification -> inflationRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex1 -> referenceWithMetaInterestRateIndex1 == null ? null : referenceWithMetaInterestRateIndex1.getValue()).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex()).<FieldWithMetaString>map("getName", inflationIndex -> inflationIndex.getName()))).getOrDefault(false)) {
						final FieldWithMetaString fieldWithMetaString = MapperC.<FieldWithMetaString>of(MapperS.of(interestRateLeg2.evaluate(item.get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex2 -> referenceWithMetaInterestRateIndex2 == null ? null : referenceWithMetaInterestRateIndex2.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaString>map("getName", floatingRateIndex -> floatingRateIndex.getName()), MapperS.of(interestRateLeg2.evaluate(item.get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", inflationRateSpecification -> inflationRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex3 -> referenceWithMetaInterestRateIndex3 == null ? null : referenceWithMetaInterestRateIndex3.getValue()).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex()).<FieldWithMetaString>map("getName", inflationIndex -> inflationIndex.getName())).get();
						return fieldWithMetaString == null ? MapperS.<String>ofNull() : MapperS.of(fieldWithMetaString.getValue());
					}
					if (exists(MapperS.of(interestRateLeg2.evaluate(item.get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex4 -> referenceWithMetaInterestRateIndex4 == null ? null : referenceWithMetaInterestRateIndex4.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex())).orNullSafe(exists(MapperS.of(interestRateLeg2.evaluate(item.get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex5 -> referenceWithMetaInterestRateIndex5 == null ? null : referenceWithMetaInterestRateIndex5.getValue()).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex()).<FieldWithMetaInflationRateIndexEnum>map("getInflationRateIndex", inflationIndex -> inflationIndex.getInflationRateIndex()))).getOrDefault(false)) {
						return MapperS.of(MapperC.<String>of(MapperS.of(interestRateLeg2.evaluate(item.get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex6 -> referenceWithMetaInterestRateIndex6 == null ? null : referenceWithMetaInterestRateIndex6.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex()).<FloatingRateIndexEnum>map("Type coercion", fieldWithMetaFloatingRateIndexEnum -> fieldWithMetaFloatingRateIndexEnum == null ? null : fieldWithMetaFloatingRateIndexEnum.getValue()).map("to-string", FloatingRateIndexEnum::toDisplayString), MapperS.of(interestRateLeg2.evaluate(item.get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex7 -> referenceWithMetaInterestRateIndex7 == null ? null : referenceWithMetaInterestRateIndex7.getValue()).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex()).<FieldWithMetaInflationRateIndexEnum>map("getInflationRateIndex", inflationIndex -> inflationIndex.getInflationRateIndex()).<InflationRateIndexEnum>map("Type coercion", fieldWithMetaInflationRateIndexEnum -> fieldWithMetaInflationRateIndexEnum == null ? null : fieldWithMetaInflationRateIndexEnum.getValue()).map("to-string", InflationRateIndexEnum::toDisplayString)).get());
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
