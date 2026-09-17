package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxCoreDetailsModelQuantityListWithLocation.MapFxCoreDetailsModelQuantityListWithLocationDefault.class)
public abstract class MapFxCoreDetailsModelQuantityListWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithLocation createQuantityWithLocation;
	@Inject protected MapCurrencyAmountToQuantity mapCurrencyAmountToQuantity;

	/**
	* @param fpmlExchangedCurrency1 
	* @param fpmlExchangedCurrency2 
	* @param fpmlLeg 
	* @return quantityList 
	*/
	public List<? extends FieldWithMetaNonNegativeQuantitySchedule> evaluate(Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg) {
		List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityListBuilder = doEvaluate(fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg);
		
		final List<? extends FieldWithMetaNonNegativeQuantitySchedule> quantityList;
		if (quantityListBuilder == null) {
			quantityList = null;
		} else {
			quantityList = quantityListBuilder.stream().map(FieldWithMetaNonNegativeQuantitySchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, quantityList);
		}
		
		return quantityList;
	}

	protected abstract List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg);

	protected abstract MapperS<? extends NonNegativeMoney> quantity1(Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg);

	protected abstract MapperS<? extends NonNegativeMoney> quantity2(Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg);

	public static class MapFxCoreDetailsModelQuantityListWithLocationDefault extends MapFxCoreDetailsModelQuantityListWithLocation {
		@Override
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg) {
			List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityList = new ArrayList<>();
			return assignOutput(quantityList, fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg);
		}
		
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> assignOutput(List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityList, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg) {
			if (exists(quantity1(fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg)).getOrDefault(false)) {
				final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule0 = createQuantityWithLocation.evaluate(mapCurrencyAmountToQuantity.evaluate(quantity1(fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get(), Collections.<Step>emptyList(), quantity1(fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get(), null), createQuantityKey.evaluate(quantity1(fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).<String>map("getValue", currency -> currency.getValue()).get(), fpmlLeg));
				if (fieldWithMetaNonNegativeQuantitySchedule0 == null) {
					quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
				} else {
					quantityList.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule0)));
				}
			} else {
				quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			}
			
			if (exists(quantity2(fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg)).getOrDefault(false)) {
				final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule1 = createQuantityWithLocation.evaluate(mapCurrencyAmountToQuantity.evaluate(quantity2(fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get(), Collections.<Step>emptyList(), quantity2(fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get(), null), createQuantityKey.evaluate(quantity2(fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).<String>map("getValue", currency -> currency.getValue()).get(), fpmlLeg));
				if (fieldWithMetaNonNegativeQuantitySchedule1 == null) {
					quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
				} else {
					quantityList.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule1)));
				}
			} else {
				quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			}
			
			return Optional.ofNullable(quantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends NonNegativeMoney> quantity1(Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg) {
			return MapperS.of(fpmlExchangedCurrency1).<NonNegativeMoney>map("getPaymentAmount", payment -> payment.getPaymentAmount());
		}
		
		@Override
		protected MapperS<? extends NonNegativeMoney> quantity2(Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg) {
			return MapperS.of(fpmlExchangedCurrency2).<NonNegativeMoney>map("getPaymentAmount", payment -> payment.getPaymentAmount());
		}
	}
}
