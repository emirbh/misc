package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbAdditionalSubProduct;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbFRGT;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbFRGTValidator implements Validator<AnnaDsbFRGT> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbFRGT o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("CSHP", (AnnaDsbEmpty) o.getCSHP() != null ? 1 : 0, 0, 1), 
				checkCardinality("WETF", (AnnaDsbAdditionalSubProduct) o.getWETF() != null ? 1 : 0, 0, 1), 
				checkCardinality("DRYF", (AnnaDsbAdditionalSubProduct) o.getDRYF() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbFRGT o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbFRGT", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbFRGT", path, "", res.getError());
				}
				return success("AnnaDsbFRGT", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbFRGT", path, "");
			})
			.collect(toList());
	}

}
