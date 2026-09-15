package drr.standards.iosco.cde.version1.party.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.template.FixedPricePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLeg;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.standards.iso.Direction2Enum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Direction2.Direction2Default.class)
public abstract class Direction2 implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected PayerReceiverFromPayout payerReceiverFromPayout;

	/**
	* @param payout 
	* @param reportingParty 
	* @return direction 
	*/
	public Direction2Enum evaluate(PayoutLegWithAuxiliary payout, CounterpartyRoleEnum reportingParty) {
		Direction2Enum direction = doEvaluate(payout, reportingParty);
		
		return direction;
	}

	protected abstract Direction2Enum doEvaluate(PayoutLegWithAuxiliary payout, CounterpartyRoleEnum reportingParty);

	protected abstract MapperS<? extends PayerReceiver> payerReceiver(PayoutLegWithAuxiliary payout, CounterpartyRoleEnum reportingParty);

	public static class Direction2Default extends Direction2 {
		@Override
		protected Direction2Enum doEvaluate(PayoutLegWithAuxiliary payout, CounterpartyRoleEnum reportingParty) {
			Direction2Enum direction = null;
			return assignOutput(direction, payout, reportingParty);
		}
		
		protected Direction2Enum assignOutput(Direction2Enum direction, PayoutLegWithAuxiliary payout, CounterpartyRoleEnum reportingParty) {
			if (exists(MapperS.of(reportingParty)).andNullSafe(areEqual(payerReceiver(payout, reportingParty).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer()), MapperS.of(reportingParty), CardinalityOperator.All)).getOrDefault(false)) {
				direction = Direction2Enum.MAKE;
			} else if (exists(MapperS.of(reportingParty)).andNullSafe(areEqual(payerReceiver(payout, reportingParty).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver()), MapperS.of(reportingParty), CardinalityOperator.All)).getOrDefault(false)) {
				direction = Direction2Enum.TAKE;
			} else {
				direction = null;
			}
			
			return direction;
		}
		
		@Override
		protected MapperS<? extends PayerReceiver> payerReceiver(PayoutLegWithAuxiliary payout, CounterpartyRoleEnum reportingParty) {
			return MapperS.of(MapperS.of(payerReceiverFromPayout.evaluate(payout)).getOrDefault(MapperS.of(payout).<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<FixedPricePayout>map("getFixedPricePayout", payoutLeg -> payoutLeg.getFixedPricePayout()).<PayerReceiver>map("getPayerReceiver", fixedPricePayout -> fixedPricePayout.getPayerReceiver()).get()));
		}
	}
}
