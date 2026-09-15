package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.ReportableEvent;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Existing_Upi.Existing_UpiDefault.class)
public abstract class Existing_Upi implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param reportableEvent 
	* @return existingUpi 
	*/
	public String evaluate(ReportableEvent reportableEvent) {
		String existingUpi = doEvaluate(reportableEvent);
		
		return existingUpi;
	}

	protected abstract String doEvaluate(ReportableEvent reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEvent reportableEvent);

	public static class Existing_UpiDefault extends Existing_Upi {
		@Override
		protected String doEvaluate(ReportableEvent reportableEvent) {
			String existingUpi = null;
			return assignOutput(existingUpi, reportableEvent);
		}
		
		protected String assignOutput(String existingUpi, ReportableEvent reportableEvent) {
			final MapperC<ProductIdentifier> thenArg0 = product(reportableEvent).<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()), MapperS.of(ProductIdTypeEnum.UPI), CardinalityOperator.All).get());
			final MapperS<ProductIdentifier> thenArg1 = MapperS.of(thenArg0.get());
			final FieldWithMetaString fieldWithMetaString = thenArg1.<FieldWithMetaString>map("getIdentifier", productIdentifier -> productIdentifier.getIdentifier()).get();
			if (fieldWithMetaString == null) {
				existingUpi = null;
			} else {
				existingUpi = fieldWithMetaString.getValue();
			}
			
			return existingUpi;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEvent reportableEvent) {
			return MapperS.of(productForEvent.evaluate(reportableEvent));
		}
	}
}
