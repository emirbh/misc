package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.ContractType15__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_ContractType15__2.Create_ContractType15__2Default.class)
public abstract class Create_ContractType15__2 implements RosettaFunction {
	
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
	public ContractType15__2 evaluate(JFSATransactionReport drrReport) {
		ContractType15__2.ContractType15__2Builder ctrctDataBuilder = doEvaluate(drrReport);
		
		final ContractType15__2 ctrctData;
		if (ctrctDataBuilder == null) {
			ctrctData = null;
		} else {
			ctrctData = ctrctDataBuilder.build();
			objectValidator.validate(ContractType15__2.class, ctrctData);
		}
		
		return ctrctData;
	}

	protected abstract ContractType15__2.ContractType15__2Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_ContractType15__2Default extends Create_ContractType15__2 {
		@Override
		protected ContractType15__2.ContractType15__2Builder doEvaluate(JFSATransactionReport drrReport) {
			ContractType15__2.ContractType15__2Builder ctrctData = ContractType15__2.builder();
			return assignOutput(ctrctData, drrReport);
		}
		
		protected ContractType15__2.ContractType15__2Builder assignOutput(ContractType15__2.ContractType15__2Builder ctrctData, JFSATransactionReport drrReport) {
			ctrctData = toBuilder(ContractType15__2.builder()
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
