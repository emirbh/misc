package drr.regulation.common.trade.contract.reports;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.util.IndexDeepPathUtil;
import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.qualification.functions.Qualify_AssetClass_Credit;
import cdm.product.qualification.functions.Qualify_AssetClass_Equity;
import cdm.product.qualification.functions.Qualify_AssetClass_ForeignExchange;
import cdm.product.qualification.functions.Qualify_AssetClass_InterestRate;
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.qualification.functions.Qualify_Commodity_Option_Cash;
import cdm.product.qualification.functions.Qualify_Commodity_Option_Physical;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDF;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDS;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Spot_Forward;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Swap;
import cdm.product.qualification.functions.Qualify_ForeignExchange_VanillaOption;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsVarianceSwap;
import drr.base.qualification.product.functions.IsVolatilitySwap;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.standards.iso.DeliveryTypeEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DeliveryTypeFromProductRule.DeliveryTypeFromProductRuleDefault.class)
public abstract class DeliveryTypeFromProductRule implements ReportFunction<NonTransferableProduct, DeliveryTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IndexDeepPathUtil indexDeepPathUtil;
	@Inject protected IsVarianceSwap isVarianceSwap;
	@Inject protected IsVolatilitySwap isVolatilitySwap;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;
	@Inject protected Qualify_AssetClass_Credit qualify_AssetClass_Credit;
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;
	@Inject protected Qualify_AssetClass_ForeignExchange qualify_AssetClass_ForeignExchange;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;
	@Inject protected Qualify_Commodity_Option_Cash qualify_Commodity_Option_Cash;
	@Inject protected Qualify_Commodity_Option_Physical qualify_Commodity_Option_Physical;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;
	@Inject protected Qualify_ForeignExchange_NDF qualify_ForeignExchange_NDF;
	@Inject protected Qualify_ForeignExchange_NDS qualify_ForeignExchange_NDS;
	@Inject protected Qualify_ForeignExchange_Spot_Forward qualify_ForeignExchange_Spot_Forward;
	@Inject protected Qualify_ForeignExchange_Swap qualify_ForeignExchange_Swap;
	@Inject protected Qualify_ForeignExchange_VanillaOption qualify_ForeignExchange_VanillaOption;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public DeliveryTypeEnum evaluate(NonTransferableProduct input) {
		DeliveryTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract DeliveryTypeEnum doEvaluate(NonTransferableProduct input);

	public static class DeliveryTypeFromProductRuleDefault extends DeliveryTypeFromProductRule {
		@Override
		protected DeliveryTypeEnum doEvaluate(NonTransferableProduct input) {
			DeliveryTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected DeliveryTypeEnum assignOutput(DeliveryTypeEnum output, NonTransferableProduct input) {
			final Boolean boolean0 = qualify_AssetClass_InterestRate.evaluate(economicTermsForProduct.evaluate(input));
			if ((boolean0 == null ? false : boolean0)) {
				output = DeliveryTypeEnum.PHYS;
			} else {
				final Boolean boolean1 = qualify_AssetClass_Equity.evaluate(economicTermsForProduct.evaluate(input));
				if ((boolean1 == null ? false : boolean1)) {
					if (ComparisonResult.ofNullSafe(MapperS.of(isVarianceSwap.evaluate(input))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isVolatilitySwap.evaluate(input)))).orNullSafe(areEqual(MapperS.of(input).<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy()).<FieldWithMetaAssetClassEnum>map("getPrimaryAssetClass", productTaxonomy -> productTaxonomy.getPrimaryAssetClass()).<AssetClassEnum>map("Type coercion", fieldWithMetaAssetClassEnum -> fieldWithMetaAssetClassEnum.getValue()), MapperS.of(AssetClassEnum.EQUITY), CardinalityOperator.Any)).orNullSafe(areEqual(MapperS.of(underlierForProduct.evaluate(input)).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetClassEnum>map("chooseAssetClass", index -> indexDeepPathUtil.chooseAssetClass(index)), MapperS.of(AssetClassEnum.EQUITY), CardinalityOperator.All)).getOrDefault(false)) {
						output = DeliveryTypeEnum.CASH;
					} else {
						output = null;
					}
				} else {
					final Boolean boolean2 = qualify_AssetClass_Credit.evaluate(economicTermsForProduct.evaluate(input));
					if ((boolean2 == null ? false : boolean2)) {
						output = DeliveryTypeEnum.OPTL;
					} else {
						final Boolean boolean3 = qualify_AssetClass_ForeignExchange.evaluate(economicTermsForProduct.evaluate(input));
						if ((boolean3 == null ? false : boolean3)) {
							if (ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDF.evaluate(economicTermsForProduct.evaluate(input)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDS.evaluate(economicTermsForProduct.evaluate(input))))).getOrDefault(false)) {
								output = DeliveryTypeEnum.CASH;
							} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Swap.evaluate(economicTermsForProduct.evaluate(input)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Spot_Forward.evaluate(economicTermsForProduct.evaluate(input))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_VanillaOption.evaluate(economicTermsForProduct.evaluate(input))))).getOrDefault(false)) {
								output = DeliveryTypeEnum.PHYS;
							} else {
								output = null;
							}
						} else {
							final Boolean boolean4 = qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(input));
							if ((boolean4 == null ? false : boolean4)) {
								if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTermsForProduct.evaluate(input)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTermsForProduct.evaluate(input))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Option_Cash.evaluate(economicTermsForProduct.evaluate(input))))).getOrDefault(false)) {
									output = DeliveryTypeEnum.CASH;
								} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Forward.evaluate(economicTermsForProduct.evaluate(input)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Option_Physical.evaluate(economicTermsForProduct.evaluate(input))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swaption.evaluate(economicTermsForProduct.evaluate(input))))).getOrDefault(false)) {
									output = DeliveryTypeEnum.PHYS;
								} else {
									output = null;
								}
							} else {
								output = null;
							}
						}
					}
				}
			}
			
			return output;
		}
	}
}
