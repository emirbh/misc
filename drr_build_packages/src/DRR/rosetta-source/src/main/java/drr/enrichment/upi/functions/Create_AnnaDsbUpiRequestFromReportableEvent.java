package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.qualification.product.functions.IsIRSwaption;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.enrichment.upi.AnnaDsbUpiRequestAndType;
import drr.enrichment.upi.AnnaDsbUpiRequestTypeEnum;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_AnnaDsbUpiRequestFromReportableEvent.Create_AnnaDsbUpiRequestFromReportableEventDefault.class)
public abstract class Create_AnnaDsbUpiRequestFromReportableEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_AnnaDsbUpiRequestFromReportableEventAndUnderlying create_AnnaDsbUpiRequestFromReportableEventAndUnderlying;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsIRSwaption isIRSwaption;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return request 
	*/
	public AnnaDsbUpiRequestAndType evaluate(ReportableEventBase reportableEvent) {
		AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder requestBuilder = doEvaluate(reportableEvent);
		
		final AnnaDsbUpiRequestAndType request;
		if (requestBuilder == null) {
			request = null;
		} else {
			request = requestBuilder.build();
			objectValidator.validate(AnnaDsbUpiRequestAndType.class, request);
		}
		
		return request;
	}

	protected abstract AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperS<Boolean> isSwaption(ReportableEventBase reportableEvent);

	protected abstract MapperS<Boolean> underlyingRequestNeeded(ReportableEventBase reportableEvent);

	public static class Create_AnnaDsbUpiRequestFromReportableEventDefault extends Create_AnnaDsbUpiRequestFromReportableEvent {
		@Override
		protected AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder doEvaluate(ReportableEventBase reportableEvent) {
			AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder request = AnnaDsbUpiRequestAndType.builder();
			return assignOutput(request, reportableEvent);
		}
		
		protected AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder assignOutput(AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder request, ReportableEventBase reportableEvent) {
			final AnnaDsbUpiRequestTypeEnum ifThenElseResult;
			if (underlyingRequestNeeded(reportableEvent).getOrDefault(false)) {
				ifThenElseResult = AnnaDsbUpiRequestTypeEnum.UNDERLYING_PRODUCT_REQUEST;
			} else {
				ifThenElseResult = AnnaDsbUpiRequestTypeEnum.PRODUCT_REQUEST;
			}
			request
				.setRequestType(ifThenElseResult);
			
			request
				.setRequest(create_AnnaDsbUpiRequestFromReportableEventAndUnderlying.evaluate(reportableEvent));
			
			return Optional.ofNullable(request)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			return MapperS.of(productForTrade.evaluate(tradeForEvent.evaluate(reportableEvent)));
		}
		
		@Override
		protected MapperS<Boolean> isSwaption(ReportableEventBase reportableEvent) {
			final MapperS<? extends NonTransferableProduct> thenArg = product(reportableEvent);
			return ComparisonResult.ofNullSafe(MapperS.of(isCreditSwaption.evaluate(thenArg.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isIRSwaption.evaluate(thenArg.get())))).asMapper();
		}
		
		@Override
		protected MapperS<Boolean> underlyingRequestNeeded(ReportableEventBase reportableEvent) {
			final MapperC<ProductIdentifier> thenArg = MapperS.of(product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()), MapperS.of(ProductIdTypeEnum.UPI), CardinalityOperator.All).get());
			return ComparisonResult.ofNullSafe(isSwaption(reportableEvent)).andNullSafe(ComparisonResult.ofNullSafe(notExists(thenArg).asMapper())).asMapper();
		}
	}
}
