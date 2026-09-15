package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.doc.SupervisorRegistration;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.SupervisoryBody;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(BuildReportableJurisdictionInformation.BuildReportableJurisdictionInformationDefault.class)
public abstract class BuildReportableJurisdictionInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsReportingRegimeMatching isReportingRegimeMatching;
	@Inject protected MapPartyTradeInformationToJurisdictionPartyInformation mapPartyTradeInformationToJurisdictionPartyInformation;
	@Inject protected MapTransactionInformation mapTransactionInformation;

	/**
	* @param regimeName 
	* @param supervisoryBodyValue 
	* @param fpmlPartyTradeInformationList 
	* @param fpmlPartyList 
	* @param fpmlRequestMessageHeader 
	* @return reportableJurisdictionInformation 
	*/
	public ReportableJurisdictionInformation evaluate(RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder reportableJurisdictionInformationBuilder = doEvaluate(regimeName, supervisoryBodyValue, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader);
		
		final ReportableJurisdictionInformation reportableJurisdictionInformation;
		if (reportableJurisdictionInformationBuilder == null) {
			reportableJurisdictionInformation = null;
		} else {
			reportableJurisdictionInformation = reportableJurisdictionInformationBuilder.build();
			objectValidator.validate(ReportableJurisdictionInformation.class, reportableJurisdictionInformation);
		}
		
		return reportableJurisdictionInformation;
	}

	protected abstract ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder doEvaluate(RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperC<? extends PartyTradeInformation> matchingPartyTradeInformation(RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<? extends ReportingRegime> matchingReportingRegime(RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<SupervisoryBodyEnum> supervisoryBody(RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	public static class BuildReportableJurisdictionInformationDefault extends BuildReportableJurisdictionInformation {
		@Override
		protected ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder doEvaluate(RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			if (fpmlPartyTradeInformationList == null) {
				fpmlPartyTradeInformationList = Collections.emptyList();
			}
			if (fpmlPartyList == null) {
				fpmlPartyList = Collections.emptyList();
			}
			ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder reportableJurisdictionInformation = ReportableJurisdictionInformation.builder();
			return assignOutput(reportableJurisdictionInformation, regimeName, supervisoryBodyValue, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader);
		}
		
		protected ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder assignOutput(ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder reportableJurisdictionInformation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			if (exists(matchingPartyTradeInformation(regimeName, supervisoryBodyValue, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader)).getOrDefault(false)) {
				reportableJurisdictionInformation = toBuilder(ReportableJurisdictionInformation.builder()
					.setRegimeNameValue(regimeName)
					.setSupervisoryBodyValue(supervisoryBody(regimeName, supervisoryBodyValue, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader).get())
					.setTransactionInformation(mapTransactionInformation.evaluate(fpmlPartyTradeInformationList, matchingReportingRegime(regimeName, supervisoryBodyValue, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader).get(), supervisoryBody(regimeName, supervisoryBodyValue, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader).get()))
					.setPartyInformation(matchingPartyTradeInformation(regimeName, supervisoryBodyValue, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader)
						.mapItem(item -> MapperS.of(mapPartyTradeInformationToJurisdictionPartyInformation.evaluate(item.get(), regimeName, supervisoryBodyValue, fpmlPartyList, fpmlRequestMessageHeader))).getMulti())
					.build());
			} else {
				reportableJurisdictionInformation = null;
			}
			
			return Optional.ofNullable(reportableJurisdictionInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends PartyTradeInformation> matchingPartyTradeInformation(RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			return MapperC.<PartyTradeInformation>of(fpmlPartyTradeInformationList)
				.filterItemNullSafe(item -> {
					final MapperC<Boolean> thenArg = item.<ReportingRegime>mapC("getReportingRegime", partyTradeInformation -> partyTradeInformation.getReportingRegime())
						.mapItem(_item -> MapperS.of(isReportingRegimeMatching.evaluate(_item.get(), regimeName, supervisoryBodyValue)));
					return areEqual(thenArg, MapperS.of(true), CardinalityOperator.Any).asMapper().get();
				});
		}
		
		@Override
		protected MapperS<? extends ReportingRegime> matchingReportingRegime(RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			final MapperC<ReportingRegime> thenArg = matchingPartyTradeInformation(regimeName, supervisoryBodyValue, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader).<ReportingRegime>mapC("getReportingRegime", partyTradeInformation -> partyTradeInformation.getReportingRegime())
				.filterItemNullSafe(item -> isReportingRegimeMatching.evaluate(item.get(), regimeName, supervisoryBodyValue));
			return thenArg
				.first();
		}
		
		@Override
		protected MapperS<SupervisoryBodyEnum> supervisoryBody(RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			return matchingReportingRegime(regimeName, supervisoryBodyValue, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader).<SupervisorRegistration>mapC("getSupervisorRegistration", reportingRegime -> reportingRegime.getSupervisorRegistration()).<SupervisoryBody>map("getSupervisoryBody", supervisorRegistration -> supervisorRegistration.getSupervisoryBody()).<String>map("getValue", _supervisoryBody -> _supervisoryBody.getValue())
				.first().checkedMap("to-enum", SupervisoryBodyEnum::fromDisplayName, IllegalArgumentException.class);
		}
	}
}
