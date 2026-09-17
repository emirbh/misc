package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.LoanTradingAccruingFeeTypeEnum;
import fpml.consolidated.loan.AccrualTypeId;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.LoanTradingFacilityFeeAccrual;
import fpml.consolidated.shared.Money;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradingFacilityFeeAccrualValidator implements Validator<LoanTradingFacilityFeeAccrual> {

	private List<ComparisonResult> getComparisonResults(LoanTradingFacilityFeeAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amount", (Money) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("accruingFeeTypeId", (AccrualTypeId) o.getAccruingFeeTypeId() != null ? 1 : 0, 1, 1), 
				checkCardinality("accruingFeeType", (LoanTradingAccruingFeeTypeEnum) o.getAccruingFeeType() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityReference", (FacilityReference) o.getFacilityReference() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingFacilityFeeAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingFacilityFeeAccrual", ValidationResult.ValidationType.CARDINALITY, "LoanTradingFacilityFeeAccrual", path, "", res.getError());
				}
				return success("LoanTradingFacilityFeeAccrual", ValidationResult.ValidationType.CARDINALITY, "LoanTradingFacilityFeeAccrual", path, "");
			})
			.collect(toList());
	}

}
