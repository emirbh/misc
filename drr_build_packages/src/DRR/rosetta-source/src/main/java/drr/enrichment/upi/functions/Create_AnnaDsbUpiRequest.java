package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.ReportableInformation;
import drr.standards.iosco.upi.AnnaDsbUpiRequest;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_AnnaDsbUpiRequest.Create_AnnaDsbUpiRequestDefault.class)
public abstract class Create_AnnaDsbUpiRequest implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_AnnaDsbUpiRequestFromReportableEventAndUnderlying create_AnnaDsbUpiRequestFromReportableEventAndUnderlying;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param originatingWorkflowStep 
	* @param reportableInformation 
	* @param reportableTrade 
	* @return request 
	*/
	public AnnaDsbUpiRequest evaluate(WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation, TradeState reportableTrade) {
		AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder requestBuilder = doEvaluate(originatingWorkflowStep, reportableInformation, reportableTrade);
		
		final AnnaDsbUpiRequest request;
		if (requestBuilder == null) {
			request = null;
		} else {
			request = requestBuilder.build();
			objectValidator.validate(AnnaDsbUpiRequest.class, request);
		}
		
		return request;
	}

	protected abstract AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder doEvaluate(WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation, TradeState reportableTrade);

	protected abstract MapperS<Boolean> needToRequestUpi(WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation, TradeState reportableTrade);

	public static class Create_AnnaDsbUpiRequestDefault extends Create_AnnaDsbUpiRequest {
		@Override
		protected AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder doEvaluate(WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation, TradeState reportableTrade) {
			AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder request = AnnaDsbUpiRequest.builder();
			return assignOutput(request, originatingWorkflowStep, reportableInformation, reportableTrade);
		}
		
		protected AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder assignOutput(AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder request, WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation, TradeState reportableTrade) {
			request = toBuilder(create_AnnaDsbUpiRequestFromReportableEventAndUnderlying.evaluate(ReportableEvent.builder()
				.setOriginatingWorkflowStep(originatingWorkflowStep)
				.setReportableInformation(reportableInformation)
				.setReportableTrade(reportableTrade)
				.setReportablePosition(null)
				.build()));
			
			return Optional.ofNullable(request)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<Boolean> needToRequestUpi(WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation, TradeState reportableTrade) {
			final MapperS<NonTransferableProduct> thenArg = MapperS.of(productForTrade.evaluate(tradeForEvent.evaluate(ReportableEvent.builder()
				.setOriginatingWorkflowStep(originatingWorkflowStep)
				.setReportableInformation(reportableInformation)
				.setReportableTrade(reportableTrade)
				.setReportablePosition(null)
				.build())));
			return notEqual(thenArg.<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier()).<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()), MapperS.of(ProductIdTypeEnum.ISIN), CardinalityOperator.All).asMapper();
		}
	}
}
