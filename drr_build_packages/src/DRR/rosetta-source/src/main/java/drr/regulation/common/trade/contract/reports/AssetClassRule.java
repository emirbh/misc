package drr.regulation.common.trade.contract.reports;

import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.qualification.functions.Qualify_AssetClass_Credit;
import cdm.product.qualification.functions.Qualify_AssetClass_Equity;
import cdm.product.qualification.functions.Qualify_AssetClass_ForeignExchange;
import cdm.product.qualification.functions.Qualify_AssetClass_InterestRate;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsSingleCommodityPayoutProduct;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.CommonAssetClass;
import javax.inject.Inject;


@ImplementedBy(AssetClassRule.AssetClassRuleDefault.class)
public abstract class AssetClassRule implements ReportFunction<ReportableEventBase, CommonAssetClass> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsSingleCommodityPayoutProduct isSingleCommodityPayoutProduct;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;
	@Inject protected Qualify_AssetClass_Credit qualify_AssetClass_Credit;
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;
	@Inject protected Qualify_AssetClass_ForeignExchange qualify_AssetClass_ForeignExchange;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public CommonAssetClass evaluate(ReportableEventBase input) {
		CommonAssetClass output = doEvaluate(input);
		
		return output;
	}

	protected abstract CommonAssetClass doEvaluate(ReportableEventBase input);

	public static class AssetClassRuleDefault extends AssetClassRule {
		@Override
		protected CommonAssetClass doEvaluate(ReportableEventBase input) {
			CommonAssetClass output = null;
			return assignOutput(output, input);
		}
		
		protected CommonAssetClass assignOutput(CommonAssetClass output, ReportableEventBase input) {
			final MapperS<NonTransferableProduct> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			output = thenArg
				.mapSingleToItem(item -> {
					final Boolean boolean0 = qualify_AssetClass_InterestRate.evaluate(economicTermsForProduct.evaluate(item.get()));
					if ((boolean0 == null ? false : boolean0)) {
						return MapperS.of(CommonAssetClass.INTR);
					}
					final Boolean boolean1 = qualify_AssetClass_Credit.evaluate(economicTermsForProduct.evaluate(item.get()));
					if ((boolean1 == null ? false : boolean1)) {
						return MapperS.of(CommonAssetClass.CRDT);
					}
					final Boolean boolean2 = qualify_AssetClass_Equity.evaluate(economicTermsForProduct.evaluate(item.get()));
					if ((boolean2 == null ? false : boolean2)) {
						return MapperS.of(CommonAssetClass.EQUI);
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isSingleCommodityPayoutProduct.evaluate(item.get())))).getOrDefault(false)) {
						return MapperS.of(CommonAssetClass.COMM);
					}
					final Boolean boolean3 = qualify_AssetClass_ForeignExchange.evaluate(economicTermsForProduct.evaluate(item.get()));
					if ((boolean3 == null ? false : boolean3)) {
						return MapperS.of(CommonAssetClass.CURR);
					}
					return MapperS.<CommonAssetClass>ofNull();
				}).get();
			
			return output;
		}
	}
}
