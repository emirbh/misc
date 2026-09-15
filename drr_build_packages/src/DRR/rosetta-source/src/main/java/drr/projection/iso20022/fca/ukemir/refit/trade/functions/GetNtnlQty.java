package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.NotionalQuantity9__1;
import iso20022.auth030.fca.NotionalQuantityLegs5__1;
import iso20022.auth030.fca.QuantityOrTerm1Choice__1;
import iso20022.auth030.fca.Schedule10__1;
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
	public NotionalQuantityLegs5__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
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

	protected abstract NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetNtnlQtyDefault extends GetNtnlQty {
		@Override
		protected NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder ntnlQty = NotionalQuantityLegs5__1.builder();
			return assignOutput(ntnlQty, drrReport);
		}
		
		protected NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder assignOutput(NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder ntnlQty, FCAUKEMIRTransactionReport drrReport) {
			ntnlQty = toBuilder(NotionalQuantityLegs5__1.builder()
				.setFrstLeg(NotionalQuantity9__1.builder()
					.setTtlQty(MapperS.of(drrReport).<CommonLeg>map("getLeg1", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getLeg1()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get())
					.setDtls(QuantityOrTerm1Choice__1.builder()
						.setSchdlPrd(MapperS.of(drrReport).<CommonLeg>map("getLeg1", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", commonLeg -> commonLeg.getNotionalQuantitySchedule())
							.mapItem(item -> MapperS.of(Schedule10__1.builder()
								.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).get())
								.setUadjstdEndDt(item.<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).get())
								.setQty(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).get())
								.build())).getMulti())
						.build())
					.build())
				.setScndLeg(NotionalQuantity9__1.builder()
					.setTtlQty(MapperS.of(drrReport).<CommonLeg>map("getLeg2", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getLeg2()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get())
					.setDtls(QuantityOrTerm1Choice__1.builder()
						.setSchdlPrd(MapperS.of(drrReport).<CommonLeg>map("getLeg2", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", commonLeg -> commonLeg.getNotionalQuantitySchedule())
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
