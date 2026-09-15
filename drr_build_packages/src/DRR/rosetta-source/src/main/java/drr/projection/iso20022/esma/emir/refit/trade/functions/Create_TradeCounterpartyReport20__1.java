package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.Direction2Enum;
import iso20022.auth030.esma.Counterparty45__1;
import iso20022.auth030.esma.Counterparty46__1;
import iso20022.auth030.esma.CounterpartyTradeNature15Choice__1;
import iso20022.auth030.esma.CounterpartyTradeNature15Choice__2;
import iso20022.auth030.esma.Direction2__1;
import iso20022.auth030.esma.Direction4Choice__1;
import iso20022.auth030.esma.FinancialInstitutionSector1__1;
import iso20022.auth030.esma.NoReasonCode;
import iso20022.auth030.esma.NonFinancialInstitutionSector10__1;
import iso20022.auth030.esma.NonFinancialInstitutionSector10__2;
import iso20022.auth030.esma.OptionParty1Code;
import iso20022.auth030.esma.OptionParty3Code;
import iso20022.auth030.esma.TradeCounterpartyReport20__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_TradeCounterpartyReport20__1.Create_TradeCounterpartyReport20__1Default.class)
public abstract class Create_TradeCounterpartyReport20__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_FinancialInstitutionSector1__1 create_FinancialInstitutionSector1__1;
	@Inject protected Create_NonFinancialInstitutionSector10__1 create_NonFinancialInstitutionSector10__1;
	@Inject protected Create_NonFinancialInstitutionSector10__2 create_NonFinancialInstitutionSector10__2;
	@Inject protected Create_OrganisationIdentification15Choice__1 create_OrganisationIdentification15Choice__1;
	@Inject protected Create_PartyIdentification248Choice__1 create_PartyIdentification248Choice__1;
	@Inject protected Create_PartyIdentification248Choice__2 create_PartyIdentification248Choice__2;
	@Inject protected GetNttyRspnsblForRpt getNttyRspnsblForRpt;
	@Inject protected GetSubmitgAgt getSubmitgAgt;

	/**
	* @param drrReport 
	* @return ctrPty 
	*/
	public TradeCounterpartyReport20__1 evaluate(ESMAEMIRTransactionReport drrReport) {
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

	protected abstract TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class Create_TradeCounterpartyReport20__1Default extends Create_TradeCounterpartyReport20__1 {
		@Override
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPty = TradeCounterpartyReport20__1.builder();
			return assignOutput(ctrPty, drrReport);
		}
		
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder assignOutput(TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPty, ESMAEMIRTransactionReport drrReport) {
			FinancialInstitutionSector1__1 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getNatureOfCounterparty1()), MapperS.of(NatureOfCounterpartyEnum.F), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = create_FinancialInstitutionSector1__1.evaluate(MapperS.of(drrReport).<String>mapC("getCorporateSectorOfTheCounterparty1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getCorporateSectorOfTheCounterparty1()).getMulti(), MapperS.of(drrReport).<Boolean>map("getClearingThresholdOfCounterparty1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getClearingThresholdOfCounterparty1()).get());
			}
			NonFinancialInstitutionSector10__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getNatureOfCounterparty1()), MapperS.of(NatureOfCounterpartyEnum.N), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = create_NonFinancialInstitutionSector10__1.evaluate(MapperS.of(drrReport).<String>mapC("getCorporateSectorOfTheCounterparty1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getCorporateSectorOfTheCounterparty1()).getMulti(), MapperS.of(drrReport).<Boolean>map("getClearingThresholdOfCounterparty1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getClearingThresholdOfCounterparty1()).get(), MapperS.of(drrReport).<Boolean>map("getDirectlyLinkedToCommercialActivityOrTreasuryFinancing", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getDirectlyLinkedToCommercialActivityOrTreasuryFinancing()).get());
			}
			NoReasonCode ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getNatureOfCounterparty1()), MapperS.of(NatureOfCounterpartyEnum.C), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = NoReasonCode.NORE;
			}
			NoReasonCode ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getNatureOfCounterparty1()), MapperS.of(NatureOfCounterpartyEnum.O), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = NoReasonCode.NORE;
			}
			FinancialInstitutionSector1__1 ifThenElseResult4 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getNatureOfCounterparty2()), MapperS.of(NatureOfCounterpartyEnum.F), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = create_FinancialInstitutionSector1__1.evaluate(MapperS.of(drrReport).<String>mapC("getCorporateSectorOfTheCounterparty2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getCorporateSectorOfTheCounterparty2()).getMulti(), MapperS.of(drrReport).<Boolean>map("getClearingThresholdOfCounterparty2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getClearingThresholdOfCounterparty2()).get());
			}
			NonFinancialInstitutionSector10__2 ifThenElseResult5 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getNatureOfCounterparty2()), MapperS.of(NatureOfCounterpartyEnum.N), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult5 = create_NonFinancialInstitutionSector10__2.evaluate(MapperS.of(drrReport).<String>mapC("getCorporateSectorOfTheCounterparty2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getCorporateSectorOfTheCounterparty2()).getMulti(), MapperS.of(drrReport).<Boolean>map("getClearingThresholdOfCounterparty2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getClearingThresholdOfCounterparty2()).get());
			}
			NoReasonCode ifThenElseResult6 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getNatureOfCounterparty2()), MapperS.of(NatureOfCounterpartyEnum.C), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult6 = NoReasonCode.NORE;
			}
			NoReasonCode ifThenElseResult7 = null;
			if (areEqual(MapperS.of(drrReport).<NatureOfCounterpartyEnum>map("getNatureOfCounterparty2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getNatureOfCounterparty2()), MapperS.of(NatureOfCounterpartyEnum.O), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult7 = NoReasonCode.NORE;
			}
			ctrPty = toBuilder(TradeCounterpartyReport20__1.builder()
				.setRptgCtrPty(Counterparty45__1.builder()
					.setId(create_PartyIdentification248Choice__1.evaluate(MapperS.of(drrReport).<String>map("getCounterparty1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getCounterparty1()).get()))
					.setNtr(CounterpartyTradeNature15Choice__1.builder()
						.setFi(ifThenElseResult0)
						.setNfi(ifThenElseResult1)
						.setCntrlCntrPty(ifThenElseResult2)
						.setOthr(ifThenElseResult3)
						.build())
					.setDrctnOrSd(Direction4Choice__1.builder()
						.setCtrPtySd(MapperS.of(drrReport).<Direction1Enum>map("getDirection1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getDirection1()).checkedMap("to-enum", e -> OptionParty1Code.valueOf(e.name()), IllegalArgumentException.class).get())
						.setDrctn(Direction2__1.builder()
							.setDrctnOfTheFrstLeg(MapperS.of(drrReport).<CommonLeg>map("getLeg1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg1()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()).checkedMap("to-enum", e -> OptionParty3Code.valueOf(e.name()), IllegalArgumentException.class).get())
							.setDrctnOfTheScndLeg(MapperS.of(drrReport).<CommonLeg>map("getLeg2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg2()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()).checkedMap("to-enum", e -> OptionParty3Code.valueOf(e.name()), IllegalArgumentException.class).get())
							.build())
						.build())
					.build())
				.setOthrCtrPty(Counterparty46__1.builder()
					.setIdTp(create_PartyIdentification248Choice__2.evaluate(drrReport))
					.setNtr(CounterpartyTradeNature15Choice__2.builder()
						.setFi(ifThenElseResult4)
						.setNfi(ifThenElseResult5)
						.setCntrlCntrPty(ifThenElseResult6)
						.setOthr(ifThenElseResult7)
						.build())
					.setRptgOblgtn(MapperS.of(drrReport).<Boolean>map("getReportingObligationOfTheCounterparty2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getReportingObligationOfTheCounterparty2()).get())
					.build())
				.setBrkr(create_OrganisationIdentification15Choice__1.evaluate(MapperS.of(drrReport).<String>map("getBrokerID", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBrokerID()).get()))
				.setSubmitgAgt(getSubmitgAgt.evaluate(drrReport))
				.setClrMmb(create_PartyIdentification248Choice__1.evaluate(MapperS.of(drrReport).<String>map("getClearingMember", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getClearingMember()).get()))
				.setNttyRspnsblForRpt(getNttyRspnsblForRpt.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(ctrPty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
