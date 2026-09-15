package drr.regulation.common.trade.reports;

import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.trade.functions.PayoutFromProductLeg2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(PayoutLeg2Rule.PayoutLeg2RuleDefault.class)
public abstract class PayoutLeg2Rule implements ReportFunction<ReportableEventBase, PayoutLegWithAuxiliary> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PayoutFromProductLeg2 payoutFromProductLeg2;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PayoutLegWithAuxiliary evaluate(ReportableEventBase input) {
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder outputBuilder = doEvaluate(input);
		
		final PayoutLegWithAuxiliary output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(PayoutLegWithAuxiliary.class, output);
		}
		
		return output;
	}

	protected abstract PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(ReportableEventBase input);

	public static class PayoutLeg2RuleDefault extends PayoutLeg2Rule {
		@Override
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(ReportableEventBase input) {
			PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder output = PayoutLegWithAuxiliary.builder();
			return assignOutput(output, input);
		}
		
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder assignOutput(PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder output, ReportableEventBase input) {
			output = toBuilder(MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(payoutFromProductLeg2.evaluate(productForEvent.evaluate(item.get()), MapperS.of(tradeForEvent.evaluate(item.get())).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get(), item.<ReportableInformationBase>map("getReportableInformation", reportableEventBase -> reportableEventBase.getReportableInformation()).get()))).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
