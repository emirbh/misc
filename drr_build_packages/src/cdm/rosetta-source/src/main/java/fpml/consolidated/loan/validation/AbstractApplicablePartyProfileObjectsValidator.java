package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AbstractApplicablePartyProfileObjects;
import fpml.consolidated.loan.ApplicableAssets;
import fpml.consolidated.loan.ApplicableTransactions;
import fpml.consolidated.loan.AssociationToAssetIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AbstractApplicablePartyProfileObjectsValidator implements Validator<AbstractApplicablePartyProfileObjects> {

	private List<ComparisonResult> getComparisonResults(AbstractApplicablePartyProfileObjects o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (AssociationToAssetIdentifier) o.getIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("applicableAssets", (ApplicableAssets) o.getApplicableAssets() != null ? 1 : 0, 1, 1), 
				checkCardinality("applicableTransactions", (ApplicableTransactions) o.getApplicableTransactions() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractApplicablePartyProfileObjects o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractApplicablePartyProfileObjects", ValidationResult.ValidationType.CARDINALITY, "AbstractApplicablePartyProfileObjects", path, "", res.getError());
				}
				return success("AbstractApplicablePartyProfileObjects", ValidationResult.ValidationType.CARDINALITY, "AbstractApplicablePartyProfileObjects", path, "");
			})
			.collect(toList());
	}

}
