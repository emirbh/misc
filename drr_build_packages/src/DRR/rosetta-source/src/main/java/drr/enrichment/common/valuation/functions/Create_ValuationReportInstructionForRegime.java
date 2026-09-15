package drr.enrichment.common.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.RegimeReportableValuation;
import drr.regulation.common.RegimeReportingSide;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.ValuationReportInstruction;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_ValuationReportInstructionForRegime.Create_ValuationReportInstructionForRegimeDefault.class)
public abstract class Create_ValuationReportInstructionForRegime implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ValuationReportInstruction create_ValuationReportInstruction;

	/**
	* @param regimeReportableValuation 
	* @param regimeName 
	* @param supervisoryBody 
	* @param delegatedReporting 
	* @return valuationReportInstruction 
	*/
	public ValuationReportInstruction evaluate(RegimeReportableValuation regimeReportableValuation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting) {
		ValuationReportInstruction.ValuationReportInstructionBuilder valuationReportInstructionBuilder = doEvaluate(regimeReportableValuation, regimeName, supervisoryBody, delegatedReporting);
		
		final ValuationReportInstruction valuationReportInstruction;
		if (valuationReportInstructionBuilder == null) {
			valuationReportInstruction = null;
		} else {
			valuationReportInstruction = valuationReportInstructionBuilder.build();
			objectValidator.validate(ValuationReportInstruction.class, valuationReportInstruction);
		}
		
		return valuationReportInstruction;
	}

	protected abstract ValuationReportInstruction.ValuationReportInstructionBuilder doEvaluate(RegimeReportableValuation regimeReportableValuation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting);

	protected abstract MapperS<? extends ReportingSide> reportingSide(RegimeReportableValuation regimeReportableValuation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting);

	public static class Create_ValuationReportInstructionForRegimeDefault extends Create_ValuationReportInstructionForRegime {
		@Override
		protected ValuationReportInstruction.ValuationReportInstructionBuilder doEvaluate(RegimeReportableValuation regimeReportableValuation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting) {
			ValuationReportInstruction.ValuationReportInstructionBuilder valuationReportInstruction = ValuationReportInstruction.builder();
			return assignOutput(valuationReportInstruction, regimeReportableValuation, regimeName, supervisoryBody, delegatedReporting);
		}
		
		protected ValuationReportInstruction.ValuationReportInstructionBuilder assignOutput(ValuationReportInstruction.ValuationReportInstructionBuilder valuationReportInstruction, RegimeReportableValuation regimeReportableValuation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting) {
			if (exists(reportingSide(regimeReportableValuation, regimeName, supervisoryBody, delegatedReporting)).getOrDefault(false)) {
				valuationReportInstruction = toBuilder(create_ValuationReportInstruction.evaluate(regimeReportableValuation, reportingSide(regimeReportableValuation, regimeName, supervisoryBody, delegatedReporting).get()));
			} else {
				valuationReportInstruction = null;
			}
			
			return Optional.ofNullable(valuationReportInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReportingSide> reportingSide(RegimeReportableValuation regimeReportableValuation, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting) {
			final MapperC<RegimeReportingSide> thenArg0 = MapperS.of(regimeReportableValuation).<RegimeReportingSide>mapC("getRegimeReportingSide", _regimeReportableValuation -> _regimeReportableValuation.getRegimeReportingSide())
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
