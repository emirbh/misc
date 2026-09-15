package drr.standards.iosco.cde.version1.execution.functions;

import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.OptionPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(OptionSettlementDate.OptionSettlementDateDefault.class)
public abstract class OptionSettlementDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected SettlementDateFromExerciseTerms settlementDateFromExerciseTerms;
	@Inject protected SettlementDateFromSchedule settlementDateFromSchedule;
	@Inject protected SettlementDateFromSettlementTerms settlementDateFromSettlementTerms;

	/**
	* @param optionPayout 
	* @return optionDate 
	*/
	public List<Date> evaluate(OptionPayout optionPayout) {
		List<Date> optionDate = doEvaluate(optionPayout);
		
		return optionDate;
	}

	protected abstract List<Date> doEvaluate(OptionPayout optionPayout);

	public static class OptionSettlementDateDefault extends OptionSettlementDate {
		@Override
		protected List<Date> doEvaluate(OptionPayout optionPayout) {
			List<Date> optionDate = new ArrayList<>();
			return assignOutput(optionDate, optionPayout);
		}
		
		protected List<Date> assignOutput(List<Date> optionDate, OptionPayout optionPayout) {
			optionDate.addAll(settlementDateFromSchedule.evaluate(MapperS.of(optionPayout).<CalculationSchedule>map("getSchedule", _optionPayout -> _optionPayout.getSchedule()).get()));
			
			optionDate.addAll(settlementDateFromSettlementTerms.evaluate(MapperS.of(optionPayout).<SettlementTerms>map("getSettlementTerms", _optionPayout -> _optionPayout.getSettlementTerms()).get()));
			
			optionDate.addAll(settlementDateFromExerciseTerms.evaluate(MapperS.of(optionPayout).<ExerciseTerms>map("getExerciseTerms", _optionPayout -> _optionPayout.getExerciseTerms()).get()));
			
			return optionDate;
		}
	}
}
