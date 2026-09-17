package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.VersionedContractId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class VersionedContractIdTypeFormatValidator implements Validator<VersionedContractId> {

	private List<ComparisonResult> getComparisonResults(VersionedContractId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("version", o.getVersion(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VersionedContractId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VersionedContractId", ValidationResult.ValidationType.TYPE_FORMAT, "VersionedContractId", path, "", res.getError());
				}
				return success("VersionedContractId", ValidationResult.ValidationType.TYPE_FORMAT, "VersionedContractId", path, "");
			})
			.collect(toList());
	}

}
