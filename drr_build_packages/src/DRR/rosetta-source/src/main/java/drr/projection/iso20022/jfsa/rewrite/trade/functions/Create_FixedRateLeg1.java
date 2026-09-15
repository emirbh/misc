package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.InterestComputationMethod4Code;
import iso20022.auth030.jfsa.FixedRate10__1;
import iso20022.auth030.jfsa.Frequency13Code__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_FixedRateLeg1.Create_FixedRateLeg1Default.class)
public abstract class Create_FixedRateLeg1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_FixedRate10__1 create_FixedRate10__1;

	/**
	* @param drrReport 
	* @return fxd 
	*/
	public FixedRate10__1 evaluate(JFSATransactionReport drrReport) {
		FixedRate10__1.FixedRate10__1Builder fxdBuilder = doEvaluate(drrReport);
		
		final FixedRate10__1 fxd;
		if (fxdBuilder == null) {
			fxd = null;
		} else {
			fxd = fxdBuilder.build();
			objectValidator.validate(FixedRate10__1.class, fxd);
		}
		
		return fxd;
	}

	protected abstract FixedRate10__1.FixedRate10__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_FixedRateLeg1Default extends Create_FixedRateLeg1 {
		@Override
		protected FixedRate10__1.FixedRate10__1Builder doEvaluate(JFSATransactionReport drrReport) {
			FixedRate10__1.FixedRate10__1Builder fxd = FixedRate10__1.builder();
			return assignOutput(fxd, drrReport);
		}
		
		protected FixedRate10__1.FixedRate10__1Builder assignOutput(FixedRate10__1.FixedRate10__1Builder fxd, JFSATransactionReport drrReport) {
			fxd = toBuilder(create_FixedRate10__1.evaluate(MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFixedRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFixedRateDayCountConvention()).map("to-string", InterestComputationMethod4Code::toDisplayString).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()).checkedMap("to-enum", e -> Frequency13Code__1.valueOf(e.name()), IllegalArgumentException.class).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()).get()));
			
			return Optional.ofNullable(fxd)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
