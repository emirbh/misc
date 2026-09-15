package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import cdm.ingest.fpml.confirmation.party.functions.MapPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportingRoleEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.ReportingBoolean;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapJurisdictionPartyInformation.MapJurisdictionPartyInformationDefault.class)
public abstract class MapJurisdictionPartyInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMandatorilyClearableEnum mapMandatorilyClearableEnum;
	@Inject protected MapPartyReference mapPartyReference;
	@Inject protected MapReportingRegimeToCFTCPartyInformation mapReportingRegimeToCFTCPartyInformation;
	@Inject protected MapReportingRegimeToESMAPartyInformation mapReportingRegimeToESMAPartyInformation;
	@Inject protected MapReportingRegimeToFCAPartyInformation mapReportingRegimeToFCAPartyInformation;
	@Inject protected MapReportingRegimeToHKMAPartyInformation mapReportingRegimeToHKMAPartyInformation;
	@Inject protected MapReportingRegimeToSECPartyInformation mapReportingRegimeToSECPartyInformation;
	@Inject protected MapTechnicalRecordId mapTechnicalRecordId;

	/**
	* @param fpmlPartyTradeInformation 
	* @param fpmlReportingRegime 
	* @param fpmlParty 
	* @param fpmlRequestMessageHeader 
	* @param regimeName 
	* @param supervisoryBody 
	* @return jurisdictionPartyInformation 
	*/
	public JurisdictionPartyInformation evaluate(PartyTradeInformation fpmlPartyTradeInformation, ReportingRegime fpmlReportingRegime, Party fpmlParty, RequestMessageHeader fpmlRequestMessageHeader, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody) {
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder jurisdictionPartyInformationBuilder = doEvaluate(fpmlPartyTradeInformation, fpmlReportingRegime, fpmlParty, fpmlRequestMessageHeader, regimeName, supervisoryBody);
		
		final JurisdictionPartyInformation jurisdictionPartyInformation;
		if (jurisdictionPartyInformationBuilder == null) {
			jurisdictionPartyInformation = null;
		} else {
			jurisdictionPartyInformation = jurisdictionPartyInformationBuilder.build();
			objectValidator.validate(JurisdictionPartyInformation.class, jurisdictionPartyInformation);
		}
		
		return jurisdictionPartyInformation;
	}

	protected abstract JurisdictionPartyInformation.JurisdictionPartyInformationBuilder doEvaluate(PartyTradeInformation fpmlPartyTradeInformation, ReportingRegime fpmlReportingRegime, Party fpmlParty, RequestMessageHeader fpmlRequestMessageHeader, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody);

	public static class MapJurisdictionPartyInformationDefault extends MapJurisdictionPartyInformation {
		@Override
		protected JurisdictionPartyInformation.JurisdictionPartyInformationBuilder doEvaluate(PartyTradeInformation fpmlPartyTradeInformation, ReportingRegime fpmlReportingRegime, Party fpmlParty, RequestMessageHeader fpmlRequestMessageHeader, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody) {
			JurisdictionPartyInformation.JurisdictionPartyInformationBuilder jurisdictionPartyInformation = JurisdictionPartyInformation.builder();
			return assignOutput(jurisdictionPartyInformation, fpmlPartyTradeInformation, fpmlReportingRegime, fpmlParty, fpmlRequestMessageHeader, regimeName, supervisoryBody);
		}
		
		protected JurisdictionPartyInformation.JurisdictionPartyInformationBuilder assignOutput(JurisdictionPartyInformation.JurisdictionPartyInformationBuilder jurisdictionPartyInformation, PartyTradeInformation fpmlPartyTradeInformation, ReportingRegime fpmlReportingRegime, Party fpmlParty, RequestMessageHeader fpmlRequestMessageHeader, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody) {
			jurisdictionPartyInformation = toBuilder(JurisdictionPartyInformation.builder()
				.setPartyReference(mapPartyReference.evaluate(MapperS.of(fpmlPartyTradeInformation).<PartyReference>map("getPartyReference", partyTradeInformation -> partyTradeInformation.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get()))
				.setMandatorilyClearable(mapMandatorilyClearableEnum.evaluate(MapperS.of(fpmlReportingRegime).<ReportingBoolean>map("getMandatorilyClearable", reportingRegime -> reportingRegime.getMandatorilyClearable()).get()))
				.setEsmaPartyInformation(mapReportingRegimeToESMAPartyInformation.evaluate(fpmlReportingRegime, fpmlParty, supervisoryBody))
				.setFcaPartyInformation(mapReportingRegimeToFCAPartyInformation.evaluate(fpmlReportingRegime, fpmlParty, supervisoryBody))
				.setHkmaPartyInformation(mapReportingRegimeToHKMAPartyInformation.evaluate(fpmlReportingRegime, fpmlParty, supervisoryBody))
				.setCftcPartyInformation(mapReportingRegimeToCFTCPartyInformation.evaluate(fpmlReportingRegime, fpmlParty, supervisoryBody))
				.setSecPartyInformation(mapReportingRegimeToSECPartyInformation.evaluate(fpmlReportingRegime, fpmlParty, supervisoryBody))
				.setReportingRole(MapperS.of(fpmlReportingRegime).<ReportingRole>map("getReportingRole", reportingRegime -> reportingRegime.getReportingRole()).<String>map("getValue", reportingRole -> reportingRole.getValue()).checkedMap("to-enum", ReportingRoleEnum::fromDisplayName, IllegalArgumentException.class).get())
				.setTechnicalRecordId(mapTechnicalRecordId.evaluate(fpmlRequestMessageHeader, supervisoryBody))
				.setPostPricedIndicator(MapperS.of(fpmlReportingRegime).<Boolean>map("getPostPricedIndicator", reportingRegime -> reportingRegime.getPostPricedIndicator()).get())
				.build());
			
			return Optional.ofNullable(jurisdictionPartyInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
