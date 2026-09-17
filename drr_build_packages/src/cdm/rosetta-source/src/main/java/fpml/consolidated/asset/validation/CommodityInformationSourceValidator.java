package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.CommodityInformationProvider;
import fpml.consolidated.asset.CommodityInformationSource;
import fpml.consolidated.shared.RateSourcePage;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityInformationSourceValidator implements Validator<CommodityInformationSource> {

	private List<ComparisonResult> getComparisonResults(CommodityInformationSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rateSource", (CommodityInformationProvider) o.getRateSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateSourcePage", (RateSourcePage) o.getRateSourcePage() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateSourcePageHeading", (String) o.getRateSourcePageHeading() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityInformationSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityInformationSource", ValidationResult.ValidationType.CARDINALITY, "CommodityInformationSource", path, "", res.getError());
				}
				return success("CommodityInformationSource", ValidationResult.ValidationType.CARDINALITY, "CommodityInformationSource", path, "");
			})
			.collect(toList());
	}

}
