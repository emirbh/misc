package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.PortfolioName;
import fpml.consolidated.msg.PortfolioConstituentReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PortfolioConstituentReferenceValidator implements Validator<PortfolioConstituentReference> {

	private List<ComparisonResult> getComparisonResults(PortfolioConstituentReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("portfolioName", (PortfolioName) o.getPortfolioName() != null ? 1 : 0, 0, 1), 
				checkCardinality("sequenceNumber", (Integer) o.getSequenceNumber() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioConstituentReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioConstituentReference", ValidationResult.ValidationType.CARDINALITY, "PortfolioConstituentReference", path, "", res.getError());
				}
				return success("PortfolioConstituentReference", ValidationResult.ValidationType.CARDINALITY, "PortfolioConstituentReference", path, "");
			})
			.collect(toList());
	}

}
