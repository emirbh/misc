package drr.regulation.common.functions;

import cdm.base.math.DatedValue;
import cdm.product.qualification.functions.Qualify_BaseProduct_CrossCurrency;
import cdm.product.qualification.functions.Qualify_BaseProduct_IRSwap;
import cdm.product.qualification.functions.Qualify_BaseProduct_Inflation;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsOption;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.quantity.reports.QuantityScheduleRule;
import drr.enrichment.upi.functions.Compute_NotionalScheduleType;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsNotionalScheduleCustom.IsNotionalScheduleCustomDefault.class)
public abstract class IsNotionalScheduleCustom implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Compute_NotionalScheduleType compute_NotionalScheduleType;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsOption isOption;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_BaseProduct_CrossCurrency qualify_BaseProduct_CrossCurrency;
	@Inject protected Qualify_BaseProduct_IRSwap qualify_BaseProduct_IRSwap;
	@Inject protected Qualify_BaseProduct_Inflation qualify_BaseProduct_Inflation;
	@Inject protected QuantityScheduleRule quantityScheduleRule;

	/**
	* @param reportableEvent 
	* @return result 
	*/
	public AnnaDsbNotionalScheduleEnum evaluate(ReportableEventBase reportableEvent) {
		AnnaDsbNotionalScheduleEnum result = doEvaluate(reportableEvent);
		
		return result;
	}

	protected abstract AnnaDsbNotionalScheduleEnum doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent);

	protected abstract MapperS<AnnaDsbNotionalScheduleEnum> leg1(ReportableEventBase reportableEvent);

	protected abstract MapperS<AnnaDsbNotionalScheduleEnum> leg2(ReportableEventBase reportableEvent);

	public static class IsNotionalScheduleCustomDefault extends IsNotionalScheduleCustom {
		@Override
		protected AnnaDsbNotionalScheduleEnum doEvaluate(ReportableEventBase reportableEvent) {
			AnnaDsbNotionalScheduleEnum result = null;
			return assignOutput(result, reportableEvent);
		}
		
		protected AnnaDsbNotionalScheduleEnum assignOutput(AnnaDsbNotionalScheduleEnum result, ReportableEventBase reportableEvent) {
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_IRSwap.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_Inflation.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_CrossCurrency.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				final Boolean _boolean = isOption.evaluate(product(reportableEvent).get());
				if ((_boolean == null ? false : _boolean)) {
					result = null;
				} else if (exists(leg1(reportableEvent)).andNullSafe(areEqual(leg1(reportableEvent), leg2(reportableEvent), CardinalityOperator.All)).getOrDefault(false)) {
					result = leg1(reportableEvent).get();
				} else {
					result = AnnaDsbNotionalScheduleEnum.CUSTOM;
				}
			} else {
				result = null;
			}
			
			return result;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			return MapperS.of(productForEvent.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent) {
			return MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get()));
		}
		
		@Override
		protected MapperS<AnnaDsbNotionalScheduleEnum> leg1(ReportableEventBase reportableEvent) {
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_IRSwap.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_Inflation.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_CrossCurrency.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				return MapperS.of(compute_NotionalScheduleType.evaluate(MapperS.of(quantityScheduleRule.evaluate(payoutLeg1Rule.evaluate(reportableEvent))).<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue()).<BigDecimal>map("getValue", datedValue -> datedValue.getValue()).getMulti()));
			}
			return MapperS.<AnnaDsbNotionalScheduleEnum>ofNull();
		}
		
		@Override
		protected MapperS<AnnaDsbNotionalScheduleEnum> leg2(ReportableEventBase reportableEvent) {
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_IRSwap.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_Inflation.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_CrossCurrency.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				return MapperS.of(compute_NotionalScheduleType.evaluate(MapperS.of(quantityScheduleRule.evaluate(payoutLeg2Rule.evaluate(reportableEvent))).<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue()).<BigDecimal>map("getValue", datedValue -> datedValue.getValue()).getMulti()));
			}
			return MapperS.<AnnaDsbNotionalScheduleEnum>ofNull();
		}
	}
}
