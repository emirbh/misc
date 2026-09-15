package drr.regulation.common.trade.datetime.reports;

import cdm.product.qualification.functions.Qualify_InterestRate_Fra;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaDate;
import drr.base.trade.functions.PositionForEvent;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.TransactionReportInstruction;
import java.time.LocalDateTime;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EffectiveDateRule.EffectiveDateRuleDefault.class)
public abstract class EffectiveDateRule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.datetime.reports.EffectiveDateRule effectiveDateRule;
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_InterestRate_Fra qualify_InterestRate_Fra;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstruction input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstruction input);

	public static class EffectiveDateRuleDefault extends EffectiveDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					final Boolean _boolean = qualify_InterestRate_Fra.evaluate(MapperS.of(productForEvent.evaluate(item.get())).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
					if ((_boolean == null ? false : _boolean)) {
						if (exists(MapperS.of(tradeForEvent.evaluate(item.get()))).getOrDefault(false)) {
							return MapperS.of(tradeForEvent.evaluate(item.get())).<FieldWithMetaDate>map("getTradeDate", trade -> trade.getTradeDate()).<Date>map("Type coercion", fieldWithMetaDate -> fieldWithMetaDate == null ? null : fieldWithMetaDate.getValue());
						}
						if (exists(MapperS.of(positionForEvent.evaluate(item.get()))).getOrDefault(false)) {
							return MapperS.of(positionForEvent.evaluate(item.get())).<LocalDateTime>map("getOpenDateTime", counterpartyPosition -> counterpartyPosition.getOpenDateTime()).<Date>map("Date", dt -> Date.of(dt.toLocalDate()));
						}
						return MapperS.<Date>ofNull();
					}
					return MapperS.of(effectiveDateRule.evaluate(item.get()));
				}).get();
			
			return output;
		}
	}
}
