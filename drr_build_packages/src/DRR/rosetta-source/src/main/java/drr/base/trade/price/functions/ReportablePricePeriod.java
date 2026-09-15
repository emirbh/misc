package drr.base.trade.price.functions;

import cdm.base.math.DatedValue;
import cdm.observable.asset.PriceSchedule;
import cdm.product.template.CalculationSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.price.DefaultingType;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.PricePeriod;
import drr.base.util.datetime.ValuePeriod;
import drr.base.util.datetime.functions.EnrichDatedValueWithEndDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ReportablePricePeriod.ReportablePricePeriodDefault.class)
public abstract class ReportablePricePeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected DefaultBasisToPercentage defaultBasisToPercentage;
	@Inject protected DefaultPercentageToDecimal defaultPercentageToDecimal;
	@Inject protected EnrichDatedValueWithEndDate enrichDatedValueWithEndDate;
	@Inject protected NotationFromPrice notationFromPrice;
	@Inject protected PriceFormatFromNotation priceFormatFromNotation;

	/**
	* @param priceSchedule 
	* @param calculationSchedule 
	* @param defaultingType 
	* @return pricePeriod 
	*/
	public List<? extends PricePeriod> evaluate(PriceSchedule priceSchedule, CalculationSchedule calculationSchedule, DefaultingType defaultingType) {
		List<PricePeriod.PricePeriodBuilder> pricePeriodBuilder = doEvaluate(priceSchedule, calculationSchedule, defaultingType);
		
		final List<? extends PricePeriod> pricePeriod;
		if (pricePeriodBuilder == null) {
			pricePeriod = null;
		} else {
			pricePeriod = pricePeriodBuilder.stream().map(PricePeriod::build).collect(Collectors.toList());
			objectValidator.validate(PricePeriod.class, pricePeriod);
		}
		
		return pricePeriod;
	}

	protected abstract List<PricePeriod.PricePeriodBuilder> doEvaluate(PriceSchedule priceSchedule, CalculationSchedule calculationSchedule, DefaultingType defaultingType);

	protected abstract MapperS<PriceNotationEnum> priceNotationForPriceSchedule(PriceSchedule priceSchedule, CalculationSchedule calculationSchedule, DefaultingType defaultingType);

	public static class ReportablePricePeriodDefault extends ReportablePricePeriod {
		@Override
		protected List<PricePeriod.PricePeriodBuilder> doEvaluate(PriceSchedule priceSchedule, CalculationSchedule calculationSchedule, DefaultingType defaultingType) {
			List<PricePeriod.PricePeriodBuilder> pricePeriod = new ArrayList<>();
			return assignOutput(pricePeriod, priceSchedule, calculationSchedule, defaultingType);
		}
		
		protected List<PricePeriod.PricePeriodBuilder> assignOutput(List<PricePeriod.PricePeriodBuilder> pricePeriod, PriceSchedule priceSchedule, CalculationSchedule calculationSchedule, DefaultingType defaultingType) {
			pricePeriod.addAll(toBuilder(MapperC.<ValuePeriod>of(enrichDatedValueWithEndDate.evaluate(MapperS.of(priceSchedule).<DatedValue>mapC("getDatedValue", _priceSchedule -> _priceSchedule.getDatedValue()).getMulti(), calculationSchedule))
				.mapItem(item -> MapperS.of(PricePeriod.builder()
					.setPrice(priceFormatFromNotation.evaluate(item.<BigDecimal>map("getValue", valuePeriod -> valuePeriod.getValue()).get(), priceNotationForPriceSchedule(priceSchedule, calculationSchedule, defaultingType).get()))
					.setEffectiveDate(item.<Date>map("getEffectiveDate", valuePeriod -> valuePeriod.getEffectiveDate()).get())
					.setEndDate(item.<Date>map("getEndDate", valuePeriod -> valuePeriod.getEndDate()).get())
					.build())).getMulti()));
			
			return Optional.ofNullable(pricePeriod)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<PriceNotationEnum> priceNotationForPriceSchedule(PriceSchedule priceSchedule, CalculationSchedule calculationSchedule, DefaultingType defaultingType) {
			if (areEqual(MapperS.of(defaultingType), MapperS.of(DefaultingType.DEFAULT_BASISTO_PERCENTAGE), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(defaultBasisToPercentage.evaluate(notationFromPrice.evaluate(priceSchedule), true));
			}
			if (areEqual(MapperS.of(defaultingType), MapperS.of(DefaultingType.DEFAULT_PERCENTAGETO_DECIMAL), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(defaultPercentageToDecimal.evaluate(notationFromPrice.evaluate(priceSchedule), true));
			}
			return MapperS.of(notationFromPrice.evaluate(priceSchedule));
		}
	}
}
