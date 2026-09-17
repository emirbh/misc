package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.PostingObligations;
import cdm.legaldocumentation.csa.PostingObligationsElection;
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

public class PostingObligationsValidator implements Validator<PostingObligations> {

	private List<ComparisonResult> getComparisonResults(PostingObligations o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("securityProvider", (String) o.getSecurityProvider() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyElection", (List<? extends PostingObligationsElection>) o.getPartyElection() == null ? 0 : o.getPartyElection().size(), 1, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PostingObligations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PostingObligations", ValidationResult.ValidationType.CARDINALITY, "PostingObligations", path, "", res.getError());
				}
				return success("PostingObligations", ValidationResult.ValidationType.CARDINALITY, "PostingObligations", path, "");
			})
			.collect(toList());
	}

}
