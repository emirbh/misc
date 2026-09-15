package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AssetClassCommodityFertilizer4Choice__1;
import iso20022.auth030.fca.validation.AssetClassCommodityFertilizer4Choice__1TypeFormatValidator;
import iso20022.auth030.fca.validation.AssetClassCommodityFertilizer4Choice__1Validator;
import iso20022.auth030.fca.validation.datarule.AssetClassCommodityFertilizer4Choice__1Choice;
import iso20022.auth030.fca.validation.exists.AssetClassCommodityFertilizer4Choice__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityFertilizer4Choice__1.class)
public class AssetClassCommodityFertilizer4Choice__1Meta implements RosettaMetaData<AssetClassCommodityFertilizer4Choice__1> {

	@Override
	public List<Validator<? super AssetClassCommodityFertilizer4Choice__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityFertilizer4Choice__1>create(AssetClassCommodityFertilizer4Choice__1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityFertilizer4Choice__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityFertilizer4Choice__1> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityFertilizer4Choice__1>create(AssetClassCommodityFertilizer4Choice__1Validator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityFertilizer4Choice__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityFertilizer4Choice__1>create(AssetClassCommodityFertilizer4Choice__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityFertilizer4Choice__1> validator() {
		return new AssetClassCommodityFertilizer4Choice__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityFertilizer4Choice__1> typeFormatValidator() {
		return new AssetClassCommodityFertilizer4Choice__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityFertilizer4Choice__1, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityFertilizer4Choice__1OnlyExistsValidator();
	}
}
