package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbCDSIndex;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbCDSIndexValidator implements Validator<AnnaDsbCDSIndex> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbCDSIndex o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("UnderlierIDSource", (AnnaDsbUnderlierIDSourceEnum) o.getUnderlierIDSource() != null ? 1 : 0, 1, 1), 
				checkCardinality("UnderlyingInstrumentIndexTermValue", (Integer) o.getUnderlyingInstrumentIndexTermValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingCreditIndexSeries", (Integer) o.getUnderlyingCreditIndexSeries() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierID", (String) o.getUnderlierID() != null ? 1 : 0, 1, 1), 
				checkCardinality("UnderlyingInstrumentIndexTermUnit", (AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getUnderlyingInstrumentIndexTermUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingCreditIndexVersion", (Integer) o.getUnderlyingCreditIndexVersion() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbCDSIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbCDSIndex", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbCDSIndex", path, "", res.getError());
				}
				return success("AnnaDsbCDSIndex", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbCDSIndex", path, "");
			})
			.collect(toList());
	}

}
