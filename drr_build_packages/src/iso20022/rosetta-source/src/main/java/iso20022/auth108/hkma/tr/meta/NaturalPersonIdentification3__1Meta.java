package iso20022.auth108.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.hkma.tr.NaturalPersonIdentification3__1;
import iso20022.auth108.hkma.tr.validation.NaturalPersonIdentification3__1TypeFormatValidator;
import iso20022.auth108.hkma.tr.validation.NaturalPersonIdentification3__1Validator;
import iso20022.auth108.hkma.tr.validation.exists.NaturalPersonIdentification3__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NaturalPersonIdentification3__1.class)
public class NaturalPersonIdentification3__1Meta implements RosettaMetaData<NaturalPersonIdentification3__1> {

	@Override
	public List<Validator<? super NaturalPersonIdentification3__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NaturalPersonIdentification3__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NaturalPersonIdentification3__1> validator(ValidatorFactory factory) {
		return factory.<NaturalPersonIdentification3__1>create(NaturalPersonIdentification3__1Validator.class);
	}

	@Override
	public Validator<? super NaturalPersonIdentification3__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NaturalPersonIdentification3__1>create(NaturalPersonIdentification3__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NaturalPersonIdentification3__1> validator() {
		return new NaturalPersonIdentification3__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super NaturalPersonIdentification3__1> typeFormatValidator() {
		return new NaturalPersonIdentification3__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NaturalPersonIdentification3__1, Set<String>> onlyExistsValidator() {
		return new NaturalPersonIdentification3__1OnlyExistsValidator();
	}
}
