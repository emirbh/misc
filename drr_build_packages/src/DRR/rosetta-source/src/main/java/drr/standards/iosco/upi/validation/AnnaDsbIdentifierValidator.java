package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbIdentifier;
import drr.standards.iosco.upi.AnnaDsbStatusEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbIdentifierValidator implements Validator<AnnaDsbIdentifier> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("Status", (AnnaDsbStatusEnum) o.getStatus() != null ? 1 : 0, 1, 1), 
				checkCardinality("LastUpdateDateTime", (String) o.getLastUpdateDateTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("StatusReason", (String) o.getStatusReason() != null ? 1 : 0, 0, 1), 
				checkCardinality("UPI", (String) o.getUPI() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbIdentifier", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbIdentifier", path, "", res.getError());
				}
				return success("AnnaDsbIdentifier", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbIdentifier", path, "");
			})
			.collect(toList());
	}

}
