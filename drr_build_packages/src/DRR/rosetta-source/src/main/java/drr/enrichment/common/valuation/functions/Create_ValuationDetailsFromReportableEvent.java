package drr.enrichment.common.valuation.functions;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.TradeIdentifier;
import cdm.event.common.Valuation;
import cdm.event.common.ValuationSourceEnum;
import cdm.event.common.ValuationTypeEnum;
import cdm.observable.asset.Money;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.qualification.event.functions.IsActionTypeVALU;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.functions.TradableProductForEvent;
import drr.base.trade.functions.TradeForEvent;
import drr.base.trade.valuation.functions.GetValuation;
import drr.enrichment.common.trade.functions.Create_ReportableEventFromInstruction;
import drr.regulation.common.LastFloatingReference;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationTradeInformation;
import drr.regulation.common.functions.FilterResetHistoryByLeg;
import drr.regulation.common.functions.GetLastFloatingReferenceResetDate;
import drr.regulation.common.functions.GetLastFloatingReferenceValue;
import drr.regulation.common.functions.InterestRateLeg1;
import drr.regulation.common.functions.InterestRateLeg2;
import drr.regulation.common.trade.contract.reports.AssetClassRule;
import drr.regulation.common.trade.functions.PayoutFromProductLeg1;
import drr.regulation.common.trade.functions.PayoutFromProductLeg2;
import drr.regulation.common.trade.payment.reports.NextFloatingReferenceResetDateRule;
import drr.regulation.csa.rewrite.trade.functions.IsCSALeg1Aligned;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_ValuationDetailsFromReportableEvent.Create_ValuationDetailsFromReportableEventDefault.class)
public abstract class Create_ValuationDetailsFromReportableEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected AssetClassRule assetClassRule;
	@Inject protected Create_ReportableEventFromInstruction create_ReportableEventFromInstruction;
	@Inject protected FilterResetHistoryByLeg filterResetHistoryByLeg;
	@Inject protected GetLastFloatingReferenceResetDate getLastFloatingReferenceResetDate;
	@Inject protected GetLastFloatingReferenceValue getLastFloatingReferenceValue;
	@Inject protected GetValuation getValuation;
	@Inject protected InterestRateLeg1 interestRateLeg1;
	@Inject protected InterestRateLeg2 interestRateLeg2;
	@Inject protected IsActionTypeVALU isActionTypeVALU;
	@Inject protected IsCSALeg1Aligned isCSALeg1Aligned;
	@Inject protected NextFloatingReferenceResetDateRule nextFloatingReferenceResetDateRule;
	@Inject protected PayoutFromProductLeg1 payoutFromProductLeg1;
	@Inject protected PayoutFromProductLeg2 payoutFromProductLeg2;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected TradableProductForEvent tradableProductForEvent;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @param regimeNameEnum 
	* @return enrichedValuationDetails 
	*/
	public ValuationDetails evaluate(ReportableEvent reportableEvent, RegimeNameEnum regimeNameEnum) {
		ValuationDetails.ValuationDetailsBuilder enrichedValuationDetailsBuilder = doEvaluate(reportableEvent, regimeNameEnum);
		
		final ValuationDetails enrichedValuationDetails;
		if (enrichedValuationDetailsBuilder == null) {
			enrichedValuationDetails = null;
		} else {
			enrichedValuationDetails = enrichedValuationDetailsBuilder.build();
			objectValidator.validate(ValuationDetails.class, enrichedValuationDetails);
		}
		
		return enrichedValuationDetails;
	}

	protected abstract ValuationDetails.ValuationDetailsBuilder doEvaluate(ReportableEvent reportableEvent, RegimeNameEnum regimeNameEnum);

	protected abstract MapperS<? extends ReportableEvent> enrichedReportableEvent(ReportableEvent reportableEvent, RegimeNameEnum regimeNameEnum);

	public static class Create_ValuationDetailsFromReportableEventDefault extends Create_ValuationDetailsFromReportableEvent {
		@Override
		protected ValuationDetails.ValuationDetailsBuilder doEvaluate(ReportableEvent reportableEvent, RegimeNameEnum regimeNameEnum) {
			ValuationDetails.ValuationDetailsBuilder enrichedValuationDetails = ValuationDetails.builder();
			return assignOutput(enrichedValuationDetails, reportableEvent, regimeNameEnum);
		}
		
		protected ValuationDetails.ValuationDetailsBuilder assignOutput(ValuationDetails.ValuationDetailsBuilder enrichedValuationDetails, ReportableEvent reportableEvent, RegimeNameEnum regimeNameEnum) {
			final MapperC<TradeIdentifier> thenArg;
			if (exists(MapperS.of(tradeForEvent.evaluate(reportableEvent))).getOrDefault(false)) {
				thenArg = MapperS.of(tradeForEvent.evaluate(reportableEvent)).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier())
					.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.All).get());
			} else {
				thenArg = MapperC.<TradeIdentifier>ofNull();
			}
			final List<ProductIdentifier> ifThenElseResult0;
			if (exists(MapperS.of(tradeForEvent.evaluate(reportableEvent))).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(tradeForEvent.evaluate(reportableEvent)).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier()).getMulti();
			} else {
				ifThenElseResult0 = Collections.<ProductIdentifier>emptyList();
			}
			final Boolean _boolean = isActionTypeVALU.evaluate(reportableEvent);
			ActionTypeEnum ifThenElseResult1 = null;
			if ((_boolean == null ? false : _boolean)) {
				ifThenElseResult1 = ActionTypeEnum.VALU;
			}
			final Date ifThenElseResult2;
			if (areEqual(MapperS.of(regimeNameEnum), MapperS.of(RegimeNameEnum.CSA), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isCSALeg1Aligned.evaluate(reportableEvent)), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult2 = nextFloatingReferenceResetDateRule.evaluate(interestRateLeg2.evaluate(productForEvent.evaluate(reportableEvent)));
			} else {
				ifThenElseResult2 = nextFloatingReferenceResetDateRule.evaluate(interestRateLeg1.evaluate(productForEvent.evaluate(reportableEvent)));
			}
			final Date ifThenElseResult3;
			if (areEqual(MapperS.of(regimeNameEnum), MapperS.of(RegimeNameEnum.CSA), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isCSALeg1Aligned.evaluate(reportableEvent)), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult3 = nextFloatingReferenceResetDateRule.evaluate(interestRateLeg1.evaluate(productForEvent.evaluate(reportableEvent)));
			} else {
				ifThenElseResult3 = nextFloatingReferenceResetDateRule.evaluate(interestRateLeg2.evaluate(productForEvent.evaluate(reportableEvent)));
			}
			final PayoutLegWithAuxiliary ifThenElseResult4;
			if (areEqual(MapperS.of(regimeNameEnum), MapperS.of(RegimeNameEnum.CSA), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isCSALeg1Aligned.evaluate(reportableEvent)), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult4 = payoutFromProductLeg2.evaluate(MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<NonTransferableProduct>map("getProduct", tradableProduct -> tradableProduct.getProduct()).get(), MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).get(), MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", _reportableEvent -> _reportableEvent.getReportableInformation()).get());
			} else {
				ifThenElseResult4 = payoutFromProductLeg1.evaluate(MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<NonTransferableProduct>map("getProduct", tradableProduct -> tradableProduct.getProduct()).get(), MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).get(), MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", _reportableEvent -> _reportableEvent.getReportableInformation()).get());
			}
			final PayoutLegWithAuxiliary ifThenElseResult5;
			if (areEqual(MapperS.of(regimeNameEnum), MapperS.of(RegimeNameEnum.CSA), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isCSALeg1Aligned.evaluate(reportableEvent)), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult5 = payoutFromProductLeg1.evaluate(MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<NonTransferableProduct>map("getProduct", tradableProduct -> tradableProduct.getProduct()).get(), MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).get(), MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", _reportableEvent -> _reportableEvent.getReportableInformation()).get());
			} else {
				ifThenElseResult5 = payoutFromProductLeg2.evaluate(MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<NonTransferableProduct>map("getProduct", tradableProduct -> tradableProduct.getProduct()).get(), MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).get(), MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", _reportableEvent -> _reportableEvent.getReportableInformation()).get());
			}
			final PayoutLegWithAuxiliary ifThenElseResult6;
			if (areEqual(MapperS.of(regimeNameEnum), MapperS.of(RegimeNameEnum.CSA), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isCSALeg1Aligned.evaluate(reportableEvent)), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult6 = payoutFromProductLeg2.evaluate(MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<NonTransferableProduct>map("getProduct", tradableProduct -> tradableProduct.getProduct()).get(), MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).get(), MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", _reportableEvent -> _reportableEvent.getReportableInformation()).get());
			} else {
				ifThenElseResult6 = payoutFromProductLeg1.evaluate(MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<NonTransferableProduct>map("getProduct", tradableProduct -> tradableProduct.getProduct()).get(), MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).get(), MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", _reportableEvent -> _reportableEvent.getReportableInformation()).get());
			}
			final PayoutLegWithAuxiliary ifThenElseResult7;
			if (areEqual(MapperS.of(regimeNameEnum), MapperS.of(RegimeNameEnum.CSA), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isCSALeg1Aligned.evaluate(reportableEvent)), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult7 = payoutFromProductLeg1.evaluate(MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<NonTransferableProduct>map("getProduct", tradableProduct -> tradableProduct.getProduct()).get(), MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).get(), MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", _reportableEvent -> _reportableEvent.getReportableInformation()).get());
			} else {
				ifThenElseResult7 = payoutFromProductLeg2.evaluate(MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<NonTransferableProduct>map("getProduct", tradableProduct -> tradableProduct.getProduct()).get(), MapperS.of(tradableProductForEvent.evaluate(reportableEvent)).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).get(), MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", _reportableEvent -> _reportableEvent.getReportableInformation()).get());
			}
			enrichedValuationDetails = toBuilder(ValuationDetails.builder()
				.setValuation(Valuation.builder()
					.setAmount(MapperS.of(getValuation.evaluate(reportableEvent)).<Money>map("getAmount", valuation -> valuation.getAmount()).get())
					.setTimestamp(MapperS.of(getValuation.evaluate(reportableEvent)).<ZonedDateTime>map("getTimestamp", valuation -> valuation.getTimestamp()).get())
					.setMethod(MapperS.of(getValuation.evaluate(reportableEvent)).<ValuationTypeEnum>map("getMethod", valuation -> valuation.getMethod()).get())
					.setSource(MapperS.of(getValuation.evaluate(reportableEvent)).<ValuationSourceEnum>map("getSource", valuation -> valuation.getSource()).get())
					.setDelta(MapperS.of(getValuation.evaluate(reportableEvent)).<BigDecimal>map("getDelta", valuation -> valuation.getDelta()).get())
					.build())
				.setTradeInformation(ValuationTradeInformation.builder()
					.setUniqueTradeIdentifier(MapperS.of(distinctIgnoringPrecision(thenArg).get()).get())
					.setUniqueProductIdentifier(ifThenElseResult0)
					.setAction(ifThenElseResult1)
					.setNextFloatingReferenceResetDateLeg1(ifThenElseResult2)
					.setNextFloatingReferenceResetDateLeg2(ifThenElseResult3)
					.setLastFloatingReference(LastFloatingReference.builder()
						.setLastFloatingReferenceResetDateLeg1(getLastFloatingReferenceResetDate.evaluate(filterResetHistoryByLeg.evaluate(reportableEvent, ifThenElseResult4)))
						.setLastFloatingReferenceResetDateLeg2(getLastFloatingReferenceResetDate.evaluate(filterResetHistoryByLeg.evaluate(reportableEvent, ifThenElseResult5)))
						.setLastFloatingReferenceValueLeg1(getLastFloatingReferenceValue.evaluate(filterResetHistoryByLeg.evaluate(reportableEvent, ifThenElseResult6)))
						.setLastFloatingReferenceValueLeg2(getLastFloatingReferenceValue.evaluate(filterResetHistoryByLeg.evaluate(reportableEvent, ifThenElseResult7)))
						.build())
					.setAssetClass(assetClassRule.evaluate(reportableEvent))
					.build())
				.build());
			
			return Optional.ofNullable(enrichedValuationDetails)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReportableEvent> enrichedReportableEvent(ReportableEvent reportableEvent, RegimeNameEnum regimeNameEnum) {
			return MapperS.of(create_ReportableEventFromInstruction.evaluate(reportableEvent));
		}
	}
}
