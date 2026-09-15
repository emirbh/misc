package drr.enrichment.common.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.RegimeReportableEvent;
import drr.regulation.common.RegimeReportingSide;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_TransactionReportInstructionForRegime.Create_TransactionReportInstructionForRegimeDefault.class)
public abstract class Create_TransactionReportInstructionForRegime implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TransactionReportInstruction create_TransactionReportInstruction;

	/**
	* @param regimeReportableEvent 
	* @param regimeName 
	* @param supervisoryBody 
	* @param delegatedReporting 
	* @return transactionReportInstruction 
	*/
	public TransactionReportInstruction evaluate(RegimeReportableEvent regimeReportableEvent, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting) {
		TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstructionBuilder = doEvaluate(regimeReportableEvent, regimeName, supervisoryBody, delegatedReporting);
		
		final TransactionReportInstruction transactionReportInstruction;
		if (transactionReportInstructionBuilder == null) {
			transactionReportInstruction = null;
		} else {
			transactionReportInstruction = transactionReportInstructionBuilder.build();
			objectValidator.validate(TransactionReportInstruction.class, transactionReportInstruction);
		}
		
		return transactionReportInstruction;
	}

	protected abstract TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(RegimeReportableEvent regimeReportableEvent, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting);

	protected abstract MapperS<? extends ReportingSide> reportingSide(RegimeReportableEvent regimeReportableEvent, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting);

	public static class Create_TransactionReportInstructionForRegimeDefault extends Create_TransactionReportInstructionForRegime {
		@Override
		protected TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(RegimeReportableEvent regimeReportableEvent, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting) {
			TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstruction = TransactionReportInstruction.builder();
			return assignOutput(transactionReportInstruction, regimeReportableEvent, regimeName, supervisoryBody, delegatedReporting);
		}
		
		protected TransactionReportInstruction.TransactionReportInstructionBuilder assignOutput(TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstruction, RegimeReportableEvent regimeReportableEvent, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting) {
			if (exists(reportingSide(regimeReportableEvent, regimeName, supervisoryBody, delegatedReporting)).getOrDefault(false)) {
				transactionReportInstruction = toBuilder(create_TransactionReportInstruction.evaluate(regimeReportableEvent, reportingSide(regimeReportableEvent, regimeName, supervisoryBody, delegatedReporting).get()));
			} else {
				transactionReportInstruction = null;
			}
			
			return Optional.ofNullable(transactionReportInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReportingSide> reportingSide(RegimeReportableEvent regimeReportableEvent, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBody, Boolean delegatedReporting) {
			final MapperC<RegimeReportingSide> thenArg0 = MapperS.of(regimeReportableEvent).<RegimeReportingSide>mapC("getRegimeReportingSide", _regimeReportableEvent -> _regimeReportableEvent.getRegimeReportingSide())
				.filterItemNullSafe(item -> areEqual(item.<RegimeNameEnum>map("getRegimeName", regimeReportingSide -> regimeReportingSide.getRegimeName()), MapperS.of(regimeName), CardinalityOperator.All).get());
			final MapperC<RegimeReportingSide> thenArg1 = thenArg0
				.filterItemNullSafe(item -> notExists(MapperS.of(supervisoryBody)).orNullSafe(areEqual(item.<SupervisoryBodyEnum>map("getSupervisoryBody", regimeReportingSide -> regimeReportingSide.getSupervisoryBody()), MapperS.of(supervisoryBody), CardinalityOperator.All)).get());
			final MapperC<ReportingSide> thenArg2 = thenArg1
				.mapItem(item -> {
					if ((delegatedReporting == null ? false : delegatedReporting)) {
						return item.<ReportingSide>map("getDelegatedReportingSide", regimeReportingSide -> regimeReportingSide.getDelegatedReportingSide());
					}
					return item.<ReportingSide>map("getReportingSide", regimeReportingSide -> regimeReportingSide.getReportingSide());
				});
			return MapperS.of(thenArg2.get());
		}
	}
}
