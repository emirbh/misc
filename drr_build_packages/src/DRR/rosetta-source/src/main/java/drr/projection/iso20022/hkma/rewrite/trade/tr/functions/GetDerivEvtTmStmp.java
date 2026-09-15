package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.tr.DateAndDateTime2Choice__1;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvtTmStmp.GetDerivEvtTmStmpDefault.class)
public abstract class GetDerivEvtTmStmp implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return tmStmp 
	*/
	public DateAndDateTime2Choice__1 evaluate(HKMATransactionReport drrReport) {
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

	protected abstract DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class GetDerivEvtTmStmpDefault extends GetDerivEvtTmStmp {
		@Override
		protected DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder doEvaluate(HKMATransactionReport drrReport) {
			DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder tmStmp = DateAndDateTime2Choice__1.builder();
			return assignOutput(tmStmp, drrReport);
		}
		
		protected DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder assignOutput(DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder tmStmp, HKMATransactionReport drrReport) {
			tmStmp = toBuilder(DateAndDateTime2Choice__1.builder()
				.setDtTm(MapperS.of(drrReport).<ZonedDateTime>map("getEventTimestamp", hKMATransactionReport -> hKMATransactionReport.getEventTimestamp()).get())
				.build());
			
			return Optional.ofNullable(tmStmp)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
