package drr.regulation.common.trade.party.reports;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.party.Address;
import cdm.base.staticdata.party.ContactInformation;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportingSide;
import drr.base.util.party.functions.NaturalPersonBuyerOrSeller;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CountryOfCounterparty2Rule.CountryOfCounterparty2RuleDefault.class)
public abstract class CountryOfCounterparty2Rule implements ReportFunction<TransactionReportInstruction, ISOCountryCodeEnum> {
	
	// RosettaFunction dependencies
	//
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
			output = MapperS.of(input)
				.mapSingleToItem(reportInstruction -> {
					final MapperC<JurisdictionPartyInformation> thenArg0 = MapperS.of(input)
						.mapSingleToList(item -> item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation()).<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()));
					final MapperC<JurisdictionPartyInformation> thenArg1 = thenArg0
						.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), reportInstruction.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).get());
					final MapperS<JurisdictionPartyInformation> thenArg2 = MapperS.of(thenArg1.get());
					final MapperS<FieldWithMetaString> thenArg3 = thenArg2
						.mapSingleToItem(item -> {
							final ReferenceWithMetaParty referenceWithMetaParty = item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).get();
							return MapperS.of(MapperS.of(naturalPersonBuyerOrSeller.evaluate((referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()))).<ContactInformation>map("getContactInformation", naturalPerson -> naturalPerson.getContactInformation()).<Address>mapC("getAddress", contactInformation -> contactInformation.getAddress()).<FieldWithMetaString>map("getCountry", address -> address.getCountry()).get());
						});
					return thenArg3
						.mapSingleToItem(item -> item.<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()).checkedMap("to-enum", ISOCountryCodeEnum::fromDisplayName, IllegalArgumentException.class));
				}).get();
			
			return output;
		}
	}
}
