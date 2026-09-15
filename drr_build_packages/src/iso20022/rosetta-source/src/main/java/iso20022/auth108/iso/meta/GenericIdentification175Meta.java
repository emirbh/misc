package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.GenericIdentification175;
import iso20022.auth108.iso.validation.GenericIdentification175TypeFormatValidator;
import iso20022.auth108.iso.validation.GenericIdentification175Validator;
import iso20022.auth108.iso.validation.exists.GenericIdentification175OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericIdentification175.class)
public class GenericIdentification175Meta implements RosettaMetaData<GenericIdentification175> {

	@Override
	public List<Validator<? super GenericIdentification175>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericIdentification175, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericIdentification175> validator(ValidatorFactory factory) {
		return factory.<GenericIdentification175>create(GenericIdentification175Validator.class);
	}

	@Override
	public Validator<? super GenericIdentification175> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericIdentification175>create(GenericIdentification175TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericIdentification175> validator() {
		return new GenericIdentification175Validator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericIdentification175> typeFormatValidator() {
		return new GenericIdentification175TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericIdentification175, Set<String>> onlyExistsValidator() {
		return new GenericIdentification175OnlyExistsValidator();
	}
}
