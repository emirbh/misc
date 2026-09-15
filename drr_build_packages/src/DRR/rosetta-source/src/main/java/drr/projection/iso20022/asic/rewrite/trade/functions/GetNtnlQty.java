package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.trade.CommonLeg;
import iso20022.auth030.asic.NotionalQuantity9__1;
import iso20022.auth030.asic.NotionalQuantityLegs5__1;
import iso20022.auth030.asic.QuantityOrTerm1Choice__1;
import iso20022.auth030.asic.QuantityTerm1__1;
import iso20022.auth030.asic.UnitOfMeasure8Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetNtnlQty.GetNtnlQtyDefault.class)
public abstract class GetNtnlQty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return ntnlQty 
	*/
	public NotionalQuantityLegs5__1 evaluate(ASICTransactionReport drrReport) {
		NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder ntnlQtyBuilder = doEvaluate(drrReport);
		
		final NotionalQuantityLegs5__1 ntnlQty;
		if (ntnlQtyBuilder == null) {
			ntnlQty = null;
		} else {
			ntnlQty = ntnlQtyBuilder.build();
			objectValidator.validate(NotionalQuantityLegs5__1.class, ntnlQty);
		}
		
		return ntnlQty;
	}

	protected abstract NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder doEvaluate(ASICTransactionReport drrReport);

	public static class GetNtnlQtyDefault extends GetNtnlQty {
		@Override
		protected NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder doEvaluate(ASICTransactionReport drrReport) {
			NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder ntnlQty = NotionalQuantityLegs5__1.builder();
			return assignOutput(ntnlQty, drrReport);
		}
		
		protected NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder assignOutput(NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder ntnlQty, ASICTransactionReport drrReport) {
			ntnlQty = toBuilder(NotionalQuantityLegs5__1.builder()
				.setFrstLeg(NotionalQuantity9__1.builder()
					.setTtlQty(MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get())
					.setUnitOfMeasr(UnitOfMeasure8Choice__1.builder()
						.setCd(MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<String>map("getQuantityUnitOfMeasure", commonLeg -> commonLeg.getQuantityUnitOfMeasure()).get())
						.build())
					.setDtls(QuantityOrTerm1Choice__1.builder()
						.setTerm(QuantityTerm1__1.builder()
							.setQty(MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<BigDecimal>map("getNotionalQuantity", commonLeg -> commonLeg.getNotionalQuantity()).get())
							.build())
						.build())
					.build())
				.setScndLeg(NotionalQuantity9__1.builder()
					.setTtlQty(MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get())
					.setUnitOfMeasr(UnitOfMeasure8Choice__1.builder()
						.setCd(MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<String>map("getQuantityUnitOfMeasure", commonLeg -> commonLeg.getQuantityUnitOfMeasure()).get())
						.build())
					.setDtls(QuantityOrTerm1Choice__1.builder()
						.setTerm(QuantityTerm1__1.builder()
							.setQty(MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<BigDecimal>map("getNotionalQuantity", commonLeg -> commonLeg.getNotionalQuantity()).get())
							.build())
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(ntnlQty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
