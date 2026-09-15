package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.LegalPersonIdentification1;
import iso20022.auth108.iso.validation.LegalPersonIdentification1TypeFormatValidator;
import iso20022.auth108.iso.validation.LegalPersonIdentification1Validator;
import iso20022.auth108.iso.validation.exists.LegalPersonIdentification1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LegalPersonIdentification1.class)
public class LegalPersonIdentification1Meta implements RosettaMetaData<LegalPersonIdentification1> {

	@Override
	public List<Validator<? super LegalPersonIdentification1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegalPersonIdentification1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegalPersonIdentification1> validator(ValidatorFactory factory) {
		return factory.<LegalPersonIdentification1>create(LegalPersonIdentification1Validator.class);
	}

	@Override
	public Validator<? super LegalPersonIdentification1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegalPersonIdentification1>create(LegalPersonIdentification1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegalPersonIdentification1> validator() {
		return new LegalPersonIdentification1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LegalPersonIdentification1> typeFormatValidator() {
		return new LegalPersonIdentification1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegalPersonIdentification1, Set<String>> onlyExistsValidator() {
		return new LegalPersonIdentification1OnlyExistsValidator();
	}
}
