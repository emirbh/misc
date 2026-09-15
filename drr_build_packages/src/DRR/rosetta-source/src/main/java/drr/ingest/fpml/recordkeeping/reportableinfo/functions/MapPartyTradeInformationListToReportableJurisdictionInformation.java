package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.csa.rewrite.trade.functions.SupervisoryBodyForCSA;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Party;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapPartyTradeInformationListToReportableJurisdictionInformation.MapPartyTradeInformationListToReportableJurisdictionInformationDefault.class)
public abstract class MapPartyTradeInformationListToReportableJurisdictionInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected BuildReportableJurisdictionInformation buildReportableJurisdictionInformation;
	@Inject protected SupervisoryBodyForCSA supervisoryBodyForCSA;

	/**
	* @param fpmlPartyTradeInformationList 
	* @param fpmlPartyList 
	* @param fpmlRequestMessageHeader 
	* @return reportableJurisdictionInformation 
	*/
	public List<? extends ReportableJurisdictionInformation> evaluate(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
		List<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> reportableJurisdictionInformationBuilder = doEvaluate(fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader);
		
		final List<? extends ReportableJurisdictionInformation> reportableJurisdictionInformation;
		if (reportableJurisdictionInformationBuilder == null) {
			reportableJurisdictionInformation = null;
		} else {
			reportableJurisdictionInformation = reportableJurisdictionInformationBuilder.stream().map(ReportableJurisdictionInformation::build).collect(Collectors.toList());
			objectValidator.validate(ReportableJurisdictionInformation.class, reportableJurisdictionInformation);
		}
		
		return reportableJurisdictionInformation;
	}

	protected abstract List<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> doEvaluate(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<? extends ReportableJurisdictionInformation> emirEsma(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<? extends ReportableJurisdictionInformation> ukEmirFca(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<? extends ReportableJurisdictionInformation> jfsaJfsa(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperC<? extends ReportableJurisdictionInformation> csaCsa(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<? extends ReportableJurisdictionInformation> hkmaHkma(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<? extends ReportableJurisdictionInformation> cftcCftc(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<? extends ReportableJurisdictionInformation> secSec(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<? extends ReportableJurisdictionInformation> asicAsic(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<? extends ReportableJurisdictionInformation> masMas(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	public static class MapPartyTradeInformationListToReportableJurisdictionInformationDefault extends MapPartyTradeInformationListToReportableJurisdictionInformation {
		@Override
		protected List<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> doEvaluate(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			if (fpmlPartyTradeInformationList == null) {
				fpmlPartyTradeInformationList = Collections.emptyList();
			}
			if (fpmlPartyList == null) {
				fpmlPartyList = Collections.emptyList();
			}
			List<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> reportableJurisdictionInformation = new ArrayList<>();
			return assignOutput(reportableJurisdictionInformation, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader);
		}
		
		protected List<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> assignOutput(List<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> reportableJurisdictionInformation, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			reportableJurisdictionInformation = toBuilder(MapperC.<ReportableJurisdictionInformation>of(emirEsma(fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader), ukEmirFca(fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader), jfsaJfsa(fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader), csaCsa(fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader), hkmaHkma(fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader), cftcCftc(fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader), secSec(fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader), asicAsic(fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader), masMas(fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader)).getMulti());
			
			return Optional.ofNullable(reportableJurisdictionInformation)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReportableJurisdictionInformation> emirEsma(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			return MapperS.of(buildReportableJurisdictionInformation.evaluate(RegimeNameEnum.EMIR, SupervisoryBodyEnum.ESMA, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader));
		}
		
		@Override
		protected MapperS<? extends ReportableJurisdictionInformation> ukEmirFca(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			return MapperS.of(buildReportableJurisdictionInformation.evaluate(RegimeNameEnum.UKEMIR, SupervisoryBodyEnum.FCA, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader));
		}
		
		@Override
		protected MapperS<? extends ReportableJurisdictionInformation> jfsaJfsa(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			return MapperS.of(buildReportableJurisdictionInformation.evaluate(RegimeNameEnum.JFSA, SupervisoryBodyEnum.JFSA, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader));
		}
		
		@Override
		protected MapperC<? extends ReportableJurisdictionInformation> csaCsa(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			final MapperC<SupervisoryBodyEnum> thenArg = MapperC.<SupervisoryBodyEnum>of(supervisoryBodyForCSA.evaluate());
			return thenArg
				.mapItem(item -> MapperS.of(buildReportableJurisdictionInformation.evaluate(RegimeNameEnum.CSA, item.get(), fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader)));
		}
		
		@Override
		protected MapperS<? extends ReportableJurisdictionInformation> hkmaHkma(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			return MapperS.of(buildReportableJurisdictionInformation.evaluate(RegimeNameEnum.HKMA, SupervisoryBodyEnum.HKMA, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader));
		}
		
		@Override
		protected MapperS<? extends ReportableJurisdictionInformation> cftcCftc(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			return MapperS.of(buildReportableJurisdictionInformation.evaluate(RegimeNameEnum.DODD_FRANK_ACT, SupervisoryBodyEnum.CFTC, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader));
		}
		
		@Override
		protected MapperS<? extends ReportableJurisdictionInformation> secSec(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			return MapperS.of(buildReportableJurisdictionInformation.evaluate(RegimeNameEnum.DODD_FRANK_ACT, SupervisoryBodyEnum.SEC, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader));
		}
		
		@Override
		protected MapperS<? extends ReportableJurisdictionInformation> asicAsic(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			return MapperS.of(buildReportableJurisdictionInformation.evaluate(RegimeNameEnum.ASIC, SupervisoryBodyEnum.ASIC, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader));
		}
		
		@Override
		protected MapperS<? extends ReportableJurisdictionInformation> masMas(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			return MapperS.of(buildReportableJurisdictionInformation.evaluate(RegimeNameEnum.MAS, SupervisoryBodyEnum.MAS, fpmlPartyTradeInformationList, fpmlPartyList, fpmlRequestMessageHeader));
		}
	}
}
