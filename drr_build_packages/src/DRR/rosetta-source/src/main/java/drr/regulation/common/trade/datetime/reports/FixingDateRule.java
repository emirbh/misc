package drr.regulation.common.trade.datetime.reports;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.functions.ToDateTime;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.FxFixingDate;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.ValuationDate;
import cdm.product.template.OptionPayout;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaDate;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(FixingDateRule.FixingDateRuleDefault.class)
public abstract class FixingDateRule implements ReportFunction<PayoutLegWithAuxiliary, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ToDateTime toDateTime;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(PayoutLegWithAuxiliary input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(PayoutLegWithAuxiliary input);

	public static class FixingDateRuleDefault extends FixingDateRule {
		@Override
		protected ZonedDateTime doEvaluate(PayoutLegWithAuxiliary input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, PayoutLegWithAuxiliary input) {
			final MapperS<SettlementTerms> thenArg0 = MapperS.of(input)
				.mapSingleToItem(payout -> {
					final MapperS<SettlementTerms> _thenArg0 = payout.<InterestRatePayout>map("getInterestRatePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getInterestRatePayout()).<SettlementTerms>map("getSettlementTerms", interestRatePayout -> interestRatePayout.getSettlementTerms());
					final MapperS<SettlementTerms> _thenArg1 = MapperS.of(_thenArg0.getOrDefault(payout.<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<SettlementTerms>map("getSettlementTerms", optionPayout -> optionPayout.getSettlementTerms()).get()));
					final MapperS<SettlementTerms> _thenArg2 = MapperS.of(_thenArg1.getOrDefault(payout.<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).get()));
					return MapperS.of(_thenArg2.getOrDefault(payout.<SettlementTerms>map("getSettlementTerms", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementTerms()).get()));
				});
			final MapperS<AdjustableDate> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(item.<CashSettlementTerms>mapC("getCashSettlementTerms", settlementTerms -> settlementTerms.getCashSettlementTerms()).get()).<ValuationDate>map("getValuationDate", cashSettlementTerms -> cashSettlementTerms.getValuationDate()).<FxFixingDate>map("getFxFixingDate", valuationDate -> valuationDate.getFxFixingDate()).<AdjustableOrRelativeDate>map("getFxFixingDate", fxFixingDate -> fxFixingDate.getFxFixingDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()));
			final MapperS<Date> thenArg2 = thenArg1
				.mapSingleToItem(item -> MapperS.of(item.<FieldWithMetaDate>map("getAdjustedDate", adjustableDate -> adjustableDate.getAdjustedDate()).<Date>map("Type coercion", fieldWithMetaDate -> fieldWithMetaDate == null ? null : fieldWithMetaDate.getValue()).getOrDefault(item.<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get())));
			output = MapperS.of(toDateTime.evaluate(thenArg2.get())).get();
			
			return output;
		}
	}
}
