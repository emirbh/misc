package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbINDP;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbINDPValidator implements Validator<AnnaDsbINDP> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbINDP o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("CSTR", (AnnaDsbEmpty) o.getCSTR() != null ? 1 : 0, 0, 1), 
				checkCardinality("MFTG", (AnnaDsbEmpty) o.getMFTG() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbINDP o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbINDP", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbINDP", path, "", res.getError());
				}
				return success("AnnaDsbINDP", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbINDP", path, "");
			})
			.collect(toList());
	}

}
