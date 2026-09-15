package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbAttributes;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbUpiRequest;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbUpiRequestValidator implements Validator<AnnaDsbUpiRequest> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbUpiRequest o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("Header", (AnnaDsbHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("Attributes", (AnnaDsbAttributes) o.getAttributes() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbUpiRequest o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbUpiRequest", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbUpiRequest", path, "", res.getError());
				}
				return success("AnnaDsbUpiRequest", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbUpiRequest", path, "");
			})
			.collect(toList());
	}

}
