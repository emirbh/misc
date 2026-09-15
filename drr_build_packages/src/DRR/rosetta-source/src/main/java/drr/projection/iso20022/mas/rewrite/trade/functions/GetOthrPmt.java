package drr.projection.iso20022.mas.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.payment.OtherPayment;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.PaymentType4Code;
import iso20022.auth030.mas.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.mas.AmountAndDirection106__3;
import iso20022.auth030.mas.GenericIdentification175__1;
import iso20022.auth030.mas.NaturalPersonIdentification2__2;
import iso20022.auth030.mas.OtherPayment5__1;
import iso20022.auth030.mas.PartyIdentification236Choice__1;
import iso20022.auth030.mas.PaymentType5Choice__1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetOthrPmt.GetOthrPmtDefault.class)
public abstract class GetOthrPmt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__3 create_OrganisationIdentification15Choice__3;

	/**
	* @param drrReport 
	* @return othrPmt 
	*/
	public List<? extends OtherPayment5__1> evaluate(MASTransactionReport drrReport) {
		List<OtherPayment5__1.OtherPayment5__1Builder> othrPmtBuilder = doEvaluate(drrReport);
		
		final List<? extends OtherPayment5__1> othrPmt;
		if (othrPmtBuilder == null) {
			othrPmt = null;
		} else {
			othrPmt = othrPmtBuilder.stream().map(OtherPayment5__1::build).collect(Collectors.toList());
			objectValidator.validate(OtherPayment5__1.class, othrPmt);
		}
		
		return othrPmt;
	}

	protected abstract List<OtherPayment5__1.OtherPayment5__1Builder> doEvaluate(MASTransactionReport drrReport);

	public static class GetOthrPmtDefault extends GetOthrPmt {
		@Override
		protected List<OtherPayment5__1.OtherPayment5__1Builder> doEvaluate(MASTransactionReport drrReport) {
			List<OtherPayment5__1.OtherPayment5__1Builder> othrPmt = new ArrayList<>();
			return assignOutput(othrPmt, drrReport);
		}
		
		protected List<OtherPayment5__1.OtherPayment5__1Builder> assignOutput(List<OtherPayment5__1.OtherPayment5__1Builder> othrPmt, MASTransactionReport drrReport) {
			othrPmt.addAll(toBuilder(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", mASTransactionReport -> mASTransactionReport.getOtherPayment())
				.mapItem(item -> {
					String ifThenElseResult0 = null;
					if (areEqual(item.<PartyIdentifierFormatEnum>map("getPayerFormat", otherPayment -> otherPayment.getPayerFormat()), MapperS.of(PartyIdentifierFormatEnum.LEI_AND_PERSON), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult0 = item.<String>map("getPayer", otherPayment -> otherPayment.getPayer()).get();
					}
					String ifThenElseResult1 = null;
					if (areEqual(item.<PartyIdentifierFormatEnum>map("getReceiverFormat", otherPayment -> otherPayment.getReceiverFormat()), MapperS.of(PartyIdentifierFormatEnum.LEI_AND_PERSON), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult1 = item.<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()).get();
					}
					return MapperS.of(OtherPayment5__1.builder()
						.setPmtTp(PaymentType5Choice__1.builder()
							.setTp(item.<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()).checkedMap("to-enum", e -> iso20022.auth030.mas.PaymentType4Code.valueOf(e.name()), IllegalArgumentException.class).get())
							.build())
						.setPmtAmt(AmountAndDirection106__3.builder()
							.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
								.setValue(item.<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount()).get())
								.setCcy(item.<ISOCurrencyCodeEnum>map("getCurrency", otherPayment -> otherPayment.getCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
								.build())
							.build())
						.setPmtPyer(PartyIdentification236Choice__1.builder()
							.setLgl(create_OrganisationIdentification15Choice__3.evaluate(areEqual(item.<PartyIdentifierFormatEnum>map("getPayerFormat", otherPayment -> otherPayment.getPayerFormat()), MapperS.of(PartyIdentifierFormatEnum.LEI), CardinalityOperator.All).get(), item.<String>map("getPayer", otherPayment -> otherPayment.getPayer()).get()))
							.setNtrl(NaturalPersonIdentification2__2.builder()
								.setId(GenericIdentification175__1.builder()
									.setId(ifThenElseResult0)
									.build())
								.build())
							.build())
						.setPmtDt(item.<Date>map("getDate", otherPayment -> otherPayment.getDate()).get())
						.setPmtRcvr(PartyIdentification236Choice__1.builder()
							.setLgl(create_OrganisationIdentification15Choice__3.evaluate(areEqual(item.<PartyIdentifierFormatEnum>map("getReceiverFormat", otherPayment -> otherPayment.getReceiverFormat()), MapperS.of(PartyIdentifierFormatEnum.LEI), CardinalityOperator.All).get(), item.<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()).get()))
							.setNtrl(NaturalPersonIdentification2__2.builder()
								.setId(GenericIdentification175__1.builder()
									.setId(ifThenElseResult1)
									.build())
								.build())
							.build())
						.build());
				}).getMulti()));
			
			return Optional.ofNullable(othrPmt)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
