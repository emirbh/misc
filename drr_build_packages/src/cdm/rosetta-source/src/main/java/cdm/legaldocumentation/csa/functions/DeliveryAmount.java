package cdm.legaldocumentation.csa.functions;

import cdm.base.math.RoundingModeEnum;
import cdm.base.math.UnitType;
import cdm.base.math.functions.Max;
import cdm.base.math.functions.RoundToNearest;
import cdm.legaldocumentation.csa.CollateralRounding;
import cdm.legaldocumentation.csa.MarginApproachEnum;
import cdm.legaldocumentation.csa.PostedCreditSupportItem;
import cdm.observable.asset.Money;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DeliveryAmount.DeliveryAmountDefault.class)
public abstract class DeliveryAmount implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreditSupportAmount creditSupportAmount0;
	@Inject protected Max max;
	@Inject protected RoundToNearest roundToNearest;
	@Inject protected UndisputedAdjustedPostedCreditSupportAmount undisputedAdjustedPostedCreditSupportAmount0;

	/**
	* @param postedCreditSupportItems 
	* @param priorDeliveryAmountAdjustment The adjustment value to include any prior Delivery Amount (IM).
	* @param priorReturnAmountAdjustment The adjustment value to exclude any prior Return Amount (IM).
	* @param disputedTransferredPostedCreditSupportAmount The disputed value of any Transfer of Eligible Credit Support.
	* @param marginAmount The Base Currency Equivalent of an amount equal to the sum of the initial margin amounts.
	* @param threshold With respect to a party, the Base Currency Equivalent of the amount specified for that party, if no amount is specified, zero.
	* @param marginApproach 
	* @param marginAmountIA The Base Currency Equivalent of an amount equal to the sum of the Independent Amounts.
	* @param minimumTransferAmount With respect to a party, the Base Currency Equivalent of the amount specified for that party, if no amount is specified, zero.
	* @param rounding Rounding methodology applicable to the Delivery Amount and the Return Amount in terms of nearest integral multiple of Base Currency units.
	* @param disputedDeliveryAmount If a party (a &#39;Disputing Party&#39;) disputes the Calculation Agent (IM)s calculation of a Delivery Amount (IM).
	* @param baseCurrency Base Currency means the currency specified as such in Paragraph 13.
	* @return result 
	*/
	public Money evaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
		// pre-conditions
		conditionValidator.validate(() -> areEqual(MapperS.of(baseCurrency), MapperS.of(minimumTransferAmount).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(baseCurrency), MapperS.of(disputedDeliveryAmount).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), CardinalityOperator.All)),
			"");
		
		Money.MoneyBuilder resultBuilder = doEvaluate(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency);
		
		final Money result;
		if (resultBuilder == null) {
			result = null;
		} else {
			result = resultBuilder.build();
			objectValidator.validate(Money.class, result);
		}
		
		return result;
	}

	protected abstract Money.MoneyBuilder doEvaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency);

	protected abstract MapperS<? extends Money> undisputedAdjustedPostedCreditSupportAmount1(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency);

	protected abstract MapperS<? extends Money> creditSupportAmount1(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency);

	protected abstract MapperS<BigDecimal> deliveryAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency);

	protected abstract MapperS<BigDecimal> undisputedDeliveryAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency);

	public static class DeliveryAmountDefault extends DeliveryAmount {
		@Override
		protected Money.MoneyBuilder doEvaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
			if (postedCreditSupportItems == null) {
				postedCreditSupportItems = Collections.emptyList();
			}
			Money.MoneyBuilder result = Money.builder();
			return assignOutput(result, postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency);
		}
		
		protected Money.MoneyBuilder assignOutput(Money.MoneyBuilder result, List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
			final BigDecimal ifThenElseResult;
			if (greaterThanEquals(undisputedDeliveryAmount(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency), MapperS.of(minimumTransferAmount).<BigDecimal>map("getValue", money -> money.getValue()), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = roundToNearest.evaluate(undisputedDeliveryAmount(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency).get(), MapperS.of(rounding).<BigDecimal>map("getDeliveryAmount", collateralRounding -> collateralRounding.getDeliveryAmount()).get(), RoundingModeEnum.UP);
			} else {
				ifThenElseResult = new BigDecimal("0.0");
			}
			result
				.setValue(ifThenElseResult);
			
			result
				.getOrCreateUnit()
				.setCurrency((baseCurrency == null ? FieldWithMetaString.builder().build() : FieldWithMetaString.builder().setValue(baseCurrency).build()));
			
			return Optional.ofNullable(result)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Money> undisputedAdjustedPostedCreditSupportAmount1(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
			return MapperS.of(undisputedAdjustedPostedCreditSupportAmount0.evaluate(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, baseCurrency));
		}
		
		@Override
		protected MapperS<? extends Money> creditSupportAmount1(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
			return MapperS.of(creditSupportAmount0.evaluate(marginAmount, threshold, marginApproach, marginAmountIA, baseCurrency));
		}
		
		@Override
		protected MapperS<BigDecimal> deliveryAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
			return MapperS.of(max.evaluate(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(creditSupportAmount1(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency).<BigDecimal>map("getValue", money -> money.getValue()), undisputedAdjustedPostedCreditSupportAmount1(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency).<BigDecimal>map("getValue", money -> money.getValue())).get(), new BigDecimal("0.0")));
		}
		
		@Override
		protected MapperS<BigDecimal> undisputedDeliveryAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
			return MapperS.of(max.evaluate(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(deliveryAmount(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency), MapperS.of(disputedDeliveryAmount).<BigDecimal>map("getValue", money -> money.getValue())).get(), new BigDecimal("0.0")));
		}
	}
}
