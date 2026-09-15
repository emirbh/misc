package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.OptionOrSwaption11__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetOptn2.GetOptn2Default.class)
public abstract class GetOptn2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetCallAmt getCallAmt;
	@Inject protected GetExrcDt getExrcDt;
	@Inject protected GetExrcStyle getExrcStyle;
	@Inject protected GetMbddTp getMbddTp;
	@Inject protected GetMtrtyDtOfUndrlyg getMtrtyDtOfUndrlyg;
	@Inject protected GetPrmAmt getPrmAmt;
	@Inject protected GetPrmPmtDt getPrmPmtDt;
	@Inject protected GetPutAmt getPutAmt;
	@Inject protected GetStrkPric getStrkPric;
	@Inject protected GetTp getTp;

	/**
	* @param drrReport 
	* @return optn 
	*/
	public OptionOrSwaption11__2 evaluate(JFSATransactionReport drrReport) {
		OptionOrSwaption11__2.OptionOrSwaption11__2Builder optnBuilder = doEvaluate(drrReport);
		
		final OptionOrSwaption11__2 optn;
		if (optnBuilder == null) {
			optn = null;
		} else {
			optn = optnBuilder.build();
			objectValidator.validate(OptionOrSwaption11__2.class, optn);
		}
		
		return optn;
	}

	protected abstract OptionOrSwaption11__2.OptionOrSwaption11__2Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetOptn2Default extends GetOptn2 {
		@Override
		protected OptionOrSwaption11__2.OptionOrSwaption11__2Builder doEvaluate(JFSATransactionReport drrReport) {
			OptionOrSwaption11__2.OptionOrSwaption11__2Builder optn = OptionOrSwaption11__2.builder();
			return assignOutput(optn, drrReport);
		}
		
		protected OptionOrSwaption11__2.OptionOrSwaption11__2Builder assignOutput(OptionOrSwaption11__2.OptionOrSwaption11__2Builder optn, JFSATransactionReport drrReport) {
			optn = toBuilder(OptionOrSwaption11__2.builder()
				.setTp(getTp.evaluate(drrReport))
				.setMbddTp(getMbddTp.evaluate(drrReport))
				.setExrcStyle(getExrcStyle.evaluate(drrReport))
				.setExrcDt(getExrcDt.evaluate(drrReport))
				.setStrkPric(getStrkPric.evaluate(drrReport))
				.setCallAmt(getCallAmt.evaluate(drrReport))
				.setPutAmt(getPutAmt.evaluate(drrReport))
				.setPrmAmt(getPrmAmt.evaluate(drrReport))
				.setPrmPmtDt(getPrmPmtDt.evaluate(drrReport))
				.setMtrtyDtOfUndrlyg(getMtrtyDtOfUndrlyg.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(optn)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
