package fpml.consolidated.reg.fpmlreporting.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolio;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolioId;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatoryReportingCollateralization;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.CollateralizedExposureGrouping;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingCollateralizationValidator implements Validator<RegulatoryReportingCollateralization> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingCollateralization o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("postingPartyReference", (PartyReference) o.getPostingPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("beneficiaryPartyReference", (PartyReference) o.getBeneficiaryPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("holdingPartyReference", (PartyReference) o.getHoldingPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralizedExposureGrouping", (CollateralizedExposureGrouping) o.getCollateralizedExposureGrouping() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralizationType", (CollateralizationType) o.getCollateralizationType() != null ? 1 : 0, 0, 1), 
				checkCardinality("portfolioId", (CollateralPortfolioId) o.getPortfolioId() != null ? 1 : 0, 0, 1), 
				checkCardinality("postedCollateral", (CollateralPortfolio) o.getPostedCollateral() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingCollateralization o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingCollateralization", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingCollateralization", path, "", res.getError());
				}
				return success("RegulatoryReportingCollateralization", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingCollateralization", path, "");
			})
			.collect(toList());
	}

}
