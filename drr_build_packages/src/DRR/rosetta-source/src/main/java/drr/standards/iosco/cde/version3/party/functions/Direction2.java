package drr.standards.iosco.cde.version3.party.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.standards.iso.Direction2Enum;
import javax.inject.Inject;


@ImplementedBy(Direction2.Direction2Default.class)
public abstract class Direction2 implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.party.functions.Direction2 direction2;

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

	public static class Direction2Default extends Direction2 {
		@Override
		protected Direction2Enum doEvaluate(PayoutLegWithAuxiliary payout, CounterpartyRoleEnum reportingParty) {
			Direction2Enum direction = null;
			return assignOutput(direction, payout, reportingParty);
		}
		
		protected Direction2Enum assignOutput(Direction2Enum direction, PayoutLegWithAuxiliary payout, CounterpartyRoleEnum reportingParty) {
			direction = direction2.evaluate(payout, reportingParty);
			
			return direction;
		}
	}
}
