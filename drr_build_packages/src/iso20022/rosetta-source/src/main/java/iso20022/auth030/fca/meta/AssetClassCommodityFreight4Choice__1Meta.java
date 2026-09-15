package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AssetClassCommodityFreight4Choice__1;
import iso20022.auth030.fca.validation.AssetClassCommodityFreight4Choice__1TypeFormatValidator;
import iso20022.auth030.fca.validation.AssetClassCommodityFreight4Choice__1Validator;
import iso20022.auth030.fca.validation.datarule.AssetClassCommodityFreight4Choice__1Choice;
import iso20022.auth030.fca.validation.exists.AssetClassCommodityFreight4Choice__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityFreight4Choice__1.class)
public class AssetClassCommodityFreight4Choice__1Meta implements RosettaMetaData<AssetClassCommodityFreight4Choice__1> {

	@Override
	public List<Validator<? super AssetClassCommodityFreight4Choice__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityFreight4Choice__1>create(AssetClassCommodityFreight4Choice__1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityFreight4Choice__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityFreight4Choice__1> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityFreight4Choice__1>create(AssetClassCommodityFreight4Choice__1Validator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityFreight4Choice__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityFreight4Choice__1>create(AssetClassCommodityFreight4Choice__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityFreight4Choice__1> validator() {
		return new AssetClassCommodityFreight4Choice__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityFreight4Choice__1> typeFormatValidator() {
		return new AssetClassCommodityFreight4Choice__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityFreight4Choice__1, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityFreight4Choice__1OnlyExistsValidator();
	}
}
