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
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PostedCreditSupportItemAmount.PostedCreditSupportItemAmountDefault.class)
public abstract class PostedCreditSupportItemAmount implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param postedItem Posted Credit Support Item.
	* @param baseCurrency Base Currency means the currency specified as such in Paragraph 13.
	* @return result 
	*/
	public Money evaluate(PostedCreditSupportItem postedItem, String baseCurrency) {
		// pre-conditions
		conditionValidator.validate(() -> areEqual(MapperS.of(baseCurrency), MapperS.of(postedItem).<Money>map("getCashOrSecurityValue", postedCreditSupportItem -> postedCreditSupportItem.getCashOrSecurityValue()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(baseCurrency), MapperS.of(postedItem).<Money>map("getDisputedCashOrSecurityValue", postedCreditSupportItem -> postedCreditSupportItem.getDisputedCashOrSecurityValue()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), CardinalityOperator.All)),
			"");
		
		Money.MoneyBuilder resultBuilder = doEvaluate(postedItem, baseCurrency);
		
		final Money result;
		if (resultBuilder == null) {
			result = null;
		} else {
			result = resultBuilder.build();
			objectValidator.validate(Money.class, result);
		}
		
		return result;
	}

	protected abstract Money.MoneyBuilder doEvaluate(PostedCreditSupportItem postedItem, String baseCurrency);

	protected abstract MapperS<BigDecimal> cashOrSecurityValue(PostedCreditSupportItem postedItem, String baseCurrency);

	protected abstract MapperS<BigDecimal> haircutPercentage(PostedCreditSupportItem postedItem, String baseCurrency);

	protected abstract MapperS<BigDecimal> fxHaircutPercentage(PostedCreditSupportItem postedItem, String baseCurrency);

	protected abstract MapperS<BigDecimal> additionalHaircutPercentage(PostedCreditSupportItem postedItem, String baseCurrency);

	protected abstract MapperS<BigDecimal> postedCreditSupportAmount(PostedCreditSupportItem postedItem, String baseCurrency);

	public static class PostedCreditSupportItemAmountDefault extends PostedCreditSupportItemAmount {
		@Override
		protected Money.MoneyBuilder doEvaluate(PostedCreditSupportItem postedItem, String baseCurrency) {
			Money.MoneyBuilder result = Money.builder();
			return assignOutput(result, postedItem, baseCurrency);
		}
		
		protected Money.MoneyBuilder assignOutput(Money.MoneyBuilder result, PostedCreditSupportItem postedItem, String baseCurrency) {
			result
				.setValue(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(postedCreditSupportAmount(postedItem, baseCurrency), MapperS.of(postedItem).<Money>map("getDisputedCashOrSecurityValue", postedCreditSupportItem -> postedCreditSupportItem.getDisputedCashOrSecurityValue()).<BigDecimal>map("getValue", money -> money.getValue())).get());
			
			result
				.getOrCreateUnit()
				.setCurrency((baseCurrency == null ? FieldWithMetaString.builder().build() : FieldWithMetaString.builder().setValue(baseCurrency).build()));
			
			return Optional.ofNullable(result)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<BigDecimal> cashOrSecurityValue(PostedCreditSupportItem postedItem, String baseCurrency) {
			return MapperS.of(postedItem).<Money>map("getCashOrSecurityValue", postedCreditSupportItem -> postedCreditSupportItem.getCashOrSecurityValue()).<BigDecimal>map("getValue", money -> money.getValue());
		}
		
		@Override
		protected MapperS<BigDecimal> haircutPercentage(PostedCreditSupportItem postedItem, String baseCurrency) {
			return MapperS.of(postedItem).<BigDecimal>map("getHaircutPercentage", postedCreditSupportItem -> postedCreditSupportItem.getHaircutPercentage());
		}
		
		@Override
		protected MapperS<BigDecimal> fxHaircutPercentage(PostedCreditSupportItem postedItem, String baseCurrency) {
			return MapperS.of(postedItem).<BigDecimal>map("getFxHaircutPercentage", postedCreditSupportItem -> postedCreditSupportItem.getFxHaircutPercentage());
		}
		
		@Override
		protected MapperS<BigDecimal> additionalHaircutPercentage(PostedCreditSupportItem postedItem, String baseCurrency) {
			return MapperS.of(postedItem).<BigDecimal>map("getFxHaircutPercentage", postedCreditSupportItem -> postedCreditSupportItem.getFxHaircutPercentage());
		}
		
		@Override
		protected MapperS<BigDecimal> postedCreditSupportAmount(PostedCreditSupportItem postedItem, String baseCurrency) {
			return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(cashOrSecurityValue(postedItem, baseCurrency), MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(new BigDecimal("1.00")), MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(haircutPercentage(postedItem, baseCurrency), fxHaircutPercentage(postedItem, baseCurrency)), additionalHaircutPercentage(postedItem, baseCurrency))));
		}
	}
}
