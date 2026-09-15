package drr.standards.iosco.cde.version1.basket.reports;

import cdm.product.asset.CreditDefaultPayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.basket.CustomBasket;
import drr.base.trade.basket.functions.CreditBasketIdentifier;
import drr.base.trade.basket.functions.UnderlierBasketIdentifier;
import drr.base.trade.functions.ProductForEvent;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CustomBasketCodeRule.CustomBasketCodeRuleDefault.class)
public abstract class CustomBasketCodeRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CreditBasketIdentifier creditBasketIdentifier;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected UnderlierBasketIdentifier underlierBasketIdentifier;

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

	public static class CustomBasketCodeRuleDefault extends CustomBasketCodeRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(item.<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<CustomBasket>map("getCustomBasket", reportableInformationBase -> reportableInformationBase.getCustomBasket()).<String>map("getCustomBasketCode", customBasket -> customBasket.getCustomBasketCode())).getOrDefault(false)) {
						return item.<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<CustomBasket>map("getCustomBasket", reportableInformationBase -> reportableInformationBase.getCustomBasket()).<String>map("getCustomBasketCode", customBasket -> customBasket.getCustomBasketCode());
					}
					final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(productForEvent.evaluate(item.get()));
					final MapperC<Payout> thenArg1 = thenArg0.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout());
					final MapperC<String> thenArg2 = thenArg1
						.mapItem(_item -> {
							if (_item.get() == null) {
								return MapperS.<String>ofNull();
							}
							if (_item.<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get() != null) {
								final MapperS<SettlementPayout> settlementPayout = _item.<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout());
								return MapperS.of(underlierBasketIdentifier.evaluate(settlementPayout.<Underlier>map("getUnderlier", _settlementPayout -> _settlementPayout.getUnderlier()).get()));
							}
							if (_item.<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get() != null) {
								final MapperS<OptionPayout> optionPayout = _item.<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout());
								return MapperS.of(underlierBasketIdentifier.evaluate(optionPayout.<Underlier>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).get()));
							}
							if (_item.<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get() != null) {
								final MapperS<PerformancePayout> performancePayout = _item.<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout());
								return MapperS.of(underlierBasketIdentifier.evaluate(performancePayout.<Underlier>map("getUnderlier", _performancePayout -> _performancePayout.getUnderlier()).get()));
							}
							if (_item.<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).get() != null) {
								final MapperS<CreditDefaultPayout> creditDefaultPayout = _item.<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout());
								return MapperS.of(creditBasketIdentifier.evaluate(creditDefaultPayout.get()));
							}
							return MapperS.<String>ofNull();
						});
					return MapperS.of(thenArg2.get());
				}).get();
			
			return output;
		}
	}
}
