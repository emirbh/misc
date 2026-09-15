package drr.standards.iosco.cde.version1.price.reports;

import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.UnitType;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iosco.cde.version1.payment.functions.OptionPremiumOnEventDate;
import drr.standards.iso.functions.ConvertNonISOToISOCurrency;
import javax.inject.Inject;


@ImplementedBy(OptionPremiumCurrencyRule.OptionPremiumCurrencyRuleDefault.class)
public abstract class OptionPremiumCurrencyRule implements ReportFunction<TransactionReportInstructionBase, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ConvertNonISOToISOCurrency convertNonISOToISOCurrency;
	@Inject protected OptionPremiumOnEventDate optionPremiumOnEventDate;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCurrencyCodeEnum evaluate(TransactionReportInstructionBase input) {
		ISOCurrencyCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(TransactionReportInstructionBase input);

	public static class OptionPremiumCurrencyRuleDefault extends OptionPremiumCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransactionReportInstructionBase input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransactionReportInstructionBase input) {
			final MapperS<FieldWithMetaString> thenArg = MapperS.of(optionPremiumOnEventDate.evaluate(input)).<NonNegativeQuantity>map("getQuantity", transfer -> transfer.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency());
			output = thenArg
				.mapSingleToItem(item -> {
					final FieldWithMetaString fieldWithMetaString = item.get();
					return MapperS.of(convertNonISOToISOCurrency.evaluate((fieldWithMetaString == null ? null : fieldWithMetaString.getValue())));
				}).get();
			
			return output;
		}
	}
}
