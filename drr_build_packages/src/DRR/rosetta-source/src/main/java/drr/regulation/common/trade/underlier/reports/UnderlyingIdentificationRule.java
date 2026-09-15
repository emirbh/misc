package drr.regulation.common.trade.underlier.reports;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.qualification.product.functions.IsIRSwaption;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.base.trade.underlier.functions.UnderlierProductIdentifier;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingIdentificationRule.UnderlyingIdentificationRuleDefault.class)
public abstract class UnderlyingIdentificationRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsIRSwaption isIRSwaption;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;
	@Inject protected UnderlierProductIdentifier underlierProductIdentifier;

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

	public static class UnderlyingIdentificationRuleDefault extends UnderlyingIdentificationRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg;
			if (ComparisonResult.ofNullSafe(MapperS.of(isCreditSwaption.evaluate(productForEvent.evaluate(input)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isIRSwaption.evaluate(productForEvent.evaluate(input))))).getOrDefault(false)) {
				thenArg = MapperS.of(underlierForProduct.evaluate(productForEvent.evaluate(input))).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct());
			} else {
				thenArg = MapperS.of(productForEvent.evaluate(input));
			}
			final FieldWithMetaString fieldWithMetaString = thenArg
				.mapSingleToItem(item -> {
					if (exists(MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), AssetIdTypeEnum.ISIN))).getOrDefault(false)) {
						return MapperS.of(MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), AssetIdTypeEnum.ISIN)).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).get());
					}
					return MapperS.<FieldWithMetaString>ofNull();
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
