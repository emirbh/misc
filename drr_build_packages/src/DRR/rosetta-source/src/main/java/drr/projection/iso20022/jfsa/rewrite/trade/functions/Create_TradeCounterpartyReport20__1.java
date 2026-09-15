package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.Direction2Enum;
import iso20022.auth030.jfsa.Counterparty45__1;
import iso20022.auth030.jfsa.Counterparty46__1;
import iso20022.auth030.jfsa.Direction2;
import iso20022.auth030.jfsa.Direction4Choice;
import iso20022.auth030.jfsa.OptionParty1Code;
import iso20022.auth030.jfsa.OptionParty3Code;
import iso20022.auth030.jfsa.TradeCounterpartyReport20__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeCounterpartyReport20__1.Create_TradeCounterpartyReport20__1Default.class)
public abstract class Create_TradeCounterpartyReport20__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_PartyIdentification248Choice__1 create_PartyIdentification248Choice__1;
	@Inject protected Create_PartyIdentification248Choice__2 create_PartyIdentification248Choice__2;
	@Inject protected GetNttyRspnsblForRpt getNttyRspnsblForRpt;
	@Inject protected GetSubmitgAgt getSubmitgAgt;

	/**
	* @param drrReport 
	* @return ctrPty 
	*/
	public TradeCounterpartyReport20__1 evaluate(JFSATransactionReport drrReport) {
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

	protected abstract TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_TradeCounterpartyReport20__1Default extends Create_TradeCounterpartyReport20__1 {
		@Override
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(JFSATransactionReport drrReport) {
			TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPty = TradeCounterpartyReport20__1.builder();
			return assignOutput(ctrPty, drrReport);
		}
		
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder assignOutput(TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPty, JFSATransactionReport drrReport) {
			ctrPty = toBuilder(TradeCounterpartyReport20__1.builder()
				.setRptgCtrPty(Counterparty45__1.builder()
					.setId(create_PartyIdentification248Choice__1.evaluate(MapperS.of(drrReport).<String>map("getCounterparty1", jFSATransactionReport -> jFSATransactionReport.getCounterparty1()).get()))
					.setDrctnOrSd(Direction4Choice.builder()
						.setCtrPtySd(MapperS.of(drrReport).<Direction1Enum>map("getDirection1", jFSATransactionReport -> jFSATransactionReport.getDirection1()).checkedMap("to-enum", e -> OptionParty1Code.valueOf(e.name()), IllegalArgumentException.class).get())
						.setDrctn(Direction2.builder()
							.setDrctnOfTheFrstLeg(MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()).checkedMap("to-enum", e -> OptionParty3Code.valueOf(e.name()), IllegalArgumentException.class).get())
							.setDrctnOfTheScndLeg(MapperS.of(drrReport).<CommonLeg>map("getLeg2", jFSATransactionReport -> jFSATransactionReport.getLeg2()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()).checkedMap("to-enum", e -> OptionParty3Code.valueOf(e.name()), IllegalArgumentException.class).get())
							.build())
						.build())
					.build())
				.setOthrCtrPty(Counterparty46__1.builder()
					.setIdTp(create_PartyIdentification248Choice__2.evaluate(drrReport))
					.build())
				.setSubmitgAgt(getSubmitgAgt.evaluate(drrReport))
				.setClrMmb(create_PartyIdentification248Choice__1.evaluate(MapperS.of(drrReport).<String>map("getClearingMember", jFSATransactionReport -> jFSATransactionReport.getClearingMember()).get()))
				.setNttyRspnsblForRpt(getNttyRspnsblForRpt.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(ctrPty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
