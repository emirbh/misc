package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.HKTRPartyScheme;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.Direction2Enum;
import drr.standards.iso.TradingCapacity7Code;
import iso20022.auth030.hkma.dtcc.Counterparty45__1;
import iso20022.auth030.hkma.dtcc.Counterparty46__1;
import iso20022.auth030.hkma.dtcc.CounterpartyTradeNature15Choice__1;
import iso20022.auth030.hkma.dtcc.Direction2__1;
import iso20022.auth030.hkma.dtcc.Direction4Choice__1;
import iso20022.auth030.hkma.dtcc.FinancialInstitutionSector1__1;
import iso20022.auth030.hkma.dtcc.FinancialPartyClassification2Choice__1;
import iso20022.auth030.hkma.dtcc.FinancialPartySectorType3Code;
import iso20022.auth030.hkma.dtcc.GenericIdentification175__1;
import iso20022.auth030.hkma.dtcc.NoReasonCode;
import iso20022.auth030.hkma.dtcc.NonFinancialInstitutionSector10__1;
import iso20022.auth030.hkma.dtcc.OptionParty1Code;
import iso20022.auth030.hkma.dtcc.OptionParty3Code;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification15Choice__3;
import iso20022.auth030.hkma.dtcc.PartyIdentification248Choice__3;
import iso20022.auth030.hkma.dtcc.TradeCounterpartyReport20__1;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_TradeCounterpartyReport20__1.Create_TradeCounterpartyReport20__1Default.class)
public abstract class Create_TradeCounterpartyReport20__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__3 create_OrganisationIdentification15Choice__3;
	@Inject protected Create_PartyIdentification248Choice__1 create_PartyIdentification248Choice__1;
	@Inject protected Create_PartyIdentification248Choice__2 create_PartyIdentification248Choice__2;
	@Inject protected Create_PartyIdentification248Choice__3 create_PartyIdentification248Choice__3;
	@Inject protected Create_PartyIdentification248Choice__4 create_PartyIdentification248Choice__4;
	@Inject protected GetExctnAgt getExctnAgt;
	@Inject protected GetNttyRspnsblForRpt getNttyRspnsblForRpt;
	@Inject protected GetSubmitgAgt getSubmitgAgt;

	/**
	* @param drrReport 
	* @return ctrPty 
	*/
	public TradeCounterpartyReport20__1 evaluate(HKMATransactionReport drrReport) {
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPtyBuilder = doEvaluate(drrReport);
		
		final TradeCounterpartyReport20__1 ctrPty;
		if (ctrPtyBuilder == null) {
			ctrPty = null;
		} else {
			ctrPty = ctrPtyBuilder.build();
			objectValidator.validate(TradeCounterpartyReport20__1.class, ctrPty);
		}
		
		return ctrPty;
	}

	protected abstract TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_TradeCounterpartyReport20__1Default extends Create_TradeCounterpartyReport20__1 {
		@Override
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(HKMATransactionReport drrReport) {
			TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPty = TradeCounterpartyReport20__1.builder();
			return assignOutput(ctrPty, drrReport);
		}
		
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder assignOutput(TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPty, HKMATransactionReport drrReport) {
			FinancialInstitutionSector1__1 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty1", hKMATransactionReport -> hKMATransactionReport.getNatureOfCounterparty1()), MapperS.of(NatureOfCounterpartyEnum.F), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = FinancialInstitutionSector1__1.builder()
					.setSctr(FinancialPartyClassification2Choice__1.builder()
						.setCd(MapperS.of(drrReport).<String>mapC("getCorporateSectorOfTheCounterparty1", hKMATransactionReport -> hKMATransactionReport.getCorporateSectorOfTheCounterparty1())
							.first().checkedMap("to-enum", FinancialPartySectorType3Code::fromDisplayName, IllegalArgumentException.class).get())
						.build())
					.build();
			}
			NonFinancialInstitutionSector10__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty1", hKMATransactionReport -> hKMATransactionReport.getNatureOfCounterparty1()), MapperS.of(NatureOfCounterpartyEnum.N), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = NonFinancialInstitutionSector10__1.builder()
					.setSctr(GenericIdentification175__1.builder()
						.setId(MapperS.of(drrReport).<String>mapC("getCorporateSectorOfTheCounterparty1", hKMATransactionReport -> hKMATransactionReport.getCorporateSectorOfTheCounterparty1())
							.first().get())
						.build())
					.build();
			}
			NoReasonCode ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty1", hKMATransactionReport -> hKMATransactionReport.getNatureOfCounterparty1()), MapperS.of(NatureOfCounterpartyEnum.C), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = NoReasonCode.NORE;
			}
			NoReasonCode ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty1", hKMATransactionReport -> hKMATransactionReport.getNatureOfCounterparty1()), MapperS.of(NatureOfCounterpartyEnum.O), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = NoReasonCode.NORE;
			}
			FinancialInstitutionSector1__1 ifThenElseResult4 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty2", hKMATransactionReport -> hKMATransactionReport.getNatureOfCounterparty2()), MapperS.of(NatureOfCounterpartyEnum.F), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = FinancialInstitutionSector1__1.builder()
					.setSctr(FinancialPartyClassification2Choice__1.builder()
						.setCd(MapperS.of(drrReport).<String>mapC("getCorporateSectorOfTheCounterparty2", hKMATransactionReport -> hKMATransactionReport.getCorporateSectorOfTheCounterparty2())
							.first().checkedMap("to-enum", FinancialPartySectorType3Code::fromDisplayName, IllegalArgumentException.class).get())
						.build())
					.build();
			}
			NonFinancialInstitutionSector10__1 ifThenElseResult5 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty2", hKMATransactionReport -> hKMATransactionReport.getNatureOfCounterparty2()), MapperS.of(NatureOfCounterpartyEnum.N), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult5 = NonFinancialInstitutionSector10__1.builder()
					.setSctr(GenericIdentification175__1.builder()
						.setId(MapperS.of(drrReport).<String>mapC("getCorporateSectorOfTheCounterparty2", hKMATransactionReport -> hKMATransactionReport.getCorporateSectorOfTheCounterparty2())
							.first().get())
						.build())
					.build();
			}
			NoReasonCode ifThenElseResult6 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty2", hKMATransactionReport -> hKMATransactionReport.getNatureOfCounterparty2()), MapperS.of(NatureOfCounterpartyEnum.C), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult6 = NoReasonCode.NORE;
			}
			NoReasonCode ifThenElseResult7 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty2", hKMATransactionReport -> hKMATransactionReport.getNatureOfCounterparty2()), MapperS.of(NatureOfCounterpartyEnum.O), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult7 = NoReasonCode.NORE;
			}
			OrganisationIdentification15Choice__3 ifThenElseResult8 = null;
			if (notEqual(MapperS.of(drrReport).<HKTRPartyScheme>map("getBrokerSchemeName", hKMATransactionReport -> hKMATransactionReport.getBrokerSchemeName()), MapperS.of(HKTRPartyScheme.TRID), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult8 = create_OrganisationIdentification15Choice__3.evaluate(MapperS.of(drrReport).<PartyIdentifierFormat2Enum>map("getBrokerIdentifierFormat", hKMATransactionReport -> hKMATransactionReport.getBrokerIdentifierFormat()).get(), MapperS.of(drrReport).<String>map("getBrokerID", hKMATransactionReport -> hKMATransactionReport.getBrokerID()).get(), MapperS.of(drrReport).<HKTRPartyScheme>map("getBrokerSchemeName", hKMATransactionReport -> hKMATransactionReport.getBrokerSchemeName()).get());
			}
			PartyIdentification248Choice__3 ifThenElseResult9 = null;
			if (notEqual(MapperS.of(drrReport).<HKTRPartyScheme>map("getClearingMemberSchemeName", hKMATransactionReport -> hKMATransactionReport.getClearingMemberSchemeName()), MapperS.of(HKTRPartyScheme.TRID), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult9 = create_PartyIdentification248Choice__3.evaluate(MapperS.of(drrReport).<PartyIdentifierFormat2Enum>map("getClearingMemberIdentifierFormat", hKMATransactionReport -> hKMATransactionReport.getClearingMemberIdentifierFormat()).get(), MapperS.of(drrReport).<String>map("getClearingMember", hKMATransactionReport -> hKMATransactionReport.getClearingMember()).get(), MapperS.of(drrReport).<HKTRPartyScheme>map("getClearingMemberSchemeName", hKMATransactionReport -> hKMATransactionReport.getClearingMemberSchemeName()).get());
			}
			ctrPty = toBuilder(TradeCounterpartyReport20__1.builder()
				.setRptgCtrPty(Counterparty45__1.builder()
					.setId(create_PartyIdentification248Choice__1.evaluate(MapperS.of(drrReport).<String>map("getCounterparty1", hKMATransactionReport -> hKMATransactionReport.getCounterparty1()).get()))
					.setDrctnOrSd(Direction4Choice__1.builder()
						.setCtrPtySd(MapperS.of(drrReport).<Direction1Enum>map("getDirection1", hKMATransactionReport -> hKMATransactionReport.getDirection1()).checkedMap("to-enum", e -> OptionParty1Code.valueOf(e.name()), IllegalArgumentException.class).get())
						.setDrctn(Direction2__1.builder()
							.setDrctnOfTheFrstLeg(MapperS.of(drrReport).<CommonLeg>map("getLeg1", hKMATransactionReport -> hKMATransactionReport.getLeg1()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()).checkedMap("to-enum", e -> OptionParty3Code.valueOf(e.name()), IllegalArgumentException.class).get())
							.setDrctnOfTheScndLeg(MapperS.of(drrReport).<CommonLeg>map("getLeg2", hKMATransactionReport -> hKMATransactionReport.getLeg2()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()).checkedMap("to-enum", e -> OptionParty3Code.valueOf(e.name()), IllegalArgumentException.class).get())
							.build())
						.build())
					.setNtr(CounterpartyTradeNature15Choice__1.builder()
						.setFi(ifThenElseResult0)
						.setNfi(ifThenElseResult1)
						.setCntrlCntrPty(ifThenElseResult2)
						.setOthr(ifThenElseResult3)
						.build())
					.setTradgCpcty(MapperS.of(drrReport).<TradingCapacity7Code>map("getTradingCapacity", hKMATransactionReport -> hKMATransactionReport.getTradingCapacity()).checkedMap("to-enum", e -> iso20022.auth030.hkma.dtcc.TradingCapacity7Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.setTradrLctn(MapperS.of(drrReport).<ISOCountryCodeEnum>map("getTraderLocation", hKMATransactionReport -> hKMATransactionReport.getTraderLocation()).map("to-string", ISOCountryCodeEnum::toDisplayString).get())
					.setBookgLctn(MapperS.of(drrReport).<ISOCountryCodeEnum>map("getBookingLocation", hKMATransactionReport -> hKMATransactionReport.getBookingLocation()).map("to-string", ISOCountryCodeEnum::toDisplayString).get())
					.build())
				.setOthrCtrPty(Counterparty46__1.builder()
					.setIdTp(create_PartyIdentification248Choice__2.evaluate(drrReport))
					.setNtr(CounterpartyTradeNature15Choice__1.builder()
						.setFi(ifThenElseResult4)
						.setNfi(ifThenElseResult5)
						.setCntrlCntrPty(ifThenElseResult6)
						.setOthr(ifThenElseResult7)
						.build())
					.build())
				.setBrkr(ifThenElseResult8)
				.setSubmitgAgt(getSubmitgAgt.evaluate(drrReport))
				.setClrMmb(ifThenElseResult9)
				.setNttyRspnsblForRpt(getNttyRspnsblForRpt.evaluate(drrReport))
				.setExctnAgt(new ArrayList(getExctnAgt.evaluate(drrReport)))
				.setBnfcry(create_PartyIdentification248Choice__4.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(ctrPty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
