package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.event.common.Trade;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.ReportableEvent;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractUpi.ExtractUpiDefault.class)
public abstract class ExtractUpi implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return upi 
	*/
	public String evaluate(ReportableEvent reportableEvent) {
		String upi = doEvaluate(reportableEvent);
		
		return upi;
	}

	protected abstract String doEvaluate(ReportableEvent reportableEvent);

	protected abstract MapperS<? extends Trade> trade(ReportableEvent reportableEvent);

	public static class ExtractUpiDefault extends ExtractUpi {
		@Override
		protected String doEvaluate(ReportableEvent reportableEvent) {
			String upi = null;
			return assignOutput(upi, reportableEvent);
		}
		
		protected String assignOutput(String upi, ReportableEvent reportableEvent) {
			final MapperC<ProductIdentifier> thenArg0 = trade(reportableEvent)
				.mapSingleToList(item -> item.<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier()));
			final MapperC<ProductIdentifier> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()), MapperS.of(ProductIdTypeEnum.UPI), CardinalityOperator.All).get());
			final MapperS<ProductIdentifier> thenArg2 = MapperS.of(thenArg1.get());
			final FieldWithMetaString fieldWithMetaString = thenArg2
				.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", productIdentifier -> productIdentifier.getIdentifier())).get();
			if (fieldWithMetaString == null) {
				upi = null;
			} else {
				upi = fieldWithMetaString.getValue();
			}
			
			return upi;
		}
		
		@Override
		protected MapperS<? extends Trade> trade(ReportableEvent reportableEvent) {
			return MapperS.of(tradeForEvent.evaluate(reportableEvent));
		}
	}
}
