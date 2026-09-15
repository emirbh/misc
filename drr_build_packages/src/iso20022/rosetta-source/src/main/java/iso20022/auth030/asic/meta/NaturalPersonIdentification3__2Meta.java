package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.NaturalPersonIdentification3__2;
import iso20022.auth030.asic.validation.NaturalPersonIdentification3__2TypeFormatValidator;
import iso20022.auth030.asic.validation.NaturalPersonIdentification3__2Validator;
import iso20022.auth030.asic.validation.exists.NaturalPersonIdentification3__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NaturalPersonIdentification3__2.class)
public class NaturalPersonIdentification3__2Meta implements RosettaMetaData<NaturalPersonIdentification3__2> {

	@Override
	public List<Validator<? super NaturalPersonIdentification3__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NaturalPersonIdentification3__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NaturalPersonIdentification3__2> validator(ValidatorFactory factory) {
		return factory.<NaturalPersonIdentification3__2>create(NaturalPersonIdentification3__2Validator.class);
	}

	@Override
	public Validator<? super NaturalPersonIdentification3__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NaturalPersonIdentification3__2>create(NaturalPersonIdentification3__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NaturalPersonIdentification3__2> validator() {
		return new NaturalPersonIdentification3__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super NaturalPersonIdentification3__2> typeFormatValidator() {
		return new NaturalPersonIdentification3__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NaturalPersonIdentification3__2, Set<String>> onlyExistsValidator() {
		return new NaturalPersonIdentification3__2OnlyExistsValidator();
	}
}
