package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import iso20022.auth030.esma.NotionalQuantity9__2;
import iso20022.auth030.esma.NotionalQuantityLegs5__2;
import iso20022.auth030.esma.QuantityOrTerm1Choice__1;
import iso20022.auth030.esma.Schedule10__1;
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
	public NotionalQuantityLegs5__2 evaluate(ESMAEMIRTransactionReport drrReport) {
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

	protected abstract NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetNtnlQty2Default extends GetNtnlQty2 {
		@Override
		protected NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder ntnlQty = NotionalQuantityLegs5__2.builder();
			return assignOutput(ntnlQty, drrReport);
		}
		
		protected NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder assignOutput(NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder ntnlQty, ESMAEMIRTransactionReport drrReport) {
			ntnlQty = toBuilder(NotionalQuantityLegs5__2.builder()
				.setFrstLeg(NotionalQuantity9__2.builder()
					.setTtlQty(MapperS.of(drrReport).<CommonLeg>map("getLeg1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg1()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get())
					.setDtls(QuantityOrTerm1Choice__1.builder()
						.setSchdlPrd(MapperS.of(drrReport).<CommonLeg>map("getLeg1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", commonLeg -> commonLeg.getNotionalQuantitySchedule())
							.mapItem(item -> MapperS.of(Schedule10__1.builder()
								.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).get())
								.setUadjstdEndDt(item.<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).get())
								.setQty(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).get())
								.build())).getMulti())
						.build())
					.build())
				.setScndLeg(NotionalQuantity9__2.builder()
					.setTtlQty(MapperS.of(drrReport).<CommonLeg>map("getLeg2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg2()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get())
					.setDtls(QuantityOrTerm1Choice__1.builder()
						.setSchdlPrd(MapperS.of(drrReport).<CommonLeg>map("getLeg2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", commonLeg -> commonLeg.getNotionalQuantitySchedule())
							.mapItem(item -> MapperS.of(Schedule10__1.builder()
								.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).get())
								.setUadjstdEndDt(item.<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).get())
								.setQty(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).get())
								.build())).getMulti())
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(ntnlQty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
