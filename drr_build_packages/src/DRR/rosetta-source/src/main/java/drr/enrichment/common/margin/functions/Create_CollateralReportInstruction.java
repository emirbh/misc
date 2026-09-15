package drr.enrichment.common.margin.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.margin.CollateralDetails;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.ReportableCollateral;
import drr.regulation.common.ReportableInformation;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CollateralReportInstruction.Create_CollateralReportInstructionDefault.class)
public abstract class Create_CollateralReportInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableCollateral 
	* @param reportingSide 
	* @return collateralReportInstruction 
	*/
	public CollateralReportInstruction evaluate(ReportableCollateral reportableCollateral, ReportingSide reportingSide) {
		CollateralReportInstruction.CollateralReportInstructionBuilder collateralReportInstructionBuilder = doEvaluate(reportableCollateral, reportingSide);
		
		final CollateralReportInstruction collateralReportInstruction;
		if (collateralReportInstructionBuilder == null) {
			collateralReportInstruction = null;
		} else {
			collateralReportInstruction = collateralReportInstructionBuilder.build();
			objectValidator.validate(CollateralReportInstruction.class, collateralReportInstruction);
		}
		
		return collateralReportInstruction;
	}

	protected abstract CollateralReportInstruction.CollateralReportInstructionBuilder doEvaluate(ReportableCollateral reportableCollateral, ReportingSide reportingSide);

	public static class Create_CollateralReportInstructionDefault extends Create_CollateralReportInstruction {
		@Override
		protected CollateralReportInstruction.CollateralReportInstructionBuilder doEvaluate(ReportableCollateral reportableCollateral, ReportingSide reportingSide) {
			CollateralReportInstruction.CollateralReportInstructionBuilder collateralReportInstruction = CollateralReportInstruction.builder();
			return assignOutput(collateralReportInstruction, reportableCollateral, reportingSide);
		}
		
		protected CollateralReportInstruction.CollateralReportInstructionBuilder assignOutput(CollateralReportInstruction.CollateralReportInstructionBuilder collateralReportInstruction, ReportableCollateral reportableCollateral, ReportingSide reportingSide) {
			collateralReportInstruction = toBuilder(CollateralReportInstruction.builder()
				.setCollateralDetails(MapperS.of(reportableCollateral).<CollateralDetails>map("getCollateralDetails", _reportableCollateral -> _reportableCollateral.getCollateralDetails()).get())
				.setReportableInformation(MapperS.of(reportableCollateral).<ReportableInformation>map("getReportableInformation", _reportableCollateral -> _reportableCollateral.getReportableInformation()).get())
				.setReportingSide(reportingSide)
				.build());
			
			return Optional.ofNullable(collateralReportInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
