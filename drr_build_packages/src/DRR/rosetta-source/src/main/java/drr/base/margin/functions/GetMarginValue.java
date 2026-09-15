package drr.base.margin.functions;

import cdm.event.common.CollateralBalance;
import cdm.event.common.CollateralStatusEnum;
import cdm.event.common.HaircutIndicatorEnum;
import cdm.observable.asset.Money;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetMarginValue.GetMarginValueDefault.class)
public abstract class GetMarginValue implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param partyCollateralBalances 
	* @param haircutType 
	* @return marginValue 
	*/
	public Money evaluate(List<? extends CollateralBalance> partyCollateralBalances, HaircutIndicatorEnum haircutType) {
		Money.MoneyBuilder marginValueBuilder = doEvaluate(partyCollateralBalances, haircutType);
		
		final Money marginValue;
		if (marginValueBuilder == null) {
			marginValue = null;
		} else {
			marginValue = marginValueBuilder.build();
			objectValidator.validate(Money.class, marginValue);
		}
		
		return marginValue;
	}

	protected abstract Money.MoneyBuilder doEvaluate(List<? extends CollateralBalance> partyCollateralBalances, HaircutIndicatorEnum haircutType);

	public static class GetMarginValueDefault extends GetMarginValue {
		@Override
		protected Money.MoneyBuilder doEvaluate(List<? extends CollateralBalance> partyCollateralBalances, HaircutIndicatorEnum haircutType) {
			if (partyCollateralBalances == null) {
				partyCollateralBalances = Collections.emptyList();
			}
			Money.MoneyBuilder marginValue = Money.builder();
			return assignOutput(marginValue, partyCollateralBalances, haircutType);
		}
		
		protected Money.MoneyBuilder assignOutput(Money.MoneyBuilder marginValue, List<? extends CollateralBalance> partyCollateralBalances, HaircutIndicatorEnum haircutType) {
			final MapperC<CollateralBalance> thenArg0 = MapperC.<CollateralBalance>of(partyCollateralBalances)
				.filterItemNullSafe(item -> areEqual(item.<HaircutIndicatorEnum>map("getHaircutIndicator", collateralBalance -> collateralBalance.getHaircutIndicator()), MapperS.of(haircutType), CardinalityOperator.All).get());
			final MapperC<CollateralBalance> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<CollateralStatusEnum>map("getCollateralBalanceStatus", collateralBalance -> collateralBalance.getCollateralBalanceStatus()), MapperS.of(CollateralStatusEnum.FULL_AMOUNT), CardinalityOperator.All).get());
			final MapperC<Money> thenArg2 = thenArg1
				.mapItem(item -> item.<Money>map("getAmountBaseCurrency", collateralBalance -> collateralBalance.getAmountBaseCurrency()));
			marginValue = toBuilder(MapperS.of(thenArg2.get()).get());
			
			return Optional.ofNullable(marginValue)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
