package drr.regulation.common.dtcc.trade.reports;

import cdm.base.staticdata.party.PersonIdentifier;
import cdm.base.staticdata.party.metafields.FieldWithMetaPersonIdentifier;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportingSide;
import drr.base.util.party.functions.NaturalPersonBuyerOrSeller;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.execution.reports.ClearedRule;
import drr.standards.iosco.cde.version3.execution.reports.PlatformIdentifierRule;
import drr.standards.iso.ClearedEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_TradeParty1IDTypeRule.DTCC_TradeParty1IDTypeRuleDefault.class)
public abstract class DTCC_TradeParty1IDTypeRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ClearedRule clearedRule;
	@Inject protected NaturalPersonBuyerOrSeller naturalPersonBuyerOrSeller;
	@Inject protected PlatformIdentifierRule platformIdentifierRule;

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

	public static class DTCC_TradeParty1IDTypeRuleDefault extends DTCC_TradeParty1IDTypeRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final ReferenceWithMetaParty referenceWithMetaParty = MapperS.of(input).<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
			if (exists(MapperS.of(MapperS.of(naturalPersonBuyerOrSeller.evaluate((referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()))).<FieldWithMetaPersonIdentifier>mapC("getPersonId", naturalPerson -> naturalPerson.getPersonId()).<PersonIdentifier>map("Type coercion", fieldWithMetaPersonIdentifier -> fieldWithMetaPersonIdentifier.getValue()).<FieldWithMetaString>map("getIdentifier", personIdentifier -> personIdentifier.getIdentifier()).get())).andNullSafe(notEqual(MapperC.<String>of(MapperS.of("XXXX"), MapperS.of("XOFF"), MapperS.of("BILT")), MapperS.of(platformIdentifierRule.evaluate(input)), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(clearedRule.evaluate(input)), MapperS.of(ClearedEnum.I), CardinalityOperator.All)).getOrDefault(false)) {
				output = "NPID";
			} else {
				output = "LEI";
			}
			
			return output;
		}
	}
}
