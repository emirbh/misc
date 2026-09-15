package drr.base.trade.quantity.reports;

import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CommodityFixedPriceQuantityRule.CommodityFixedPriceQuantityRuleDefault.class)
public abstract class CommodityFixedPriceQuantityRule implements ReportFunction<TradeLot, PriceQuantity> {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceQuantity evaluate(TradeLot input) {
		PriceQuantity.PriceQuantityBuilder outputBuilder = doEvaluate(input);
		
		final PriceQuantity output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(PriceQuantity.class, output);
		}
		
		return output;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(TradeLot input);

	public static class CommodityFixedPriceQuantityRuleDefault extends CommodityFixedPriceQuantityRule {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(TradeLot input) {
			PriceQuantity.PriceQuantityBuilder output = PriceQuantity.builder();
			return assignOutput(output, input);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder output, TradeLot input) {
			final MapperC<PriceQuantity> thenArg = MapperS.of(input).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity())
				.filterItemNullSafe(item -> notExists(item.<FieldWithMetaObservable>map("getObservable", priceQuantity -> priceQuantity.getObservable())).get());
			output = toBuilder(MapperS.of(thenArg.get()).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
