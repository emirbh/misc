package cdm.ingest.fpml.confirmation.tradestate.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.UnitType;
import cdm.base.staticdata.identifier.IdentifiedList;
import cdm.base.staticdata.identifier.Identifier;
import cdm.event.common.ExecutionDetails;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.header.functions.MapIssuerTradeIdModelToIdentifier;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.consolidated.asset.AssetMeasureType;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.doc.PackageSummary;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.ird.Calculation;
import fpml.consolidated.ird.CalculationPeriodAmount;
import fpml.consolidated.ird.InterestRateStream;
import fpml.consolidated.ird.Notional;
import fpml.consolidated.ird.Swap;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.IssuerTradeId;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.TradeId;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapExecutionDetails.MapExecutionDetailsDefault.class)
public abstract class MapExecutionDetails implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapIssuerTradeIdModelToIdentifier mapIssuerTradeIdModelToIdentifier;

	/**
	* @param fpmlTrade 
	* @param fpmlQuoteList 
	* @return executionDetails 
	*/
	public ExecutionDetails evaluate(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList) {
		ExecutionDetails.ExecutionDetailsBuilder executionDetailsBuilder = doEvaluate(fpmlTrade, fpmlQuoteList);
		
		final ExecutionDetails executionDetails;
		if (executionDetailsBuilder == null) {
			executionDetails = null;
		} else {
			executionDetails = executionDetailsBuilder.build();
			objectValidator.validate(ExecutionDetails.class, executionDetails);
		}
		
		return executionDetails;
	}

	protected abstract ExecutionDetails.ExecutionDetailsBuilder doEvaluate(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList);

	protected abstract MapperS<? extends BasicQuotation> quotationModel(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList);

	protected abstract MapperS<? extends FieldWithMetaString> unitFromQuotation(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList);

	protected abstract MapperS<ArithmeticOperationEnum> arithmeticOp(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList);

	protected abstract MapperS<? extends FieldWithMetaString> swapStreamNotionalCurrency(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList);

	protected abstract MapperS<? extends FieldWithMetaString> unitValue(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList);

	public static class MapExecutionDetailsDefault extends MapExecutionDetails {
		@Override
		protected ExecutionDetails.ExecutionDetailsBuilder doEvaluate(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList) {
			if (fpmlQuoteList == null) {
				fpmlQuoteList = Collections.emptyList();
			}
			ExecutionDetails.ExecutionDetailsBuilder executionDetails = ExecutionDetails.builder();
			return assignOutput(executionDetails, fpmlTrade, fpmlQuoteList);
		}
		
		protected ExecutionDetails.ExecutionDetailsBuilder assignOutput(ExecutionDetails.ExecutionDetailsBuilder executionDetails, Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList) {
			final PriceTypeEnum ifThenElseResult;
			if (areEqual(quotationModel(fpmlTrade, fpmlQuoteList).<AssetMeasureType>map("getMeasureType", basicQuotation -> basicQuotation.getMeasureType()).<String>map("getValue", assetMeasureType -> assetMeasureType.getValue()), MapperS.of("PackagePrice"), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = PriceTypeEnum.CASH_PRICE;
			} else if (areEqual(quotationModel(fpmlTrade, fpmlQuoteList).<AssetMeasureType>map("getMeasureType", basicQuotation -> basicQuotation.getMeasureType()).<String>map("getValue", assetMeasureType -> assetMeasureType.getValue()), MapperS.of("PackageSpread"), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = PriceTypeEnum.INTEREST_RATE;
			} else {
				ifThenElseResult = null;
			}
			executionDetails = toBuilder(ExecutionDetails.builder()
				.setExecutionType(null)
				.setPackageReference(IdentifiedList.builder()
					.setListId(mapIssuerTradeIdModelToIdentifier.evaluate(MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PackageSummary>map("getOriginatingPackage", tradeHeader -> tradeHeader.getOriginatingPackage()).<IssuerTradeId>map("getPackageIdentifier", packageSummary -> packageSummary.getPackageIdentifier()).<IssuerId>map("getIssuer", issuerTradeId -> issuerTradeId.getIssuer()).get(), MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PackageSummary>map("getOriginatingPackage", tradeHeader -> tradeHeader.getOriginatingPackage()).<IssuerTradeId>map("getPackageIdentifier", packageSummary -> packageSummary.getPackageIdentifier()).<TradeId>map("getTradeId", issuerTradeId -> issuerTradeId.getTradeId()).get()))
					.setPrice(Price.builder()
						.setValue(quotationModel(fpmlTrade, fpmlQuoteList).<BigDecimal>map("getValue", basicQuotation -> basicQuotation.getValue()).get())
						.setUnit(UnitType.builder()
							.setCurrency(unitValue(fpmlTrade, fpmlQuoteList).get())
							.build())
						.setPerUnitOf(UnitType.builder()
							.setCurrency(unitValue(fpmlTrade, fpmlQuoteList).get())
							.build())
						.setPriceType(ifThenElseResult)
						.setArithmeticOperator(arithmeticOp(fpmlTrade, fpmlQuoteList).get())
						.build())
					.setComponentId(Collections.<Identifier>emptyList())
					.build())
				.build());
			
			return Optional.ofNullable(executionDetails)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends BasicQuotation> quotationModel(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList) {
			final MapperC<BasicQuotation> thenArg = MapperC.<BasicQuotation>of(fpmlQuoteList)
				.filterItemNullSafe(item -> areEqual(item.<AssetMeasureType>map("getMeasureType", basicQuotation -> basicQuotation.getMeasureType()).<String>map("getValue", assetMeasureType -> assetMeasureType.getValue()), MapperS.of("PackagePrice"), CardinalityOperator.All).orNullSafe(areEqual(item.<AssetMeasureType>map("getMeasureType", basicQuotation -> basicQuotation.getMeasureType()).<String>map("getValue", assetMeasureType -> assetMeasureType.getValue()), MapperS.of("PackageSpread"), CardinalityOperator.All)).get());
			return MapperS.of(thenArg.get());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> unitFromQuotation(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList) {
			if (exists(quotationModel(fpmlTrade, fpmlQuoteList).<Currency>map("getCurrency", basicQuotation -> basicQuotation.getCurrency())).getOrDefault(false)) {
				return MapperS.of(mapCurrency.evaluate(quotationModel(fpmlTrade, fpmlQuoteList).<Currency>map("getCurrency", basicQuotation -> basicQuotation.getCurrency()).get()));
			}
			return MapperS.<FieldWithMetaString>ofNull();
		}
		
		@Override
		protected MapperS<ArithmeticOperationEnum> arithmeticOp(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList) {
			if (areEqual(quotationModel(fpmlTrade, fpmlQuoteList).<AssetMeasureType>map("getMeasureType", basicQuotation -> basicQuotation.getMeasureType()).<String>map("getValue", assetMeasureType -> assetMeasureType.getValue()), MapperS.of("PackageSpread"), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(ArithmeticOperationEnum.ADD);
			}
			return MapperS.<ArithmeticOperationEnum>ofNull();
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> swapStreamNotionalCurrency(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList) {
			final Product switchArgument = MapperS.of(fpmlTrade).<Product>map("getProduct", trade -> trade.getProduct()).get();
			if (switchArgument == null) {
				return MapperS.<FieldWithMetaString>ofNull();
			}
			if (switchArgument instanceof Swap) {
				final Swap swap = (Swap) switchArgument;
				return MapperS.of(mapCurrency.evaluate(MapperS.of(swap).<InterestRateStream>mapC("getSwapStream", _swap -> _swap.getSwapStream()).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount()).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<Notional>map("getNotionalSchedule", calculation -> calculation.getNotionalSchedule()).<NonNegativeAmountSchedule>map("getNotionalStepSchedule", notional -> notional.getNotionalStepSchedule()).<Currency>map("getCurrency", nonNegativeAmountSchedule -> nonNegativeAmountSchedule.getCurrency())
					.first().get()));
			}
			return MapperS.<FieldWithMetaString>ofNull();
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> unitValue(Trade fpmlTrade, List<? extends BasicQuotation> fpmlQuoteList) {
			if (exists(quotationModel(fpmlTrade, fpmlQuoteList)).getOrDefault(false)) {
				if (exists(unitFromQuotation(fpmlTrade, fpmlQuoteList)).getOrDefault(false)) {
					return unitFromQuotation(fpmlTrade, fpmlQuoteList);
				}
				return swapStreamNotionalCurrency(fpmlTrade, fpmlQuoteList);
			}
			return MapperS.<FieldWithMetaString>ofNull();
		}
	}
}
