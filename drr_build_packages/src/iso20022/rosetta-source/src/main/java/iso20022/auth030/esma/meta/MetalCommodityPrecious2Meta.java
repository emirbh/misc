package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.MetalCommodityPrecious2;
import iso20022.auth030.esma.validation.MetalCommodityPrecious2TypeFormatValidator;
import iso20022.auth030.esma.validation.MetalCommodityPrecious2Validator;
import iso20022.auth030.esma.validation.exists.MetalCommodityPrecious2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MetalCommodityPrecious2.class)
public class MetalCommodityPrecious2Meta implements RosettaMetaData<MetalCommodityPrecious2> {

	@Override
	public List<Validator<? super MetalCommodityPrecious2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MetalCommodityPrecious2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MetalCommodityPrecious2> validator(ValidatorFactory factory) {
		return factory.<MetalCommodityPrecious2>create(MetalCommodityPrecious2Validator.class);
	}

	@Override
	public Validator<? super MetalCommodityPrecious2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MetalCommodityPrecious2>create(MetalCommodityPrecious2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MetalCommodityPrecious2> validator() {
		return new MetalCommodityPrecious2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super MetalCommodityPrecious2> typeFormatValidator() {
		return new MetalCommodityPrecious2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MetalCommodityPrecious2, Set<String>> onlyExistsValidator() {
		return new MetalCommodityPrecious2OnlyExistsValidator();
	}
}
