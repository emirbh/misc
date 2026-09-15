package drr.enrichment.common.margin.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.RegimeReportableCollateral;
import drr.regulation.common.RegimeReportingSide;
import drr.regulation.common.SupervisoryBodyEnum;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_CollateralReportInstructionForRegime.Create_CollateralReportInstructionForRegimeDefault.class)
public abstract class Create_CollateralReportInstructionForRegime implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_CollateralReportInstruction create_CollateralReportInstruction;

	/**
	* @param regimeReportableCollateral 
	* @param regimeName 
	* @param supervisoryBody 
	* @param delegatedReporting 
	* @return collateralReportInstruction 
	*/
	public CollateralReportInstruction evaluate(RegimeReportableCollateral regimeReportableCollateral, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting) {
		CollateralReportInstruction.CollateralReportInstructionBuilder collateralReportInstructionBuilder = doEvaluate(regimeReportableCollateral, regimeName, supervisoryBody, delegatedReporting);
		
		final CollateralReportInstruction collateralReportInstruction;
		if (collateralReportInstructionBuilder == null) {
			collateralReportInstruction = null;
		} else {
			collateralReportInstruction = collateralReportInstructionBuilder.build();
			objectValidator.validate(CollateralReportInstruction.class, collateralReportInstruction);
		}
		
		return collateralReportInstruction;
	}

	protected abstract CollateralReportInstruction.CollateralReportInstructionBuilder doEvaluate(RegimeReportableCollateral regimeReportableCollateral, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting);

	protected abstract MapperS<? extends ReportingSide> reportingSide(RegimeReportableCollateral regimeReportableCollateral, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting);

	public static class Create_CollateralReportInstructionForRegimeDefault extends Create_CollateralReportInstructionForRegime {
		@Override
		protected CollateralReportInstruction.CollateralReportInstructionBuilder doEvaluate(RegimeReportableCollateral regimeReportableCollateral, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting) {
			CollateralReportInstruction.CollateralReportInstructionBuilder collateralReportInstruction = CollateralReportInstruction.builder();
			return assignOutput(collateralReportInstruction, regimeReportableCollateral, regimeName, supervisoryBody, delegatedReporting);
		}
		
		protected CollateralReportInstruction.CollateralReportInstructionBuilder assignOutput(CollateralReportInstruction.CollateralReportInstructionBuilder collateralReportInstruction, RegimeReportableCollateral regimeReportableCollateral, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting) {
			if (exists(reportingSide(regimeReportableCollateral, regimeName, supervisoryBody, delegatedReporting)).getOrDefault(false)) {
				collateralReportInstruction = toBuilder(create_CollateralReportInstruction.evaluate(regimeReportableCollateral, reportingSide(regimeReportableCollateral, regimeName, supervisoryBody, delegatedReporting).get()));
			} else {
				collateralReportInstruction = null;
			}
			
			return Optional.ofNullable(collateralReportInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReportingSide> reportingSide(RegimeReportableCollateral regimeReportableCollateral, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting) {
			final MapperC<RegimeReportingSide> thenArg0 = MapperS.of(regimeReportableCollateral).<RegimeReportingSide>mapC("getRegimeReportingSide", _regimeReportableCollateral -> _regimeReportableCollateral.getRegimeReportingSide())
				.filterItemNullSafe(item -> areEqual(item.<RegimeNameEnum>map("getRegimeName", regimeReportingSide -> regimeReportingSide.getRegimeName()), MapperS.of(regimeName), CardinalityOperator.All).andNullSafe(areEqual(item.<SupervisoryBodyEnum>map("getSupervisoryBody", regimeReportingSide -> regimeReportingSide.getSupervisoryBody()), MapperS.of(supervisoryBody), CardinalityOperator.All)).get());
			final MapperC<ReportingSide> thenArg1 = thenArg0
				.mapItem(item -> {
					if ((delegatedReporting == null ? false : delegatedReporting)) {
						return item.<ReportingSide>map("getDelegatedReportingSide", regimeReportingSide -> regimeReportingSide.getDelegatedReportingSide());
					}
					return item.<ReportingSide>map("getReportingSide", regimeReportingSide -> regimeReportingSide.getReportingSide());
				});
			return MapperS.of(thenArg1.get());
		}
	}
}
