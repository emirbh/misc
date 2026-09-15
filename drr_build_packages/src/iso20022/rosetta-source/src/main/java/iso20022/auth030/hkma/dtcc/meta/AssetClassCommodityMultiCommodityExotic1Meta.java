package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityMultiCommodityExotic1;
import iso20022.auth030.hkma.dtcc.validation.AssetClassCommodityMultiCommodityExotic1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.AssetClassCommodityMultiCommodityExotic1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.AssetClassCommodityMultiCommodityExotic1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityMultiCommodityExotic1.class)
public class AssetClassCommodityMultiCommodityExotic1Meta implements RosettaMetaData<AssetClassCommodityMultiCommodityExotic1> {

	@Override
	public List<Validator<? super AssetClassCommodityMultiCommodityExotic1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityMultiCommodityExotic1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityMultiCommodityExotic1> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityMultiCommodityExotic1>create(AssetClassCommodityMultiCommodityExotic1Validator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityMultiCommodityExotic1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityMultiCommodityExotic1>create(AssetClassCommodityMultiCommodityExotic1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityMultiCommodityExotic1> validator() {
		return new AssetClassCommodityMultiCommodityExotic1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityMultiCommodityExotic1> typeFormatValidator() {
		return new AssetClassCommodityMultiCommodityExotic1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityMultiCommodityExotic1, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityMultiCommodityExotic1OnlyExistsValidator();
	}
}
