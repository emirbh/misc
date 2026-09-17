package fpml.consolidated.repo.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Bond;
import fpml.consolidated.asset.ConvertibleBond;
import fpml.consolidated.asset.EquityAsset;
import fpml.consolidated.repo.RepoChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RepoChoiceValidator implements Validator<RepoChoice> {

	private List<ComparisonResult> getComparisonResults(RepoChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("bond", (Bond) o.getBond() != null ? 1 : 0, 0, 1), 
				checkCardinality("convertibleBond", (ConvertibleBond) o.getConvertibleBond() != null ? 1 : 0, 0, 1), 
				checkCardinality("equity", (EquityAsset) o.getEquity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepoChoice", ValidationResult.ValidationType.CARDINALITY, "RepoChoice", path, "", res.getError());
				}
				return success("RepoChoice", ValidationResult.ValidationType.CARDINALITY, "RepoChoice", path, "");
			})
			.collect(toList());
	}

}
