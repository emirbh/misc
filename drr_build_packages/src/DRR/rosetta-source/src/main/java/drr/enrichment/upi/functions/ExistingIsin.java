package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
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

@ImplementedBy(ExistingIsin.ExistingIsinDefault.class)
public abstract class ExistingIsin implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param reportableEvent 
	* @return contrProduct 
	*/
	public String evaluate(ReportableEvent reportableEvent) {
		String contrProduct = doEvaluate(reportableEvent);
		
		return contrProduct;
	}

	protected abstract String doEvaluate(ReportableEvent reportableEvent);

	public static class ExistingIsinDefault extends ExistingIsin {
		@Override
		protected String doEvaluate(ReportableEvent reportableEvent) {
			String contrProduct = null;
			return assignOutput(contrProduct, reportableEvent);
		}
		
		protected String assignOutput(String contrProduct, ReportableEvent reportableEvent) {
			final MapperC<ProductIdentifier> thenArg0 = MapperS.of(productForEvent.evaluate(reportableEvent)).<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()), MapperS.of(ProductIdTypeEnum.ISIN), CardinalityOperator.All).get());
			final MapperS<ProductIdentifier> thenArg1 = thenArg0
				.first();
			final FieldWithMetaString fieldWithMetaString = thenArg1
				.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", productIdentifier -> productIdentifier.getIdentifier())).get();
			if (fieldWithMetaString == null) {
				contrProduct = null;
			} else {
				contrProduct = fieldWithMetaString.getValue();
			}
			
			return contrProduct;
		}
	}
}
