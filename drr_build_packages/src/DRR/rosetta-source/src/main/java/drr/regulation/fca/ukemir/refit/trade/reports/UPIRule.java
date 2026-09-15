package drr.regulation.fca.ukemir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.upi.reports.UniqueProductIdentifierRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UPIRule.UPIRuleDefault.class)
public abstract class UPIRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ISINRule iSINRule;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected UniqueProductIdentifierRule uniqueProductIdentifierRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class UPIRuleDefault extends UPIRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableAction.evaluate(item.get()))).andNullSafe(notExists(MapperS.of(iSINRule.evaluate(item.get())))).get());
			final FieldWithMetaString fieldWithMetaString = thenArg
				.mapSingleToItem(item -> {
					final String string = uniqueProductIdentifierRule.evaluate(item.get());
					return string == null ? MapperS.<FieldWithMetaString>ofNull() : MapperS.of(FieldWithMetaString.builder().setValue(string).build());
				}).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
