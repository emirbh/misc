package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.math.RoundingDirectionEnum;
import cdm.base.math.functions.RoundToPrecision;
import cdm.event.common.TradeState;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.trade.functions.TradeStateForEvent;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import drr.standards.iosco.cde.version3.payment.functions.IsOtherPayment;
import drr.standards.iosco.cde.version3.payment.reports.OtherPaymentAmountRule;
import drr.standards.iosco.cde.version3.payment.reports.OtherPaymentCurrencyRule;
import drr.standards.iosco.cde.version3.payment.reports.OtherPaymentDateRule;
import drr.standards.iosco.cde.version3.payment.reports.OtherPaymentTypeRule;
import drr.standards.iso.PaymentType4Code;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentRule.OtherPaymentRuleDefault.class)
public abstract class OtherPaymentRule implements ReportFunction<TransactionReportInstruction, List<? extends OtherPayment>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected IsOtherPayment isOtherPayment;
	@Inject protected OtherPaymentAmountRule otherPaymentAmountRule;
	@Inject protected OtherPaymentCurrencyRule otherPaymentCurrencyRule;
	@Inject protected OtherPaymentDateRule otherPaymentDateRule;
	@Inject protected OtherPaymentPayerFormatRule otherPaymentPayerFormatRule;
	@Inject protected OtherPaymentPayerRule otherPaymentPayerRule;
	@Inject protected OtherPaymentPayerSchemeNameRule otherPaymentPayerSchemeNameRule;
	@Inject protected OtherPaymentReceiverFormatRule otherPaymentReceiverFormatRule;
	@Inject protected OtherPaymentReceiverRule otherPaymentReceiverRule;
	@Inject protected OtherPaymentReceiverSchemeNameRule otherPaymentReceiverSchemeNameRule;
	@Inject protected OtherPaymentTypeRule otherPaymentTypeRule;
	@Inject protected RoundToPrecision roundToPrecision;
	@Inject protected TradeStateForEvent tradeStateForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends OtherPayment> evaluate(TransactionReportInstruction input) {
		List<OtherPayment.OtherPaymentBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends OtherPayment> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(OtherPayment::build).collect(Collectors.toList());
			objectValidator.validate(OtherPayment.class, output);
		}
		
		return output;
	}

	protected abstract List<OtherPayment.OtherPaymentBuilder> doEvaluate(TransactionReportInstruction input);

	public static class OtherPaymentRuleDefault extends OtherPaymentRule {
		@Override
		protected List<OtherPayment.OtherPaymentBuilder> doEvaluate(TransactionReportInstruction input) {
			List<OtherPayment.OtherPaymentBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<OtherPayment.OtherPaymentBuilder> assignOutput(List<OtherPayment.OtherPaymentBuilder> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableActionForHKMA.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).get());
			output = toBuilder(thenArg
				.mapSingleToList(transactionReportInstruction -> {
					final MapperS<TradeState> thenArg0 = MapperS.of(tradeStateForEvent.evaluate(thenArg.get()));
					final MapperC<TransferState> thenArg1 = thenArg0
						.mapSingleToList(item -> item.<TransferState>mapC("getTransferHistory", tradeState -> tradeState.getTransferHistory()));
					final MapperC<TransferState> thenArg2 = thenArg1
						.filterItemNullSafe(item -> isOtherPayment.evaluate(item.get()));
					return thenArg2
						.mapItem(item -> {
							final MapperS<BigDecimal> _thenArg0 = MapperS.of(otherPaymentAmountRule.evaluate(item.get()));
							final MapperS<BigDecimal> _thenArg1 = _thenArg0
								.mapSingleToItem(_item -> MapperS.of(roundToPrecision.evaluate(_item.get(), 5, RoundingDirectionEnum.NEAREST, false)));
							return MapperS.of(OtherPayment.builder()
								.setPaymentType(MapperS.of(otherPaymentTypeRule.evaluate(item.get())).checkedMap("to-enum", e -> PaymentType4Code.valueOf(e.name()), IllegalArgumentException.class).get())
								.setAmount(MapperS.of(formatToShortFraction5DecimalNumber.evaluate(_thenArg1.get())).get())
								.setCurrency(otherPaymentCurrencyRule.evaluate(item.get()))
								.setDate(otherPaymentDateRule.evaluate(item.get()))
								.setPayer(otherPaymentPayerRule.evaluate(item.get()))
								.setPayerFormat(otherPaymentPayerFormatRule.evaluate(item.get()))
								.setReceiver(otherPaymentReceiverRule.evaluate(item.get()))
								.setReceiverFormat(otherPaymentReceiverFormatRule.evaluate(item.get()))
								.setPayerSchemeName(otherPaymentPayerSchemeNameRule.evaluate(item.get()))
								.setReceiverSchemeName(otherPaymentReceiverSchemeNameRule.evaluate(item.get()))
								.build());
						});
				}).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
