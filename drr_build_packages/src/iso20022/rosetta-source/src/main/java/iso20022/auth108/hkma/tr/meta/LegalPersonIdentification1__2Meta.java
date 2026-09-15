package iso20022.auth108.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.hkma.tr.LegalPersonIdentification1__2;
import iso20022.auth108.hkma.tr.validation.LegalPersonIdentification1__2TypeFormatValidator;
import iso20022.auth108.hkma.tr.validation.LegalPersonIdentification1__2Validator;
import iso20022.auth108.hkma.tr.validation.exists.LegalPersonIdentification1__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LegalPersonIdentification1__2.class)
public class LegalPersonIdentification1__2Meta implements RosettaMetaData<LegalPersonIdentification1__2> {

	@Override
	public List<Validator<? super LegalPersonIdentification1__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegalPersonIdentification1__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegalPersonIdentification1__2> validator(ValidatorFactory factory) {
		return factory.<LegalPersonIdentification1__2>create(LegalPersonIdentification1__2Validator.class);
	}

	@Override
	public Validator<? super LegalPersonIdentification1__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegalPersonIdentification1__2>create(LegalPersonIdentification1__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegalPersonIdentification1__2> validator() {
		return new LegalPersonIdentification1__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LegalPersonIdentification1__2> typeFormatValidator() {
		return new LegalPersonIdentification1__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegalPersonIdentification1__2, Set<String>> onlyExistsValidator() {
		return new LegalPersonIdentification1__2OnlyExistsValidator();
	}
}
