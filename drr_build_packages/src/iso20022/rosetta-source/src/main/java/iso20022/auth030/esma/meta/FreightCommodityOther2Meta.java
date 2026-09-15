package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.FreightCommodityOther2;
import iso20022.auth030.esma.validation.FreightCommodityOther2TypeFormatValidator;
import iso20022.auth030.esma.validation.FreightCommodityOther2Validator;
import iso20022.auth030.esma.validation.exists.FreightCommodityOther2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FreightCommodityOther2.class)
public class FreightCommodityOther2Meta implements RosettaMetaData<FreightCommodityOther2> {

	@Override
	public List<Validator<? super FreightCommodityOther2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FreightCommodityOther2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FreightCommodityOther2> validator(ValidatorFactory factory) {
		return factory.<FreightCommodityOther2>create(FreightCommodityOther2Validator.class);
	}

	@Override
	public Validator<? super FreightCommodityOther2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FreightCommodityOther2>create(FreightCommodityOther2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FreightCommodityOther2> validator() {
		return new FreightCommodityOther2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FreightCommodityOther2> typeFormatValidator() {
		return new FreightCommodityOther2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FreightCommodityOther2, Set<String>> onlyExistsValidator() {
		return new FreightCommodityOther2OnlyExistsValidator();
	}
}
