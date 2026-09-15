package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AssetClassCommodityOfficialEconomicStatistics1;
import iso20022.auth030.esma.validation.AssetClassCommodityOfficialEconomicStatistics1TypeFormatValidator;
import iso20022.auth030.esma.validation.AssetClassCommodityOfficialEconomicStatistics1Validator;
import iso20022.auth030.esma.validation.exists.AssetClassCommodityOfficialEconomicStatistics1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityOfficialEconomicStatistics1.class)
public class AssetClassCommodityOfficialEconomicStatistics1Meta implements RosettaMetaData<AssetClassCommodityOfficialEconomicStatistics1> {

	@Override
	public List<Validator<? super AssetClassCommodityOfficialEconomicStatistics1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityOfficialEconomicStatistics1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityOfficialEconomicStatistics1> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityOfficialEconomicStatistics1>create(AssetClassCommodityOfficialEconomicStatistics1Validator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityOfficialEconomicStatistics1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityOfficialEconomicStatistics1>create(AssetClassCommodityOfficialEconomicStatistics1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityOfficialEconomicStatistics1> validator() {
		return new AssetClassCommodityOfficialEconomicStatistics1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityOfficialEconomicStatistics1> typeFormatValidator() {
		return new AssetClassCommodityOfficialEconomicStatistics1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityOfficialEconomicStatistics1, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityOfficialEconomicStatistics1OnlyExistsValidator();
	}
}
