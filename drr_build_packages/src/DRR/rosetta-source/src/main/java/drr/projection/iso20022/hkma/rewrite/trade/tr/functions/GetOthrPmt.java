package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.payment.OtherPayment;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.regulation.common.HKTRPartyScheme;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.standards.iso.PaymentType4Code;
import iso20022.auth030.hkma.tr.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.hkma.tr.AmountAndDirection106__3;
import iso20022.auth030.hkma.tr.GenericIdentification175__1;
import iso20022.auth030.hkma.tr.NaturalPersonIdentification2__1;
import iso20022.auth030.hkma.tr.OtherPayment5__1;
import iso20022.auth030.hkma.tr.PartyIdentification236Choice__1;
import iso20022.auth030.hkma.tr.PaymentType5Choice__1;
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
	public List<? extends OtherPayment5__1> evaluate(HKMATransactionReport drrReport) {
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

	protected abstract List<OtherPayment5__1.OtherPayment5__1Builder> doEvaluate(HKMATransactionReport drrReport);

	public static class GetOthrPmtDefault extends GetOthrPmt {
		@Override
		protected List<OtherPayment5__1.OtherPayment5__1Builder> doEvaluate(HKMATransactionReport drrReport) {
			List<OtherPayment5__1.OtherPayment5__1Builder> othrPmt = new ArrayList<>();
			return assignOutput(othrPmt, drrReport);
		}
		
		protected List<OtherPayment5__1.OtherPayment5__1Builder> assignOutput(List<OtherPayment5__1.OtherPayment5__1Builder> othrPmt, HKMATransactionReport drrReport) {
			othrPmt.addAll(toBuilder(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", hKMATransactionReport -> hKMATransactionReport.getOtherPayment())
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
							.setTp(item.<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()).checkedMap("to-enum", e -> iso20022.auth030.hkma.tr.PaymentType4Code.valueOf(e.name()), IllegalArgumentException.class).get())
							.build())
						.setPmtAmt(AmountAndDirection106__3.builder()
							.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
								.setValue(item.<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount()).get())
								.setCcy(item.<ISOCurrencyCodeEnum>map("getCurrency", otherPayment -> otherPayment.getCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
								.build())
							.build())
						.setPmtDt(item.<Date>map("getDate", otherPayment -> otherPayment.getDate()).get())
						.setPmtPyer(PartyIdentification236Choice__1.builder()
							.setLgl(create_OrganisationIdentification15Choice__3.evaluate(item.<PartyIdentifierFormatEnum>map("getPayerFormat", otherPayment -> otherPayment.getPayerFormat()).checkedMap("to-enum", e -> PartyIdentifierFormat2Enum.valueOf(e.name()), IllegalArgumentException.class).get(), item.<String>map("getPayer", otherPayment -> otherPayment.getPayer()).get(), item.<String>map("getPayerSchemeName", otherPayment -> otherPayment.getPayerSchemeName()).checkedMap("to-enum", HKTRPartyScheme::fromDisplayName, IllegalArgumentException.class).get()))
							.setNtrl(NaturalPersonIdentification2__1.builder()
								.setId(GenericIdentification175__1.builder()
									.setId(ifThenElseResult0)
									.build())
								.build())
							.build())
						.setPmtRcvr(PartyIdentification236Choice__1.builder()
							.setLgl(create_OrganisationIdentification15Choice__3.evaluate(item.<PartyIdentifierFormatEnum>map("getReceiverFormat", otherPayment -> otherPayment.getReceiverFormat()).checkedMap("to-enum", e -> PartyIdentifierFormat2Enum.valueOf(e.name()), IllegalArgumentException.class).get(), item.<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()).get(), item.<String>map("getReceiverSchemeName", otherPayment -> otherPayment.getReceiverSchemeName()).checkedMap("to-enum", HKTRPartyScheme::fromDisplayName, IllegalArgumentException.class).get()))
							.setNtrl(NaturalPersonIdentification2__1.builder()
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
