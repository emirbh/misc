package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.trade.CommonLeg;
import iso20022.auth030.asic.InterestRate33Choice__3;
import iso20022.auth030.asic.InterestRateLegs14__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetIntrstRate_2.GetIntrstRate_2Default.class)
public abstract class GetIntrstRate_2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_FloatingRate3 create_FloatingRate3;

	/**
	* @param drrReport 
	* @return intrstRate 
	*/
	public InterestRateLegs14__2 evaluate(ASICTransactionReport drrReport) {
		InterestRateLegs14__2.InterestRateLegs14__2Builder intrstRateBuilder = doEvaluate(drrReport);
		
		final InterestRateLegs14__2 intrstRate;
		if (intrstRateBuilder == null) {
			intrstRate = null;
		} else {
			intrstRate = intrstRateBuilder.build();
			objectValidator.validate(InterestRateLegs14__2.class, intrstRate);
		}
		
		return intrstRate;
	}

	protected abstract InterestRateLegs14__2.InterestRateLegs14__2Builder doEvaluate(ASICTransactionReport drrReport);

	public static class GetIntrstRate_2Default extends GetIntrstRate_2 {
		@Override
		protected InterestRateLegs14__2.InterestRateLegs14__2Builder doEvaluate(ASICTransactionReport drrReport) {
			InterestRateLegs14__2.InterestRateLegs14__2Builder intrstRate = InterestRateLegs14__2.builder();
			return assignOutput(intrstRate, drrReport);
		}
		
		protected InterestRateLegs14__2.InterestRateLegs14__2Builder assignOutput(InterestRateLegs14__2.InterestRateLegs14__2Builder intrstRate, ASICTransactionReport drrReport) {
			intrstRate = toBuilder(InterestRateLegs14__2.builder()
				.setFrstLeg(InterestRate33Choice__3.builder()
					.setFltg(create_FloatingRate3.evaluate(MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<Date>map("getNextFloatingReferenceResetDate", commonLeg -> commonLeg.getNextFloatingReferenceResetDate()).get()))
					.build())
				.setScndLeg(InterestRate33Choice__3.builder()
					.setFltg(create_FloatingRate3.evaluate(MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<Date>map("getNextFloatingReferenceResetDate", commonLeg -> commonLeg.getNextFloatingReferenceResetDate()).get()))
					.build())
				.build());
			
			return Optional.ofNullable(intrstRate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
