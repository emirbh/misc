package drr.standards.iosco.cde.version1.payment.reports;

import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.UnitType;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.event.common.Transfer;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.standards.iso.functions.ConvertNonISOToISOCurrency;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentCurrencyRule.OtherPaymentCurrencyRuleDefault.class)
public abstract class OtherPaymentCurrencyRule implements ReportFunction<TransferState, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ConvertNonISOToISOCurrency convertNonISOToISOCurrency;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCurrencyCodeEnum evaluate(TransferState input) {
		ISOCurrencyCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(TransferState input);

	public static class OtherPaymentCurrencyRuleDefault extends OtherPaymentCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransferState input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransferState input) {
			final MapperS<FieldWithMetaString> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<NonNegativeQuantity>map("getQuantity", transfer -> transfer.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()));
			output = thenArg
				.mapSingleToItem(item -> {
					final FieldWithMetaString fieldWithMetaString = item.get();
					return MapperS.of(convertNonISOToISOCurrency.evaluate((fieldWithMetaString == null ? null : fieldWithMetaString.getValue())));
				}).get();
			
			return output;
		}
	}
}
