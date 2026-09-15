package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AssetClassCommodityPaper4Choice__1;
import iso20022.auth030.fca.PaperCommodityContainerBoard2__1;
import iso20022.auth030.fca.PaperCommodityNewsprint2__1;
import iso20022.auth030.fca.PaperCommodityOther1__1;
import iso20022.auth030.fca.PaperCommodityPulp2__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityPaper4Choice__1Validator implements Validator<AssetClassCommodityPaper4Choice__1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityPaper4Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cntnrBrd", (PaperCommodityContainerBoard2__1) o.getCntnrBrd() != null ? 1 : 0, 0, 1), 
				checkCardinality("nwsprnt", (PaperCommodityNewsprint2__1) o.getNwsprnt() != null ? 1 : 0, 0, 1), 
				checkCardinality("pulp", (PaperCommodityPulp2__1) o.getPulp() != null ? 1 : 0, 0, 1), 
				checkCardinality("rcvrdPpr", (PaperCommodityOther1__1) o.getRcvrdPpr() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (PaperCommodityOther1__1) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityPaper4Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityPaper4Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityPaper4Choice__1", path, "", res.getError());
				}
				return success("AssetClassCommodityPaper4Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityPaper4Choice__1", path, "");
			})
			.collect(toList());
	}

}
