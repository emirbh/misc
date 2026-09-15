package drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.payment.OtherPayment;
import drr.base.trade.price.PriceFormat;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCTransactionReport;
import drr.regulation.common.trade.CommonLeg;
import drr.standards.iso.PaymentType4Code;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(RequiresUpFrontFeeProjection.RequiresUpFrontFeeProjectionDefault.class)
public abstract class RequiresUpFrontFeeProjection implements RosettaFunction {

	/**
	* @param drrReport 
	* @return result 
	*/
	public Boolean evaluate(CFTCTransactionReport drrReport) {
		Boolean result = doEvaluate(drrReport);
		
		return result;
	}

	protected abstract Boolean doEvaluate(CFTCTransactionReport drrReport);

	public static class RequiresUpFrontFeeProjectionDefault extends RequiresUpFrontFeeProjection {
		@Override
		protected Boolean doEvaluate(CFTCTransactionReport drrReport) {
			Boolean result = null;
			return assignOutput(result, drrReport);
		}
		
		protected Boolean assignOutput(Boolean result, CFTCTransactionReport drrReport) {
			result = notExists(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cFTCTransactionReport -> cFTCTransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType())).andNullSafe(areEqual(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.CREDIT), CardinalityOperator.All)).andNullSafe(notExists(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()))).andNullSafe(notExists(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()))).get();
			
			return result;
		}
	}
}
