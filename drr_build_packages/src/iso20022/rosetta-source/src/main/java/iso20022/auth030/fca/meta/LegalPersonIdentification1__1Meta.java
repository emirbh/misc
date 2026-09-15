package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.LegalPersonIdentification1__1;
import iso20022.auth030.fca.validation.LegalPersonIdentification1__1TypeFormatValidator;
import iso20022.auth030.fca.validation.LegalPersonIdentification1__1Validator;
import iso20022.auth030.fca.validation.exists.LegalPersonIdentification1__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LegalPersonIdentification1__1.class)
public class LegalPersonIdentification1__1Meta implements RosettaMetaData<LegalPersonIdentification1__1> {

	@Override
	public List<Validator<? super LegalPersonIdentification1__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegalPersonIdentification1__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegalPersonIdentification1__1> validator(ValidatorFactory factory) {
		return factory.<LegalPersonIdentification1__1>create(LegalPersonIdentification1__1Validator.class);
	}

	@Override
	public Validator<? super LegalPersonIdentification1__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegalPersonIdentification1__1>create(LegalPersonIdentification1__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegalPersonIdentification1__1> validator() {
		return new LegalPersonIdentification1__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LegalPersonIdentification1__1> typeFormatValidator() {
		return new LegalPersonIdentification1__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegalPersonIdentification1__1, Set<String>> onlyExistsValidator() {
		return new LegalPersonIdentification1__1OnlyExistsValidator();
	}
}
