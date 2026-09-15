package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AssetClassCommodityIndustrialProduct2Choice__1;
import iso20022.auth030.fca.validation.AssetClassCommodityIndustrialProduct2Choice__1TypeFormatValidator;
import iso20022.auth030.fca.validation.AssetClassCommodityIndustrialProduct2Choice__1Validator;
import iso20022.auth030.fca.validation.datarule.AssetClassCommodityIndustrialProduct2Choice__1Choice;
import iso20022.auth030.fca.validation.exists.AssetClassCommodityIndustrialProduct2Choice__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityIndustrialProduct2Choice__1.class)
public class AssetClassCommodityIndustrialProduct2Choice__1Meta implements RosettaMetaData<AssetClassCommodityIndustrialProduct2Choice__1> {

	@Override
	public List<Validator<? super AssetClassCommodityIndustrialProduct2Choice__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityIndustrialProduct2Choice__1>create(AssetClassCommodityIndustrialProduct2Choice__1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityIndustrialProduct2Choice__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityIndustrialProduct2Choice__1> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityIndustrialProduct2Choice__1>create(AssetClassCommodityIndustrialProduct2Choice__1Validator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityIndustrialProduct2Choice__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityIndustrialProduct2Choice__1>create(AssetClassCommodityIndustrialProduct2Choice__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityIndustrialProduct2Choice__1> validator() {
		return new AssetClassCommodityIndustrialProduct2Choice__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityIndustrialProduct2Choice__1> typeFormatValidator() {
		return new AssetClassCommodityIndustrialProduct2Choice__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityIndustrialProduct2Choice__1, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityIndustrialProduct2Choice__1OnlyExistsValidator();
	}
}
