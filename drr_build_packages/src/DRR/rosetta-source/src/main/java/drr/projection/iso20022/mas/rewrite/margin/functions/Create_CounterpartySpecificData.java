package drr.projection.iso20022.mas.rewrite.margin.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.margin.MASMarginReport;
import iso20022.auth108.mas.Counterparty45__1;
import iso20022.auth108.mas.Counterparty46__1;
import iso20022.auth108.mas.GenericIdentification175__1;
import iso20022.auth108.mas.LegalPersonIdentification1__1;
import iso20022.auth108.mas.LegalPersonIdentification1__2;
import iso20022.auth108.mas.NaturalPersonIdentification2__1;
import iso20022.auth108.mas.NaturalPersonIdentification3__1;
import iso20022.auth108.mas.OrganisationIdentification15Choice__1;
import iso20022.auth108.mas.PartyIdentification248Choice__1;
import iso20022.auth108.mas.PartyIdentification248Choice__2;
import iso20022.auth108.mas.TradeCounterpartyReport20__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_CounterpartySpecificData.Create_CounterpartySpecificDataDefault.class)
public abstract class Create_CounterpartySpecificData implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__2 create_OrganisationIdentification15Choice__2;

	/**
	* @param marginReport 
	* @return ctrPtySpcfcData 
	*/
	public TradeCounterpartyReport20__1 evaluate(MASMarginReport marginReport) {
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

	protected abstract TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(MASMarginReport marginReport);

	public static class Create_CounterpartySpecificDataDefault extends Create_CounterpartySpecificData {
		@Override
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(MASMarginReport marginReport) {
			TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPtySpcfcData = TradeCounterpartyReport20__1.builder();
			return assignOutput(ctrPtySpcfcData, marginReport);
		}
		
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder assignOutput(TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPtySpcfcData, MASMarginReport marginReport) {
			LegalPersonIdentification1__2 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCounterparty2IdentifierType", mASMarginReport -> mASMarginReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = LegalPersonIdentification1__2.builder()
					.setId(create_OrganisationIdentification15Choice__2.evaluate(marginReport))
					.build();
			}
			NaturalPersonIdentification3__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCounterparty2IdentifierType", mASMarginReport -> mASMarginReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = NaturalPersonIdentification3__1.builder()
					.setId(NaturalPersonIdentification2__1.builder()
						.setId(GenericIdentification175__1.builder()
							.setId(MapperS.of(marginReport).<String>map("getCounterparty2", mASMarginReport -> mASMarginReport.getCounterparty2()).get())
							.build())
						.build())
					.build();
			}
			ctrPtySpcfcData = toBuilder(TradeCounterpartyReport20__1.builder()
				.setRptgCtrPty(Counterparty45__1.builder()
					.setId(PartyIdentification248Choice__1.builder()
						.setLgl(LegalPersonIdentification1__1.builder()
							.setId(OrganisationIdentification15Choice__1.builder()
								.setLei(MapperS.of(marginReport).<String>map("getCounterparty1", mASMarginReport -> mASMarginReport.getCounterparty1()).get())
								.build())
							.build())
						.build())
					.build())
				.setSubmitgAgt(OrganisationIdentification15Choice__1.builder()
					.setLei(MapperS.of(marginReport).<String>map("getReportSubmittingEntityID", mASMarginReport -> mASMarginReport.getReportSubmittingEntityID()).get())
					.build())
				.setOthrCtrPty(Counterparty46__1.builder()
					.setIdTp(PartyIdentification248Choice__2.builder()
						.setLgl(ifThenElseResult0)
						.setNtrl(ifThenElseResult1)
						.build())
					.build())
				.setNttyRspnsblForRpt(OrganisationIdentification15Choice__1.builder()
					.setLei(MapperS.of(marginReport).<String>map("getReportingSpecifiedPerson", mASMarginReport -> mASMarginReport.getReportingSpecifiedPerson()).get())
					.build())
				.setExctnAgt(OrganisationIdentification15Choice__1.builder()
					.setLei(MapperS.of(marginReport).<String>map("getExecutionAgentOfTheCounterparty1", mASMarginReport -> mASMarginReport.getExecutionAgentOfTheCounterparty1()).get())
					.build())
				.build());
			
			return Optional.ofNullable(ctrPtySpcfcData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
