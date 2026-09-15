package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityExpireRelativeToEvent;
import fpml.consolidated.com.CommodityRelativeExpirationDates;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.DateOffset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityRelativeExpirationDatesValidator implements Validator<CommodityRelativeExpirationDates> {

	private List<ComparisonResult> getComparisonResults(CommodityRelativeExpirationDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("expireRelativeToEvent", (CommodityExpireRelativeToEvent) o.getExpireRelativeToEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDateOffset", (DateOffset) o.getExpirationDateOffset() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCentersReference", (BusinessCentersReference) o.getBusinessCentersReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCenters", (BusinessCenters) o.getBusinessCenters() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityRelativeExpirationDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityRelativeExpirationDates", ValidationResult.ValidationType.CARDINALITY, "CommodityRelativeExpirationDates", path, "", res.getError());
				}
				return success("CommodityRelativeExpirationDates", ValidationResult.ValidationType.CARDINALITY, "CommodityRelativeExpirationDates", path, "");
			})
			.collect(toList());
	}

}
