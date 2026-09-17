package cdm.observable.asset.validation;

import cdm.base.datetime.BusinessCenterTime;
import cdm.observable.asset.FxInformationSource;
import cdm.observable.asset.metafields.FieldWithMetaInformationProviderEnum;
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

public class FxInformationSourceValidator implements Validator<FxInformationSource> {

	private List<ComparisonResult> getComparisonResults(FxInformationSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("sourceProvider", (FieldWithMetaInformationProviderEnum) o.getSourceProvider() != null ? 1 : 0, 1, 1), 
				checkCardinality("sourcePage", (FieldWithMetaString) o.getSourcePage() != null ? 1 : 0, 0, 1), 
				checkCardinality("sourcePageHeading", (String) o.getSourcePageHeading() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingTime", (BusinessCenterTime) o.getFixingTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxInformationSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxInformationSource", ValidationResult.ValidationType.CARDINALITY, "FxInformationSource", path, "", res.getError());
				}
				return success("FxInformationSource", ValidationResult.ValidationType.CARDINALITY, "FxInformationSource", path, "");
			})
			.collect(toList());
	}

}
