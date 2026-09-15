package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AssetClassCommodityInflation1;
import iso20022.auth030.fca.validation.AssetClassCommodityInflation1TypeFormatValidator;
import iso20022.auth030.fca.validation.AssetClassCommodityInflation1Validator;
import iso20022.auth030.fca.validation.exists.AssetClassCommodityInflation1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityInflation1.class)
public class AssetClassCommodityInflation1Meta implements RosettaMetaData<AssetClassCommodityInflation1> {

	@Override
	public List<Validator<? super AssetClassCommodityInflation1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityInflation1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityInflation1> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityInflation1>create(AssetClassCommodityInflation1Validator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityInflation1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityInflation1>create(AssetClassCommodityInflation1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityInflation1> validator() {
		return new AssetClassCommodityInflation1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityInflation1> typeFormatValidator() {
		return new AssetClassCommodityInflation1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityInflation1, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityInflation1OnlyExistsValidator();
	}
}
