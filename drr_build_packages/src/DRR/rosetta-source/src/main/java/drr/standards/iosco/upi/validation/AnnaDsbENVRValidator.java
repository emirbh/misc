package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbAdditionalSubProduct;
import drr.standards.iosco.upi.AnnaDsbENVR;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbENVRValidator implements Validator<AnnaDsbENVR> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbENVR o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("CRBR", (AnnaDsbEmpty) o.getCRBR() != null ? 1 : 0, 0, 1), 
				checkCardinality("EMIS", (AnnaDsbAdditionalSubProduct) o.getEMIS() != null ? 1 : 0, 0, 1), 
				checkCardinality("WTHR", (AnnaDsbEmpty) o.getWTHR() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbENVR o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbENVR", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbENVR", path, "", res.getError());
				}
				return success("AnnaDsbENVR", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbENVR", path, "");
			})
			.collect(toList());
	}

}
