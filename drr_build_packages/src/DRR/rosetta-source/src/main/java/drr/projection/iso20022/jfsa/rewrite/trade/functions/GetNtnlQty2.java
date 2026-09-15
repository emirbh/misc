package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.NotionalQuantity9__2;
import iso20022.auth030.jfsa.NotionalQuantityLegs5__2;
import iso20022.auth030.jfsa.UnitOfMeasure8Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetNtnlQty2.GetNtnlQty2Default.class)
public abstract class GetNtnlQty2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return ntnlQty 
	*/
	public NotionalQuantityLegs5__2 evaluate(JFSATransactionReport drrReport) {
		NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder ntnlQtyBuilder = doEvaluate(drrReport);
		
		final NotionalQuantityLegs5__2 ntnlQty;
		if (ntnlQtyBuilder == null) {
			ntnlQty = null;
		} else {
			ntnlQty = ntnlQtyBuilder.build();
			objectValidator.validate(NotionalQuantityLegs5__2.class, ntnlQty);
		}
		
		return ntnlQty;
	}

	protected abstract NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetNtnlQty2Default extends GetNtnlQty2 {
		@Override
		protected NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder doEvaluate(JFSATransactionReport drrReport) {
			NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder ntnlQty = NotionalQuantityLegs5__2.builder();
			return assignOutput(ntnlQty, drrReport);
		}
		
		protected NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder assignOutput(NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder ntnlQty, JFSATransactionReport drrReport) {
			ntnlQty = toBuilder(NotionalQuantityLegs5__2.builder()
				.setFrstLeg(NotionalQuantity9__2.builder()
					.setTtlQty(MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get())
					.setUnitOfMeasr(UnitOfMeasure8Choice__1.builder()
						.setCd(MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<String>map("getQuantityUnitOfMeasure", commonLeg -> commonLeg.getQuantityUnitOfMeasure()).get())
						.build())
					.build())
				.setScndLeg(NotionalQuantity9__2.builder()
					.setTtlQty(MapperS.of(drrReport).<CommonLeg>map("getLeg2", jFSATransactionReport -> jFSATransactionReport.getLeg2()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get())
					.setUnitOfMeasr(UnitOfMeasure8Choice__1.builder()
						.setCd(MapperS.of(drrReport).<CommonLeg>map("getLeg2", jFSATransactionReport -> jFSATransactionReport.getLeg2()).<String>map("getQuantityUnitOfMeasure", commonLeg -> commonLeg.getQuantityUnitOfMeasure()).get())
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(ntnlQty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
