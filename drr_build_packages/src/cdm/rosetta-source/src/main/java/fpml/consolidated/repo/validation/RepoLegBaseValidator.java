package fpml.consolidated.repo.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.RepoLegBase;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RepoLegBaseValidator implements Validator<RepoLegBase> {

	private List<ComparisonResult> getComparisonResults(RepoLegBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (AdjustableOrRelativeDate) o.getSettlementDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoLegBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepoLegBase", ValidationResult.ValidationType.CARDINALITY, "RepoLegBase", path, "", res.getError());
				}
				return success("RepoLegBase", ValidationResult.ValidationType.CARDINALITY, "RepoLegBase", path, "");
			})
			.collect(toList());
	}

}
