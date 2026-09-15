package drr.regulation.jfsa.rewrite.trade.reports;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.product.asset.InterestRatePayout;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetIndexIndicatorFromFloatingRate;
import drr.regulation.common.functions.InterestRateLeg1;
import drr.regulation.common.functions.ProductOrUnderlierProduct;
import drr.regulation.common.functions.RateOption;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import drr.standards.iso.IndexEnum;
import javax.inject.Inject;


@ImplementedBy(IndicatorOfTheFloatingRateOfLeg1Rule.IndicatorOfTheFloatingRateOfLeg1RuleDefault.class)
public abstract class IndicatorOfTheFloatingRateOfLeg1Rule implements ReportFunction<TransactionReportInstruction, IndexEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetIndexIndicatorFromFloatingRate getIndexIndicatorFromFloatingRate;
	@Inject protected InterestRateLeg1 interestRateLeg1;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected ProductOrUnderlierProduct productOrUnderlierProduct;
	@Inject protected RateOption rateOption;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public IndexEnum evaluate(TransactionReportInstruction input) {
		IndexEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract IndexEnum doEvaluate(TransactionReportInstruction input);

	public static class IndicatorOfTheFloatingRateOfLeg1RuleDefault extends IndicatorOfTheFloatingRateOfLeg1Rule {
		@Override
		protected IndexEnum doEvaluate(TransactionReportInstruction input) {
			IndexEnum output = null;
			return assignOutput(output, input);
		}
		
		protected IndexEnum assignOutput(IndexEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			final MapperS<NonTransferableProduct> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			final MapperS<NonTransferableProduct> thenArg2 = thenArg1
				.mapSingleToItem(item -> MapperS.of(productOrUnderlierProduct.evaluate(item.get())));
			final MapperS<InterestRatePayout> thenArg3 = thenArg2
				.mapSingleToItem(item -> MapperS.of(interestRateLeg1.evaluate(item.get())));
			final MapperS<InterestRateIndex> thenArg4 = thenArg3
				.mapSingleToItem(item -> MapperS.of(rateOption.evaluate(item.get())));
			final MapperS<String> thenArg5 = thenArg4
				.mapSingleToItem(item -> item.<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex()).<FloatingRateIndexEnum>map("Type coercion", fieldWithMetaFloatingRateIndexEnum -> fieldWithMetaFloatingRateIndexEnum == null ? null : fieldWithMetaFloatingRateIndexEnum.getValue()).map("to-string", FloatingRateIndexEnum::toDisplayString));
			output = thenArg5
				.mapSingleToItem(item -> MapperS.of(getIndexIndicatorFromFloatingRate.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
