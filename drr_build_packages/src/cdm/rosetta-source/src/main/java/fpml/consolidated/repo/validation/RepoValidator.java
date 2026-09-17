package fpml.consolidated.repo.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.GenericSecurity;
import fpml.consolidated.fpmlenum.CallingPartyEnum;
import fpml.consolidated.fpmlenum.ExtensionStyleEnum;
import fpml.consolidated.fpmlenum.RepoDurationEnum;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.repo.AdjustableOffset;
import fpml.consolidated.repo.CollateralArrangement;
import fpml.consolidated.repo.InitialMargin;
import fpml.consolidated.repo.PartyNoticePeriod;
import fpml.consolidated.repo.Repo;
import fpml.consolidated.repo.RepoFarLeg;
import fpml.consolidated.repo.RepoNearLeg;
import fpml.consolidated.repo.TriParty;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.Schedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RepoValidator implements Validator<Repo> {

	private List<ComparisonResult> getComparisonResults(Repo o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("fixedRateSchedule", (Schedule) o.getFixedRateSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateCalculation", (FloatingRateCalculation) o.getFloatingRateCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("resetFrequency", (Frequency) o.getResetFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("duration", (RepoDurationEnum) o.getDuration() != null ? 1 : 0, 0, 1), 
				checkCardinality("extensionStyle", (ExtensionStyleEnum) o.getExtensionStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("extensionPeriod", (AdjustableOffset) o.getExtensionPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("callingParty", (CallingPartyEnum) o.getCallingParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("earliestCallDate", (AdjustableDate) o.getEarliestCallDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("callDate", (AdjustableOrRelativeDate) o.getCallDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("noticePeriod", (AdjustableOffset) o.getNoticePeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyNoticePeriod", (List<? extends PartyNoticePeriod>) o.getPartyNoticePeriod() == null ? 0 : o.getPartyNoticePeriod().size(), 0, 2), 
				checkCardinality("initialMargin", (InitialMargin) o.getInitialMargin() != null ? 1 : 0, 0, 1), 
				checkCardinality("nearLeg", (RepoNearLeg) o.getNearLeg() != null ? 1 : 0, 1, 1), 
				checkCardinality("farLeg", (RepoFarLeg) o.getFarLeg() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentFrequency", (Frequency) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("security", (GenericSecurity) o.getSecurity() != null ? 1 : 0, 0, 1), 
				checkCardinality("triParty", (TriParty) o.getTriParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("generalCollateral", (Boolean) o.getGeneralCollateral() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralArrangement", (CollateralArrangement) o.getCollateralArrangement() != null ? 1 : 0, 0, 1), 
				checkCardinality("eligibleForRehypothecation", (Boolean) o.getEligibleForRehypothecation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Repo o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Repo", ValidationResult.ValidationType.CARDINALITY, "Repo", path, "", res.getError());
				}
				return success("Repo", ValidationResult.ValidationType.CARDINALITY, "Repo", path, "");
			})
			.collect(toList());
	}

}
