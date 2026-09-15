package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AssetClassCommodityC10Other1;
import iso20022.auth030.fca.validation.AssetClassCommodityC10Other1TypeFormatValidator;
import iso20022.auth030.fca.validation.AssetClassCommodityC10Other1Validator;
import iso20022.auth030.fca.validation.exists.AssetClassCommodityC10Other1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityC10Other1.class)
public class AssetClassCommodityC10Other1Meta implements RosettaMetaData<AssetClassCommodityC10Other1> {

	@Override
	public List<Validator<? super AssetClassCommodityC10Other1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityC10Other1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityC10Other1> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityC10Other1>create(AssetClassCommodityC10Other1Validator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityC10Other1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityC10Other1>create(AssetClassCommodityC10Other1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityC10Other1> validator() {
		return new AssetClassCommodityC10Other1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityC10Other1> typeFormatValidator() {
		return new AssetClassCommodityC10Other1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityC10Other1, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityC10Other1OnlyExistsValidator();
	}
}
