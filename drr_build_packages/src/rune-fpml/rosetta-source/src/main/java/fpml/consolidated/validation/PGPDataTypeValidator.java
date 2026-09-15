package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.PGPDataType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PGPDataTypeValidator implements Validator<PGPDataType> {

	private List<ComparisonResult> getComparisonResults(PGPDataType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("pgpKeyID", (String) o.getPgpKeyID() != null ? 1 : 0, 0, 1), 
				checkCardinality("pgpKeyPacket", (String) o.getPgpKeyPacket() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PGPDataType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PGPDataType", ValidationResult.ValidationType.CARDINALITY, "PGPDataType", path, "", res.getError());
				}
				return success("PGPDataType", ValidationResult.ValidationType.CARDINALITY, "PGPDataType", path, "");
			})
			.collect(toList());
	}

}
