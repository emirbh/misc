package cdm.legaldocumentation.csa.functions;

import cdm.base.math.UnitType;
import cdm.legaldocumentation.csa.PostedCreditSupportItem;
import cdm.observable.asset.Money;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UndisputedAdjustedPostedCreditSupportAmount.UndisputedAdjustedPostedCreditSupportAmountDefault.class)
public abstract class UndisputedAdjustedPostedCreditSupportAmount implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PostedCreditSupportItemAmount postedCreditSupportItemAmount;

	/**
	* @param postedCreditSupportItems Posted Credit Support Items.
	* @param priorDeliveryAmountAdjustment The adjustment value to include any prior Delivery Amount (IM).
	* @param priorReturnAmountAdjustment The adjustment value to exclude any prior Return Amount (IM).
	* @param disputedTransferredPostedCreditSupportAmount The disputed value of any Transfer of Eligible Credit Support.
	* @param baseCurrency Base Currency means the currency specified as such in Paragraph 13.
	* @return result 
	*/
	public Money evaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency) {
		// pre-conditions
		conditionValidator.validate(() -> areEqual(MapperS.of(baseCurrency), MapperS.of(priorDeliveryAmountAdjustment).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(baseCurrency), MapperS.of(priorReturnAmountAdjustment).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(baseCurrency), MapperS.of(disputedTransferredPostedCreditSupportAmount).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString2 -> fieldWithMetaString2 == null ? null : fieldWithMetaString2.getValue()), CardinalityOperator.All)),
			"");
		
		Money.MoneyBuilder resultBuilder = doEvaluate(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, baseCurrency);
		
		final Money result;
		if (resultBuilder == null) {
			result = null;
		} else {
			result = resultBuilder.build();
			objectValidator.validate(Money.class, result);
		}
		
		return result;
	}

	protected abstract Money.MoneyBuilder doEvaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency);

	protected abstract MapperS<BigDecimal> totalPostedCreditSupportAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency);

	protected abstract MapperS<BigDecimal> adjustedPostedCreditSupportAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency);

	public static class UndisputedAdjustedPostedCreditSupportAmountDefault extends UndisputedAdjustedPostedCreditSupportAmount {
		@Override
		protected Money.MoneyBuilder doEvaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency) {
			if (postedCreditSupportItems == null) {
				postedCreditSupportItems = Collections.emptyList();
			}
			Money.MoneyBuilder result = Money.builder();
			return assignOutput(result, postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, baseCurrency);
		}
		
		protected Money.MoneyBuilder assignOutput(Money.MoneyBuilder result, List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency) {
			result
				.setValue(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(adjustedPostedCreditSupportAmount(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, baseCurrency), MapperS.of(disputedTransferredPostedCreditSupportAmount).<BigDecimal>map("getValue", money -> money.getValue())).get());
			
			result
				.getOrCreateUnit()
				.setCurrency((baseCurrency == null ? FieldWithMetaString.builder().build() : FieldWithMetaString.builder().setValue(baseCurrency).build()));
			
			return Optional.ofNullable(result)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<BigDecimal> totalPostedCreditSupportAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency) {
			final MapperC<BigDecimal> thenArg = MapperC.<PostedCreditSupportItem>of(postedCreditSupportItems)
				.mapItem(item -> MapperS.of(postedCreditSupportItemAmount.evaluate(item.get(), baseCurrency)).<BigDecimal>map("getValue", money -> money.getValue()));
			return thenArg
				.sumBigDecimal();
		}
		
		@Override
		protected MapperS<BigDecimal> adjustedPostedCreditSupportAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency) {
			return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(totalPostedCreditSupportAmount(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, baseCurrency), MapperS.of(priorDeliveryAmountAdjustment).<BigDecimal>map("getValue", money -> money.getValue())), MapperS.of(priorReturnAmountAdjustment).<BigDecimal>map("getValue", money -> money.getValue()));
		}
	}
}
