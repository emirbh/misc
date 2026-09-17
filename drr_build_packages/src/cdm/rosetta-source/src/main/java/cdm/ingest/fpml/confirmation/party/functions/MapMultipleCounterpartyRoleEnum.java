package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapMultipleCounterpartyRoleEnum.MapMultipleCounterpartyRoleEnumDefault.class)
public abstract class MapMultipleCounterpartyRoleEnum implements RosettaFunction {

	/**
	* @param fpmlPartyReference1 
	* @param fpmlPartyReference2 
	* @param cdmCounterpartyList 
	* @return counterpartyRoleEnum 
	*/
	public List<CounterpartyRoleEnum> evaluate(String fpmlPartyReference1, String fpmlPartyReference2, List<? extends Counterparty> cdmCounterpartyList) {
		List<CounterpartyRoleEnum> counterpartyRoleEnum = doEvaluate(fpmlPartyReference1, fpmlPartyReference2, cdmCounterpartyList);
		
		return counterpartyRoleEnum;
	}

	protected abstract List<CounterpartyRoleEnum> doEvaluate(String fpmlPartyReference1, String fpmlPartyReference2, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapMultipleCounterpartyRoleEnumDefault extends MapMultipleCounterpartyRoleEnum {
		@Override
		protected List<CounterpartyRoleEnum> doEvaluate(String fpmlPartyReference1, String fpmlPartyReference2, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<CounterpartyRoleEnum> counterpartyRoleEnum = new ArrayList<>();
			return assignOutput(counterpartyRoleEnum, fpmlPartyReference1, fpmlPartyReference2, cdmCounterpartyList);
		}
		
		protected List<CounterpartyRoleEnum> assignOutput(List<CounterpartyRoleEnum> counterpartyRoleEnum, String fpmlPartyReference1, String fpmlPartyReference2, List<? extends Counterparty> cdmCounterpartyList) {
			final MapperC<Counterparty> thenArg0 = MapperC.<Counterparty>of(cdmCounterpartyList)
				.filterItemNullSafe(item -> exists(item.<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).map("getReference", a->a.getExternalReference())).get());
			final MapperC<Counterparty> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).map("getReference", a->a.getExternalReference()), MapperS.of(fpmlPartyReference1), CardinalityOperator.All).get());
			counterpartyRoleEnum.addAll(thenArg1
				.mapItem(item -> item.<CounterpartyRoleEnum>map("getRole", counterparty -> counterparty.getRole())).getMulti());
			
			final MapperC<Counterparty> thenArg2 = MapperC.<Counterparty>of(cdmCounterpartyList)
				.filterItemNullSafe(item -> exists(item.<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).map("getReference", a->a.getExternalReference())).get());
			final MapperC<Counterparty> thenArg3 = thenArg2
				.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).map("getReference", a->a.getExternalReference()), MapperS.of(fpmlPartyReference2), CardinalityOperator.All).get());
			counterpartyRoleEnum.addAll(thenArg3
				.mapItem(item -> item.<CounterpartyRoleEnum>map("getRole", counterparty -> counterparty.getRole())).getMulti());
			
			return counterpartyRoleEnum;
		}
	}
}
