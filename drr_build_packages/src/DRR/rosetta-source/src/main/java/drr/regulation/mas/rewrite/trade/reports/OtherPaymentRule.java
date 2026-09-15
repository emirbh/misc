package drr.regulation.mas.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import drr.standards.iso.PaymentType4Code;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentRule.OtherPaymentRuleDefault.class)
public abstract class OtherPaymentRule implements ReportFunction<TransactionReportInstruction, List<? extends OtherPayment>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected drr.standards.iosco.cde.version3.payment.reports.OtherPaymentRule otherPaymentRule;

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

	public static class OtherPaymentRuleDefault extends OtherPaymentRule {
		@Override
		protected List<OtherPayment.OtherPaymentBuilder> doEvaluate(TransactionReportInstruction input) {
			List<OtherPayment.OtherPaymentBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<OtherPayment.OtherPaymentBuilder> assignOutput(List<OtherPayment.OtherPaymentBuilder> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableActionForMAS.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).get());
			final MapperC<OtherPayment> thenArg1 = thenArg0
				.mapSingleToList(item -> MapperC.<OtherPayment>of(otherPaymentRule.evaluate(item.get())));
			output = toBuilder(thenArg1
				.sort(item -> MapperMaths.<String, String, String>add(MapperMaths.<String, String, String>add(MapperMaths.<String, String, String>add(item.<Date>map("getDate", otherPayment -> otherPayment.getDate()).map("to-string", Object::toString), item.<String>map("getPayer", otherPayment -> otherPayment.getPayer())), item.<String>map("getReceiver", otherPayment -> otherPayment.getReceiver())), item.<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()).map("to-string", PaymentType4Code::toDisplayString))).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
