package drr.projection.iso20022.hkma.rewrite.margin.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.hkma.rewrite.margin.HKMAMarginReport;
import iso20022.auth108.hkma.tr.Counterparty45__1;
import iso20022.auth108.hkma.tr.Counterparty46__1;
import iso20022.auth108.hkma.tr.GenericIdentification175__1;
import iso20022.auth108.hkma.tr.GenericIdentification175__2;
import iso20022.auth108.hkma.tr.LegalPersonIdentification1__1;
import iso20022.auth108.hkma.tr.LegalPersonIdentification1__2;
import iso20022.auth108.hkma.tr.NaturalPersonIdentification2__1;
import iso20022.auth108.hkma.tr.NaturalPersonIdentification3__1;
import iso20022.auth108.hkma.tr.OrganisationIdentification15Choice__1;
import iso20022.auth108.hkma.tr.OrganisationIdentification15Choice__2;
import iso20022.auth108.hkma.tr.OrganisationIdentification38__1;
import iso20022.auth108.hkma.tr.PartyIdentification248Choice__1;
import iso20022.auth108.hkma.tr.PartyIdentification248Choice__2;
import iso20022.auth108.hkma.tr.TradeCounterpartyReport20__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_CounterpartySpecificData.Create_CounterpartySpecificDataDefault.class)
public abstract class Create_CounterpartySpecificData implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetSubmitgAgt getSubmitgAgt;

	/**
	* @param marginReport 
	* @return ctrPtySpcfcData 
	*/
	public TradeCounterpartyReport20__1 evaluate(HKMAMarginReport marginReport) {
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

	protected abstract TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(HKMAMarginReport marginReport);

	public static class Create_CounterpartySpecificDataDefault extends Create_CounterpartySpecificData {
		@Override
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(HKMAMarginReport marginReport) {
			TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPtySpcfcData = TradeCounterpartyReport20__1.builder();
			return assignOutput(ctrPtySpcfcData, marginReport);
		}
		
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder assignOutput(TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPtySpcfcData, HKMAMarginReport marginReport) {
			LegalPersonIdentification1__2 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCounterparty2IdentifierType", hKMAMarginReport -> hKMAMarginReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				String ifThenElseResult0 = null;
				if (areEqual(MapperS.of(marginReport).<PartyIdentifierFormat2Enum>map("getCounterparty2IdentifierFormat", hKMAMarginReport -> hKMAMarginReport.getCounterparty2IdentifierFormat()), MapperS.of(PartyIdentifierFormat2Enum.SWIFTBIC), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult0 = MapperS.of(marginReport).<String>map("getCounterparty2", hKMAMarginReport -> hKMAMarginReport.getCounterparty2()).get();
				}
				ifThenElseResult1 = LegalPersonIdentification1__2.builder()
					.setId(OrganisationIdentification15Choice__2.builder()
						.setLei(MapperS.of(marginReport).<String>map("getCounterparty2", hKMAMarginReport -> hKMAMarginReport.getCounterparty2()).get())
						.setOthr(OrganisationIdentification38__1.builder()
							.setId(GenericIdentification175__1.builder()
								.setId(MapperS.of(marginReport).<String>map("getCounterparty2", hKMAMarginReport -> hKMAMarginReport.getCounterparty2()).get())
								.setSchmeNm(null)
								.build())
							.setNm(MapperS.of(marginReport).<String>map("getCounterparty2Name", hKMAMarginReport -> hKMAMarginReport.getCounterparty2Name()).get())
							.build())
						.setAnyBIC(ifThenElseResult0)
						.build())
					.build();
			}
			NaturalPersonIdentification3__1 ifThenElseResult2 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCounterparty2IdentifierType", hKMAMarginReport -> hKMAMarginReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = NaturalPersonIdentification3__1.builder()
					.setId(NaturalPersonIdentification2__1.builder()
						.setId(GenericIdentification175__2.builder()
							.setId(MapperS.of(marginReport).<String>map("getCounterparty2", hKMAMarginReport -> hKMAMarginReport.getCounterparty2()).get())
							.build())
						.build())
					.build();
			}
			ctrPtySpcfcData = toBuilder(TradeCounterpartyReport20__1.builder()
				.setRptgCtrPty(Counterparty45__1.builder()
					.setId(PartyIdentification248Choice__1.builder()
						.setLgl(LegalPersonIdentification1__1.builder()
							.setId(OrganisationIdentification15Choice__1.builder()
								.setLei(MapperS.of(marginReport).<String>map("getCounterparty1", hKMAMarginReport -> hKMAMarginReport.getCounterparty1()).get())
								.build())
							.build())
						.build())
					.build())
				.setOthrCtrPty(Counterparty46__1.builder()
					.setIdTp(PartyIdentification248Choice__2.builder()
						.setLgl(ifThenElseResult1)
						.setNtrl(ifThenElseResult2)
						.build())
					.build())
				.setSubmitgAgt(getSubmitgAgt.evaluate(marginReport))
				.setNttyRspnsblForRpt(OrganisationIdentification15Choice__1.builder()
					.setLei(MapperS.of(marginReport).<String>map("getEntityResponsibleForReporting", hKMAMarginReport -> hKMAMarginReport.getEntityResponsibleForReporting()).get())
					.build())
				.build());
			
			return Optional.ofNullable(ctrPtySpcfcData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
