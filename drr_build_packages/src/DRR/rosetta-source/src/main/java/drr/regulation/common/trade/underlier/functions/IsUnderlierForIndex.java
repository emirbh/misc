package drr.regulation.common.trade.underlier.functions;

import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsUnderlierForIndex.IsUnderlierForIndexDefault.class)
public abstract class IsUnderlierForIndex implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetUnderlierIDForIndex getUnderlierIDForIndex;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param reportableEvent 
	* @return result 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean result = doEvaluate(reportableEvent);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	public static class IsUnderlierForIndexDefault extends IsUnderlierForIndex {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean result = null;
			return assignOutput(result, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean result, ReportableEventBase reportableEvent) {
			final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(productForEvent.evaluate(reportableEvent));
			final MapperS<NonTransferableProduct> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					final Boolean _boolean = isCreditSwaption.evaluate(item.get());
					if ((_boolean == null ? false : _boolean)) {
						return MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct());
					}
					return item;
				});
			result = thenArg1
				.mapSingleToItem(item -> {
					if (exists(MapperC.<String>of(getUnderlierIDForIndex.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(true);
					}
					return MapperS.of(false);
				}).get();
			
			return result;
		}
	}
}
