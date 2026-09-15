package drr.regulation.common.functions;

import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetIsin.GetIsinDefault.class)
public abstract class GetIsin implements RosettaFunction {

	/**
	* @param product 
	* @return isin 
	*/
	public String evaluate(NonTransferableProduct product) {
		String isin = doEvaluate(product);
		
		return isin;
	}

	protected abstract String doEvaluate(NonTransferableProduct product);

	public static class GetIsinDefault extends GetIsin {
		@Override
		protected String doEvaluate(NonTransferableProduct product) {
			String isin = null;
			return assignOutput(isin, product);
		}
		
		protected String assignOutput(String isin, NonTransferableProduct product) {
			final MapperS<NonTransferableProduct> thenArg = MapperS.of(product);
			final FieldWithMetaString fieldWithMetaString = thenArg
				.mapSingleToItem(item -> {
					final MapperC<ProductIdentifier> thenArg0 = item.<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier())
						.filterItemNullSafe(_item -> areEqual(_item.<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()), MapperS.of(ProductIdTypeEnum.ISIN), CardinalityOperator.All).get());
					final MapperS<ProductIdentifier> thenArg1 = MapperS.of(thenArg0.get());
					return thenArg1
						.mapSingleToItem(_item -> _item.<FieldWithMetaString>map("getIdentifier", productIdentifier -> productIdentifier.getIdentifier()));
				}).get();
			if (fieldWithMetaString == null) {
				isin = null;
			} else {
				isin = fieldWithMetaString.getValue();
			}
			
			return isin;
		}
	}
}
