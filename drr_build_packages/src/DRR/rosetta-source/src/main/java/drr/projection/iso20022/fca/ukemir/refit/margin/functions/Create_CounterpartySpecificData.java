package drr.projection.iso20022.fca.ukemir.refit.margin.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import iso20022.auth108.fca.Counterparty45__1;
import iso20022.auth108.fca.Counterparty46__1;
import iso20022.auth108.fca.GenericIdentification175__1;
import iso20022.auth108.fca.LegalPersonIdentification1__1;
import iso20022.auth108.fca.NaturalPersonIdentification2__1;
import iso20022.auth108.fca.NaturalPersonIdentification3__1;
import iso20022.auth108.fca.OrganisationIdentification15Choice__1;
import iso20022.auth108.fca.PartyIdentification248Choice__1;
import iso20022.auth108.fca.PartyIdentification248Choice__2;
import iso20022.auth108.fca.TradeCounterpartyRelationship1Choice__1;
import iso20022.auth108.fca.TradeCounterpartyRelationshipRecord1__1;
import iso20022.auth108.fca.TradeCounterpartyReport20__1;
import iso20022.auth108.fca.TradeCounterpartyType1Code__1;
import iso20022.auth108.fca.TradeCounterpartyType1Code__2;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_CounterpartySpecificData.Create_CounterpartySpecificDataDefault.class)
public abstract class Create_CounterpartySpecificData implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param marginReport 
	* @return ctrPtySpcfcData 
	*/
	public TradeCounterpartyReport20__1 evaluate(FCAUKEMIRMarginReport marginReport) {
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPtySpcfcDataBuilder = doEvaluate(marginReport);
		
		final TradeCounterpartyReport20__1 ctrPtySpcfcData;
		if (ctrPtySpcfcDataBuilder == null) {
			ctrPtySpcfcData = null;
		} else {
			ctrPtySpcfcData = ctrPtySpcfcDataBuilder.build();
			objectValidator.validate(TradeCounterpartyReport20__1.class, ctrPtySpcfcData);
		}
		
		return ctrPtySpcfcData;
	}

	protected abstract TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(FCAUKEMIRMarginReport marginReport);

	public static class Create_CounterpartySpecificDataDefault extends Create_CounterpartySpecificData {
		@Override
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(FCAUKEMIRMarginReport marginReport) {
			TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPtySpcfcData = TradeCounterpartyReport20__1.builder();
			return assignOutput(ctrPtySpcfcData, marginReport);
		}
		
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder assignOutput(TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPtySpcfcData, FCAUKEMIRMarginReport marginReport) {
			LegalPersonIdentification1__1 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCounterparty2IdentifierType", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = LegalPersonIdentification1__1.builder()
					.setId(OrganisationIdentification15Choice__1.builder()
						.setLei(MapperS.of(marginReport).<String>map("getCounterparty2", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getCounterparty2()).get())
						.build())
					.build();
			}
			NaturalPersonIdentification3__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCounterparty2IdentifierType", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = NaturalPersonIdentification3__1.builder()
					.setId(NaturalPersonIdentification2__1.builder()
						.setId(GenericIdentification175__1.builder()
							.setId(MapperS.of(marginReport).<String>map("getCounterparty2", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getCounterparty2()).get())
							.build())
						.build())
					.build();
			}
			final List<OrganisationIdentification15Choice__1> ifThenElseResult4;
			if (exists(MapperS.of(marginReport).<String>map("getExecutionAgentOfCounterparty1", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1())).orNullSafe(exists(MapperS.of(marginReport).<String>map("getExecutionAgentOfCounterparty2", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()))).getOrDefault(false)) {
				final MapperS<OrganisationIdentification15Choice__1> ifThenElseResult2;
				if (exists(MapperS.of(marginReport).<String>map("getExecutionAgentOfCounterparty1", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1())).getOrDefault(false)) {
					ifThenElseResult2 = MapperS.of(OrganisationIdentification15Choice__1.builder()
						.setLei(MapperS.of(marginReport).<String>map("getExecutionAgentOfCounterparty1", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1()).get())
						.build());
				} else {
					ifThenElseResult2 = MapperS.<OrganisationIdentification15Choice__1>ofNull();
				}
				final MapperS<OrganisationIdentification15Choice__1> ifThenElseResult3;
				if (exists(MapperS.of(marginReport).<String>map("getExecutionAgentOfCounterparty2", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2())).getOrDefault(false)) {
					ifThenElseResult3 = MapperS.of(OrganisationIdentification15Choice__1.builder()
						.setLei(MapperS.of(marginReport).<String>map("getExecutionAgentOfCounterparty2", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()).get())
						.build());
				} else {
					ifThenElseResult3 = MapperS.<OrganisationIdentification15Choice__1>ofNull();
				}
				ifThenElseResult4 = MapperC.<OrganisationIdentification15Choice__1>of(ifThenElseResult2, ifThenElseResult3).getMulti();
			} else {
				ifThenElseResult4 = Collections.<OrganisationIdentification15Choice__1>emptyList();
			}
			TradeCounterpartyRelationshipRecord1__1 ifThenElseResult6 = null;
			if (exists(MapperS.of(marginReport).<String>map("getExecutionAgentOfCounterparty1", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1())).andNullSafe(notExists(MapperS.of(marginReport).<String>map("getExecutionAgentOfCounterparty2", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()))).orNullSafe(notExists(MapperS.of(marginReport).<String>map("getExecutionAgentOfCounterparty1", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1())).andNullSafe(exists(MapperS.of(marginReport).<String>map("getExecutionAgentOfCounterparty2", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2())))).getOrDefault(false)) {
				final TradeCounterpartyType1Code__1 ifThenElseResult5;
				if (exists(MapperS.of(marginReport).<String>map("getExecutionAgentOfCounterparty1", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1())).getOrDefault(false)) {
					ifThenElseResult5 = TradeCounterpartyType1Code__1.REPC;
				} else {
					ifThenElseResult5 = TradeCounterpartyType1Code__1.OTHC;
				}
				ifThenElseResult6 = TradeCounterpartyRelationshipRecord1__1.builder()
					.setStartRltshPty(ifThenElseResult5)
					.setEndRltshPty(TradeCounterpartyType1Code__2.EXEA)
					.setRltshTp(TradeCounterpartyRelationship1Choice__1.builder()
						.setPrtry("ZZZZ")
						.build())
					.build();
			}
			ctrPtySpcfcData = toBuilder(TradeCounterpartyReport20__1.builder()
				.setRptgCtrPty(Counterparty45__1.builder()
					.setId(PartyIdentification248Choice__1.builder()
						.setLgl(LegalPersonIdentification1__1.builder()
							.setId(OrganisationIdentification15Choice__1.builder()
								.setLei(MapperS.of(marginReport).<String>map("getCounterparty1", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getCounterparty1()).get())
								.build())
							.build())
						.build())
					.build())
				.setSubmitgAgt(OrganisationIdentification15Choice__1.builder()
					.setLei(MapperS.of(marginReport).<String>map("getReportSubmittingEntityID", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getReportSubmittingEntityID()).get())
					.build())
				.setOthrCtrPty(Counterparty46__1.builder()
					.setIdTp(PartyIdentification248Choice__2.builder()
						.setLgl(ifThenElseResult0)
						.setNtrl(ifThenElseResult1)
						.build())
					.build())
				.setNttyRspnsblForRpt(OrganisationIdentification15Choice__1.builder()
					.setLei(MapperS.of(marginReport).<String>map("getEntityResponsibleForReporting", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getEntityResponsibleForReporting()).get())
					.build())
				.setExctnAgt(ifThenElseResult4)
				.setRltshRcrd(ifThenElseResult6)
				.build());
			
			return Optional.ofNullable(ctrPtySpcfcData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
