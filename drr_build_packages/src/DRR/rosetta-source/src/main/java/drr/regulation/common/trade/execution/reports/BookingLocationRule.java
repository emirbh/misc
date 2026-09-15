package drr.regulation.common.trade.execution.reports;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.party.Address;
import cdm.base.staticdata.party.ContactInformation;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportingSide;
import drr.regulation.common.TransactionReportInstruction;


@ImplementedBy(BookingLocationRule.BookingLocationRuleDefault.class)
public abstract class BookingLocationRule implements ReportFunction<TransactionReportInstruction, ISOCountryCodeEnum> {

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

	public static class BookingLocationRuleDefault extends BookingLocationRule {
		@Override
		protected ISOCountryCodeEnum doEvaluate(TransactionReportInstruction input) {
			ISOCountryCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCountryCodeEnum assignOutput(ISOCountryCodeEnum output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					final FieldWithMetaString fieldWithMetaString = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()).<ContactInformation>map("getContactInformation", party -> party.getContactInformation()).<Address>mapC("getAddress", contactInformation -> contactInformation.getAddress()).<FieldWithMetaString>map("getCountry", address -> address.getCountry()).get();
					return (fieldWithMetaString == null ? MapperS.<String>ofNull() : MapperS.of(fieldWithMetaString.getValue())).checkedMap("to-enum", ISOCountryCodeEnum::fromDisplayName, IllegalArgumentException.class);
				}).get();
			
			return output;
		}
	}
}
