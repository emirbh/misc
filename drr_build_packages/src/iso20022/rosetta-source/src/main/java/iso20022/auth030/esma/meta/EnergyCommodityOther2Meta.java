package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.EnergyCommodityOther2;
import iso20022.auth030.esma.validation.EnergyCommodityOther2TypeFormatValidator;
import iso20022.auth030.esma.validation.EnergyCommodityOther2Validator;
import iso20022.auth030.esma.validation.exists.EnergyCommodityOther2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnergyCommodityOther2.class)
public class EnergyCommodityOther2Meta implements RosettaMetaData<EnergyCommodityOther2> {

	@Override
	public List<Validator<? super EnergyCommodityOther2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnergyCommodityOther2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnergyCommodityOther2> validator(ValidatorFactory factory) {
		return factory.<EnergyCommodityOther2>create(EnergyCommodityOther2Validator.class);
	}

	@Override
	public Validator<? super EnergyCommodityOther2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnergyCommodityOther2>create(EnergyCommodityOther2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityOther2> validator() {
		return new EnergyCommodityOther2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityOther2> typeFormatValidator() {
		return new EnergyCommodityOther2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnergyCommodityOther2, Set<String>> onlyExistsValidator() {
		return new EnergyCommodityOther2OnlyExistsValidator();
	}
}
