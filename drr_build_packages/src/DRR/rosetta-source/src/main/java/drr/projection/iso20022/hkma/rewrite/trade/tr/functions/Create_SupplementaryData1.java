package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.tr.SupplementaryData1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_SupplementaryData1.Create_SupplementaryData1Default.class)
public abstract class Create_SupplementaryData1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_SupplementaryDataEnvelope1 create_SupplementaryDataEnvelope1;

	/**
	* @param drrReport 
	* @return splmtryData 
	*/
	public SupplementaryData1 evaluate(HKMATransactionReport drrReport) {
		SupplementaryData1.SupplementaryData1Builder splmtryDataBuilder = doEvaluate(drrReport);
		
		final SupplementaryData1 splmtryData;
		if (splmtryDataBuilder == null) {
			splmtryData = null;
		} else {
			splmtryData = splmtryDataBuilder.build();
			objectValidator.validate(SupplementaryData1.class, splmtryData);
		}
		
		return splmtryData;
	}

	protected abstract SupplementaryData1.SupplementaryData1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_SupplementaryData1Default extends Create_SupplementaryData1 {
		@Override
		protected SupplementaryData1.SupplementaryData1Builder doEvaluate(HKMATransactionReport drrReport) {
			SupplementaryData1.SupplementaryData1Builder splmtryData = SupplementaryData1.builder();
			return assignOutput(splmtryData, drrReport);
		}
		
		protected SupplementaryData1.SupplementaryData1Builder assignOutput(SupplementaryData1.SupplementaryData1Builder splmtryData, HKMATransactionReport drrReport) {
			splmtryData = toBuilder(SupplementaryData1.builder()
				.setPlcAndNm(null)
				.setEnvlp(create_SupplementaryDataEnvelope1.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(splmtryData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
