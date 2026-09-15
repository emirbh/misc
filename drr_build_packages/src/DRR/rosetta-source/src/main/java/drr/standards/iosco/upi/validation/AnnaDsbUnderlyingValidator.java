package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbDebtSeniorityEnum;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbUnderlierCharacteristicEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierType;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetType;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbUnderlyingValidator implements Validator<AnnaDsbUnderlying> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbUnderlying o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("DebtSeniority", (AnnaDsbDebtSeniorityEnum) o.getDebtSeniority() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierCharacteristic", (AnnaDsbUnderlierCharacteristicEnum) o.getUnderlierCharacteristic() != null ? 1 : 0, 0, 1), 
				checkCardinality("ReferenceRate", (String) o.getReferenceRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierID", (String) o.getUnderlierID() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndexTermUnit", (AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getUnderlyingInstrumentIndexTermUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentISIN", (String) o.getUnderlyingInstrumentISIN() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingCreditIndexVersion", (Integer) o.getUnderlyingCreditIndexVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierType", (AnnaDsbUnderlierType) o.getUnderlierType() != null ? 1 : 0, 0, 1), 
				checkCardinality("Basket", (AnnaDsbEmpty) o.getBasket() != null ? 1 : 0, 0, 1), 
				checkCardinality("ReferenceRateTermUnit", (AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getReferenceRateTermUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingAssetType", (AnnaDsbUnderlyingAssetType) o.getUnderlyingAssetType() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierIDSource", (AnnaDsbUnderlierIDSourceEnum) o.getUnderlierIDSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndexTermValue", (Integer) o.getUnderlyingInstrumentIndexTermValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingCreditIndexSeries", (Integer) o.getUnderlyingCreditIndexSeries() != null ? 1 : 0, 0, 1), 
				checkCardinality("InstrumentISIN", (String) o.getInstrumentISIN() != null ? 1 : 0, 0, 1), 
				checkCardinality("InstrumentLEI", (String) o.getInstrumentLEI() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndex", (String) o.getUnderlyingInstrumentIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndexProp", (String) o.getUnderlyingInstrumentIndexProp() != null ? 1 : 0, 0, 1), 
				checkCardinality("ReferenceRateTermValue", (Integer) o.getReferenceRateTermValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentUPI", (String) o.getUnderlyingInstrumentUPI() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentLEI", (String) o.getUnderlyingInstrumentLEI() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbUnderlying o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbUnderlying", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbUnderlying", path, "", res.getError());
				}
				return success("AnnaDsbUnderlying", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbUnderlying", path, "");
			})
			.collect(toList());
	}

}
