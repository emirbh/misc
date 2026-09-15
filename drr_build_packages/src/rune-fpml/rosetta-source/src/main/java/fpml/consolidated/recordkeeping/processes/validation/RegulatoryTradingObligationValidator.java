package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.FacilityExecutionExceptionDeclaration;
import fpml.consolidated.recordkeeping.processes.RegulatoryTradingObligation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryTradingObligationValidator implements Validator<RegulatoryTradingObligation> {

	private List<ComparisonResult> getComparisonResults(RegulatoryTradingObligation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradedOnVenue", (Boolean) o.getTradedOnVenue() != null ? 1 : 0, 1, 1), 
				checkCardinality("exception", (Boolean) o.getException() != null ? 1 : 0, 0, 1), 
				checkCardinality("exceptionDeclaration", (FacilityExecutionExceptionDeclaration) o.getExceptionDeclaration() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryTradingObligation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryTradingObligation", ValidationResult.ValidationType.CARDINALITY, "RegulatoryTradingObligation", path, "", res.getError());
				}
				return success("RegulatoryTradingObligation", ValidationResult.ValidationType.CARDINALITY, "RegulatoryTradingObligation", path, "");
			})
			.collect(toList());
	}

}
