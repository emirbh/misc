package drr.standards.iosco.upi.reports;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.util.ObservableDeepPathUtil;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ProductClassificationRule.ProductClassificationRuleDefault.class)
public abstract class ProductClassificationRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ObservableDeepPathUtil observableDeepPathUtil;
	@Inject protected ProductForEvent productForEvent;

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

	public static class ProductClassificationRuleDefault extends ProductClassificationRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			final FieldWithMetaString fieldWithMetaString = thenArg
				.mapSingleToItem(item -> {
					final MapperC<Taxonomy> thenArg0 = MapperC.<Taxonomy>of(item.<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy()), item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Taxonomy>mapC("chooseTaxonomy", observable -> observableDeepPathUtil.chooseTaxonomy(observable)))
						.filterItemNullSafe(_item -> areEqual(_item.<TaxonomySourceEnum>map("getSource", taxonomy -> taxonomy.getSource()), MapperS.of(TaxonomySourceEnum.CFI), CardinalityOperator.All).get());
					final MapperS<Taxonomy> thenArg1 = MapperS.of(thenArg0.get());
					return thenArg1
						.mapSingleToItem(_item -> _item.<TaxonomyValue>map("getValue", taxonomy -> taxonomy.getValue()).<FieldWithMetaString>map("getName", taxonomyValue -> taxonomyValue.getName()));
				}).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
