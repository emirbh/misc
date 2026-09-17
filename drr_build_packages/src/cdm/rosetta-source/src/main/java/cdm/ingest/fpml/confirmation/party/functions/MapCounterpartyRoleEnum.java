package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCounterpartyRoleEnum.MapCounterpartyRoleEnumDefault.class)
public abstract class MapCounterpartyRoleEnum implements RosettaFunction {

	/**
	* @param fpmlPartyReference 
	* @param cdmCounterpartyList 
	* @return counterpartyRoleEnum 
	*/
	public CounterpartyRoleEnum evaluate(String fpmlPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
		CounterpartyRoleEnum counterpartyRoleEnum = doEvaluate(fpmlPartyReference, cdmCounterpartyList);
		
		return counterpartyRoleEnum;
	}

	protected abstract CounterpartyRoleEnum doEvaluate(String fpmlPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCounterpartyRoleEnumDefault extends MapCounterpartyRoleEnum {
		@Override
		protected CounterpartyRoleEnum doEvaluate(String fpmlPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			CounterpartyRoleEnum counterpartyRoleEnum = null;
			return assignOutput(counterpartyRoleEnum, fpmlPartyReference, cdmCounterpartyList);
		}
		
		protected CounterpartyRoleEnum assignOutput(CounterpartyRoleEnum counterpartyRoleEnum, String fpmlPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			final MapperC<Counterparty> thenArg0 = MapperC.<Counterparty>of(cdmCounterpartyList)
				.filterItemNullSafe(item -> exists(item.<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).map("getReference", a->a.getExternalReference())).get());
			final MapperC<Counterparty> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).map("getReference", a->a.getExternalReference()), MapperS.of(fpmlPartyReference), CardinalityOperator.All).get());
			final MapperC<CounterpartyRoleEnum> thenArg2 = thenArg1
				.mapItem(item -> item.<CounterpartyRoleEnum>map("getRole", counterparty -> counterparty.getRole()));
			counterpartyRoleEnum = MapperS.of(thenArg2.get()).get();
			
			return counterpartyRoleEnum;
		}
	}
}
