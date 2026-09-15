package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.NotionalQuantity9__1;
import iso20022.auth030.jfsa.NotionalQuantityLegs5__1;
import iso20022.auth030.jfsa.QuantityOrTerm1Choice__1;
import iso20022.auth030.jfsa.Schedule10__1;
import iso20022.auth030.jfsa.UnitOfMeasure8Choice__1;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetNtnlQty.GetNtnlQtyDefault.class)
public abstract class GetNtnlQty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return ntnlQty 
	*/
	public NotionalQuantityLegs5__1 evaluate(JFSATransactionReport drrReport) {
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

	protected abstract NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetNtnlQtyDefault extends GetNtnlQty {
		@Override
		protected NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder doEvaluate(JFSATransactionReport drrReport) {
			NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder ntnlQty = NotionalQuantityLegs5__1.builder();
			return assignOutput(ntnlQty, drrReport);
		}
		
		protected NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder assignOutput(NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder ntnlQty, JFSATransactionReport drrReport) {
			final BigInteger bigInteger0 = new BigInteger("9999999999999999999999999");
			BigDecimal ifThenElseResult0 = null;
			if (lessThan(MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()), (bigInteger0 == null ? MapperS.<BigDecimal>ofNull() : MapperS.of(new BigDecimal(bigInteger0))), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get();
			}
			final BigInteger bigInteger1 = new BigInteger("9999999999999999999999999");
			BigDecimal ifThenElseResult1 = null;
			if (notEqual(MapperS.of(drrReport).<CommonLeg>map("getLeg2", jFSATransactionReport -> jFSATransactionReport.getLeg2()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()), (bigInteger1 == null ? MapperS.<BigDecimal>ofNull() : MapperS.of(new BigDecimal(bigInteger1))), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(drrReport).<CommonLeg>map("getLeg2", jFSATransactionReport -> jFSATransactionReport.getLeg2()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get();
			}
			ntnlQty = toBuilder(NotionalQuantityLegs5__1.builder()
				.setFrstLeg(NotionalQuantity9__1.builder()
					.setTtlQty(ifThenElseResult0)
					.setUnitOfMeasr(UnitOfMeasure8Choice__1.builder()
						.setCd(MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<String>map("getQuantityUnitOfMeasure", commonLeg -> commonLeg.getQuantityUnitOfMeasure()).get())
						.build())
					.setDtls(QuantityOrTerm1Choice__1.builder()
						.setSchdlPrd(MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", commonLeg -> commonLeg.getNotionalQuantitySchedule())
							.mapItem(item -> MapperS.of(Schedule10__1.builder()
								.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).get())
								.setUadjstdEndDt(item.<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).get())
								.setQty(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).get())
								.build())).getMulti())
						.build())
					.build())
				.setScndLeg(NotionalQuantity9__1.builder()
					.setTtlQty(ifThenElseResult1)
					.setUnitOfMeasr(UnitOfMeasure8Choice__1.builder()
						.setCd(MapperS.of(drrReport).<CommonLeg>map("getLeg2", jFSATransactionReport -> jFSATransactionReport.getLeg2()).<String>map("getQuantityUnitOfMeasure", commonLeg -> commonLeg.getQuantityUnitOfMeasure()).get())
						.build())
					.setDtls(QuantityOrTerm1Choice__1.builder()
						.setSchdlPrd(MapperS.of(drrReport).<CommonLeg>map("getLeg2", jFSATransactionReport -> jFSATransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", commonLeg -> commonLeg.getNotionalQuantitySchedule())
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
