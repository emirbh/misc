package drr.standards.iosco.cde.version1.price.reports;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableDates;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.event.common.Trade;
import cdm.product.template.EconomicTerms;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaDate;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.base.util.datetime.functions.AdjustableDateResolution;
import drr.base.util.datetime.functions.AdjustableDatesResolution;
import drr.base.util.datetime.functions.MinAdjustableDateResolution;
import javax.inject.Inject;


@ImplementedBy(FirstExerciseDateRule.FirstExerciseDateRuleDefault.class)
public abstract class FirstExerciseDateRule implements ReportFunction<TransactionReportInstructionBase, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableDateResolution adjustableDateResolution;
	@Inject protected AdjustableDatesResolution adjustableDatesResolution;
	@Inject protected MinAdjustableDateResolution minAdjustableDateResolution;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstructionBase input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstructionBase input);

	public static class FirstExerciseDateRuleDefault extends FirstExerciseDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstructionBase input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstructionBase input) {
			final MapperS<Trade> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(tradeForEvent.evaluate(item.get())));
			output = thenArg
				.mapSingleToItem(trade -> MapperS.of(MapperS.of(productForTrade.evaluate(trade.get())).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms())
					.mapSingleToItem(item -> {
						final OptionExerciseStyleEnum switchArgument = item.<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()).get();
						if (switchArgument == null) {
							return MapperS.<Date>ofNull();
						}
						if (switchArgument == OptionExerciseStyleEnum.AMERICAN) {
							final FieldWithMetaDate fieldWithMetaDate = trade.<FieldWithMetaDate>map("getTradeDate", _trade -> _trade.getTradeDate()).get();
							return MapperS.of(MapperS.of(adjustableDateResolution.evaluate(item.<AdjustableOrRelativeDate>map("getCommencementDate", exerciseTerms -> exerciseTerms.getCommencementDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get())).getOrDefault((fieldWithMetaDate == null ? null : fieldWithMetaDate.getValue())));
						}
						if (switchArgument == OptionExerciseStyleEnum.EUROPEAN) {
							return MapperS.of(MapperS.of(minAdjustableDateResolution.evaluate(item.<AdjustableOrRelativeDate>mapC("getExpirationDate", exerciseTerms -> exerciseTerms.getExpirationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).getMulti())).getOrDefault(adjustableDateResolution.evaluate(MapperS.of(productForTrade.evaluate(trade.get())).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<AdjustableOrRelativeDate>map("getTerminationDate", economicTerms -> economicTerms.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get())));
						}
						if (switchArgument == OptionExerciseStyleEnum.BERMUDA) {
							return MapperC.<Date>of(adjustableDatesResolution.evaluate(item.<AdjustableOrRelativeDates>map("getExerciseDates", exerciseTerms -> exerciseTerms.getExerciseDates()).<AdjustableDates>map("getAdjustableDates", adjustableOrRelativeDates -> adjustableOrRelativeDates.getAdjustableDates()).get()))
								.min();
						}
						return MapperS.<Date>ofNull();
					})).get();
			
			return output;
		}
	}
}
