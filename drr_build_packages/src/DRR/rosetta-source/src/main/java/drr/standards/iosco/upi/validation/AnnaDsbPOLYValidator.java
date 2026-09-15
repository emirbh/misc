package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbPOLY;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbPOLYValidator implements Validator<AnnaDsbPOLY> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbPOLY o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("PLST", (AnnaDsbEmpty) o.getPLST() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbPOLY o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbPOLY", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbPOLY", path, "", res.getError());
				}
				return success("AnnaDsbPOLY", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbPOLY", path, "");
			})
			.collect(toList());
	}

}
