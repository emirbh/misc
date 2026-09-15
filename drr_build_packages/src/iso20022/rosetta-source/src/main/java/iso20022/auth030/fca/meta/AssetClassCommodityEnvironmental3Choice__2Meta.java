package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AssetClassCommodityEnvironmental3Choice__2;
import iso20022.auth030.fca.validation.AssetClassCommodityEnvironmental3Choice__2TypeFormatValidator;
import iso20022.auth030.fca.validation.AssetClassCommodityEnvironmental3Choice__2Validator;
import iso20022.auth030.fca.validation.datarule.AssetClassCommodityEnvironmental3Choice__2Choice;
import iso20022.auth030.fca.validation.exists.AssetClassCommodityEnvironmental3Choice__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityEnvironmental3Choice__2.class)
public class AssetClassCommodityEnvironmental3Choice__2Meta implements RosettaMetaData<AssetClassCommodityEnvironmental3Choice__2> {

	@Override
	public List<Validator<? super AssetClassCommodityEnvironmental3Choice__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityEnvironmental3Choice__2>create(AssetClassCommodityEnvironmental3Choice__2Choice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityEnvironmental3Choice__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityEnvironmental3Choice__2> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityEnvironmental3Choice__2>create(AssetClassCommodityEnvironmental3Choice__2Validator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityEnvironmental3Choice__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityEnvironmental3Choice__2>create(AssetClassCommodityEnvironmental3Choice__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityEnvironmental3Choice__2> validator() {
		return new AssetClassCommodityEnvironmental3Choice__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityEnvironmental3Choice__2> typeFormatValidator() {
		return new AssetClassCommodityEnvironmental3Choice__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityEnvironmental3Choice__2, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityEnvironmental3Choice__2OnlyExistsValidator();
	}
}
