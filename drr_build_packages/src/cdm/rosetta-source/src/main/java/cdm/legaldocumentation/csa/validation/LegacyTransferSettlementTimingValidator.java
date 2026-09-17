package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CashCTSTimeEnum;
import cdm.legaldocumentation.csa.LegacyTransferSettlementTiming;
import cdm.legaldocumentation.csa.SecuritiesCTSTimeEnum;
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

public class LegacyTransferSettlementTimingValidator implements Validator<LegacyTransferSettlementTiming> {

	private List<ComparisonResult> getComparisonResults(LegacyTransferSettlementTiming o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashCollateralTransferSettlementTime", (CashCTSTimeEnum) o.getCashCollateralTransferSettlementTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("securititesCollateralTransferSettlementTime", (SecuritiesCTSTimeEnum) o.getSecurititesCollateralTransferSettlementTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalLanguage", (String) o.getAdditionalLanguage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyTransferSettlementTiming o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegacyTransferSettlementTiming", ValidationResult.ValidationType.CARDINALITY, "LegacyTransferSettlementTiming", path, "", res.getError());
				}
				return success("LegacyTransferSettlementTiming", ValidationResult.ValidationType.CARDINALITY, "LegacyTransferSettlementTiming", path, "");
			})
			.collect(toList());
	}

}
