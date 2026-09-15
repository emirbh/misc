package drr.base.trade.payment.validation;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.payment.OtherPayment;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.standards.iso.PaymentType4Code;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OtherPaymentValidator implements Validator<OtherPayment> {

	private List<ComparisonResult> getComparisonResults(OtherPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("paymentType", (PaymentType4Code) o.getPaymentType() != null ? 1 : 0, 0, 1), 
				checkCardinality("amount", (BigDecimal) o.getAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (ISOCurrencyCodeEnum) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("date", (Date) o.getDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("payer", (String) o.getPayer() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerFormat", (PartyIdentifierFormatEnum) o.getPayerFormat() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiver", (String) o.getReceiver() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverFormat", (PartyIdentifierFormatEnum) o.getReceiverFormat() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerSchemeName", (String) o.getPayerSchemeName() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverSchemeName", (String) o.getReceiverSchemeName() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OtherPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OtherPayment", ValidationResult.ValidationType.CARDINALITY, "OtherPayment", path, "", res.getError());
				}
				return success("OtherPayment", ValidationResult.ValidationType.CARDINALITY, "OtherPayment", path, "");
			})
			.collect(toList());
	}

}
