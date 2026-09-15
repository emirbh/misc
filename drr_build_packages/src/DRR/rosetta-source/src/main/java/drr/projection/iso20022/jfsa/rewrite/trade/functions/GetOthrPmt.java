package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.payment.OtherPayment;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.PaymentType4Code;
import iso20022.auth030.jfsa.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.jfsa.AmountAndDirection106__2;
import iso20022.auth030.jfsa.GenericIdentification175__1;
import iso20022.auth030.jfsa.NaturalPersonIdentification2__1;
import iso20022.auth030.jfsa.OrganisationIdentification15Choice__2;
import iso20022.auth030.jfsa.OtherPayment5__1;
import iso20022.auth030.jfsa.PartyIdentification236Choice__1;
import iso20022.auth030.jfsa.PaymentType5Choice__1;
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

	/**
	* @param drrReport 
	* @return othrPmt 
	*/
	public List<? extends OtherPayment5__1> evaluate(JFSATransactionReport drrReport) {
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

	protected abstract List<OtherPayment5__1.OtherPayment5__1Builder> doEvaluate(JFSATransactionReport drrReport);

	public static class GetOthrPmtDefault extends GetOthrPmt {
		@Override
		protected List<OtherPayment5__1.OtherPayment5__1Builder> doEvaluate(JFSATransactionReport drrReport) {
			List<OtherPayment5__1.OtherPayment5__1Builder> othrPmt = new ArrayList<>();
			return assignOutput(othrPmt, drrReport);
		}
		
		protected List<OtherPayment5__1.OtherPayment5__1Builder> assignOutput(List<OtherPayment5__1.OtherPayment5__1Builder> othrPmt, JFSATransactionReport drrReport) {
			othrPmt.addAll(toBuilder(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", jFSATransactionReport -> jFSATransactionReport.getOtherPayment())
				.mapItem(item -> {
					OrganisationIdentification15Choice__2 ifThenElseResult0 = null;
					if (areEqual(item.<PartyIdentifierFormatEnum>map("getPayerFormat", otherPayment -> otherPayment.getPayerFormat()), MapperS.of(PartyIdentifierFormatEnum.LEI), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult0 = OrganisationIdentification15Choice__2.builder()
							.setLei(item.<String>map("getPayer", otherPayment -> otherPayment.getPayer()).get())
							.build();
					}
					NaturalPersonIdentification2__1 ifThenElseResult1 = null;
					if (areEqual(item.<PartyIdentifierFormatEnum>map("getPayerFormat", otherPayment -> otherPayment.getPayerFormat()), MapperS.of(PartyIdentifierFormatEnum.LEI_AND_PERSON), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult1 = NaturalPersonIdentification2__1.builder()
							.setId(GenericIdentification175__1.builder()
								.setId(item.<String>map("getPayer", otherPayment -> otherPayment.getPayer()).get())
								.build())
							.build();
					}
					OrganisationIdentification15Choice__2 ifThenElseResult2 = null;
					if (areEqual(item.<PartyIdentifierFormatEnum>map("getReceiverFormat", otherPayment -> otherPayment.getReceiverFormat()), MapperS.of(PartyIdentifierFormatEnum.LEI), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult2 = OrganisationIdentification15Choice__2.builder()
							.setLei(item.<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()).get())
							.build();
					}
					NaturalPersonIdentification2__1 ifThenElseResult3 = null;
					if (areEqual(item.<PartyIdentifierFormatEnum>map("getReceiverFormat", otherPayment -> otherPayment.getReceiverFormat()), MapperS.of(PartyIdentifierFormatEnum.LEI_AND_PERSON), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult3 = NaturalPersonIdentification2__1.builder()
							.setId(GenericIdentification175__1.builder()
								.setId(item.<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()).get())
								.build())
							.build();
					}
					return MapperS.of(OtherPayment5__1.builder()
						.setPmtTp(PaymentType5Choice__1.builder()
							.setTp(item.<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()).checkedMap("to-enum", e -> iso20022.auth030.jfsa.PaymentType4Code.valueOf(e.name()), IllegalArgumentException.class).get())
							.build())
						.setPmtAmt(AmountAndDirection106__2.builder()
							.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
								.setValue(item.<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount()).get())
								.setCcy(item.<ISOCurrencyCodeEnum>map("getCurrency", otherPayment -> otherPayment.getCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
								.build())
							.build())
						.setPmtDt(item.<Date>map("getDate", otherPayment -> otherPayment.getDate()).get())
						.setPmtPyer(PartyIdentification236Choice__1.builder()
							.setLgl(ifThenElseResult0)
							.setNtrl(ifThenElseResult1)
							.build())
						.setPmtRcvr(PartyIdentification236Choice__1.builder()
							.setLgl(ifThenElseResult2)
							.setNtrl(ifThenElseResult3)
							.build())
						.build());
				}).getMulti()));
			
			return Optional.ofNullable(othrPmt)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
