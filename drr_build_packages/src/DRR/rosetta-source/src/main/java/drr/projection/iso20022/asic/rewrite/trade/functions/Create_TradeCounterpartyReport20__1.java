package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.trade.CommonLeg;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.Direction2Enum;
import iso20022.auth030.asic.Counterparty45__1;
import iso20022.auth030.asic.Counterparty46__1;
import iso20022.auth030.asic.Direction2;
import iso20022.auth030.asic.Direction4Choice;
import iso20022.auth030.asic.OptionParty1Code;
import iso20022.auth030.asic.OptionParty3Code;
import iso20022.auth030.asic.TradeCounterpartyReport20__1;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeCounterpartyReport20__1.Create_TradeCounterpartyReport20__1Default.class)
public abstract class Create_TradeCounterpartyReport20__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__1 create_OrganisationIdentification15Choice__1;
	@Inject protected Create_PartyIdentification248Choice__1 create_PartyIdentification248Choice__1;
	@Inject protected Create_PartyIdentification248Choice__2 create_PartyIdentification248Choice__2;
	@Inject protected Create_PartyIdentification248Choice__3 create_PartyIdentification248Choice__3;
	@Inject protected GetExctnAgt getExctnAgt;
	@Inject protected GetNttyRspnsblForRpt getNttyRspnsblForRpt;
	@Inject protected GetSubmitgAgt getSubmitgAgt;

	/**
	* @param drrReport 
	* @return ctrPty 
	*/
	public TradeCounterpartyReport20__1 evaluate(ASICTransactionReport drrReport) {
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

	protected abstract TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(ASICTransactionReport drrReport);

	public static class Create_TradeCounterpartyReport20__1Default extends Create_TradeCounterpartyReport20__1 {
		@Override
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(ASICTransactionReport drrReport) {
			TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPty = TradeCounterpartyReport20__1.builder();
			return assignOutput(ctrPty, drrReport);
		}
		
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder assignOutput(TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPty, ASICTransactionReport drrReport) {
			ctrPty = toBuilder(TradeCounterpartyReport20__1.builder()
				.setRptgCtrPty(Counterparty45__1.builder()
					.setId(create_PartyIdentification248Choice__1.evaluate(MapperS.of(drrReport).<String>map("getCounterparty1", aSICTransactionReport -> aSICTransactionReport.getCounterparty1()).get()))
					.setDrctnOrSd(Direction4Choice.builder()
						.setCtrPtySd(MapperS.of(drrReport).<Direction1Enum>map("getDirection1", aSICTransactionReport -> aSICTransactionReport.getDirection1()).checkedMap("to-enum", e -> OptionParty1Code.valueOf(e.name()), IllegalArgumentException.class).get())
						.setDrctn(Direction2.builder()
							.setDrctnOfTheFrstLeg(MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()).checkedMap("to-enum", e -> OptionParty3Code.valueOf(e.name()), IllegalArgumentException.class).get())
							.setDrctnOfTheScndLeg(MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()).checkedMap("to-enum", e -> OptionParty3Code.valueOf(e.name()), IllegalArgumentException.class).get())
							.build())
						.build())
					.build())
				.setOthrCtrPty(Counterparty46__1.builder()
					.setIdTp(create_PartyIdentification248Choice__2.evaluate(drrReport))
					.build())
				.setBrkr(create_OrganisationIdentification15Choice__1.evaluate(MapperS.of(drrReport).<String>map("getBrokerID", aSICTransactionReport -> aSICTransactionReport.getBrokerID()).get()))
				.setSubmitgAgt(getSubmitgAgt.evaluate(drrReport))
				.setClrMmb(create_PartyIdentification248Choice__1.evaluate(MapperS.of(drrReport).<String>map("getClearingMember", aSICTransactionReport -> aSICTransactionReport.getClearingMember()).get()))
				.setNttyRspnsblForRpt(getNttyRspnsblForRpt.evaluate(drrReport))
				.setExctnAgt(new ArrayList(getExctnAgt.evaluate(drrReport)))
				.setBnfcry(create_PartyIdentification248Choice__3.evaluate(MapperS.of(drrReport).<Boolean>map("getBeneficiary1IdentifierTypeIndicator", aSICTransactionReport -> aSICTransactionReport.getBeneficiary1IdentifierTypeIndicator()).get(), MapperS.of(drrReport).<String>map("getBeneficiary1", aSICTransactionReport -> aSICTransactionReport.getBeneficiary1()).get()))
				.build());
			
			return Optional.ofNullable(ctrPty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
