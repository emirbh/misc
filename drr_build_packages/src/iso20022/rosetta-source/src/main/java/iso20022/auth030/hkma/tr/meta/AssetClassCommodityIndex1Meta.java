package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AssetClassCommodityIndex1;
import iso20022.auth030.hkma.tr.validation.AssetClassCommodityIndex1TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.AssetClassCommodityIndex1Validator;
import iso20022.auth030.hkma.tr.validation.exists.AssetClassCommodityIndex1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityIndex1.class)
public class AssetClassCommodityIndex1Meta implements RosettaMetaData<AssetClassCommodityIndex1> {

	@Override
	public List<Validator<? super AssetClassCommodityIndex1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityIndex1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityIndex1> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityIndex1>create(AssetClassCommodityIndex1Validator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityIndex1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityIndex1>create(AssetClassCommodityIndex1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityIndex1> validator() {
		return new AssetClassCommodityIndex1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityIndex1> typeFormatValidator() {
		return new AssetClassCommodityIndex1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityIndex1, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityIndex1OnlyExistsValidator();
	}
}
