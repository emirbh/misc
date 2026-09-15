package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.BusinessDayAdjustments;
import cdm.ingest.fpml.confirmation.other.functions.MapBusinessDayConventionEnum;
import cdm.ingest.fpml.confirmation.other.functions.MapPayRelativeToEnum;
import cdm.product.common.schedule.PaymentDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.CommodityPayRelativeToEnum;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.DateOffset;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityRelativePaymentDates.MapCommodityRelativePaymentDatesDefault.class)
public abstract class MapCommodityRelativePaymentDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenters mapBusinessCenters;
	@Inject protected MapBusinessDayConventionEnum mapBusinessDayConventionEnum;
	@Inject protected MapOffset mapOffset;
	@Inject protected MapPayRelativeToEnum mapPayRelativeToEnum;

	/**
	* @param fpmlRelativePaymentDates 
	* @return paymentDates 
	*/
	public PaymentDates evaluate(CommodityRelativePaymentDates fpmlRelativePaymentDates) {
		PaymentDates.PaymentDatesBuilder paymentDatesBuilder = doEvaluate(fpmlRelativePaymentDates);
		
		final PaymentDates paymentDates;
		if (paymentDatesBuilder == null) {
			paymentDates = null;
		} else {
			paymentDates = paymentDatesBuilder.build();
			objectValidator.validate(PaymentDates.class, paymentDates);
		}
		
		return paymentDates;
	}

	protected abstract PaymentDates.PaymentDatesBuilder doEvaluate(CommodityRelativePaymentDates fpmlRelativePaymentDates);

	public static class MapCommodityRelativePaymentDatesDefault extends MapCommodityRelativePaymentDates {
		@Override
		protected PaymentDates.PaymentDatesBuilder doEvaluate(CommodityRelativePaymentDates fpmlRelativePaymentDates) {
			PaymentDates.PaymentDatesBuilder paymentDates = PaymentDates.builder();
			return assignOutput(paymentDates, fpmlRelativePaymentDates);
		}
		
		protected PaymentDates.PaymentDatesBuilder assignOutput(PaymentDates.PaymentDatesBuilder paymentDates, CommodityRelativePaymentDates fpmlRelativePaymentDates) {
			paymentDates = toBuilder(PaymentDates.builder()
				.setPayRelativeTo(mapPayRelativeToEnum.evaluate(MapperS.of(fpmlRelativePaymentDates).<CommodityPayRelativeToEnum>map("getPayRelativeTo", commodityRelativePaymentDates -> commodityRelativePaymentDates.getPayRelativeTo()).map("to-string", CommodityPayRelativeToEnum::toDisplayString).get()))
				.setPaymentDaysOffset(mapOffset.evaluate(MapperS.of(fpmlRelativePaymentDates).<DateOffset>map("getPaymentDaysOffset", commodityRelativePaymentDates -> commodityRelativePaymentDates.getPaymentDaysOffset()).get()))
				.setPaymentDatesAdjustments(BusinessDayAdjustments.builder()
					.setBusinessDayConvention(mapBusinessDayConventionEnum.evaluate(MapperS.of(fpmlRelativePaymentDates).<DateOffset>map("getPaymentDaysOffset", commodityRelativePaymentDates -> commodityRelativePaymentDates.getPaymentDaysOffset()).<BusinessDayConventionEnum>map("getBusinessDayConvention", dateOffset -> dateOffset.getBusinessDayConvention()).map("to-string", BusinessDayConventionEnum::toDisplayString).get()))
					.setBusinessCenters(mapBusinessCenters.evaluate(MapperS.of(fpmlRelativePaymentDates).<BusinessCenters>map("getBusinessCenters", commodityRelativePaymentDates -> commodityRelativePaymentDates.getBusinessCenters()).get()))
					.build())
				.build());
			
			return Optional.ofNullable(paymentDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
