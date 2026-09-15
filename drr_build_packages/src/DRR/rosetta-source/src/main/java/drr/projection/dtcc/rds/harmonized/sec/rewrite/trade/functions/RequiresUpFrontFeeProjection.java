package drr.projection.dtcc.rds.harmonized.sec.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.payment.OtherPayment;
import drr.base.trade.price.PriceFormat;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import drr.standards.iso.PaymentType4Code;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(RequiresUpFrontFeeProjection.RequiresUpFrontFeeProjectionDefault.class)
public abstract class RequiresUpFrontFeeProjection implements RosettaFunction {

	/**
	* @param drrReport 
	* @return result 
	*/
	public Boolean evaluate(SECTransactionReport drrReport) {
		Boolean result = doEvaluate(drrReport);
		
		return result;
	}

	protected abstract Boolean doEvaluate(SECTransactionReport drrReport);

	public static class RequiresUpFrontFeeProjectionDefault extends RequiresUpFrontFeeProjection {
		@Override
		protected Boolean doEvaluate(SECTransactionReport drrReport) {
			Boolean result = null;
			return assignOutput(result, drrReport);
		}
		
		protected Boolean assignOutput(Boolean result, SECTransactionReport drrReport) {
			result = notExists(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", sECTransactionReport -> sECTransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType())).andNullSafe(areEqual(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReport -> sECTransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.CREDIT), CardinalityOperator.All)).andNullSafe(notExists(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", sECLeg -> sECLeg.getFixedRate()))).andNullSafe(notExists(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()))).get();
			
			return result;
		}
	}
}
