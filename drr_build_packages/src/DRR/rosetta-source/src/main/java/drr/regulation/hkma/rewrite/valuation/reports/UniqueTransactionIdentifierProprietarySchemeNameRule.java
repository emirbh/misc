package drr.regulation.hkma.rewrite.valuation.reports;

import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.UTIProprietarySchemeNameEnum;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.hkma.rewrite.valuation.functions.Extract_HKMATransactionSchemeName;
import drr.regulation.hkma.rewrite.valuation.functions.Extract_UTIPropietary;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UniqueTransactionIdentifierProprietarySchemeNameRule.UniqueTransactionIdentifierProprietarySchemeNameRuleDefault.class)
public abstract class UniqueTransactionIdentifierProprietarySchemeNameRule implements ReportFunction<ValuationReportInstruction, UTIProprietarySchemeNameEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Extract_HKMATransactionSchemeName extract_HKMATransactionSchemeName;
	@Inject protected Extract_UTIPropietary extract_UTIPropietary;
	@Inject protected UniqueTransactionIdentifierProprietaryRule uniqueTransactionIdentifierProprietaryRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public UTIProprietarySchemeNameEnum evaluate(ValuationReportInstruction input) {
		UTIProprietarySchemeNameEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract UTIProprietarySchemeNameEnum doEvaluate(ValuationReportInstruction input);

	public static class UniqueTransactionIdentifierProprietarySchemeNameRuleDefault extends UniqueTransactionIdentifierProprietarySchemeNameRule {
		@Override
		protected UTIProprietarySchemeNameEnum doEvaluate(ValuationReportInstruction input) {
			UTIProprietarySchemeNameEnum output = null;
			return assignOutput(output, input);
		}
		
		protected UTIProprietarySchemeNameEnum assignOutput(UTIProprietarySchemeNameEnum output, ValuationReportInstruction input) {
			final MapperS<TradeIdentifier> thenArg;
			if (exists(MapperS.of(uniqueTransactionIdentifierProprietaryRule.evaluate(input))).getOrDefault(false)) {
				thenArg = MapperS.of(extract_UTIPropietary.evaluate(input));
			} else {
				thenArg = MapperS.<TradeIdentifier>ofNull();
			}
			output = MapperS.of(extract_HKMATransactionSchemeName.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
