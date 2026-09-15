package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityPerformanceSwapEarlyTermination;
import fpml.consolidated.com.CommodityStartingDate;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityPerformanceSwapEarlyTerminationValidator implements Validator<CommodityPerformanceSwapEarlyTermination> {

	private List<ComparisonResult> getComparisonResults(CommodityPerformanceSwapEarlyTermination o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("startingDate", (CommodityStartingDate) o.getStartingDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPerformanceSwapEarlyTermination o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPerformanceSwapEarlyTermination", ValidationResult.ValidationType.CARDINALITY, "CommodityPerformanceSwapEarlyTermination", path, "", res.getError());
				}
				return success("CommodityPerformanceSwapEarlyTermination", ValidationResult.ValidationType.CARDINALITY, "CommodityPerformanceSwapEarlyTermination", path, "");
			})
			.collect(toList());
	}

}
