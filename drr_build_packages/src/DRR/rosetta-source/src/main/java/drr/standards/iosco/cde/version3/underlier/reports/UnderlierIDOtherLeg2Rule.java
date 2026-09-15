package drr.standards.iosco.cde.version3.underlier.reports;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.FilterAssetIdentifier;
import drr.regulation.common.functions.GetOtherUnderlierLeg2;
import drr.regulation.common.functions.GetUnderlierProductIdentifierLeg2;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlierIDOtherLeg2Rule.UnderlierIDOtherLeg2RuleDefault.class)
public abstract class UnderlierIDOtherLeg2Rule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterAssetIdentifier filterAssetIdentifier;
	@Inject protected GetOtherUnderlierLeg2 getOtherUnderlierLeg2;
	@Inject protected GetUnderlierProductIdentifierLeg2 getUnderlierProductIdentifierLeg2;
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class UnderlierIDOtherLeg2RuleDefault extends UnderlierIDOtherLeg2Rule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			final MapperS<NonTransferableProduct> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			output = thenArg
				.mapSingleToItem(item -> {
					if (exists(MapperC.<AssetIdentifier>of(getUnderlierProductIdentifierLeg2.evaluate(item.get()))).andNullSafe(notExists(MapperS.of(filterAssetIdentifier.evaluate(getUnderlierProductIdentifierLeg2.evaluate(item.get()), AssetIdTypeEnum.ISIN)))).getOrDefault(false)) {
						return MapperC.<AssetIdentifier>of(getUnderlierProductIdentifierLeg2.evaluate(item.get()))
							.first().<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue());
					}
					if (exists(MapperS.of(getOtherUnderlierLeg2.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(getOtherUnderlierLeg2.evaluate(item.get()));
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
