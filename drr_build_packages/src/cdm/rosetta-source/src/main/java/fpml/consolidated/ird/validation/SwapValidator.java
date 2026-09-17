package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.CancelableProvision;
import fpml.consolidated.ird.EarlyTerminationProvision;
import fpml.consolidated.ird.ExtendibleProvision;
import fpml.consolidated.ird.InterestRateStream;
import fpml.consolidated.ird.Swap;
import fpml.consolidated.ird.SwapAdditionalTerms;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SwapValidator implements Validator<Swap> {

	private List<ComparisonResult> getComparisonResults(Swap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("swapStream", (List<? extends InterestRateStream>) o.getSwapStream() == null ? 0 : o.getSwapStream().size(), 1, 0), 
				checkCardinality("earlyTerminationProvision", (EarlyTerminationProvision) o.getEarlyTerminationProvision() != null ? 1 : 0, 0, 1), 
				checkCardinality("cancelableProvision", (CancelableProvision) o.getCancelableProvision() != null ? 1 : 0, 0, 1), 
				checkCardinality("extendibleProvision", (ExtendibleProvision) o.getExtendibleProvision() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalTerms", (SwapAdditionalTerms) o.getAdditionalTerms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Swap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Swap", ValidationResult.ValidationType.CARDINALITY, "Swap", path, "", res.getError());
				}
				return success("Swap", ValidationResult.ValidationType.CARDINALITY, "Swap", path, "");
			})
			.collect(toList());
	}

}
