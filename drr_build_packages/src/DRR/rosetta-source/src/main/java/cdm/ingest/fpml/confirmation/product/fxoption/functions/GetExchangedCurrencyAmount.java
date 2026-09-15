package cdm.ingest.fpml.confirmation.product.fxoption.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.StrikeQuoteBasisEnum;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.fx.FxStrikePrice;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetExchangedCurrencyAmount.GetExchangedCurrencyAmountDefault.class)
public abstract class GetExchangedCurrencyAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlFxOption 
	* @return fpmlNonNegativeMoney 
	*/
	public NonNegativeMoney evaluate(FxOption fpmlFxOption) {
		NonNegativeMoney.NonNegativeMoneyBuilder fpmlNonNegativeMoneyBuilder = doEvaluate(fpmlFxOption);
		
		final NonNegativeMoney fpmlNonNegativeMoney;
		if (fpmlNonNegativeMoneyBuilder == null) {
			fpmlNonNegativeMoney = null;
		} else {
			fpmlNonNegativeMoney = fpmlNonNegativeMoneyBuilder.build();
			objectValidator.validate(NonNegativeMoney.class, fpmlNonNegativeMoney);
		}
		
		return fpmlNonNegativeMoney;
	}

	protected abstract NonNegativeMoney.NonNegativeMoneyBuilder doEvaluate(FxOption fpmlFxOption);

	public static class GetExchangedCurrencyAmountDefault extends GetExchangedCurrencyAmount {
		@Override
		protected NonNegativeMoney.NonNegativeMoneyBuilder doEvaluate(FxOption fpmlFxOption) {
			NonNegativeMoney.NonNegativeMoneyBuilder fpmlNonNegativeMoney = NonNegativeMoney.builder();
			return assignOutput(fpmlNonNegativeMoney, fpmlFxOption);
		}
		
		protected NonNegativeMoney.NonNegativeMoneyBuilder assignOutput(NonNegativeMoney.NonNegativeMoneyBuilder fpmlNonNegativeMoney, FxOption fpmlFxOption) {
			if (areEqual(MapperS.of(fpmlFxOption).<FxStrikePrice>map("getStrike", fxOption -> fxOption.getStrike()).<StrikeQuoteBasisEnum>map("getStrikeQuoteBasis", fxStrikePrice -> fxStrikePrice.getStrikeQuoteBasis()), MapperS.of(StrikeQuoteBasisEnum.CALL_CURRENCY_PER_PUT_CURRENCY), CardinalityOperator.All).getOrDefault(false)) {
				fpmlNonNegativeMoney = toBuilder(MapperS.of(fpmlFxOption).<NonNegativeMoney>map("getPutCurrencyAmount", fxOption -> fxOption.getPutCurrencyAmount()).get());
			} else {
				fpmlNonNegativeMoney = toBuilder(MapperS.of(fpmlFxOption).<NonNegativeMoney>map("getCallCurrencyAmount", fxOption -> fxOption.getCallCurrencyAmount()).get());
			}
			
			return Optional.ofNullable(fpmlNonNegativeMoney)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
