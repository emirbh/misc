package cdm.observable.asset.validation;

import cdm.observable.asset.FxInformationSource;
import cdm.observable.asset.FxSettlementRateSource;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxSettlementRateSourceValidator implements Validator<FxSettlementRateSource> {

	private List<ComparisonResult> getComparisonResults(FxSettlementRateSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementRateOption", (FieldWithMetaString) o.getSettlementRateOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonstandardSettlementRate", (FxInformationSource) o.getNonstandardSettlementRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSettlementRateSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxSettlementRateSource", ValidationResult.ValidationType.CARDINALITY, "FxSettlementRateSource", path, "", res.getError());
				}
				return success("FxSettlementRateSource", ValidationResult.ValidationType.CARDINALITY, "FxSettlementRateSource", path, "");
			})
			.collect(toList());
	}

}
