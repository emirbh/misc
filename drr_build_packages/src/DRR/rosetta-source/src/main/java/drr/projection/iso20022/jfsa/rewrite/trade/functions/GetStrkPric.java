package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import cdm.base.math.functions.Abs;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceFormat;
import drr.base.util.string.functions.StringLength;
import drr.base.util.string.functions.SubString;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.jfsa.AmountAndDirection106__1;
import iso20022.auth030.jfsa.SecuritiesTransactionPrice17Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetStrkPric.GetStrkPricDefault.class)
public abstract class GetStrkPric implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;
	@Inject protected StringLength stringLength;
	@Inject protected SubString subString;

	/**
	* @param drrReport 
	* @return strkPric 
	*/
	public SecuritiesTransactionPrice17Choice__1 evaluate(JFSATransactionReport drrReport) {
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder strkPricBuilder = doEvaluate(drrReport);
		
		final SecuritiesTransactionPrice17Choice__1 strkPric;
		if (strkPricBuilder == null) {
			strkPric = null;
		} else {
			strkPric = strkPricBuilder.build();
			objectValidator.validate(SecuritiesTransactionPrice17Choice__1.class, strkPric);
		}
		
		return strkPric;
	}

	protected abstract SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetStrkPricDefault extends GetStrkPric {
		@Override
		protected SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder doEvaluate(JFSATransactionReport drrReport) {
			SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder strkPric = SecuritiesTransactionPrice17Choice__1.builder();
			return assignOutput(strkPric, drrReport);
		}
		
		protected SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder assignOutput(SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder strkPric, JFSATransactionReport drrReport) {
			strkPric = toBuilder(MapperS.of(drrReport)
				.mapSingleToItem(item -> {
					final String ifThenElseResult0;
					if (greaterThan(MapperS.of(stringLength.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", jFSATransactionReport -> jFSATransactionReport.getStrikePriceCurrency()).get())), MapperS.of(3), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult0 = subString.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", jFSATransactionReport -> jFSATransactionReport.getStrikePriceCurrency()).get(), 5, 3);
					} else {
						ifThenElseResult0 = MapperS.of(drrReport).<String>map("getStrikePriceCurrency", jFSATransactionReport -> jFSATransactionReport.getStrikePriceCurrency()).get();
					}
					Boolean ifThenElseResult1 = null;
					if (lessThan(item.<PriceFormat>map("getStrikePrice", jFSATransactionReport -> jFSATransactionReport.getStrikePrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult1 = false;
					}
					return MapperS.of(SecuritiesTransactionPrice17Choice__1.builder()
						.setMntryVal(AmountAndDirection106__1.builder()
							.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
								.setValue(abs.evaluate(item.<PriceFormat>map("getStrikePrice", jFSATransactionReport -> jFSATransactionReport.getStrikePrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
								.setCcy(ifThenElseResult0)
								.build())
							.setSgn(ifThenElseResult1)
							.build())
						.setDcml(item.<PriceFormat>map("getStrikePrice", jFSATransactionReport -> jFSATransactionReport.getStrikePrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
						.build());
				}).get());
			
			return Optional.ofNullable(strkPric)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
