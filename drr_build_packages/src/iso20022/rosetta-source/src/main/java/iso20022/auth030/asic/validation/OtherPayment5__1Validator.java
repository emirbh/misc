package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.AmountAndDirection106__3;
import iso20022.auth030.asic.OtherPayment5__1;
import iso20022.auth030.asic.PartyIdentification236Choice__1;
import iso20022.auth030.asic.PaymentType5Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OtherPayment5__1Validator implements Validator<OtherPayment5__1> {

	private List<ComparisonResult> getComparisonResults(OtherPayment5__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("pmtAmt", (AmountAndDirection106__3) o.getPmtAmt() != null ? 1 : 0, 0, 1), 
				checkCardinality("pmtTp", (PaymentType5Choice__1) o.getPmtTp() != null ? 1 : 0, 0, 1), 
				checkCardinality("pmtDt", (Date) o.getPmtDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("pmtPyer", (PartyIdentification236Choice__1) o.getPmtPyer() != null ? 1 : 0, 0, 1), 
				checkCardinality("pmtRcvr", (PartyIdentification236Choice__1) o.getPmtRcvr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OtherPayment5__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OtherPayment5__1", ValidationResult.ValidationType.CARDINALITY, "OtherPayment5__1", path, "", res.getError());
				}
				return success("OtherPayment5__1", ValidationResult.ValidationType.CARDINALITY, "OtherPayment5__1", path, "");
			})
			.collect(toList());
	}

}
