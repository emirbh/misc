package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.ExerciseDate1Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetExrcDt.GetExrcDtDefault.class)
public abstract class GetExrcDt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return exrcDt 
	*/
	public ExerciseDate1Choice__1 evaluate(JFSATransactionReport drrReport) {
		ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder exrcDtBuilder = doEvaluate(drrReport);
		
		final ExerciseDate1Choice__1 exrcDt;
		if (exrcDtBuilder == null) {
			exrcDt = null;
		} else {
			exrcDt = exrcDtBuilder.build();
			objectValidator.validate(ExerciseDate1Choice__1.class, exrcDt);
		}
		
		return exrcDt;
	}

	protected abstract ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetExrcDtDefault extends GetExrcDt {
		@Override
		protected ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder doEvaluate(JFSATransactionReport drrReport) {
			ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder exrcDt = ExerciseDate1Choice__1.builder();
			return assignOutput(exrcDt, drrReport);
		}
		
		protected ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder assignOutput(ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder exrcDt, JFSATransactionReport drrReport) {
			exrcDt = toBuilder(ExerciseDate1Choice__1.builder()
				.setFrstExrcDt(MapperS.of(drrReport).<Date>map("getFirstExerciseDate", jFSATransactionReport -> jFSATransactionReport.getFirstExerciseDate()).get())
				.build());
			
			return Optional.ofNullable(exrcDt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
