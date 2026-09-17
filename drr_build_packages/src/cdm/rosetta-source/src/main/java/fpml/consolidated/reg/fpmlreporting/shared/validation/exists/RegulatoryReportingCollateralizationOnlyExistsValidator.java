package fpml.consolidated.reg.fpmlreporting.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolio;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolioId;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatoryReportingCollateralization;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.CollateralizedExposureGrouping;
import fpml.consolidated.shared.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingCollateralizationOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingCollateralization, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingCollateralization> ValidationResult<RegulatoryReportingCollateralization> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("postingPartyReference", ExistenceChecker.isSet((PartyReference) o.getPostingPartyReference()))
				.put("beneficiaryPartyReference", ExistenceChecker.isSet((PartyReference) o.getBeneficiaryPartyReference()))
				.put("holdingPartyReference", ExistenceChecker.isSet((PartyReference) o.getHoldingPartyReference()))
				.put("collateralizedExposureGrouping", ExistenceChecker.isSet((CollateralizedExposureGrouping) o.getCollateralizedExposureGrouping()))
				.put("collateralizationType", ExistenceChecker.isSet((CollateralizationType) o.getCollateralizationType()))
				.put("portfolioId", ExistenceChecker.isSet((CollateralPortfolioId) o.getPortfolioId()))
				.put("postedCollateral", ExistenceChecker.isSet((CollateralPortfolio) o.getPostedCollateral()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingCollateralization", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingCollateralization", path, "");
		}
		return failure("RegulatoryReportingCollateralization", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingCollateralization", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
