package drr.regulation.cftc.rewrite.margin.reports;

import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.functions.ExtractReportSubmittingPartyIdentifier;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_SubmittingPartyIDTypeRule.DTCC_SubmittingPartyIDTypeRuleDefault.class)
public abstract class DTCC_SubmittingPartyIDTypeRule implements ReportFunction<CollateralReportInstruction, PartyIdentifierTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractReportSubmittingPartyIdentifier extractReportSubmittingPartyIdentifier;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PartyIdentifierTypeEnum evaluate(CollateralReportInstruction input) {
		PartyIdentifierTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PartyIdentifierTypeEnum doEvaluate(CollateralReportInstruction input);

	public static class DTCC_SubmittingPartyIDTypeRuleDefault extends DTCC_SubmittingPartyIDTypeRule {
		@Override
		protected PartyIdentifierTypeEnum doEvaluate(CollateralReportInstruction input) {
			PartyIdentifierTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierTypeEnum assignOutput(PartyIdentifierTypeEnum output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(extractReportSubmittingPartyIdentifier.evaluate(item.<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).get()))).getOrDefault(false)) {
						return MapperS.of(PartyIdentifierTypeEnum.LEI);
					}
					return MapperS.<PartyIdentifierTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
