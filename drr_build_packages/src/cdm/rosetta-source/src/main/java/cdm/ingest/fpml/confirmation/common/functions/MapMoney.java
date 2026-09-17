package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.math.UnitType;
import cdm.observable.asset.Money;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapMoney.MapMoneyDefault.class)
public abstract class MapMoney implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlMoney 
	* @return money 
	*/
	public Money evaluate(fpml.consolidated.shared.Money fpmlMoney) {
		Money.MoneyBuilder moneyBuilder = doEvaluate(fpmlMoney);
		
		final Money money;
		if (moneyBuilder == null) {
			money = null;
		} else {
			money = moneyBuilder.build();
			objectValidator.validate(Money.class, money);
		}
		
		return money;
	}

	protected abstract Money.MoneyBuilder doEvaluate(fpml.consolidated.shared.Money fpmlMoney);

	public static class MapMoneyDefault extends MapMoney {
		@Override
		protected Money.MoneyBuilder doEvaluate(fpml.consolidated.shared.Money fpmlMoney) {
			Money.MoneyBuilder money = Money.builder();
			return assignOutput(money, fpmlMoney);
		}
		
		protected Money.MoneyBuilder assignOutput(Money.MoneyBuilder money, fpml.consolidated.shared.Money fpmlMoney) {
			if (exists(MapperS.of(fpmlMoney)).getOrDefault(false)) {
				money = toBuilder(Money.builder()
					.setValue(MapperS.of(fpmlMoney).<BigDecimal>map("getAmount", _money -> _money.getAmount()).get())
					.setUnit(UnitType.builder()
						.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlMoney).<Currency>map("getCurrency", _money -> _money.getCurrency()).get()))
						.build())
					.build());
			} else {
				money = null;
			}
			
			return Optional.ofNullable(money)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
