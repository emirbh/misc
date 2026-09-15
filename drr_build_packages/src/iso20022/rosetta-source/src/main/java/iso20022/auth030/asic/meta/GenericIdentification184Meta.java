package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.GenericIdentification184;
import iso20022.auth030.asic.validation.GenericIdentification184TypeFormatValidator;
import iso20022.auth030.asic.validation.GenericIdentification184Validator;
import iso20022.auth030.asic.validation.exists.GenericIdentification184OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericIdentification184.class)
public class GenericIdentification184Meta implements RosettaMetaData<GenericIdentification184> {

	@Override
	public List<Validator<? super GenericIdentification184>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericIdentification184, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericIdentification184> validator(ValidatorFactory factory) {
		return factory.<GenericIdentification184>create(GenericIdentification184Validator.class);
	}

	@Override
	public Validator<? super GenericIdentification184> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericIdentification184>create(GenericIdentification184TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericIdentification184> validator() {
		return new GenericIdentification184Validator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericIdentification184> typeFormatValidator() {
		return new GenericIdentification184TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericIdentification184, Set<String>> onlyExistsValidator() {
		return new GenericIdentification184OnlyExistsValidator();
	}
}
