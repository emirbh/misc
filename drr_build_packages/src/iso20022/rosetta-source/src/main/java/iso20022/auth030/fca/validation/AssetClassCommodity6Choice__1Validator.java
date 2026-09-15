package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AssetClassCommodity6Choice__1;
import iso20022.auth030.fca.AssetClassCommodityAgricultural6Choice__1;
import iso20022.auth030.fca.AssetClassCommodityC10Other1;
import iso20022.auth030.fca.AssetClassCommodityEnergy3Choice__1;
import iso20022.auth030.fca.AssetClassCommodityEnvironmental3Choice__1;
import iso20022.auth030.fca.AssetClassCommodityFertilizer4Choice__1;
import iso20022.auth030.fca.AssetClassCommodityFreight4Choice__1;
import iso20022.auth030.fca.AssetClassCommodityIndustrialProduct2Choice__1;
import iso20022.auth030.fca.AssetClassCommodityInflation1;
import iso20022.auth030.fca.AssetClassCommodityMetal2Choice__1;
import iso20022.auth030.fca.AssetClassCommodityMultiCommodityExotic1;
import iso20022.auth030.fca.AssetClassCommodityOfficialEconomicStatistics1;
import iso20022.auth030.fca.AssetClassCommodityOther1;
import iso20022.auth030.fca.AssetClassCommodityPaper4Choice__1;
import iso20022.auth030.fca.AssetClassCommodityPolypropylene4Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodity6Choice__1Validator implements Validator<AssetClassCommodity6Choice__1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodity6Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("agrcltrl", (AssetClassCommodityAgricultural6Choice__1) o.getAgrcltrl() != null ? 1 : 0, 0, 1), 
				checkCardinality("nrgy", (AssetClassCommodityEnergy3Choice__1) o.getNrgy() != null ? 1 : 0, 0, 1), 
				checkCardinality("envttl", (AssetClassCommodityEnvironmental3Choice__1) o.getEnvttl() != null ? 1 : 0, 0, 1), 
				checkCardinality("frtlzr", (AssetClassCommodityFertilizer4Choice__1) o.getFrtlzr() != null ? 1 : 0, 0, 1), 
				checkCardinality("frght", (AssetClassCommodityFreight4Choice__1) o.getFrght() != null ? 1 : 0, 0, 1), 
				checkCardinality("indstrlPdct", (AssetClassCommodityIndustrialProduct2Choice__1) o.getIndstrlPdct() != null ? 1 : 0, 0, 1), 
				checkCardinality("infltn", (AssetClassCommodityInflation1) o.getInfltn() != null ? 1 : 0, 0, 1), 
				checkCardinality("metl", (AssetClassCommodityMetal2Choice__1) o.getMetl() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiCmmdtyExtc", (AssetClassCommodityMultiCommodityExotic1) o.getMultiCmmdtyExtc() != null ? 1 : 0, 0, 1), 
				checkCardinality("offclEcnmcSttstcs", (AssetClassCommodityOfficialEconomicStatistics1) o.getOffclEcnmcSttstcs() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (AssetClassCommodityOther1) o.getOthr() != null ? 1 : 0, 0, 1), 
				checkCardinality("othrC10", (AssetClassCommodityC10Other1) o.getOthrC10() != null ? 1 : 0, 0, 1), 
				checkCardinality("ppr", (AssetClassCommodityPaper4Choice__1) o.getPpr() != null ? 1 : 0, 0, 1), 
				checkCardinality("plprpln", (AssetClassCommodityPolypropylene4Choice__1) o.getPlprpln() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodity6Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodity6Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodity6Choice__1", path, "", res.getError());
				}
				return success("AssetClassCommodity6Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodity6Choice__1", path, "");
			})
			.collect(toList());
	}

}
