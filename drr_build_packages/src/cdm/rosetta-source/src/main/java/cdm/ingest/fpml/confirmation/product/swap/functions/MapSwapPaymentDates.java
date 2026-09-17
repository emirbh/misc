package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.datetime.Offset;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessDayAdjustments;
import cdm.ingest.fpml.confirmation.other.functions.MapPayRelativeToEnum;
import cdm.product.common.schedule.PaymentDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fpmlenum.PayRelativeToEnum;
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.Frequency;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSwapPaymentDates.MapSwapPaymentDatesDefault.class)
public abstract class MapSwapPaymentDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapFrequency mapFrequency;
	@Inject protected MapPayRelativeToEnum mapPayRelativeToEnum;

	/**
	* @param fpmlPaymentDates 
	* @return paymentDates 
	*/
	public PaymentDates evaluate(fpml.consolidated.ird.PaymentDates fpmlPaymentDates) {
		PaymentDates.PaymentDatesBuilder paymentDatesBuilder = doEvaluate(fpmlPaymentDates);
		
		final PaymentDates paymentDates;
		if (paymentDatesBuilder == null) {
			paymentDates = null;
		} else {
			paymentDates = paymentDatesBuilder.build();
			objectValidator.validate(PaymentDates.class, paymentDates);
		}
		
		return paymentDates;
	}

	protected abstract PaymentDates.PaymentDatesBuilder doEvaluate(fpml.consolidated.ird.PaymentDates fpmlPaymentDates);

	public static class MapSwapPaymentDatesDefault extends MapSwapPaymentDates {
		@Override
		protected PaymentDates.PaymentDatesBuilder doEvaluate(fpml.consolidated.ird.PaymentDates fpmlPaymentDates) {
			PaymentDates.PaymentDatesBuilder paymentDates = PaymentDates.builder();
			return assignOutput(paymentDates, fpmlPaymentDates);
		}
		
		protected PaymentDates.PaymentDatesBuilder assignOutput(PaymentDates.PaymentDatesBuilder paymentDates, fpml.consolidated.ird.PaymentDates fpmlPaymentDates) {
			final PaymentDates.PaymentDatesBuilder withMetaArgument = PaymentDates.builder()
				.setPaymentFrequency(mapFrequency.evaluate(MapperS.of(fpmlPaymentDates).<Frequency>map("getPaymentFrequency", _paymentDates -> _paymentDates.getPaymentFrequency()).get()))
				.setFirstPaymentDate(MapperS.of(fpmlPaymentDates).<ZonedDateTime>map("getFirstPaymentDate", _paymentDates -> _paymentDates.getFirstPaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setLastRegularPaymentDate(MapperS.of(fpmlPaymentDates).<ZonedDateTime>map("getLastRegularPaymentDate", _paymentDates -> _paymentDates.getLastRegularPaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setPayRelativeTo(mapPayRelativeToEnum.evaluate(MapperS.of(fpmlPaymentDates).<PayRelativeToEnum>map("getPayRelativeTo", _paymentDates -> _paymentDates.getPayRelativeTo()).map("to-string", PayRelativeToEnum::toDisplayString).get()))
				.setPaymentDatesAdjustments(mapBusinessDayAdjustments.evaluate(MapperS.of(fpmlPaymentDates).<BusinessDayAdjustments>map("getPaymentDatesAdjustments", _paymentDates -> _paymentDates.getPaymentDatesAdjustments()).get()))
				.setPaymentDaysOffset(Offset.builder()
					.setPeriodMultiplier(MapperS.of(fpmlPaymentDates).<fpml.consolidated.shared.Offset>map("getPaymentDaysOffset", _paymentDates -> _paymentDates.getPaymentDaysOffset()).<Integer>map("getPeriodMultiplier", offset -> offset.getPeriodMultiplier()).get())
					.setPeriod(MapperS.of(fpmlPaymentDates).<fpml.consolidated.shared.Offset>map("getPaymentDaysOffset", _paymentDates -> _paymentDates.getPaymentDaysOffset()).<PeriodEnum>map("getPeriod", offset -> offset.getPeriod()).checkedMap("to-enum", e -> cdm.base.datetime.PeriodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setDayType(MapperS.of(fpmlPaymentDates).<fpml.consolidated.shared.Offset>map("getPaymentDaysOffset", _paymentDates -> _paymentDates.getPaymentDaysOffset()).<DayTypeEnum>map("getDayType", offset -> offset.getDayType()).checkedMap("to-enum", e -> cdm.base.datetime.DayTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.build())
				.build() == null ? null : PaymentDates.builder()
				.setPaymentFrequency(mapFrequency.evaluate(MapperS.of(fpmlPaymentDates).<Frequency>map("getPaymentFrequency", _paymentDates -> _paymentDates.getPaymentFrequency()).get()))
				.setFirstPaymentDate(MapperS.of(fpmlPaymentDates).<ZonedDateTime>map("getFirstPaymentDate", _paymentDates -> _paymentDates.getFirstPaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setLastRegularPaymentDate(MapperS.of(fpmlPaymentDates).<ZonedDateTime>map("getLastRegularPaymentDate", _paymentDates -> _paymentDates.getLastRegularPaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setPayRelativeTo(mapPayRelativeToEnum.evaluate(MapperS.of(fpmlPaymentDates).<PayRelativeToEnum>map("getPayRelativeTo", _paymentDates -> _paymentDates.getPayRelativeTo()).map("to-string", PayRelativeToEnum::toDisplayString).get()))
				.setPaymentDatesAdjustments(mapBusinessDayAdjustments.evaluate(MapperS.of(fpmlPaymentDates).<BusinessDayAdjustments>map("getPaymentDatesAdjustments", _paymentDates -> _paymentDates.getPaymentDatesAdjustments()).get()))
				.setPaymentDaysOffset(Offset.builder()
					.setPeriodMultiplier(MapperS.of(fpmlPaymentDates).<fpml.consolidated.shared.Offset>map("getPaymentDaysOffset", _paymentDates -> _paymentDates.getPaymentDaysOffset()).<Integer>map("getPeriodMultiplier", offset -> offset.getPeriodMultiplier()).get())
					.setPeriod(MapperS.of(fpmlPaymentDates).<fpml.consolidated.shared.Offset>map("getPaymentDaysOffset", _paymentDates -> _paymentDates.getPaymentDaysOffset()).<PeriodEnum>map("getPeriod", offset -> offset.getPeriod()).checkedMap("to-enum", e -> cdm.base.datetime.PeriodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setDayType(MapperS.of(fpmlPaymentDates).<fpml.consolidated.shared.Offset>map("getPaymentDaysOffset", _paymentDates -> _paymentDates.getPaymentDaysOffset()).<DayTypeEnum>map("getDayType", offset -> offset.getDayType()).checkedMap("to-enum", e -> cdm.base.datetime.DayTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.build())
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlPaymentDates).<String>map("getId", _paymentDates -> _paymentDates.getId()).get());
			paymentDates = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(paymentDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
