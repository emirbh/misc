package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.NaturalPersonIdentification2__2;
import iso20022.auth030.asic.validation.NaturalPersonIdentification2__2TypeFormatValidator;
import iso20022.auth030.asic.validation.NaturalPersonIdentification2__2Validator;
import iso20022.auth030.asic.validation.exists.NaturalPersonIdentification2__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NaturalPersonIdentification2__2.class)
public class NaturalPersonIdentification2__2Meta implements RosettaMetaData<NaturalPersonIdentification2__2> {

	@Override
	public List<Validator<? super NaturalPersonIdentification2__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NaturalPersonIdentification2__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NaturalPersonIdentification2__2> validator(ValidatorFactory factory) {
		return factory.<NaturalPersonIdentification2__2>create(NaturalPersonIdentification2__2Validator.class);
	}

	@Override
	public Validator<? super NaturalPersonIdentification2__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NaturalPersonIdentification2__2>create(NaturalPersonIdentification2__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NaturalPersonIdentification2__2> validator() {
		return new NaturalPersonIdentification2__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super NaturalPersonIdentification2__2> typeFormatValidator() {
		return new NaturalPersonIdentification2__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NaturalPersonIdentification2__2, Set<String>> onlyExistsValidator() {
		return new NaturalPersonIdentification2__2OnlyExistsValidator();
	}
}
