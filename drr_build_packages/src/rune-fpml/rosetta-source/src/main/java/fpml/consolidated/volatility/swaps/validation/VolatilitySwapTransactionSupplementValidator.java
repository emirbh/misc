package fpml.consolidated.volatility.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import fpml.consolidated.volatility.swaps.VolatilitySwapTransactionSupplement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VolatilitySwapTransactionSupplementValidator implements Validator<VolatilitySwapTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(VolatilitySwapTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("volatilityLeg", (List<? extends VolatilityLeg>) o.getVolatilityLeg() == null ? 0 : o.getVolatilityLeg().size(), 1, 0), 
				checkCardinality("multipleExchangeIndexAnnexFallback", (Boolean) o.getMultipleExchangeIndexAnnexFallback() != null ? 1 : 0, 0, 1), 
				checkCardinality("componentSecurityIndexAnnexFallback", (Boolean) o.getComponentSecurityIndexAnnexFallback() != null ? 1 : 0, 0, 1), 
				checkCardinality("localJurisdiction", (CountryCode) o.getLocalJurisdiction() != null ? 1 : 0, 0, 1), 
				checkCardinality("relevantJurisdiction", (CountryCode) o.getRelevantJurisdiction() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilitySwapTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilitySwapTransactionSupplement", ValidationResult.ValidationType.CARDINALITY, "VolatilitySwapTransactionSupplement", path, "", res.getError());
				}
				return success("VolatilitySwapTransactionSupplement", ValidationResult.ValidationType.CARDINALITY, "VolatilitySwapTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}
