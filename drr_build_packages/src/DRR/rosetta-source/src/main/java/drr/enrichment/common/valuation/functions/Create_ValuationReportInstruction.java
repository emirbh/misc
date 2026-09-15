package drr.enrichment.common.valuation.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.product.collateral.Collateral;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableValuation;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.standards.iso.ReportLevelEnum;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_ValuationReportInstruction.Create_ValuationReportInstructionDefault.class)
public abstract class Create_ValuationReportInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableValuation 
	* @param reportingSide 
	* @return valuationReportInstruction 
	*/
	public ValuationReportInstruction evaluate(ReportableValuation reportableValuation, ReportingSide reportingSide) {
		ValuationReportInstruction.ValuationReportInstructionBuilder valuationReportInstructionBuilder = doEvaluate(reportableValuation, reportingSide);
		
		final ValuationReportInstruction valuationReportInstruction;
		if (valuationReportInstructionBuilder == null) {
			valuationReportInstruction = null;
		} else {
			valuationReportInstruction = valuationReportInstructionBuilder.build();
			objectValidator.validate(ValuationReportInstruction.class, valuationReportInstruction);
		}
		
		return valuationReportInstruction;
	}

	protected abstract ValuationReportInstruction.ValuationReportInstructionBuilder doEvaluate(ReportableValuation reportableValuation, ReportingSide reportingSide);

	public static class Create_ValuationReportInstructionDefault extends Create_ValuationReportInstruction {
		@Override
		protected ValuationReportInstruction.ValuationReportInstructionBuilder doEvaluate(ReportableValuation reportableValuation, ReportingSide reportingSide) {
			ValuationReportInstruction.ValuationReportInstructionBuilder valuationReportInstruction = ValuationReportInstruction.builder();
			return assignOutput(valuationReportInstruction, reportableValuation, reportingSide);
		}
		
		protected ValuationReportInstruction.ValuationReportInstructionBuilder assignOutput(ValuationReportInstruction.ValuationReportInstructionBuilder valuationReportInstruction, ReportableValuation reportableValuation, ReportingSide reportingSide) {
			valuationReportInstruction = toBuilder(ValuationReportInstruction.builder()
				.setValuationDetails(MapperS.of(reportableValuation).<ValuationDetails>map("getValuationDetails", _reportableValuation -> _reportableValuation.getValuationDetails()).get())
				.setReportableInformation(MapperS.of(reportableValuation).<ReportableInformation>map("getReportableInformation", _reportableValuation -> _reportableValuation.getReportableInformation()).get())
				.setCollateralDetails(MapperS.of(reportableValuation).<Collateral>map("getCollateralDetails", _reportableValuation -> _reportableValuation.getCollateralDetails()).get())
				.setReportingSide(reportingSide)
				.setEventIdentifier(MapperS.of(reportableValuation).<Identifier>mapC("getEventIdentifier", _reportableValuation -> _reportableValuation.getEventIdentifier()).getMulti())
				.setLevel(MapperS.of(reportableValuation).<ReportLevelEnum>map("getLevel", _reportableValuation -> _reportableValuation.getLevel()).get())
				.build());
			
			return Optional.ofNullable(valuationReportInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
