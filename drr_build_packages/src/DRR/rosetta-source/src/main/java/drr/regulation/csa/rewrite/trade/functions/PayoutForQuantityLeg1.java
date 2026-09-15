package drr.regulation.csa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutForQuantityLeg1Rule;
import drr.regulation.common.trade.reports.PayoutForQuantityLeg2Rule;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PayoutForQuantityLeg1.PayoutForQuantityLeg1Default.class)
public abstract class PayoutForQuantityLeg1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PayoutForQuantityLeg1Rule payoutForQuantityLeg1Rule;
	@Inject protected PayoutForQuantityLeg2Rule payoutForQuantityLeg2Rule;
	@Inject protected PayoutLeg1 payoutLeg1;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;

	/**
	* @param transaction 
	* @return _payoutLeg1 
	*/
	public PayoutLegWithAuxiliary evaluate(TransactionReportInstruction transaction) {
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder payoutLeg1Builder = doEvaluate(transaction);
		
		final PayoutLegWithAuxiliary _payoutLeg1;
		if (payoutLeg1Builder == null) {
			_payoutLeg1 = null;
		} else {
			_payoutLeg1 = payoutLeg1Builder.build();
			objectValidator.validate(PayoutLegWithAuxiliary.class, _payoutLeg1);
		}
		
		return _payoutLeg1;
	}

	protected abstract PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(TransactionReportInstruction transaction);

	public static class PayoutForQuantityLeg1Default extends PayoutForQuantityLeg1 {
		@Override
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(TransactionReportInstruction transaction) {
			PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder _payoutLeg1 = PayoutLegWithAuxiliary.builder();
			return assignOutput(_payoutLeg1, transaction);
		}
		
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder assignOutput(PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder _payoutLeg1, TransactionReportInstruction transaction) {
			if (areEqual(MapperS.of(payoutLeg1Rule.evaluate(transaction)), MapperS.of(payoutLeg1.evaluate(transaction)), CardinalityOperator.All).getOrDefault(false)) {
				_payoutLeg1 = toBuilder(payoutForQuantityLeg1Rule.evaluate(transaction));
			} else {
				_payoutLeg1 = toBuilder(payoutForQuantityLeg2Rule.evaluate(transaction));
			}
			
			return Optional.ofNullable(_payoutLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
