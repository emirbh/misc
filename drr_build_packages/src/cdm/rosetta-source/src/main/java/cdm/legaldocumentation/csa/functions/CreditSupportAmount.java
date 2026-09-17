package cdm.legaldocumentation.csa.functions;

import cdm.base.math.UnitType;
import cdm.base.math.functions.Max;
import cdm.legaldocumentation.csa.MarginApproachEnum;
import cdm.observable.asset.Money;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
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

@ImplementedBy(CreditSupportAmount.CreditSupportAmountDefault.class)
public abstract class CreditSupportAmount implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Max max;

	/**
	* @param marginAmount The Base Currency Equivalent of an amount equal to the sum of the initial margin amounts.
	* @param threshold With respect to a party, the Base Currency Equivalent of the amount specified for that party, if no amount is specified, zero.
	* @param marginApproach Specifies the margin approach specific to Initial Margin agreements.
	* @param marginAmountIA The Base Currency Equivalent of an amount equal to the sum of the Independent Amounts.
	* @param baseCurrency Base Currency means the currency specified as such in Paragraph 13.
	* @return result 
	*/
	public Money evaluate(Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, String baseCurrency) {
		// pre-conditions
		conditionValidator.validate(() -> {
			final ComparisonResult ifThenElseResult;
			if (exists(MapperS.of(marginAmountIA)).getOrDefault(false)) {
				ifThenElseResult = areEqual(MapperS.of(baseCurrency), MapperS.of(marginAmountIA).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString2 -> fieldWithMetaString2 == null ? null : fieldWithMetaString2.getValue()), CardinalityOperator.All);
			} else {
				ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
			}
			return areEqual(MapperS.of(baseCurrency), MapperS.of(marginAmount).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(baseCurrency), MapperS.of(threshold).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), CardinalityOperator.All)).andNullSafe(ifThenElseResult);
		},
			"");
		
		conditionValidator.validate(() -> {
			if (areEqual(MapperS.of(marginApproach), MapperS.of(MarginApproachEnum.DISTINCT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(marginApproach), MapperS.of(MarginApproachEnum.ALLOCATED), CardinalityOperator.All)).getOrDefault(false)) {
				return notExists(MapperS.of(marginAmountIA));
			}
			if (areEqual(MapperS.of(marginApproach), MapperS.of(MarginApproachEnum.GREATER_OF), CardinalityOperator.All).getOrDefault(false)) {
				return exists(MapperS.of(marginAmountIA));
			}
			return ComparisonResult.ofEmpty();
		},
			"");
		
		Money.MoneyBuilder resultBuilder = doEvaluate(marginAmount, threshold, marginApproach, marginAmountIA, baseCurrency);
		
		final Money result;
		if (resultBuilder == null) {
			result = null;
		} else {
			result = resultBuilder.build();
			objectValidator.validate(Money.class, result);
		}
		
		return result;
	}

	protected abstract Money.MoneyBuilder doEvaluate(Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, String baseCurrency);

	protected abstract MapperS<BigDecimal> creditSupportAmountCalc(Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, String baseCurrency);

	public static class CreditSupportAmountDefault extends CreditSupportAmount {
		@Override
		protected Money.MoneyBuilder doEvaluate(Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, String baseCurrency) {
			Money.MoneyBuilder result = Money.builder();
			return assignOutput(result, marginAmount, threshold, marginApproach, marginAmountIA, baseCurrency);
		}
		
		protected Money.MoneyBuilder assignOutput(Money.MoneyBuilder result, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, String baseCurrency) {
			final BigDecimal ifThenElseResult;
			if (areEqual(MapperS.of(marginApproach), MapperS.of(MarginApproachEnum.DISTINCT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(marginApproach), MapperS.of(MarginApproachEnum.ALLOCATED), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult = creditSupportAmountCalc(marginAmount, threshold, marginApproach, marginAmountIA, baseCurrency).get();
			} else if (areEqual(MapperS.of(marginApproach), MapperS.of(MarginApproachEnum.GREATER_OF), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = max.evaluate(creditSupportAmountCalc(marginAmount, threshold, marginApproach, marginAmountIA, baseCurrency).get(), MapperS.of(marginAmountIA).<BigDecimal>map("getValue", money -> money.getValue()).get());
			} else {
				ifThenElseResult = null;
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
		protected MapperS<BigDecimal> creditSupportAmountCalc(Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, String baseCurrency) {
			return MapperS.of(max.evaluate(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(marginAmount).<BigDecimal>map("getValue", money -> money.getValue()), MapperS.of(threshold).<BigDecimal>map("getValue", money -> money.getValue())).get(), new BigDecimal("0.0")));
		}
	}
}
