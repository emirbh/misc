package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.doc.SupervisorRegistration;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SupervisoryBody;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapPartyTradeInformationToJurisdictionPartyInformation.MapPartyTradeInformationToJurisdictionPartyInformationDefault.class)
public abstract class MapPartyTradeInformationToJurisdictionPartyInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsReportingRegimeMatching isReportingRegimeMatching;
	@Inject protected MapJurisdictionPartyInformation mapJurisdictionPartyInformation;

	/**
	* @param fpmlPartyTradeInformation 
	* @param regimeName 
	* @param supervisoryBodyValue 
	* @param fpmlPartyList 
	* @param fpmlRequestMessageHeader 
	* @return jurisdictionPartyInformation 
	*/
	public JurisdictionPartyInformation evaluate(PartyTradeInformation fpmlPartyTradeInformation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder jurisdictionPartyInformationBuilder = doEvaluate(fpmlPartyTradeInformation, regimeName, supervisoryBodyValue, fpmlPartyList, fpmlRequestMessageHeader);
		
		final JurisdictionPartyInformation jurisdictionPartyInformation;
		if (jurisdictionPartyInformationBuilder == null) {
			jurisdictionPartyInformation = null;
		} else {
			jurisdictionPartyInformation = jurisdictionPartyInformationBuilder.build();
			objectValidator.validate(JurisdictionPartyInformation.class, jurisdictionPartyInformation);
		}
		
		return jurisdictionPartyInformation;
	}

	protected abstract JurisdictionPartyInformation.JurisdictionPartyInformationBuilder doEvaluate(PartyTradeInformation fpmlPartyTradeInformation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<? extends Party> fpmlParty(PartyTradeInformation fpmlPartyTradeInformation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<? extends ReportingRegime> matchingReportingRegime(PartyTradeInformation fpmlPartyTradeInformation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<SupervisoryBodyEnum> supervisoryBody(PartyTradeInformation fpmlPartyTradeInformation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	public static class MapPartyTradeInformationToJurisdictionPartyInformationDefault extends MapPartyTradeInformationToJurisdictionPartyInformation {
		@Override
		protected JurisdictionPartyInformation.JurisdictionPartyInformationBuilder doEvaluate(PartyTradeInformation fpmlPartyTradeInformation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			if (fpmlPartyList == null) {
				fpmlPartyList = Collections.emptyList();
			}
			JurisdictionPartyInformation.JurisdictionPartyInformationBuilder jurisdictionPartyInformation = JurisdictionPartyInformation.builder();
			return assignOutput(jurisdictionPartyInformation, fpmlPartyTradeInformation, regimeName, supervisoryBodyValue, fpmlPartyList, fpmlRequestMessageHeader);
		}
		
		protected JurisdictionPartyInformation.JurisdictionPartyInformationBuilder assignOutput(JurisdictionPartyInformation.JurisdictionPartyInformationBuilder jurisdictionPartyInformation, PartyTradeInformation fpmlPartyTradeInformation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			if (exists(matchingReportingRegime(fpmlPartyTradeInformation, regimeName, supervisoryBodyValue, fpmlPartyList, fpmlRequestMessageHeader)).getOrDefault(false)) {
				jurisdictionPartyInformation = toBuilder(mapJurisdictionPartyInformation.evaluate(fpmlPartyTradeInformation, matchingReportingRegime(fpmlPartyTradeInformation, regimeName, supervisoryBodyValue, fpmlPartyList, fpmlRequestMessageHeader).get(), fpmlParty(fpmlPartyTradeInformation, regimeName, supervisoryBodyValue, fpmlPartyList, fpmlRequestMessageHeader).get(), fpmlRequestMessageHeader, regimeName, supervisoryBody(fpmlPartyTradeInformation, regimeName, supervisoryBodyValue, fpmlPartyList, fpmlRequestMessageHeader).get()));
			} else {
				jurisdictionPartyInformation = null;
			}
			
			return Optional.ofNullable(jurisdictionPartyInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Party> fpmlParty(PartyTradeInformation fpmlPartyTradeInformation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			final MapperC<Party> thenArg = MapperC.<Party>of(fpmlPartyList)
				.filterItemNullSafe(item -> areEqual(item.<String>map("getId", party -> party.getId()), MapperS.of(fpmlPartyTradeInformation).<PartyReference>map("getPartyReference", partyTradeInformation -> partyTradeInformation.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()), CardinalityOperator.All).get());
			return thenArg
				.first();
		}
		
		@Override
		protected MapperS<? extends ReportingRegime> matchingReportingRegime(PartyTradeInformation fpmlPartyTradeInformation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			final MapperC<ReportingRegime> thenArg = MapperS.of(fpmlPartyTradeInformation).<ReportingRegime>mapC("getReportingRegime", partyTradeInformation -> partyTradeInformation.getReportingRegime())
				.filterItemNullSafe(item -> isReportingRegimeMatching.evaluate(item.get(), regimeName, supervisoryBodyValue));
			return thenArg
				.first();
		}
		
		@Override
		protected MapperS<SupervisoryBodyEnum> supervisoryBody(PartyTradeInformation fpmlPartyTradeInformation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			return matchingReportingRegime(fpmlPartyTradeInformation, regimeName, supervisoryBodyValue, fpmlPartyList, fpmlRequestMessageHeader).<SupervisorRegistration>mapC("getSupervisorRegistration", reportingRegime -> reportingRegime.getSupervisorRegistration()).<SupervisoryBody>map("getSupervisoryBody", supervisorRegistration -> supervisorRegistration.getSupervisoryBody()).<String>map("getValue", _supervisoryBody -> _supervisoryBody.getValue())
				.first().checkedMap("to-enum", SupervisoryBodyEnum::fromDisplayName, IllegalArgumentException.class);
		}
	}
}
