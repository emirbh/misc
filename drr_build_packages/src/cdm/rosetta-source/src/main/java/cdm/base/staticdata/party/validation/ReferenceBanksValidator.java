package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.ReferenceBank;
import cdm.base.staticdata.party.ReferenceBanks;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReferenceBanksValidator implements Validator<ReferenceBanks> {

	private List<ComparisonResult> getComparisonResults(ReferenceBanks o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceBank", (List<? extends ReferenceBank>) o.getReferenceBank() == null ? 0 : o.getReferenceBank().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceBanks o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceBanks", ValidationResult.ValidationType.CARDINALITY, "ReferenceBanks", path, "", res.getError());
				}
				return success("ReferenceBanks", ValidationResult.ValidationType.CARDINALITY, "ReferenceBanks", path, "");
			})
			.collect(toList());
	}

}
