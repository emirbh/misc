package fpml.consolidated.sec.lending.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.DeliveryMethod;
import fpml.consolidated.sec.lending.PrepaidRate;
import fpml.consolidated.sec.lending.SecLendInitiation;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecLendInitiationValidator implements Validator<SecLendInitiation> {

	private List<ComparisonResult> getComparisonResults(SecLendInitiation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementDate", (IdentifiedDate) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryMethod", (DeliveryMethod) o.getDeliveryMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralSettlementDate", (IdentifiedDate) o.getCollateralSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("prepaidRate", (PrepaidRate) o.getPrepaidRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecLendInitiation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecLendInitiation", ValidationResult.ValidationType.CARDINALITY, "SecLendInitiation", path, "", res.getError());
				}
				return success("SecLendInitiation", ValidationResult.ValidationType.CARDINALITY, "SecLendInitiation", path, "");
			})
			.collect(toList());
	}

}
