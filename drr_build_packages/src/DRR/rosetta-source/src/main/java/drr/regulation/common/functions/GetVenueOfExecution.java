package drr.regulation.common.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.PartyInformation;
import drr.regulation.common.ReportableInformation;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetVenueOfExecution.GetVenueOfExecutionDefault.class)
public abstract class GetVenueOfExecution implements RosettaFunction {

	/**
	* @param reportableInformation 
	* @return venueOfExecution 
	*/
	public String evaluate(ReportableInformation reportableInformation) {
		String venueOfExecution = doEvaluate(reportableInformation);
		
		return venueOfExecution;
	}

	protected abstract String doEvaluate(ReportableInformation reportableInformation);

	public static class GetVenueOfExecutionDefault extends GetVenueOfExecution {
		@Override
		protected String doEvaluate(ReportableInformation reportableInformation) {
			String venueOfExecution = null;
			return assignOutput(venueOfExecution, reportableInformation);
		}
		
		protected String assignOutput(String venueOfExecution, ReportableInformation reportableInformation) {
			final MapperC<RelatedParty> thenArg0 = MapperS.of(reportableInformation).<PartyInformation>mapC("getGlobalPartyInformation", _reportableInformation -> _reportableInformation.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty())
				.filterItemNullSafe(item -> areEqual(item.<PartyRoleEnum>map("getRole", relatedParty -> relatedParty.getRole()), MapperS.of(PartyRoleEnum.EXECUTION_FACILITY), CardinalityOperator.All).get());
			final MapperListOfLists<PartyIdentifier> thenArg1 = thenArg0
				.mapItemToList(item -> item.<ReferenceWithMetaParty>map("getPartyReference", relatedParty -> relatedParty.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()));
			final MapperC<PartyIdentifier> thenArg2 = thenArg1
				.flattenList();
			final MapperC<PartyIdentifier> thenArg3 = thenArg2
				.filterItemNullSafe(item -> areEqual(item.<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.MIC), CardinalityOperator.All).get());
			final MapperC<FieldWithMetaString> thenArg4 = thenArg3
				.mapItem(item -> item.<FieldWithMetaString>map("getIdentifier", partyIdentifier -> partyIdentifier.getIdentifier()));
			final FieldWithMetaString fieldWithMetaString = thenArg4
				.first().get();
			if (fieldWithMetaString == null) {
				venueOfExecution = null;
			} else {
				venueOfExecution = fieldWithMetaString.getValue();
			}
			
			return venueOfExecution;
		}
	}
}
