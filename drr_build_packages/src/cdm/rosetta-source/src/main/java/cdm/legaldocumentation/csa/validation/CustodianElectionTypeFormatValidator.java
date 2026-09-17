package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CustodianElection;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CustodianElectionTypeFormatValidator implements Validator<CustodianElection> {

	private List<ComparisonResult> getComparisonResults(CustodianElection o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodianElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustodianElection", ValidationResult.ValidationType.TYPE_FORMAT, "CustodianElection", path, "", res.getError());
				}
				return success("CustodianElection", ValidationResult.ValidationType.TYPE_FORMAT, "CustodianElection", path, "");
			})
			.collect(toList());
	}

}
