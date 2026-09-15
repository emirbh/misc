package drr.regulation.asic.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.party.Address;
import cdm.base.staticdata.party.ContactInformation;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportingSide;
import drr.base.util.party.functions.NaturalPersonBuyerOrSeller;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CountryOfCounterparty2Rule.CountryOfCounterparty2RuleDefault.class)
public abstract class CountryOfCounterparty2Rule implements ReportFunction<TransactionReportInstruction, ISOCountryCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected NaturalPersonBuyerOrSeller naturalPersonBuyerOrSeller;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCountryCodeEnum evaluate(TransactionReportInstruction input) {
		ISOCountryCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCountryCodeEnum doEvaluate(TransactionReportInstruction input);

	public static class CountryOfCounterparty2RuleDefault extends CountryOfCounterparty2Rule {
		@Override
		protected ISOCountryCodeEnum doEvaluate(TransactionReportInstruction input) {
			ISOCountryCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCountryCodeEnum assignOutput(ISOCountryCodeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(reportInstruction -> {
					final MapperC<ReportableJurisdictionInformation> thenArg0 = thenArg
						.mapSingleToList(item -> item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation()));
					final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
						.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.ASIC), CardinalityOperator.All).get());
					final MapperListOfLists<JurisdictionPartyInformation> thenArg2 = thenArg1
						.mapItemToList(item -> item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()));
					final MapperListOfLists<JurisdictionPartyInformation> thenArg3 = thenArg2
						.filterListNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", _referenceWithMetaParty -> _referenceWithMetaParty.getValue()), reportInstruction.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), CardinalityOperator.Any).get());
					final MapperS<JurisdictionPartyInformation> thenArg4 = MapperS.of(thenArg3
						.flattenList().get());
					final MapperS<FieldWithMetaString> thenArg5 = thenArg4
						.mapSingleToItem(item -> {
							if (notEqual(item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.All).getOrDefault(false)) {
								final ReferenceWithMetaParty referenceWithMetaParty2 = item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).get();
								return MapperS.of(MapperS.of(item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()).<ContactInformation>map("getContactInformation", party -> party.getContactInformation()).<Address>mapC("getAddress", contactInformation -> contactInformation.getAddress()).<FieldWithMetaString>map("getCountry", address -> address.getCountry()).get()).getOrDefault(MapperS.of(naturalPersonBuyerOrSeller.evaluate((referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue()))).<ContactInformation>map("getContactInformation", naturalPerson -> naturalPerson.getContactInformation()).<Address>mapC("getAddress", contactInformation -> contactInformation.getAddress()).<FieldWithMetaString>map("getCountry", address -> address.getCountry()).get()));
							}
							return MapperS.<FieldWithMetaString>ofNull();
						});
					return thenArg5
						.mapSingleToItem(item -> item.<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()).checkedMap("to-enum", ISOCountryCodeEnum::fromDisplayName, IllegalArgumentException.class));
				}).get();
			
			return output;
		}
	}
}
