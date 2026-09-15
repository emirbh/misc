package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetInstrumentType;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import javax.inject.Inject;


@ImplementedBy(InstrumentTypeRule.InstrumentTypeRuleDefault.class)
public abstract class InstrumentTypeRule implements ReportFunction<TransactionReportInstruction, AnnaDsbInstrumentTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetInstrumentType getInstrumentType;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public AnnaDsbInstrumentTypeEnum evaluate(TransactionReportInstruction input) {
		AnnaDsbInstrumentTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract AnnaDsbInstrumentTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class InstrumentTypeRuleDefault extends InstrumentTypeRule {
		@Override
		protected AnnaDsbInstrumentTypeEnum doEvaluate(TransactionReportInstruction input) {
			AnnaDsbInstrumentTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected AnnaDsbInstrumentTypeEnum assignOutput(AnnaDsbInstrumentTypeEnum output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(getInstrumentType.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
