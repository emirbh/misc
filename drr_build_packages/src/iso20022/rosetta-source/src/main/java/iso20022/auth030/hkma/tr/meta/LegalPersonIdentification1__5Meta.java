package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.LegalPersonIdentification1__5;
import iso20022.auth030.hkma.tr.validation.LegalPersonIdentification1__5TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.LegalPersonIdentification1__5Validator;
import iso20022.auth030.hkma.tr.validation.exists.LegalPersonIdentification1__5OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LegalPersonIdentification1__5.class)
public class LegalPersonIdentification1__5Meta implements RosettaMetaData<LegalPersonIdentification1__5> {

	@Override
	public List<Validator<? super LegalPersonIdentification1__5>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegalPersonIdentification1__5, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegalPersonIdentification1__5> validator(ValidatorFactory factory) {
		return factory.<LegalPersonIdentification1__5>create(LegalPersonIdentification1__5Validator.class);
	}

	@Override
	public Validator<? super LegalPersonIdentification1__5> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegalPersonIdentification1__5>create(LegalPersonIdentification1__5TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegalPersonIdentification1__5> validator() {
		return new LegalPersonIdentification1__5Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LegalPersonIdentification1__5> typeFormatValidator() {
		return new LegalPersonIdentification1__5TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegalPersonIdentification1__5, Set<String>> onlyExistsValidator() {
		return new LegalPersonIdentification1__5OnlyExistsValidator();
	}
}
