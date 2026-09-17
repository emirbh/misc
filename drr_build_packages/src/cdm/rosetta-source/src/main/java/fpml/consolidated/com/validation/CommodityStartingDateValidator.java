package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityStartingDate;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityStartingDateValidator implements Validator<CommodityStartingDate> {

	private List<ComparisonResult> getComparisonResults(CommodityStartingDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateRelativeTo", (PartyReference) o.getDateRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustableDate", (AdjustableDate) o.getAdjustableDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityStartingDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityStartingDate", ValidationResult.ValidationType.CARDINALITY, "CommodityStartingDate", path, "", res.getError());
				}
				return success("CommodityStartingDate", ValidationResult.ValidationType.CARDINALITY, "CommodityStartingDate", path, "");
			})
			.collect(toList());
	}

}
