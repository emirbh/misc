package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.dtcc.SupplementaryDataEnvelope1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_SupplementaryDataEnvelope1.Create_SupplementaryDataEnvelope1Default.class)
public abstract class Create_SupplementaryDataEnvelope1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return envlp 
	*/
	public SupplementaryDataEnvelope1 evaluate(HKMATransactionReport drrReport) {
		SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder envlpBuilder = doEvaluate(drrReport);
		
		final SupplementaryDataEnvelope1 envlp;
		if (envlpBuilder == null) {
			envlp = null;
		} else {
			envlp = envlpBuilder.build();
			objectValidator.validate(SupplementaryDataEnvelope1.class, envlp);
		}
		
		return envlp;
	}

	protected abstract SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_SupplementaryDataEnvelope1Default extends Create_SupplementaryDataEnvelope1 {
		@Override
		protected SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder doEvaluate(HKMATransactionReport drrReport) {
			SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder envlp = SupplementaryDataEnvelope1.builder();
			return assignOutput(envlp, drrReport);
		}
		
		protected SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder assignOutput(SupplementaryDataEnvelope1.SupplementaryDataEnvelope1Builder envlp, HKMATransactionReport drrReport) {
			return Optional.ofNullable(envlp)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
