package drr.projection.iso20022.esma.emir.refit.trade.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.PaymentType4Code;
import iso20022.auth030.esma.ActiveOrHistoricCurrencyAnd5DecimalAmount__1;
import iso20022.auth030.esma.AmountAndDirection106__2;
import iso20022.auth030.esma.OrganisationIdentification15Choice__1;
import iso20022.auth030.esma.OtherPayment5__1;
import iso20022.auth030.esma.PartyIdentification236Choice__1;
import iso20022.auth030.esma.PaymentType5Choice__1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(GetOthrPmt.GetOthrPmtDefault.class)
public abstract class GetOthrPmt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return othrPmt 
	*/
	public List<? extends OtherPayment5__1> evaluate(ESMAEMIRTransactionReport drrReport) {
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

	protected abstract List<OtherPayment5__1.OtherPayment5__1Builder> doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetOthrPmtDefault extends GetOthrPmt {
		@Override
		protected List<OtherPayment5__1.OtherPayment5__1Builder> doEvaluate(ESMAEMIRTransactionReport drrReport) {
			List<OtherPayment5__1.OtherPayment5__1Builder> othrPmt = new ArrayList<>();
			return assignOutput(othrPmt, drrReport);
		}
		
		protected List<OtherPayment5__1.OtherPayment5__1Builder> assignOutput(List<OtherPayment5__1.OtherPayment5__1Builder> othrPmt, ESMAEMIRTransactionReport drrReport) {
			othrPmt.addAll(toBuilder(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getOtherPayment())
				.mapItem(item -> MapperS.of(OtherPayment5__1.builder()
					.setPmtTp(PaymentType5Choice__1.builder()
						.setTp(item.<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()).checkedMap("to-enum", e -> iso20022.auth030.esma.PaymentType4Code.valueOf(e.name()), IllegalArgumentException.class).get())
						.build())
					.setPmtAmt(AmountAndDirection106__2.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount__1.builder()
							.setValue(item.<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount()).get())
							.setCcy(item.<ISOCurrencyCodeEnum>map("getCurrency", otherPayment -> otherPayment.getCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.build())
					.setPmtDt(item.<Date>map("getDate", otherPayment -> otherPayment.getDate()).get())
					.setPmtPyer(PartyIdentification236Choice__1.builder()
						.setLgl(OrganisationIdentification15Choice__1.builder()
							.setLei(item.<String>map("getPayer", otherPayment -> otherPayment.getPayer()).get())
							.build())
						.build())
					.setPmtRcvr(PartyIdentification236Choice__1.builder()
						.setLgl(OrganisationIdentification15Choice__1.builder()
							.setLei(item.<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()).get())
							.build())
						.build())
					.build())).getMulti()));
			
			return Optional.ofNullable(othrPmt)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
