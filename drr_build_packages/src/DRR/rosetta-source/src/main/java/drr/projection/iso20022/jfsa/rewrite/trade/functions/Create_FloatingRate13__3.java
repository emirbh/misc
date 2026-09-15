package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.jfsa.FloatingRate13__1;
import iso20022.auth030.jfsa.FloatingRate13__3;
import iso20022.auth030.jfsa.FloatingRateIdentification8Choice__1;
import iso20022.auth030.jfsa.Frequency13Code;
import iso20022.auth030.jfsa.Frequency13Code__1;
import iso20022.auth030.jfsa.InterestComputationMethodFormat7__1;
import iso20022.auth030.jfsa.InterestRateContractTerm4;
import iso20022.auth030.jfsa.InterestRateContractTerm4__1;
import iso20022.auth030.jfsa.InterestRateFrequency3Choice__1;
import iso20022.auth030.jfsa.InterestRateFrequency3Choice__2;
import iso20022.auth030.jfsa.SecuritiesTransactionPrice20Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_FloatingRate13__3.Create_FloatingRate13__3Default.class)
public abstract class Create_FloatingRate13__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fltg1 
	* @return fltg3 
	*/
	public FloatingRate13__3 evaluate(FloatingRate13__1 fltg1) {
		FloatingRate13__3.FloatingRate13__3Builder fltg3Builder = doEvaluate(fltg1);
		
		final FloatingRate13__3 fltg3;
		if (fltg3Builder == null) {
			fltg3 = null;
		} else {
			fltg3 = fltg3Builder.build();
			objectValidator.validate(FloatingRate13__3.class, fltg3);
		}
		
		return fltg3;
	}

	protected abstract FloatingRate13__3.FloatingRate13__3Builder doEvaluate(FloatingRate13__1 fltg1);

	public static class Create_FloatingRate13__3Default extends Create_FloatingRate13__3 {
		@Override
		protected FloatingRate13__3.FloatingRate13__3Builder doEvaluate(FloatingRate13__1 fltg1) {
			FloatingRate13__3.FloatingRate13__3Builder fltg3 = FloatingRate13__3.builder();
			return assignOutput(fltg3, fltg1);
		}
		
		protected FloatingRate13__3.FloatingRate13__3Builder assignOutput(FloatingRate13__3.FloatingRate13__3Builder fltg3, FloatingRate13__1 fltg1) {
			fltg3 = toBuilder(FloatingRate13__3.builder()
				.setNm(MapperS.of(fltg1).<String>map("getNm", floatingRate13__1 -> floatingRate13__1.getNm()).get())
				.setRate(MapperS.of(fltg1).<FloatingRateIdentification8Choice__1>map("getRate", floatingRate13__1 -> floatingRate13__1.getRate()).get())
				.setRefPrd(InterestRateContractTerm4__1.builder()
					.setUnit(MapperS.of(fltg1).<InterestRateContractTerm4__1>map("getRefPrd", floatingRate13__1 -> floatingRate13__1.getRefPrd()).<Frequency13Code__1>map("getUnit", interestRateContractTerm4__1 -> interestRateContractTerm4__1.getUnit()).get())
					.setVal(MapperS.of(fltg1).<InterestRateContractTerm4__1>map("getRefPrd", floatingRate13__1 -> floatingRate13__1.getRefPrd()).<Integer>map("getVal", interestRateContractTerm4__1 -> interestRateContractTerm4__1.getVal()).get())
					.build())
				.setSprd(MapperS.of(fltg1).<SecuritiesTransactionPrice20Choice__1>map("getSprd", floatingRate13__1 -> floatingRate13__1.getSprd()).get())
				.setDayCnt(MapperS.of(fltg1).<InterestComputationMethodFormat7__1>map("getDayCnt", floatingRate13__1 -> floatingRate13__1.getDayCnt()).get())
				.setPmtFrqcy(InterestRateFrequency3Choice__2.builder()
					.setTerm(InterestRateContractTerm4.builder()
						.setUnit(MapperS.of(fltg1).<InterestRateFrequency3Choice__1>map("getPmtFrqcy", floatingRate13__1 -> floatingRate13__1.getPmtFrqcy()).<InterestRateContractTerm4__1>map("getTerm", interestRateFrequency3Choice__1 -> interestRateFrequency3Choice__1.getTerm()).<Frequency13Code__1>map("getUnit", interestRateContractTerm4__1 -> interestRateContractTerm4__1.getUnit()).checkedMap("to-enum", e -> Frequency13Code.valueOf(e.name()), IllegalArgumentException.class).get())
						.setVal(MapperS.of(fltg1).<InterestRateFrequency3Choice__1>map("getPmtFrqcy", floatingRate13__1 -> floatingRate13__1.getPmtFrqcy()).<InterestRateContractTerm4__1>map("getTerm", interestRateFrequency3Choice__1 -> interestRateFrequency3Choice__1.getTerm()).<Integer>map("getVal", interestRateContractTerm4__1 -> interestRateContractTerm4__1.getVal()).get())
						.build())
					.build())
				.setRstFrqcy(InterestRateFrequency3Choice__2.builder()
					.setTerm(InterestRateContractTerm4.builder()
						.setUnit(MapperS.of(fltg1).<InterestRateFrequency3Choice__1>map("getRstFrqcy", floatingRate13__1 -> floatingRate13__1.getRstFrqcy()).<InterestRateContractTerm4__1>map("getTerm", interestRateFrequency3Choice__1 -> interestRateFrequency3Choice__1.getTerm()).<Frequency13Code__1>map("getUnit", interestRateContractTerm4__1 -> interestRateContractTerm4__1.getUnit()).checkedMap("to-enum", e -> Frequency13Code.valueOf(e.name()), IllegalArgumentException.class).get())
						.setVal(MapperS.of(fltg1).<InterestRateFrequency3Choice__1>map("getRstFrqcy", floatingRate13__1 -> floatingRate13__1.getRstFrqcy()).<InterestRateContractTerm4__1>map("getTerm", interestRateFrequency3Choice__1 -> interestRateFrequency3Choice__1.getTerm()).<Integer>map("getVal", interestRateContractTerm4__1 -> interestRateContractTerm4__1.getVal()).get())
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(fltg3)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
