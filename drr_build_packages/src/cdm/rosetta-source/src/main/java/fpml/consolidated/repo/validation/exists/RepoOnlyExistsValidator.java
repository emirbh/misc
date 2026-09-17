package fpml.consolidated.repo.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
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
import fpml.consolidated.repo.RepoChoice;
import fpml.consolidated.repo.RepoFarLeg;
import fpml.consolidated.repo.RepoNearLeg;
import fpml.consolidated.repo.TriParty;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.Schedule;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RepoOnlyExistsValidator implements ValidatorWithArg<Repo, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Repo> ValidationResult<Repo> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("fixedRateSchedule", ExistenceChecker.isSet((Schedule) o.getFixedRateSchedule()))
				.put("floatingRateCalculation", ExistenceChecker.isSet((FloatingRateCalculation) o.getFloatingRateCalculation()))
				.put("resetFrequency", ExistenceChecker.isSet((Frequency) o.getResetFrequency()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("duration", ExistenceChecker.isSet((RepoDurationEnum) o.getDuration()))
				.put("extensionStyle", ExistenceChecker.isSet((ExtensionStyleEnum) o.getExtensionStyle()))
				.put("extensionPeriod", ExistenceChecker.isSet((AdjustableOffset) o.getExtensionPeriod()))
				.put("callingParty", ExistenceChecker.isSet((CallingPartyEnum) o.getCallingParty()))
				.put("earliestCallDate", ExistenceChecker.isSet((AdjustableDate) o.getEarliestCallDate()))
				.put("callDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getCallDate()))
				.put("noticePeriod", ExistenceChecker.isSet((AdjustableOffset) o.getNoticePeriod()))
				.put("partyNoticePeriod", ExistenceChecker.isSet((List<? extends PartyNoticePeriod>) o.getPartyNoticePeriod()))
				.put("initialMargin", ExistenceChecker.isSet((InitialMargin) o.getInitialMargin()))
				.put("nearLeg", ExistenceChecker.isSet((RepoNearLeg) o.getNearLeg()))
				.put("farLeg", ExistenceChecker.isSet((RepoFarLeg) o.getFarLeg()))
				.put("paymentFrequency", ExistenceChecker.isSet((Frequency) o.getPaymentFrequency()))
				.put("repoChoice", ExistenceChecker.isSet((List<? extends RepoChoice>) o.getRepoChoice()))
				.put("security", ExistenceChecker.isSet((GenericSecurity) o.getSecurity()))
				.put("triParty", ExistenceChecker.isSet((TriParty) o.getTriParty()))
				.put("generalCollateral", ExistenceChecker.isSet((Boolean) o.getGeneralCollateral()))
				.put("collateralArrangement", ExistenceChecker.isSet((CollateralArrangement) o.getCollateralArrangement()))
				.put("eligibleForRehypothecation", ExistenceChecker.isSet((Boolean) o.getEligibleForRehypothecation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Repo", ValidationResult.ValidationType.ONLY_EXISTS, "Repo", path, "");
		}
		return failure("Repo", ValidationResult.ValidationType.ONLY_EXISTS, "Repo", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
