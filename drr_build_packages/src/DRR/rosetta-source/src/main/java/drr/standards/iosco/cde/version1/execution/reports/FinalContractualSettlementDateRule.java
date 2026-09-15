package drr.standards.iosco.cde.version1.execution.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.ProductForEvent;
import drr.standards.iosco.cde.version1.execution.functions.ExtractFinalContractualSettlementDate;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FinalContractualSettlementDateRule.FinalContractualSettlementDateRuleDefault.class)
public abstract class FinalContractualSettlementDateRule implements ReportFunction<TransactionReportInstructionBase, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractFinalContractualSettlementDate extractFinalContractualSettlementDate;
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstructionBase input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstructionBase input);

	public static class FinalContractualSettlementDateRuleDefault extends FinalContractualSettlementDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstructionBase input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstructionBase input) {
			if (exists(MapperS.of(input).<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<Date>map("getFinalContractualSettlementDate", reportableInformationBase -> reportableInformationBase.getFinalContractualSettlementDate())).getOrDefault(false)) {
				output = MapperS.of(input).<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<Date>map("getFinalContractualSettlementDate", reportableInformationBase -> reportableInformationBase.getFinalContractualSettlementDate()).get();
			} else {
				output = MapperC.<Date>of(extractFinalContractualSettlementDate.evaluate(productForEvent.evaluate(input)))
					.max().get();
			}
			
			return output;
		}
	}
}
