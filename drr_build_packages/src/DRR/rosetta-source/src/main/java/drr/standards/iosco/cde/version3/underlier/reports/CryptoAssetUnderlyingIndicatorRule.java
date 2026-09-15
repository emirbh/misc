package drr.standards.iosco.cde.version3.underlier.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CryptoAssetUnderlyingIndicatorRule.CryptoAssetUnderlyingIndicatorRuleDefault.class)
public abstract class CryptoAssetUnderlyingIndicatorRule implements ReportFunction<TransactionReportInstruction, Boolean> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction input);

	public static class CryptoAssetUnderlyingIndicatorRuleDefault extends CryptoAssetUnderlyingIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<Boolean>map("getCryptoBased", reportableInformation -> reportableInformation.getCryptoBased())).getOrDefault(false)) {
						return item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<Boolean>map("getCryptoBased", reportableInformation -> reportableInformation.getCryptoBased());
					}
					return MapperS.of(false);
				}).get();
			
			return output;
		}
	}
}
