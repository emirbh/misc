package drr.standards.iosco.cde.version1.execution.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableDates;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.OptionExerciseStyleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.util.datetime.functions.AdjustableDateResolution;
import drr.base.util.datetime.functions.AdjustableDatesResolution;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SettlementDateFromExerciseTerms.SettlementDateFromExerciseTermsDefault.class)
public abstract class SettlementDateFromExerciseTerms implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableDateResolution adjustableDateResolution;
	@Inject protected AdjustableDatesResolution adjustableDatesResolution;

	/**
	* @param exerciseTerms 
	* @return date 
	*/
	public List<Date> evaluate(ExerciseTerms exerciseTerms) {
		List<Date> date = doEvaluate(exerciseTerms);
		
		return date;
	}

	protected abstract List<Date> doEvaluate(ExerciseTerms exerciseTerms);

	public static class SettlementDateFromExerciseTermsDefault extends SettlementDateFromExerciseTerms {
		@Override
		protected List<Date> doEvaluate(ExerciseTerms exerciseTerms) {
			List<Date> date = new ArrayList<>();
			return assignOutput(date, exerciseTerms);
		}
		
		protected List<Date> assignOutput(List<Date> date, ExerciseTerms exerciseTerms) {
			if (areEqual(MapperS.of(exerciseTerms).<OptionExerciseStyleEnum>map("getStyle", _exerciseTerms -> _exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.EUROPEAN), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(exerciseTerms).<OptionExerciseStyleEnum>map("getStyle", _exerciseTerms -> _exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.AMERICAN), CardinalityOperator.All)).getOrDefault(false)) {
				date.addAll(MapperS.of(exerciseTerms).<AdjustableOrRelativeDate>mapC("getExpirationDate", _exerciseTerms -> _exerciseTerms.getExpirationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())
					.mapItem(item -> MapperS.of(adjustableDateResolution.evaluate(item.get()))).getMulti());
			} else {
				date.addAll(Collections.<Date>emptyList());
			}
			
			if (areEqual(MapperS.of(exerciseTerms).<OptionExerciseStyleEnum>map("getStyle", _exerciseTerms -> _exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.BERMUDA), CardinalityOperator.All).getOrDefault(false)) {
				date.addAll(MapperS.of(exerciseTerms).<AdjustableOrRelativeDates>map("getExerciseDates", _exerciseTerms -> _exerciseTerms.getExerciseDates()).<AdjustableDates>map("getAdjustableDates", adjustableOrRelativeDates -> adjustableOrRelativeDates.getAdjustableDates())
					.mapSingleToList(item -> MapperC.<Date>of(adjustableDatesResolution.evaluate(item.get()))).getMulti());
			} else {
				date.addAll(Collections.<Date>emptyList());
			}
			
			return date;
		}
	}
}
