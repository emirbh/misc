package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.ContractType15__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_ContractType15__1.Create_ContractType15__1Default.class)
public abstract class Create_ContractType15__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetAsstClss getAsstClss;
	@Inject protected GetCtrctTp getCtrctTp;
	@Inject protected GetDerivBasedOnCrptAsst getDerivBasedOnCrptAsst;
	@Inject protected GetPdctId getPdctId;
	@Inject protected GetSttlmCcy getSttlmCcy;
	@Inject protected GetSttlmCcyScndLeg getSttlmCcyScndLeg;
	@Inject protected GetUndrlygInstrm getUndrlygInstrm;

	/**
	* @param drrReport 
	* @return ctrctData 
	*/
	public ContractType15__1 evaluate(JFSATransactionReport drrReport) {
		ContractType15__1.ContractType15__1Builder ctrctDataBuilder = doEvaluate(drrReport);
		
		final ContractType15__1 ctrctData;
		if (ctrctDataBuilder == null) {
			ctrctData = null;
		} else {
			ctrctData = ctrctDataBuilder.build();
			objectValidator.validate(ContractType15__1.class, ctrctData);
		}
		
		return ctrctData;
	}

	protected abstract ContractType15__1.ContractType15__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_ContractType15__1Default extends Create_ContractType15__1 {
		@Override
		protected ContractType15__1.ContractType15__1Builder doEvaluate(JFSATransactionReport drrReport) {
			ContractType15__1.ContractType15__1Builder ctrctData = ContractType15__1.builder();
			return assignOutput(ctrctData, drrReport);
		}
		
		protected ContractType15__1.ContractType15__1Builder assignOutput(ContractType15__1.ContractType15__1Builder ctrctData, JFSATransactionReport drrReport) {
			ctrctData = toBuilder(ContractType15__1.builder()
				.setPdctId(getPdctId.evaluate(drrReport))
				.setCtrctTp(getCtrctTp.evaluate(drrReport))
				.setAsstClss(getAsstClss.evaluate(drrReport))
				.setDerivBasedOnCrptAsst(getDerivBasedOnCrptAsst.evaluate(drrReport))
				.setUndrlygInstrm(getUndrlygInstrm.evaluate(drrReport))
				.setSttlmCcy(getSttlmCcy.evaluate(drrReport))
				.setSttlmCcyScndLeg(getSttlmCcyScndLeg.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(ctrctData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
