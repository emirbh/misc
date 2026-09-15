package drr.regulation.jfsa.rewrite.trade.reports;

import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.qualification.functions.Qualify_AssetClass_Credit;
import cdm.product.qualification.functions.Qualify_AssetClass_Equity;
import cdm.product.qualification.functions.Qualify_AssetClass_ForeignExchange;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutForQuantityLeg2Rule;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import drr.standards.iosco.cde.version3.quantity.functions.NotionalAmountFormat;
import drr.standards.iosco.cde.version3.quantity.reports.NotionalAmountScheduleRule;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalAmountLeg2Rule.NotionalAmountLeg2RuleDefault.class)
public abstract class NotionalAmountLeg2Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
	@Inject protected NotionalAmountFormat notionalAmountFormat;
	@Inject protected NotionalAmountScheduleRule notionalAmountScheduleRule;
	@Inject protected PayoutForQuantityLeg2Rule payoutForQuantityLeg2Rule;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;
	@Inject protected Qualify_AssetClass_Credit qualify_AssetClass_Credit;
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;
	@Inject protected Qualify_AssetClass_ForeignExchange qualify_AssetClass_ForeignExchange;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstruction input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstruction input);

	public static class NotionalAmountLeg2RuleDefault extends NotionalAmountLeg2Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			final MapperS<BigDecimal> ifThenElseResult;
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(thenArg0.get()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Credit.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(thenArg0.get())))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Equity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(thenArg0.get())))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_ForeignExchange.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(thenArg0.get())))))).andNullSafe(exists(MapperC.<NotionalPeriod>of(notionalAmountScheduleRule.evaluate(payoutLeg2Rule.evaluate(thenArg0.get()))))).getOrDefault(false)) {
				final MapperS<NotionalPeriod> thenArg1 = MapperC.<NotionalPeriod>of(notionalAmountScheduleRule.evaluate(payoutLeg2Rule.evaluate(thenArg0.get())))
					.min(item -> item.<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()));
				ifThenElseResult = thenArg1.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue());
			} else {
				final BigInteger bigInteger = new BigInteger("9999999999999999999999999");
				ifThenElseResult = MapperS.of(notionalAmountFormat.evaluate(payoutForQuantityLeg2Rule.evaluate(thenArg0.get()), (bigInteger == null ? null : new BigDecimal(bigInteger))));
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
