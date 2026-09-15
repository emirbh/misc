package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.product.common.schedule.PaymentCalculationPeriod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.ird.CalculationPeriod;
import fpml.consolidated.ird.Cashflows;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapPaymentCalculationPeriodList.MapPaymentCalculationPeriodListDefault.class)
public abstract class MapPaymentCalculationPeriodList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationPeriodList mapCalculationPeriodList;

	/**
	* @param fpmlCashflows 
	* @return paymentCalculationPeriodList 
	*/
	public List<? extends PaymentCalculationPeriod> evaluate(Cashflows fpmlCashflows) {
		List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> paymentCalculationPeriodListBuilder = doEvaluate(fpmlCashflows);
		
		final List<? extends PaymentCalculationPeriod> paymentCalculationPeriodList;
		if (paymentCalculationPeriodListBuilder == null) {
			paymentCalculationPeriodList = null;
		} else {
			paymentCalculationPeriodList = paymentCalculationPeriodListBuilder.stream().map(PaymentCalculationPeriod::build).collect(Collectors.toList());
			objectValidator.validate(PaymentCalculationPeriod.class, paymentCalculationPeriodList);
		}
		
		return paymentCalculationPeriodList;
	}

	protected abstract List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> doEvaluate(Cashflows fpmlCashflows);

	public static class MapPaymentCalculationPeriodListDefault extends MapPaymentCalculationPeriodList {
		@Override
		protected List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> doEvaluate(Cashflows fpmlCashflows) {
			List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> paymentCalculationPeriodList = new ArrayList<>();
			return assignOutput(paymentCalculationPeriodList, fpmlCashflows);
		}
		
		protected List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> assignOutput(List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> paymentCalculationPeriodList, Cashflows fpmlCashflows) {
			paymentCalculationPeriodList.addAll(toBuilder(MapperS.of(fpmlCashflows).<fpml.consolidated.ird.PaymentCalculationPeriod>mapC("getPaymentCalculationPeriod", cashflows -> cashflows.getPaymentCalculationPeriod())
				.mapItem(item -> MapperS.of(PaymentCalculationPeriod.builder()
					.setAdjustedPaymentDate(item.<ZonedDateTime>map("getAdjustedPaymentDate", paymentCalculationPeriod -> paymentCalculationPeriod.getAdjustedPaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
					.setCalculationPeriod(new ArrayList(mapCalculationPeriodList.evaluate(item.<CalculationPeriod>mapC("getCalculationPeriod", paymentCalculationPeriod -> paymentCalculationPeriod.getCalculationPeriod()).getMulti())))
					.build())).getMulti()));
			
			return Optional.ofNullable(paymentCalculationPeriodList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
