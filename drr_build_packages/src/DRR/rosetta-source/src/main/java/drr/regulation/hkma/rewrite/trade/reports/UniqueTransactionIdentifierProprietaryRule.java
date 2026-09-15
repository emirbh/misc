package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.uti.functions.GetUniqueSwapIdentifier;
import drr.standards.iosco.uti.functions.GetUniqueTransactionIdentifier;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import drr.standards.iso.functions.IsValidLeiFromGlobalUti;
import java.util.Collections;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UniqueTransactionIdentifierProprietaryRule.UniqueTransactionIdentifierProprietaryRuleDefault.class)
public abstract class UniqueTransactionIdentifierProprietaryRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetUniqueSwapIdentifier getUniqueSwapIdentifier;
	@Inject protected GetUniqueTransactionIdentifier getUniqueTransactionIdentifier;
	@Inject protected IsMax52UpperCaseAlphanumericText isMax52UpperCaseAlphanumericText;
	@Inject protected IsValidLeiFromGlobalUti isValidLeiFromGlobalUti;

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

	public static class UniqueTransactionIdentifierProprietaryRuleDefault extends UniqueTransactionIdentifierProprietaryRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final SupervisoryBodyEnum supervisoryBodyEnum0 = SupervisoryBodyEnum.HKMA;
			if (exists(MapperS.of(getUniqueTransactionIdentifier.evaluate(MapperS.of(input).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), (supervisoryBodyEnum0 == null ? Collections.<SupervisoryBodyEnum>emptyList() : Collections.singletonList(supervisoryBodyEnum0)), null, input))).getOrDefault(false)) {
				final SupervisoryBodyEnum supervisoryBodyEnum1 = SupervisoryBodyEnum.HKMA;
				final MapperS<String> thenArg = MapperS.of(getUniqueTransactionIdentifier.evaluate(MapperS.of(input).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), (supervisoryBodyEnum1 == null ? Collections.<SupervisoryBodyEnum>emptyList() : Collections.singletonList(supervisoryBodyEnum1)), null, input));
				output = thenArg
					.filterSingleNullSafe(item -> areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(isValidLeiFromGlobalUti.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All)).get()).get();
			} else {
				final SupervisoryBodyEnum supervisoryBodyEnum2 = SupervisoryBodyEnum.HKMA;
				output = getUniqueSwapIdentifier.evaluate(input, (supervisoryBodyEnum2 == null ? Collections.<SupervisoryBodyEnum>emptyList() : Collections.singletonList(supervisoryBodyEnum2)));
			}
			
			return output;
		}
	}
}
