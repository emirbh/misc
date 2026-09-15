package drr.regulation.common.functions;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.RelativeDateOffset;
import cdm.base.datetime.functions.AddBusinessDays;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.product.common.schedule.ResetDates;
import cdm.product.qualification.functions.Qualify_InterestRate_Fra;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.datetime.reports.EffectiveDateRule;
import drr.standards.iosco.cde.version3.datetime.reports.ExpirationDateRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetExpirationDate.GetExpirationDateDefault.class)
public abstract class GetExpirationDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected AddBusinessDays addBusinessDays;
	@Inject protected EffectiveDateRule effectiveDateRule;
	@Inject protected ExpirationDateRule expirationDateRule;
	@Inject protected InterestRateLeg2 interestRateLeg2;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_InterestRate_Fra qualify_InterestRate_Fra;

	/**
	* @param transactionReportInstruction 
	* @return expirationDate 
	*/
	public Date evaluate(TransactionReportInstruction transactionReportInstruction) {
		Date expirationDate = doEvaluate(transactionReportInstruction);
		
		return expirationDate;
	}

	protected abstract Date doEvaluate(TransactionReportInstruction transactionReportInstruction);

	protected abstract MapperS<? extends NonTransferableProduct> product(TransactionReportInstruction transactionReportInstruction);

	protected abstract MapperS<? extends RelativeDateOffset> fixingDates(TransactionReportInstruction transactionReportInstruction);

	protected abstract MapperS<Integer> periodMultiplier(TransactionReportInstruction transactionReportInstruction);

	public static class GetExpirationDateDefault extends GetExpirationDate {
		@Override
		protected Date doEvaluate(TransactionReportInstruction transactionReportInstruction) {
			Date expirationDate = null;
			return assignOutput(expirationDate, transactionReportInstruction);
		}
		
		protected Date assignOutput(Date expirationDate, TransactionReportInstruction transactionReportInstruction) {
			final Boolean _boolean = qualify_InterestRate_Fra.evaluate(product(transactionReportInstruction).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
			if ((_boolean == null ? false : _boolean)) {
				expirationDate = addBusinessDays.evaluate(effectiveDateRule.evaluate(transactionReportInstruction), periodMultiplier(transactionReportInstruction).get(), fixingDates(transactionReportInstruction).<BusinessCenters>map("getBusinessCenters", relativeDateOffset -> relativeDateOffset.getBusinessCenters()).<FieldWithMetaBusinessCenterEnum>mapC("getBusinessCenter", businessCenters -> businessCenters.getBusinessCenter()).<BusinessCenterEnum>map("Type coercion", fieldWithMetaBusinessCenterEnum -> fieldWithMetaBusinessCenterEnum.getValue()).getMulti());
			} else {
				expirationDate = expirationDateRule.evaluate(product(transactionReportInstruction).get());
			}
			
			return expirationDate;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(TransactionReportInstruction transactionReportInstruction) {
			return MapperS.of(productForEvent.evaluate(transactionReportInstruction));
		}
		
		@Override
		protected MapperS<? extends RelativeDateOffset> fixingDates(TransactionReportInstruction transactionReportInstruction) {
			return MapperS.of(interestRateLeg2.evaluate(product(transactionReportInstruction).get())).<ResetDates>map("getResetDates", interestRatePayout -> interestRatePayout.getResetDates()).<RelativeDateOffset>map("getFixingDates", resetDates -> resetDates.getFixingDates());
		}
		
		@Override
		protected MapperS<Integer> periodMultiplier(TransactionReportInstruction transactionReportInstruction) {
			if (exists(fixingDates(transactionReportInstruction).<Integer>map("getPeriodMultiplier", relativeDateOffset -> relativeDateOffset.getPeriodMultiplier())).getOrDefault(false)) {
				return fixingDates(transactionReportInstruction).<Integer>map("getPeriodMultiplier", relativeDateOffset -> relativeDateOffset.getPeriodMultiplier());
			}
			return MapperS.of(0);
		}
	}
}
