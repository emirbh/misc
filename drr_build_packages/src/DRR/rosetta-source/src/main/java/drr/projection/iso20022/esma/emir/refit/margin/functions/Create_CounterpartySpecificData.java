package drr.projection.iso20022.esma.emir.refit.margin.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRMarginReport;
import iso20022.auth108.esma.Counterparty45__1;
import iso20022.auth108.esma.Counterparty46__1;
import iso20022.auth108.esma.GenericIdentification175__1;
import iso20022.auth108.esma.LegalPersonIdentification1__1;
import iso20022.auth108.esma.NaturalPersonIdentification2__1;
import iso20022.auth108.esma.NaturalPersonIdentification3__1;
import iso20022.auth108.esma.OrganisationIdentification15Choice__1;
import iso20022.auth108.esma.PartyIdentification248Choice__1;
import iso20022.auth108.esma.PartyIdentification248Choice__2;
import iso20022.auth108.esma.TradeCounterpartyReport20__1;
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
	public TradeCounterpartyReport20__1 evaluate(ESMAEMIRMarginReport marginReport) {
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

	protected abstract TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(ESMAEMIRMarginReport marginReport);

	public static class Create_CounterpartySpecificDataDefault extends Create_CounterpartySpecificData {
		@Override
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(ESMAEMIRMarginReport marginReport) {
			TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPtySpcfcData = TradeCounterpartyReport20__1.builder();
			return assignOutput(ctrPtySpcfcData, marginReport);
		}
		
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder assignOutput(TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPtySpcfcData, ESMAEMIRMarginReport marginReport) {
			LegalPersonIdentification1__1 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCounterparty2IdentifierType", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = LegalPersonIdentification1__1.builder()
					.setId(OrganisationIdentification15Choice__1.builder()
						.setLei(MapperS.of(marginReport).<String>map("getCounterparty2", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getCounterparty2()).get())
						.build())
					.build();
			}
			NaturalPersonIdentification3__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCounterparty2IdentifierType", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = NaturalPersonIdentification3__1.builder()
					.setId(NaturalPersonIdentification2__1.builder()
						.setId(GenericIdentification175__1.builder()
							.setId(MapperS.of(marginReport).<String>map("getCounterparty2", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getCounterparty2()).get())
							.build())
						.build())
					.build();
			}
			ctrPtySpcfcData = toBuilder(TradeCounterpartyReport20__1.builder()
				.setRptgCtrPty(Counterparty45__1.builder()
					.setId(PartyIdentification248Choice__1.builder()
						.setLgl(LegalPersonIdentification1__1.builder()
							.setId(OrganisationIdentification15Choice__1.builder()
								.setLei(MapperS.of(marginReport).<String>map("getCounterparty1", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getCounterparty1()).get())
								.build())
							.build())
						.build())
					.build())
				.setSubmitgAgt(OrganisationIdentification15Choice__1.builder()
					.setLei(MapperS.of(marginReport).<String>map("getReportSubmittingEntityID", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getReportSubmittingEntityID()).get())
					.build())
				.setOthrCtrPty(Counterparty46__1.builder()
					.setIdTp(PartyIdentification248Choice__2.builder()
						.setLgl(ifThenElseResult0)
						.setNtrl(ifThenElseResult1)
						.build())
					.build())
				.setNttyRspnsblForRpt(OrganisationIdentification15Choice__1.builder()
					.setLei(MapperS.of(marginReport).<String>map("getEntityResponsibleForReporting", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getEntityResponsibleForReporting()).get())
					.build())
				.build());
			
			return Optional.ofNullable(ctrPtySpcfcData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
