package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbCredit;
import drr.standards.iosco.upi.AnnaDsbDebtSeniorityEnum;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierCharacteristicEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbCreditValidator implements Validator<AnnaDsbCredit> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbCredit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ReturnorPayoutTrigger", (AnnaDsbReturnorPayoutTriggerEnum) o.getReturnorPayoutTrigger() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierCharacteristic", (AnnaDsbUnderlierCharacteristicEnum) o.getUnderlierCharacteristic() != null ? 1 : 0, 0, 1), 
				checkCardinality("DebtSeniority", (AnnaDsbDebtSeniorityEnum) o.getDebtSeniority() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndexTermUnit", (AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getUnderlyingInstrumentIndexTermUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentISIN", (String) o.getUnderlyingInstrumentISIN() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingCreditIndexVersion", (Integer) o.getUnderlyingCreditIndexVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndexTermValue", (Integer) o.getUnderlyingInstrumentIndexTermValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingCreditIndexSeries", (Integer) o.getUnderlyingCreditIndexSeries() != null ? 1 : 0, 0, 1), 
				checkCardinality("Underlying", (AnnaDsbUnderlying) o.getUnderlying() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndexProp", (String) o.getUnderlyingInstrumentIndexProp() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndex", (String) o.getUnderlyingInstrumentIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierName", (String) o.getUnderlierName() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentLEI", (String) o.getUnderlyingInstrumentLEI() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbCredit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbCredit", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbCredit", path, "", res.getError());
				}
				return success("AnnaDsbCredit", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbCredit", path, "");
			})
			.collect(toList());
	}

}
