package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbAdditionalSubProduct;
import drr.standards.iosco.upi.AnnaDsbMETL;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbMETLValidator implements Validator<AnnaDsbMETL> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbMETL o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("NPRM", (AnnaDsbAdditionalSubProduct) o.getNPRM() != null ? 1 : 0, 0, 1), 
				checkCardinality("PRME", (AnnaDsbAdditionalSubProduct) o.getPRME() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbMETL o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbMETL", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbMETL", path, "", res.getError());
				}
				return success("AnnaDsbMETL", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbMETL", path, "");
			})
			.collect(toList());
	}

}
