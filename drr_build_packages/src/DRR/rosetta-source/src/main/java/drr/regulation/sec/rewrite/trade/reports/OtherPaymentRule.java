package drr.regulation.sec.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
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
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;
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
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			output = toBuilder(thenArg
				.mapSingleToList(item -> MapperC.<OtherPayment>of(otherPaymentRule.evaluate(item.get()))).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
