package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.RiskReductionTechniqueEnum;
import iso20022.auth030.esma.PTRREvent2__1;
import iso20022.auth030.esma.RiskReductionService1Code__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetPstTradRskRdctnEvt.GetPstTradRskRdctnEvtDefault.class)
public abstract class GetPstTradRskRdctnEvt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__1 create_OrganisationIdentification15Choice__1;

	/**
	* @param drrReport 
	* @return pstTradRskRdctnEvt 
	*/
	public PTRREvent2__1 evaluate(ESMAEMIRTransactionReport drrReport) {
		PTRREvent2__1.PTRREvent2__1Builder pstTradRskRdctnEvtBuilder = doEvaluate(drrReport);
		
		final PTRREvent2__1 pstTradRskRdctnEvt;
		if (pstTradRskRdctnEvtBuilder == null) {
			pstTradRskRdctnEvt = null;
		} else {
			pstTradRskRdctnEvt = pstTradRskRdctnEvtBuilder.build();
			objectValidator.validate(PTRREvent2__1.class, pstTradRskRdctnEvt);
		}
		
		return pstTradRskRdctnEvt;
	}

	protected abstract PTRREvent2__1.PTRREvent2__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetPstTradRskRdctnEvtDefault extends GetPstTradRskRdctnEvt {
		@Override
		protected PTRREvent2__1.PTRREvent2__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			PTRREvent2__1.PTRREvent2__1Builder pstTradRskRdctnEvt = PTRREvent2__1.builder();
			return assignOutput(pstTradRskRdctnEvt, drrReport);
		}
		
		protected PTRREvent2__1.PTRREvent2__1Builder assignOutput(PTRREvent2__1.PTRREvent2__1Builder pstTradRskRdctnEvt, ESMAEMIRTransactionReport drrReport) {
			pstTradRskRdctnEvt = toBuilder(PTRREvent2__1.builder()
				.setTchnq(MapperS.of(drrReport).<RiskReductionTechniqueEnum>map("getTypeOfPTRRTechnique", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getTypeOfPTRRTechnique()).checkedMap("to-enum", e -> RiskReductionService1Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
				.setSvcPrvdr(create_OrganisationIdentification15Choice__1.evaluate(MapperS.of(drrReport).<String>map("getPtrrServiceProvider", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPtrrServiceProvider()).get()))
				.build());
			
			return Optional.ofNullable(pstTradRskRdctnEvt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
