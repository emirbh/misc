package drr.regulation.common.dtcc.trade.reports;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_ProductIDRule.DTCC_ProductIDRuleDefault.class)
public abstract class DTCC_ProductIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class DTCC_ProductIDRuleDefault extends DTCC_ProductIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			final MapperS<NonTransferableProduct> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(item.get())));
			final MapperC<ProductTaxonomy> thenArg2 = thenArg1
				.mapSingleToList(item -> item.<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy()));
			final MapperC<ProductTaxonomy> thenArg3 = thenArg2
				.filterItemNullSafe(item -> areEqual(item.<TaxonomySourceEnum>map("getSource", productTaxonomy -> productTaxonomy.getSource()), MapperS.of(TaxonomySourceEnum.ISDA), CardinalityOperator.All).andNullSafe(exists(item.<TaxonomyValue>map("getValue", productTaxonomy -> productTaxonomy.getValue()).<FieldWithMetaString>map("getName", taxonomyValue -> taxonomyValue.getName()))).get());
			final MapperS<ProductTaxonomy> thenArg4 = thenArg3
				.first();
			final FieldWithMetaString fieldWithMetaString = thenArg4
				.mapSingleToItem(item -> item.<TaxonomyValue>map("getValue", productTaxonomy -> productTaxonomy.getValue()).<FieldWithMetaString>map("getName", taxonomyValue -> taxonomyValue.getName())).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
