package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.UTIProprietarySchemeNameEnum;
import drr.standards.iosco.uti.functions.GetUniqueTransactionIdentifier;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import drr.standards.iso.functions.IsValidLeiFromGlobalUti;
import java.util.Collections;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UniqueTransactionIdentifierProprietarySchemeNameRule.UniqueTransactionIdentifierProprietarySchemeNameRuleDefault.class)
public abstract class UniqueTransactionIdentifierProprietarySchemeNameRule implements ReportFunction<TransactionReportInstruction, UTIProprietarySchemeNameEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetUniqueTransactionIdentifier getUniqueTransactionIdentifier;
	@Inject protected IsMax52UpperCaseAlphanumericText isMax52UpperCaseAlphanumericText;
	@Inject protected IsValidLeiFromGlobalUti isValidLeiFromGlobalUti;
	@Inject protected UniqueTransactionIdentifierProprietaryRule uniqueTransactionIdentifierProprietaryRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public UTIProprietarySchemeNameEnum evaluate(TransactionReportInstruction input) {
		UTIProprietarySchemeNameEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract UTIProprietarySchemeNameEnum doEvaluate(TransactionReportInstruction input);

	public static class UniqueTransactionIdentifierProprietarySchemeNameRuleDefault extends UniqueTransactionIdentifierProprietarySchemeNameRule {
		@Override
		protected UTIProprietarySchemeNameEnum doEvaluate(TransactionReportInstruction input) {
			UTIProprietarySchemeNameEnum output = null;
			return assignOutput(output, input);
		}
		
		protected UTIProprietarySchemeNameEnum assignOutput(UTIProprietarySchemeNameEnum output, TransactionReportInstruction input) {
			if (exists(MapperS.of(uniqueTransactionIdentifierProprietaryRule.evaluate(input))).getOrDefault(false)) {
				final SupervisoryBodyEnum supervisoryBodyEnum0 = SupervisoryBodyEnum.HKMA;
				final SupervisoryBodyEnum supervisoryBodyEnum1 = SupervisoryBodyEnum.HKMA;
				final SupervisoryBodyEnum supervisoryBodyEnum2 = SupervisoryBodyEnum.HKMA;
				if (exists(MapperS.of(getUniqueTransactionIdentifier.evaluate(MapperS.of(input).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), (supervisoryBodyEnum0 == null ? Collections.<SupervisoryBodyEnum>emptyList() : Collections.singletonList(supervisoryBodyEnum0)), null, input))).andNullSafe(areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate(getUniqueTransactionIdentifier.evaluate(MapperS.of(input).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), (supervisoryBodyEnum1 == null ? Collections.<SupervisoryBodyEnum>emptyList() : Collections.singletonList(supervisoryBodyEnum1)), null, input))), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(isValidLeiFromGlobalUti.evaluate(getUniqueTransactionIdentifier.evaluate(MapperS.of(input).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), (supervisoryBodyEnum2 == null ? Collections.<SupervisoryBodyEnum>emptyList() : Collections.singletonList(supervisoryBodyEnum2)), null, input))), MapperS.of(false), CardinalityOperator.All))).getOrDefault(false)) {
					output = UTIProprietarySchemeNameEnum.UTI_TID;
				} else {
					output = UTIProprietarySchemeNameEnum.UTI_USI;
				}
			} else {
				output = null;
			}
			
			return output;
		}
	}
}
