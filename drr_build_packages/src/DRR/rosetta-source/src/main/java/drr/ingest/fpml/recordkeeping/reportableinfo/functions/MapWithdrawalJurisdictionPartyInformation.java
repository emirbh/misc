package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import cdm.ingest.fpml.confirmation.party.functions.MapPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import fpml.consolidated.business.events.WithdrawalPartyTradeInformation;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapWithdrawalJurisdictionPartyInformation.MapWithdrawalJurisdictionPartyInformationDefault.class)
public abstract class MapWithdrawalJurisdictionPartyInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyReference mapPartyReference;
	@Inject protected MapTechnicalRecordId mapTechnicalRecordId;

	/**
	* @param fpmlWithdrawalPartyTradeInformation 
	* @param fpmlRequestMessageHeader 
	* @param regimeName 
	* @param supervisoryBody 
	* @return jurisdictionPartyInformation 
	*/
	public JurisdictionPartyInformation evaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, RequestMessageHeader fpmlRequestMessageHeader, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody) {
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder jurisdictionPartyInformationBuilder = doEvaluate(fpmlWithdrawalPartyTradeInformation, fpmlRequestMessageHeader, regimeName, supervisoryBody);
		
		final JurisdictionPartyInformation jurisdictionPartyInformation;
		if (jurisdictionPartyInformationBuilder == null) {
			jurisdictionPartyInformation = null;
		} else {
			jurisdictionPartyInformation = jurisdictionPartyInformationBuilder.build();
			objectValidator.validate(JurisdictionPartyInformation.class, jurisdictionPartyInformation);
		}
		
		return jurisdictionPartyInformation;
	}

	protected abstract JurisdictionPartyInformation.JurisdictionPartyInformationBuilder doEvaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, RequestMessageHeader fpmlRequestMessageHeader, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody);

	public static class MapWithdrawalJurisdictionPartyInformationDefault extends MapWithdrawalJurisdictionPartyInformation {
		@Override
		protected JurisdictionPartyInformation.JurisdictionPartyInformationBuilder doEvaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, RequestMessageHeader fpmlRequestMessageHeader, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody) {
			JurisdictionPartyInformation.JurisdictionPartyInformationBuilder jurisdictionPartyInformation = JurisdictionPartyInformation.builder();
			return assignOutput(jurisdictionPartyInformation, fpmlWithdrawalPartyTradeInformation, fpmlRequestMessageHeader, regimeName, supervisoryBody);
		}
		
		protected JurisdictionPartyInformation.JurisdictionPartyInformationBuilder assignOutput(JurisdictionPartyInformation.JurisdictionPartyInformationBuilder jurisdictionPartyInformation, WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, RequestMessageHeader fpmlRequestMessageHeader, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody) {
			jurisdictionPartyInformation = toBuilder(JurisdictionPartyInformation.builder()
				.setPartyReference(mapPartyReference.evaluate(MapperS.of(fpmlWithdrawalPartyTradeInformation).<PartyReference>map("getPartyReference", withdrawalPartyTradeInformation -> withdrawalPartyTradeInformation.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get()))
				.setMandatorilyClearable(null)
				.setEsmaPartyInformation(null)
				.setFcaPartyInformation(null)
				.setHkmaPartyInformation(null)
				.setCftcPartyInformation(null)
				.setSecPartyInformation(null)
				.setReportingRole(null)
				.setTechnicalRecordId(mapTechnicalRecordId.evaluate(fpmlRequestMessageHeader, supervisoryBody))
				.build());
			
			return Optional.ofNullable(jurisdictionPartyInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
