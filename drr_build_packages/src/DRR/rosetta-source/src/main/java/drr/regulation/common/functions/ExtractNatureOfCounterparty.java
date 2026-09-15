package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.NatureOfPartyEnum;
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractNatureOfCounterparty.ExtractNatureOfCounterpartyDefault.class)
public abstract class ExtractNatureOfCounterparty implements RosettaFunction {

	/**
	* @param natureOfParty 
	* @return natureOfCounterparty 
	*/
	public NatureOfCounterpartyEnum evaluate(NatureOfPartyEnum natureOfParty) {
		NatureOfCounterpartyEnum natureOfCounterparty = doEvaluate(natureOfParty);
		
		return natureOfCounterparty;
	}

	protected abstract NatureOfCounterpartyEnum doEvaluate(NatureOfPartyEnum natureOfParty);

	public static class ExtractNatureOfCounterpartyDefault extends ExtractNatureOfCounterparty {
		@Override
		protected NatureOfCounterpartyEnum doEvaluate(NatureOfPartyEnum natureOfParty) {
			NatureOfCounterpartyEnum natureOfCounterparty = null;
			return assignOutput(natureOfCounterparty, natureOfParty);
		}
		
		protected NatureOfCounterpartyEnum assignOutput(NatureOfCounterpartyEnum natureOfCounterparty, NatureOfPartyEnum natureOfParty) {
			if (areEqual(MapperS.of(natureOfParty), MapperS.of(NatureOfPartyEnum.FINANCIAL), CardinalityOperator.All).getOrDefault(false)) {
				natureOfCounterparty = NatureOfCounterpartyEnum.F;
			} else if (areEqual(MapperS.of(natureOfParty), MapperS.of(NatureOfPartyEnum.NON_FINANCIAL), CardinalityOperator.All).getOrDefault(false)) {
				natureOfCounterparty = NatureOfCounterpartyEnum.N;
			} else if (areEqual(MapperS.of(natureOfParty), MapperS.of(NatureOfPartyEnum.CENTRAL_COUNTERPARTY), CardinalityOperator.All).getOrDefault(false)) {
				natureOfCounterparty = NatureOfCounterpartyEnum.C;
			} else if (areEqual(MapperS.of(natureOfParty), MapperS.of(NatureOfPartyEnum.EXEMPT), CardinalityOperator.All).getOrDefault(false)) {
				natureOfCounterparty = NatureOfCounterpartyEnum.O;
			} else {
				natureOfCounterparty = null;
			}
			
			return natureOfCounterparty;
		}
	}
}
