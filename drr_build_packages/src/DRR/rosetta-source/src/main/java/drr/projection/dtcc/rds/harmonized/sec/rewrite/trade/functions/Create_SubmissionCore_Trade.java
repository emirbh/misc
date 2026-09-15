package drr.projection.dtcc.rds.harmonized.sec.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECTransactionReportTrade;
import iso20022.dtcc.rds.harmonized.Core;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_SubmissionCore_Trade.Create_SubmissionCore_TradeDefault.class)
public abstract class Create_SubmissionCore_Trade implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @param commonCore 
	* @return core 
	*/
	public Core evaluate(SECTransactionReportTrade drrReport, Core commonCore) {
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

	protected abstract Core.CoreBuilder doEvaluate(SECTransactionReportTrade drrReport, Core commonCore);

	public static class Create_SubmissionCore_TradeDefault extends Create_SubmissionCore_Trade {
		@Override
		protected Core.CoreBuilder doEvaluate(SECTransactionReportTrade drrReport, Core commonCore) {
			Core.CoreBuilder core = Core.builder();
			return assignOutput(core, drrReport, commonCore);
		}
		
		protected Core.CoreBuilder assignOutput(Core.CoreBuilder core, SECTransactionReportTrade drrReport, Core commonCore) {
			core = toBuilder(commonCore, () -> Core.builder());
			
			core
				.addTradeParty2ReportingDestination(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReportTrade -> sECTransactionReportTrade.getDtccAdditionalFields()).<SupervisoryBodyEnum>mapC("getTradeParty2ReportingDestination", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty2ReportingDestination())
					.mapItem(item -> item.map("to-string", SupervisoryBodyEnum::toDisplayString)).getMulti());
			
			return Optional.ofNullable(core)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
