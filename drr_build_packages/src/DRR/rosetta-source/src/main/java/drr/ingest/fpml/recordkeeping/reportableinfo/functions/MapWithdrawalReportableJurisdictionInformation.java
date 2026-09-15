package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import fpml.consolidated.business.events.WithdrawalPartyTradeInformation;
import fpml.consolidated.doc.ReportingRegimeIdentifier;
import fpml.consolidated.doc.SupervisorRegistration;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.ReportingRegimeName;
import fpml.consolidated.shared.SupervisoryBody;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapWithdrawalReportableJurisdictionInformation.MapWithdrawalReportableJurisdictionInformationDefault.class)
public abstract class MapWithdrawalReportableJurisdictionInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapRegimeNameEnum mapRegimeNameEnum;
	@Inject protected MapWithdrawalJurisdictionPartyInformation mapWithdrawalJurisdictionPartyInformation;
	@Inject protected MapWithdrawalTransactionInformation mapWithdrawalTransactionInformation;

	/**
	* @param fpmlWithdrawalPartyTradeInformation 
	* @param fpmlReportingRegime 
	* @param fpmlRequestMessageHeader 
	* @return reportableJurisdictionInformation 
	*/
	public ReportableJurisdictionInformation evaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, ReportingRegimeIdentifier fpmlReportingRegime, RequestMessageHeader fpmlRequestMessageHeader) {
		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder reportableJurisdictionInformationBuilder = doEvaluate(fpmlWithdrawalPartyTradeInformation, fpmlReportingRegime, fpmlRequestMessageHeader);
		
		final ReportableJurisdictionInformation reportableJurisdictionInformation;
		if (reportableJurisdictionInformationBuilder == null) {
			reportableJurisdictionInformation = null;
		} else {
			reportableJurisdictionInformation = reportableJurisdictionInformationBuilder.build();
			objectValidator.validate(ReportableJurisdictionInformation.class, reportableJurisdictionInformation);
		}
		
		return reportableJurisdictionInformation;
	}

	protected abstract ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder doEvaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, ReportingRegimeIdentifier fpmlReportingRegime, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<SupervisoryBodyEnum> supervisoryBody(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, ReportingRegimeIdentifier fpmlReportingRegime, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<RegimeNameEnum> regimeName(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, ReportingRegimeIdentifier fpmlReportingRegime, RequestMessageHeader fpmlRequestMessageHeader);

	public static class MapWithdrawalReportableJurisdictionInformationDefault extends MapWithdrawalReportableJurisdictionInformation {
		@Override
		protected ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder doEvaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, ReportingRegimeIdentifier fpmlReportingRegime, RequestMessageHeader fpmlRequestMessageHeader) {
			ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder reportableJurisdictionInformation = ReportableJurisdictionInformation.builder();
			return assignOutput(reportableJurisdictionInformation, fpmlWithdrawalPartyTradeInformation, fpmlReportingRegime, fpmlRequestMessageHeader);
		}
		
		protected ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder assignOutput(ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder reportableJurisdictionInformation, WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, ReportingRegimeIdentifier fpmlReportingRegime, RequestMessageHeader fpmlRequestMessageHeader) {
			reportableJurisdictionInformation = toBuilder(ReportableJurisdictionInformation.builder()
				.setRegimeNameValue(regimeName(fpmlWithdrawalPartyTradeInformation, fpmlReportingRegime, fpmlRequestMessageHeader).get())
				.setSupervisoryBodyValue(supervisoryBody(fpmlWithdrawalPartyTradeInformation, fpmlReportingRegime, fpmlRequestMessageHeader).get())
				.setTransactionInformation(mapWithdrawalTransactionInformation.evaluate(fpmlWithdrawalPartyTradeInformation, fpmlReportingRegime))
				.setPartyInformation(MapperC.<JurisdictionPartyInformation>of(MapperS.of(mapWithdrawalJurisdictionPartyInformation.evaluate(fpmlWithdrawalPartyTradeInformation, fpmlRequestMessageHeader, regimeName(fpmlWithdrawalPartyTradeInformation, fpmlReportingRegime, fpmlRequestMessageHeader).get(), supervisoryBody(fpmlWithdrawalPartyTradeInformation, fpmlReportingRegime, fpmlRequestMessageHeader).get()))).getMulti())
				.build());
			
			return Optional.ofNullable(reportableJurisdictionInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<SupervisoryBodyEnum> supervisoryBody(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, ReportingRegimeIdentifier fpmlReportingRegime, RequestMessageHeader fpmlRequestMessageHeader) {
			return MapperS.of(fpmlReportingRegime).<SupervisorRegistration>mapC("getSupervisorRegistration", reportingRegimeIdentifier -> reportingRegimeIdentifier.getSupervisorRegistration()).<SupervisoryBody>map("getSupervisoryBody", supervisorRegistration -> supervisorRegistration.getSupervisoryBody()).<String>map("getValue", _supervisoryBody -> _supervisoryBody.getValue())
				.first().checkedMap("to-enum", SupervisoryBodyEnum::fromDisplayName, IllegalArgumentException.class);
		}
		
		@Override
		protected MapperS<RegimeNameEnum> regimeName(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, ReportingRegimeIdentifier fpmlReportingRegime, RequestMessageHeader fpmlRequestMessageHeader) {
			return MapperS.of(mapRegimeNameEnum.evaluate(MapperS.of(fpmlReportingRegime).<ReportingRegimeName>map("getName", reportingRegimeIdentifier -> reportingRegimeIdentifier.getName()).get()));
		}
	}
}
