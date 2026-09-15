package drr.regulation.common.trade.execution.reports;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.party.Address;
import cdm.base.staticdata.party.ContactInformation;
import cdm.base.staticdata.party.NaturalPerson;
import cdm.base.staticdata.party.NaturalPersonRole;
import cdm.base.staticdata.party.NaturalPersonRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.FieldWithMetaNaturalPersonRoleEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaNaturalPerson;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.PartyInformation;
import drr.base.trade.ReportingSide;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import java.util.ArrayList;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(TraderLocationRule.TraderLocationRuleDefault.class)
public abstract class TraderLocationRule implements ReportFunction<TransactionReportInstruction, List<ISOCountryCodeEnum>> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<ISOCountryCodeEnum> evaluate(TransactionReportInstruction input) {
		List<ISOCountryCodeEnum> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<ISOCountryCodeEnum> doEvaluate(TransactionReportInstruction input);

	public static class TraderLocationRuleDefault extends TraderLocationRule {
		@Override
		protected List<ISOCountryCodeEnum> doEvaluate(TransactionReportInstruction input) {
			List<ISOCountryCodeEnum> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<ISOCountryCodeEnum> assignOutput(List<ISOCountryCodeEnum> output, TransactionReportInstruction input) {
			final MapperS<PartyInformation> thenArg0 = MapperS.of(input)
				.mapSingleToItem(reportInstruction -> {
					final MapperC<PartyInformation> _thenArg0 = MapperS.of(input).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation());
					final MapperC<PartyInformation> _thenArg1 = _thenArg0
						.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", partyInformation -> partyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), reportInstruction.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).get());
					return MapperS.of(_thenArg1.get());
				});
			final MapperC<NaturalPersonRole> thenArg1 = thenArg0
				.mapSingleToList(item -> item.<NaturalPersonRole>mapC("getRelatedPerson", partyInformation -> partyInformation.getRelatedPerson()));
			final MapperC<NaturalPersonRole> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaNaturalPersonRoleEnum>mapC("getRole", naturalPersonRole -> naturalPersonRole.getRole()).<NaturalPersonRoleEnum>map("Type coercion", fieldWithMetaNaturalPersonRoleEnum -> fieldWithMetaNaturalPersonRoleEnum.getValue()), MapperS.of(NaturalPersonRoleEnum.TRADER), CardinalityOperator.Any).get());
			output = thenArg2
				.mapItem(item -> {
					final FieldWithMetaString fieldWithMetaString = item.<ReferenceWithMetaNaturalPerson>map("getPersonReference", naturalPersonRole -> naturalPersonRole.getPersonReference()).<NaturalPerson>map("Type coercion", referenceWithMetaNaturalPerson -> referenceWithMetaNaturalPerson == null ? null : referenceWithMetaNaturalPerson.getValue()).<ContactInformation>map("getContactInformation", naturalPerson -> naturalPerson.getContactInformation()).<Address>mapC("getAddress", contactInformation -> contactInformation.getAddress()).<FieldWithMetaString>map("getCountry", address -> address.getCountry()).get();
					return (fieldWithMetaString == null ? MapperS.<String>ofNull() : MapperS.of(fieldWithMetaString.getValue())).checkedMap("to-enum", ISOCountryCodeEnum::fromDisplayName, IllegalArgumentException.class);
				}).getMulti();
			
			return output;
		}
	}
}
