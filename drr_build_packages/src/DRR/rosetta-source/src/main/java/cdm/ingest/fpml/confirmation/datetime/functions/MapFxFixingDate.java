package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.product.common.schedule.DateRelativeToPaymentDates;
import cdm.product.common.schedule.metafields.ReferenceWithMetaPaymentDates;
import cdm.product.common.settlement.FxFixingDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.ird.PaymentDates;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxFixingDate.MapFxFixingDateDefault.class)
public abstract class MapFxFixingDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterReference mapBusinessCenterReference;
	@Inject protected MapBusinessCenters mapBusinessCenters;
	@Inject protected MapPaymentDatesReference mapPaymentDatesReference;

	/**
	* @param fpmlFxFixingDate 
	* @param fpmlPaymentDates 
	* @return fxFixingDate 
	*/
	public FxFixingDate evaluate(fpml.consolidated.ird.FxFixingDate fpmlFxFixingDate, PaymentDates fpmlPaymentDates) {
		FxFixingDate.FxFixingDateBuilder fxFixingDateBuilder = doEvaluate(fpmlFxFixingDate, fpmlPaymentDates);
		
		final FxFixingDate fxFixingDate;
		if (fxFixingDateBuilder == null) {
			fxFixingDate = null;
		} else {
			fxFixingDate = fxFixingDateBuilder.build();
			objectValidator.validate(FxFixingDate.class, fxFixingDate);
		}
		
		return fxFixingDate;
	}

	protected abstract FxFixingDate.FxFixingDateBuilder doEvaluate(fpml.consolidated.ird.FxFixingDate fpmlFxFixingDate, PaymentDates fpmlPaymentDates);

	public static class MapFxFixingDateDefault extends MapFxFixingDate {
		@Override
		protected FxFixingDate.FxFixingDateBuilder doEvaluate(fpml.consolidated.ird.FxFixingDate fpmlFxFixingDate, PaymentDates fpmlPaymentDates) {
			FxFixingDate.FxFixingDateBuilder fxFixingDate = FxFixingDate.builder();
			return assignOutput(fxFixingDate, fpmlFxFixingDate, fpmlPaymentDates);
		}
		
		protected FxFixingDate.FxFixingDateBuilder assignOutput(FxFixingDate.FxFixingDateBuilder fxFixingDate, fpml.consolidated.ird.FxFixingDate fpmlFxFixingDate, PaymentDates fpmlPaymentDates) {
			final ReferenceWithMetaPaymentDates referenceWithMetaPaymentDates = mapPaymentDatesReference.evaluate(fpmlPaymentDates);
			fxFixingDate = toBuilder(FxFixingDate.builder()
				.setPeriod(MapperS.of(fpmlFxFixingDate).<PeriodEnum>map("getPeriod", _fxFixingDate -> _fxFixingDate.getPeriod()).checkedMap("to-enum", e -> cdm.base.datetime.PeriodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setPeriodMultiplier(MapperS.of(fpmlFxFixingDate).<Integer>map("getPeriodMultiplier", _fxFixingDate -> _fxFixingDate.getPeriodMultiplier()).get())
				.setDayType(MapperS.of(fpmlFxFixingDate).<DayTypeEnum>map("getDayType", _fxFixingDate -> _fxFixingDate.getDayType()).checkedMap("to-enum", e -> cdm.base.datetime.DayTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setBusinessDayConvention(MapperS.of(fpmlFxFixingDate).<BusinessDayConventionEnum>map("getBusinessDayConvention", _fxFixingDate -> _fxFixingDate.getBusinessDayConvention()).checkedMap("to-enum", e -> cdm.base.datetime.BusinessDayConventionEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setBusinessCenters(mapBusinessCenters.evaluate(MapperS.of(fpmlFxFixingDate).<BusinessCenters>map("getBusinessCenters", _fxFixingDate -> _fxFixingDate.getBusinessCenters()).get()))
				.setBusinessCentersReference(mapBusinessCenterReference.evaluate(MapperS.of(fpmlFxFixingDate).<BusinessCentersReference>map("getBusinessCentersReference", _fxFixingDate -> _fxFixingDate.getBusinessCentersReference()).get()))
				.setDateRelativeToPaymentDates(DateRelativeToPaymentDates.builder()
					.setPaymentDatesReference((referenceWithMetaPaymentDates == null ? Collections.<ReferenceWithMetaPaymentDates>emptyList() : Collections.singletonList(referenceWithMetaPaymentDates)))
					.build())
				.build());
			
			return Optional.ofNullable(fxFixingDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
