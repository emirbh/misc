package drr.standards.iosco.cde.version3.underlier.reports;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.RateSpecification;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsFRA;
import drr.base.qualification.product.functions.IsFXForward;
import drr.base.qualification.product.functions.IsFXOption;
import drr.base.qualification.product.functions.IsFXSwap;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.functions.GetUnderlierProductIdentifierLeg1;
import drr.regulation.common.functions.InterestRateLeg1;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlierIDOtherSourceLeg1Rule.UnderlierIDOtherSourceLeg1RuleDefault.class)
public abstract class UnderlierIDOtherSourceLeg1Rule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetUnderlierProductIdentifierLeg1 getUnderlierProductIdentifierLeg1;
	@Inject protected InterestRateLeg1 interestRateLeg1;
	@Inject protected IsFRA isFRA;
	@Inject protected IsFXForward isFXForward;
	@Inject protected IsFXOption isFXOption;
	@Inject protected IsFXSwap isFXSwap;
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

	public static class UnderlierIDOtherSourceLeg1RuleDefault extends UnderlierIDOtherSourceLeg1Rule {
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
					if (exists(MapperC.<AssetIdentifier>of(getUnderlierProductIdentifierLeg1.evaluate(item.get()))).andNullSafe(notEqual(MapperC.<AssetIdentifier>of(getUnderlierProductIdentifierLeg1.evaluate(item.get())).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperC.<AssetIdentifier>of(getUnderlierProductIdentifierLeg1.evaluate(item.get()))
							.first().<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()).map("to-string", AssetIdTypeEnum::toDisplayString);
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(isFRA.evaluate(item.get()))).andNullSafe(notExists(MapperS.of(interestRateLeg1.evaluate(item.get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex0 -> referenceWithMetaInterestRateIndex0 == null ? null : referenceWithMetaInterestRateIndex0.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<AssetIdentifier>mapC("getIdentifier", floatingRateIndex -> floatingRateIndex.getIdentifier()))).andNullSafe(exists(MapperS.of(interestRateLeg1.evaluate(item.get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex1 -> referenceWithMetaInterestRateIndex1 == null ? null : referenceWithMetaInterestRateIndex1.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaString>map("getName", floatingRateIndex -> floatingRateIndex.getName()))).getOrDefault(false)) {
						return MapperS.of(ProductIdTypeEnum.NAME).map("to-string", ProductIdTypeEnum::toDisplayString);
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(isFXForward.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXOption.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXSwap.evaluate(item.get())))).getOrDefault(false)) {
						return MapperS.of("CCY");
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
