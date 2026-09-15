package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.ReportableJurisdictionInformation;
import fpml.consolidated.business.events.WithdrawalPartyTradeInformation;
import fpml.consolidated.doc.ReportingRegimeIdentifier;
import fpml.consolidated.msg.RequestMessageHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapWithdrawalPartyTradeInformationToReportableJurisdictionInformation.MapWithdrawalPartyTradeInformationToReportableJurisdictionInformationDefault.class)
public abstract class MapWithdrawalPartyTradeInformationToReportableJurisdictionInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapWithdrawalReportableJurisdictionInformation mapWithdrawalReportableJurisdictionInformation;

	/**
	* @param fpmlWithdrawalPartyTradeInformation 
	* @param fpmlRequestMessageHeader 
	* @return reportableJurisdictionInformation 
	*/
	public List<? extends ReportableJurisdictionInformation> evaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, RequestMessageHeader fpmlRequestMessageHeader) {
		List<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> reportableJurisdictionInformationBuilder = doEvaluate(fpmlWithdrawalPartyTradeInformation, fpmlRequestMessageHeader);
		
		final List<? extends ReportableJurisdictionInformation> reportableJurisdictionInformation;
		if (reportableJurisdictionInformationBuilder == null) {
			reportableJurisdictionInformation = null;
		} else {
			reportableJurisdictionInformation = reportableJurisdictionInformationBuilder.stream().map(ReportableJurisdictionInformation::build).collect(Collectors.toList());
			objectValidator.validate(ReportableJurisdictionInformation.class, reportableJurisdictionInformation);
		}
		
		return reportableJurisdictionInformation;
	}

	protected abstract List<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> doEvaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, RequestMessageHeader fpmlRequestMessageHeader);

	public static class MapWithdrawalPartyTradeInformationToReportableJurisdictionInformationDefault extends MapWithdrawalPartyTradeInformationToReportableJurisdictionInformation {
		@Override
		protected List<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> doEvaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, RequestMessageHeader fpmlRequestMessageHeader) {
			List<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> reportableJurisdictionInformation = new ArrayList<>();
			return assignOutput(reportableJurisdictionInformation, fpmlWithdrawalPartyTradeInformation, fpmlRequestMessageHeader);
		}
		
		protected List<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> assignOutput(List<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> reportableJurisdictionInformation, WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, RequestMessageHeader fpmlRequestMessageHeader) {
			reportableJurisdictionInformation = toBuilder(MapperS.of(fpmlWithdrawalPartyTradeInformation).<ReportingRegimeIdentifier>mapC("getReportingRegime", withdrawalPartyTradeInformation -> withdrawalPartyTradeInformation.getReportingRegime())
				.mapItem(item -> MapperS.of(mapWithdrawalReportableJurisdictionInformation.evaluate(fpmlWithdrawalPartyTradeInformation, item.get(), fpmlRequestMessageHeader))).getMulti());
			
			return Optional.ofNullable(reportableJurisdictionInformation)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
