package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityOther1;
import iso20022.auth030.hkma.dtcc.validation.AssetClassCommodityOther1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.AssetClassCommodityOther1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.AssetClassCommodityOther1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityOther1.class)
public class AssetClassCommodityOther1Meta implements RosettaMetaData<AssetClassCommodityOther1> {

	@Override
	public List<Validator<? super AssetClassCommodityOther1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityOther1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityOther1> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityOther1>create(AssetClassCommodityOther1Validator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityOther1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityOther1>create(AssetClassCommodityOther1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityOther1> validator() {
		return new AssetClassCommodityOther1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityOther1> typeFormatValidator() {
		return new AssetClassCommodityOther1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityOther1, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityOther1OnlyExistsValidator();
	}
}
