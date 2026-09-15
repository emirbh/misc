package drr.regulation.mas.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.product.qualification.functions.Qualify_AssetClass_ForeignExchange;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCommodity;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierProductIdentifier;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractCommodityClassification;
import drr.regulation.common.functions.ExtractProductIdentifierBySource;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingIdOtherSourceDTCCRule.UnderlyingIdOtherSourceDTCCRuleDefault.class)
public abstract class UnderlyingIdOtherSourceDTCCRule implements ReportFunction<TransactionReportInstruction, AssetIdTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ExtractCommodityClassification extractCommodityClassification;
	@Inject protected ExtractProductIdentifierBySource extractProductIdentifierBySource;
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected IsCommodity isCommodity;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_ForeignExchange qualify_AssetClass_ForeignExchange;
	@Inject protected UnderlierProductIdentifier underlierProductIdentifier;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public AssetIdTypeEnum evaluate(TransactionReportInstruction input) {
		AssetIdTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract AssetIdTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class UnderlyingIdOtherSourceDTCCRuleDefault extends UnderlyingIdOtherSourceDTCCRule {
		@Override
		protected AssetIdTypeEnum doEvaluate(TransactionReportInstruction input) {
			AssetIdTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected AssetIdTypeEnum assignOutput(AssetIdTypeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			final MapperS<NonTransferableProduct> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			final MapperS<NonTransferableProduct> thenArg2 = thenArg1
				.filterSingleNullSafe(item -> areEqual(MapperS.of(qualify_AssetClass_ForeignExchange.evaluate(economicTermsForProduct.evaluate(item.get()))), MapperS.of(false), CardinalityOperator.All).get());
			output = thenArg2
				.mapSingleToItem(item -> {
					final Boolean _boolean = isCommodity.evaluate(item.get());
					if ((_boolean == null ? false : _boolean)) {
						final MapperS<String> _thenArg0 = MapperS.of(extractCommodityClassification.evaluate(economicTermsForProduct.evaluate(item.get()), TaxonomySourceEnum.MAS, 1));
						final MapperS<AssetIdTypeEnum> ifThenElseResult;
						if (areEqual(MapperC.<String>of(MapperS.of("GROS"), MapperS.of("DIRY"), MapperS.of("LSTK"), MapperS.of("FRST"), MapperS.of("SOFT"), MapperS.of("OILP"), MapperS.of("NGAS"), MapperS.of("COAL"), MapperS.of("ELEC"), MapperS.of("INRG"), MapperS.of("PRME"), MapperS.of("NPRM"), MapperS.of("WTHR"), MapperS.of("EMIS"), MapperS.of("FRGT")), _thenArg0, CardinalityOperator.Any).getOrDefault(false)) {
							ifThenElseResult = _thenArg0.checkedMap("to-enum", AssetIdTypeEnum::fromDisplayName, IllegalArgumentException.class);
						} else if (exists(_thenArg0).getOrDefault(false)) {
							ifThenElseResult = MapperS.of(AssetIdTypeEnum.OTHER);
						} else {
							ifThenElseResult = MapperS.<AssetIdTypeEnum>ofNull();
						}
						return ifThenElseResult;
					}
					if (notExists(MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), AssetIdTypeEnum.ISIN))).andNullSafe(exists(MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), null)))).getOrDefault(false)) {
						final MapperC<AssetIdentifier> _thenArg1 = MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), null));
						final MapperS<AssetIdentifier> _thenArg2 = MapperS.of(extractProductIdentifierBySource.evaluate(_thenArg1.getMulti()));
						return _thenArg2.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType());
					}
					return MapperS.<AssetIdTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
