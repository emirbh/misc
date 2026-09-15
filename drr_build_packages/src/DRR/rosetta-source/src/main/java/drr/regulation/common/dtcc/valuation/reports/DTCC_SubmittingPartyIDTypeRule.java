package drr.regulation.common.dtcc.valuation.reports;

import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.functions.ExtractReportSubmittingPartyIdentifier;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_SubmittingPartyIDTypeRule.DTCC_SubmittingPartyIDTypeRuleDefault.class)
public abstract class DTCC_SubmittingPartyIDTypeRule implements ReportFunction<ValuationReportInstruction, PartyIdentifierTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractReportSubmittingPartyIdentifier extractReportSubmittingPartyIdentifier;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PartyIdentifierTypeEnum evaluate(ValuationReportInstruction input) {
		PartyIdentifierTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PartyIdentifierTypeEnum doEvaluate(ValuationReportInstruction input);

	public static class DTCC_SubmittingPartyIDTypeRuleDefault extends DTCC_SubmittingPartyIDTypeRule {
		@Override
		protected PartyIdentifierTypeEnum doEvaluate(ValuationReportInstruction input) {
			PartyIdentifierTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierTypeEnum assignOutput(PartyIdentifierTypeEnum output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(extractReportSubmittingPartyIdentifier.evaluate(item.<ReportingSide>map("getReportingSide", valuationReportInstruction -> valuationReportInstruction.getReportingSide()).get()))).getOrDefault(false)) {
						return MapperS.of(PartyIdentifierTypeEnum.LEI);
					}
					return MapperS.<PartyIdentifierTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
