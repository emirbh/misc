package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.JapaneseSecuritiesProvisions;
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

public class JapaneseSecuritiesProvisionsValidator implements Validator<JapaneseSecuritiesProvisions> {

	private List<ComparisonResult> getComparisonResults(JapaneseSecuritiesProvisions o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isApplicable", (Boolean) o.getIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("relevantProvisionsElection", (Boolean) o.getRelevantProvisionsElection() != null ? 1 : 0, 0, 1), 
				checkCardinality("relevantProvisionsTerms", (String) o.getRelevantProvisionsTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("amendmentsToJapaneseProvisions", (Boolean) o.getAmendmentsToJapaneseProvisions() != null ? 1 : 0, 0, 1), 
				checkCardinality("amendmentsToJapaneseProvisionsTerms", (String) o.getAmendmentsToJapaneseProvisionsTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearstreamAmendmentToJapaneseProvisions", (Boolean) o.getClearstreamAmendmentToJapaneseProvisions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, JapaneseSecuritiesProvisions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("JapaneseSecuritiesProvisions", ValidationResult.ValidationType.CARDINALITY, "JapaneseSecuritiesProvisions", path, "", res.getError());
				}
				return success("JapaneseSecuritiesProvisions", ValidationResult.ValidationType.CARDINALITY, "JapaneseSecuritiesProvisions", path, "");
			})
			.collect(toList());
	}

}
