package fpml.consolidated.variance.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.variance.swaps.VarianceLeg;
import fpml.consolidated.variance.swaps.VarianceSwapTransactionSupplement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VarianceSwapTransactionSupplementValidator implements Validator<VarianceSwapTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(VarianceSwapTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("varianceLeg", (List<? extends VarianceLeg>) o.getVarianceLeg() == null ? 0 : o.getVarianceLeg().size(), 1, 0), 
				checkCardinality("multipleExchangeIndexAnnexFallback", (Boolean) o.getMultipleExchangeIndexAnnexFallback() != null ? 1 : 0, 0, 1), 
				checkCardinality("componentSecurityIndexAnnexFallback", (Boolean) o.getComponentSecurityIndexAnnexFallback() != null ? 1 : 0, 0, 1), 
				checkCardinality("localJurisdiction", (CountryCode) o.getLocalJurisdiction() != null ? 1 : 0, 0, 1), 
				checkCardinality("relevantJurisdiction", (CountryCode) o.getRelevantJurisdiction() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceSwapTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VarianceSwapTransactionSupplement", ValidationResult.ValidationType.CARDINALITY, "VarianceSwapTransactionSupplement", path, "", res.getError());
				}
				return success("VarianceSwapTransactionSupplement", ValidationResult.ValidationType.CARDINALITY, "VarianceSwapTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}
