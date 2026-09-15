package drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import iso20022.dtcc.rds.harmonized.Core;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_SubmissionCore_Part43.Create_SubmissionCore_Part43Default.class)
public abstract class Create_SubmissionCore_Part43 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @param commonCore 
	* @return core 
	*/
	public Core evaluate(CFTCPart43TransactionReport drrReport, Core commonCore) {
		Core.CoreBuilder coreBuilder = doEvaluate(drrReport, commonCore);
		
		final Core core;
		if (coreBuilder == null) {
			core = null;
		} else {
			core = coreBuilder.build();
			objectValidator.validate(Core.class, core);
		}
		
		return core;
	}

	protected abstract Core.CoreBuilder doEvaluate(CFTCPart43TransactionReport drrReport, Core commonCore);

	public static class Create_SubmissionCore_Part43Default extends Create_SubmissionCore_Part43 {
		@Override
		protected Core.CoreBuilder doEvaluate(CFTCPart43TransactionReport drrReport, Core commonCore) {
			Core.CoreBuilder core = Core.builder();
			return assignOutput(core, drrReport, commonCore);
		}
		
		protected Core.CoreBuilder assignOutput(Core.CoreBuilder core, CFTCPart43TransactionReport drrReport, Core commonCore) {
			core = toBuilder(commonCore, () -> Core.builder());
			
			core
				.setMessageType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCPart43TransactionReport -> cFTCPart43TransactionReport.getDtccAdditionalFields()).<String>map("getMessageType", dTCCAdditionalFields -> dTCCAdditionalFields.getMessageType()).get());
			
			return Optional.ofNullable(core)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
