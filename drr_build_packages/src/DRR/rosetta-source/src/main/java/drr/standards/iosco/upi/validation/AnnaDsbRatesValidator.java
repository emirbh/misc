package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlying;
import drr.standards.iosco.upi.AnnaDsbRates;
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

public class AnnaDsbRatesValidator implements Validator<AnnaDsbRates> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbRates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ReturnorPayoutTrigger", (AnnaDsbReturnorPayoutTriggerEnum) o.getReturnorPayoutTrigger() != null ? 1 : 0, 0, 1), 
				checkCardinality("ReferenceRate", (String) o.getReferenceRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierCharacteristic", (String) o.getUnderlierCharacteristic() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentISIN", (String) o.getUnderlyingInstrumentISIN() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegReferenceRateTermUnit", (AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getOtherLegReferenceRateTermUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("NotionalCurrency", (String) o.getNotionalCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegUnderlying", (AnnaDsbOtherLegUnderlying) o.getOtherLegUnderlying() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherNotionalCurrency", (String) o.getOtherNotionalCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("ReferenceRateTermUnit", (AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getReferenceRateTermUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegReferenceRateTermValue", (Integer) o.getOtherLegReferenceRateTermValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegReferenceRate", (String) o.getOtherLegReferenceRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("Underlying", (AnnaDsbUnderlying) o.getUnderlying() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegUnderlierCharacteristic", (AnnaDsbUnderlierCharacteristicEnum) o.getOtherLegUnderlierCharacteristic() != null ? 1 : 0, 0, 1), 
				checkCardinality("ReferenceRateTermValue", (Integer) o.getReferenceRateTermValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierName", (String) o.getUnderlierName() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbRates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbRates", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbRates", path, "", res.getError());
				}
				return success("AnnaDsbRates", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbRates", path, "");
			})
			.collect(toList());
	}

}
