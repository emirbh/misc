package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.FrequencyPeriodEnum;
import iso20022.auth030.mas.Frequency19Code;
import iso20022.auth030.mas.NotionalQuantity9__1;
import iso20022.auth030.mas.NotionalQuantityLegs5__1;
import iso20022.auth030.mas.QuantityOrTerm1Choice__1;
import iso20022.auth030.mas.QuantityTerm1__1;
import iso20022.auth030.mas.UnitOfMeasure8Choice__1;
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
	public NotionalQuantityLegs5__1 evaluate(MASTransactionReport drrReport) {
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

	protected abstract NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder doEvaluate(MASTransactionReport drrReport);

	public static class GetNtnlQtyDefault extends GetNtnlQty {
		@Override
		protected NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder doEvaluate(MASTransactionReport drrReport) {
			NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder ntnlQty = NotionalQuantityLegs5__1.builder();
			return assignOutput(ntnlQty, drrReport);
		}
		
		protected NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder assignOutput(NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder ntnlQty, MASTransactionReport drrReport) {
			ntnlQty = toBuilder(NotionalQuantityLegs5__1.builder()
				.setFrstLeg(NotionalQuantity9__1.builder()
					.setTtlQty(MapperS.of(drrReport).<CommonLeg>map("getLeg1", mASTransactionReport -> mASTransactionReport.getLeg1()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get())
					.setUnitOfMeasr(UnitOfMeasure8Choice__1.builder()
						.setCd(MapperS.of(drrReport).<CommonLeg>map("getLeg1", mASTransactionReport -> mASTransactionReport.getLeg1()).<String>map("getQuantityUnitOfMeasure", commonLeg -> commonLeg.getQuantityUnitOfMeasure()).get())
						.build())
					.setDtls(QuantityOrTerm1Choice__1.builder()
						.setTerm(QuantityTerm1__1.builder()
							.setQty(MapperS.of(drrReport).<CommonLeg>map("getLeg1", mASTransactionReport -> mASTransactionReport.getLeg1()).<BigDecimal>map("getNotionalQuantity", commonLeg -> commonLeg.getNotionalQuantity()).get())
							.setVal(MapperS.of(drrReport).<CommonLeg>map("getLeg1", mASTransactionReport -> mASTransactionReport.getLeg1()).<Integer>map("getQuantityFrequencyMultiplier", commonLeg -> commonLeg.getQuantityFrequencyMultiplier()).get())
							.setTmUnit(MapperS.of(drrReport).<CommonLeg>map("getLeg1", mASTransactionReport -> mASTransactionReport.getLeg1()).<FrequencyPeriodEnum>map("getQuantityFrequency", commonLeg -> commonLeg.getQuantityFrequency()).checkedMap("to-enum", e -> Frequency19Code.valueOf(e.name()), IllegalArgumentException.class).get())
							.build())
						.build())
					.build())
				.setScndLeg(NotionalQuantity9__1.builder()
					.setTtlQty(MapperS.of(drrReport).<CommonLeg>map("getLeg2", mASTransactionReport -> mASTransactionReport.getLeg2()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get())
					.setUnitOfMeasr(UnitOfMeasure8Choice__1.builder()
						.setCd(MapperS.of(drrReport).<CommonLeg>map("getLeg2", mASTransactionReport -> mASTransactionReport.getLeg2()).<String>map("getQuantityUnitOfMeasure", commonLeg -> commonLeg.getQuantityUnitOfMeasure()).get())
						.build())
					.setDtls(QuantityOrTerm1Choice__1.builder()
						.setTerm(QuantityTerm1__1.builder()
							.setQty(MapperS.of(drrReport).<CommonLeg>map("getLeg2", mASTransactionReport -> mASTransactionReport.getLeg2()).<BigDecimal>map("getNotionalQuantity", commonLeg -> commonLeg.getNotionalQuantity()).get())
							.setVal(MapperS.of(drrReport).<CommonLeg>map("getLeg2", mASTransactionReport -> mASTransactionReport.getLeg2()).<Integer>map("getQuantityFrequencyMultiplier", commonLeg -> commonLeg.getQuantityFrequencyMultiplier()).get())
							.setTmUnit(MapperS.of(drrReport).<CommonLeg>map("getLeg2", mASTransactionReport -> mASTransactionReport.getLeg2()).<FrequencyPeriodEnum>map("getQuantityFrequency", commonLeg -> commonLeg.getQuantityFrequency()).checkedMap("to-enum", e -> Frequency19Code.valueOf(e.name()), IllegalArgumentException.class).get())
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
