package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AssetClassCommodityPolypropylene4Choice__1;
import iso20022.auth030.fca.PolypropyleneCommodityOther2__1;
import iso20022.auth030.fca.PolypropyleneCommodityPlastic2__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityPolypropylene4Choice__1Validator implements Validator<AssetClassCommodityPolypropylene4Choice__1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityPolypropylene4Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("plstc", (PolypropyleneCommodityPlastic2__1) o.getPlstc() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (PolypropyleneCommodityOther2__1) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityPolypropylene4Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityPolypropylene4Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityPolypropylene4Choice__1", path, "", res.getError());
				}
				return success("AssetClassCommodityPolypropylene4Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityPolypropylene4Choice__1", path, "");
			})
			.collect(toList());
	}

}
