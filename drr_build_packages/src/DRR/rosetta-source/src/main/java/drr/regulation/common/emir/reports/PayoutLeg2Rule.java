package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsFRA;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ProductOrUnderlierProduct;
import drr.regulation.common.trade.payment.functions.FixedInterestRatePayoutFromPayout;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PayoutLeg2Rule.PayoutLeg2RuleDefault.class)
public abstract class PayoutLeg2Rule implements ReportFunction<TransactionReportInstruction, PayoutLegWithAuxiliary> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FixedInterestRatePayoutFromPayout fixedInterestRatePayoutFromPayout;
	@Inject protected IsFRA isFRA;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
	@Inject protected drr.regulation.common.trade.reports.PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected ProductOrUnderlierProduct productOrUnderlierProduct;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PayoutLegWithAuxiliary evaluate(TransactionReportInstruction input) {
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

	protected abstract PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(TransactionReportInstruction input);

	public static class PayoutLeg2RuleDefault extends PayoutLeg2Rule {
		@Override
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(TransactionReportInstruction input) {
			PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder output = PayoutLegWithAuxiliary.builder();
			return assignOutput(output, input);
		}
		
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder assignOutput(PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder output, TransactionReportInstruction input) {
			final Boolean _boolean = isFRA.evaluate(productOrUnderlierProduct.evaluate(productForEvent.evaluate(input)));
			if ((_boolean == null ? false : _boolean)) {
				if (exists(MapperS.of(fixedInterestRatePayoutFromPayout.evaluate(payoutLeg1Rule.evaluate(input)))).getOrDefault(false)) {
					output = toBuilder(payoutLeg1Rule.evaluate(input));
				} else {
					output = null;
				}
			} else {
				output = toBuilder(payoutLeg2Rule.evaluate(input));
			}
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
