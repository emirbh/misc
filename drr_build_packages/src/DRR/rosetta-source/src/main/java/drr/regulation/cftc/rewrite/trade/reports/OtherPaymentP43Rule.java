package drr.regulation.cftc.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.payment.reports.OtherPaymentRule;
import drr.standards.iso.PaymentType4Code;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentP43Rule.OtherPaymentP43RuleDefault.class)
public abstract class OtherPaymentP43Rule implements ReportFunction<TransactionReportInstruction, List<? extends OtherPayment>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected OtherPaymentRule otherPaymentRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends OtherPayment> evaluate(TransactionReportInstruction input) {
		List<OtherPayment.OtherPaymentBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends OtherPayment> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(OtherPayment::build).collect(Collectors.toList());
			objectValidator.validate(OtherPayment.class, output);
		}
		
		return output;
	}

	protected abstract List<OtherPayment.OtherPaymentBuilder> doEvaluate(TransactionReportInstruction input);

	public static class OtherPaymentP43RuleDefault extends OtherPaymentP43Rule {
		@Override
		protected List<OtherPayment.OtherPaymentBuilder> doEvaluate(TransactionReportInstruction input) {
			List<OtherPayment.OtherPaymentBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<OtherPayment.OtherPaymentBuilder> assignOutput(List<OtherPayment.OtherPaymentBuilder> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			final MapperC<OtherPayment> thenArg1 = thenArg0
				.mapSingleToList(item -> MapperC.<OtherPayment>of(otherPaymentRule.evaluate(item.get())));
			output = toBuilder(thenArg1
				.mapItem(item -> MapperS.of(OtherPayment.builder()
					.setPaymentType(item.<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()).get())
					.setAmount(item.<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount()).get())
					.setCurrency(item.<ISOCurrencyCodeEnum>map("getCurrency", otherPayment -> otherPayment.getCurrency()).get())
					.setDate(null)
					.setPayer(null)
					.setPayerFormat(null)
					.setReceiver(null)
					.setReceiverFormat(null)
					.setPayerSchemeName(null)
					.setReceiverSchemeName(null)
					.build())).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
