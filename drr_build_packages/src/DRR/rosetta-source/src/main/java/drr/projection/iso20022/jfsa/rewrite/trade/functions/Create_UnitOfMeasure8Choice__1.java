package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import iso20022.auth030.jfsa.UnitOfMeasure8Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_UnitOfMeasure8Choice__1.Create_UnitOfMeasure8Choice__1Default.class)
public abstract class Create_UnitOfMeasure8Choice__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param unitOfMeasure 
	* @return unitOfMeasr 
	*/
	public UnitOfMeasure8Choice__1 evaluate(String unitOfMeasure) {
		UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder unitOfMeasrBuilder = doEvaluate(unitOfMeasure);
		
		final UnitOfMeasure8Choice__1 unitOfMeasr;
		if (unitOfMeasrBuilder == null) {
			unitOfMeasr = null;
		} else {
			unitOfMeasr = unitOfMeasrBuilder.build();
			objectValidator.validate(UnitOfMeasure8Choice__1.class, unitOfMeasr);
		}
		
		return unitOfMeasr;
	}

	protected abstract UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder doEvaluate(String unitOfMeasure);

	public static class Create_UnitOfMeasure8Choice__1Default extends Create_UnitOfMeasure8Choice__1 {
		@Override
		protected UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder doEvaluate(String unitOfMeasure) {
			UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder unitOfMeasr = UnitOfMeasure8Choice__1.builder();
			return assignOutput(unitOfMeasr, unitOfMeasure);
		}
		
		protected UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder assignOutput(UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder unitOfMeasr, String unitOfMeasure) {
			unitOfMeasr = toBuilder(UnitOfMeasure8Choice__1.builder()
				.setCd(unitOfMeasure)
				.build());
			
			return Optional.ofNullable(unitOfMeasr)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
