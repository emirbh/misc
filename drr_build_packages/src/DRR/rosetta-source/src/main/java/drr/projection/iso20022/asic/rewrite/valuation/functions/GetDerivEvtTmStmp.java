package drr.projection.iso20022.asic.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.asic.rewrite.valuation.ASICValuationReport;
import iso20022.auth030.asic.DateAndDateTime2Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvtTmStmp.GetDerivEvtTmStmpDefault.class)
public abstract class GetDerivEvtTmStmp implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return tmStmp 
	*/
	public DateAndDateTime2Choice__1 evaluate(ASICValuationReport drrReport) {
		DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder tmStmpBuilder = doEvaluate(drrReport);
		
		final DateAndDateTime2Choice__1 tmStmp;
		if (tmStmpBuilder == null) {
			tmStmp = null;
		} else {
			tmStmp = tmStmpBuilder.build();
			objectValidator.validate(DateAndDateTime2Choice__1.class, tmStmp);
		}
		
		return tmStmp;
	}

	protected abstract DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder doEvaluate(ASICValuationReport drrReport);

	public static class GetDerivEvtTmStmpDefault extends GetDerivEvtTmStmp {
		@Override
		protected DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder doEvaluate(ASICValuationReport drrReport) {
			DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder tmStmp = DateAndDateTime2Choice__1.builder();
			return assignOutput(tmStmp, drrReport);
		}
		
		protected DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder assignOutput(DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder tmStmp, ASICValuationReport drrReport) {
			tmStmp = toBuilder(DateAndDateTime2Choice__1.builder()
				.setDtTm(null)
				.build());
			
			return Optional.ofNullable(tmStmp)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
