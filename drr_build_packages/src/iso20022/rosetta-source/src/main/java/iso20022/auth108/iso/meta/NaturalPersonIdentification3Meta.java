package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.NaturalPersonIdentification3;
import iso20022.auth108.iso.validation.NaturalPersonIdentification3TypeFormatValidator;
import iso20022.auth108.iso.validation.NaturalPersonIdentification3Validator;
import iso20022.auth108.iso.validation.exists.NaturalPersonIdentification3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NaturalPersonIdentification3.class)
public class NaturalPersonIdentification3Meta implements RosettaMetaData<NaturalPersonIdentification3> {

	@Override
	public List<Validator<? super NaturalPersonIdentification3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NaturalPersonIdentification3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NaturalPersonIdentification3> validator(ValidatorFactory factory) {
		return factory.<NaturalPersonIdentification3>create(NaturalPersonIdentification3Validator.class);
	}

	@Override
	public Validator<? super NaturalPersonIdentification3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NaturalPersonIdentification3>create(NaturalPersonIdentification3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NaturalPersonIdentification3> validator() {
		return new NaturalPersonIdentification3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super NaturalPersonIdentification3> typeFormatValidator() {
		return new NaturalPersonIdentification3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NaturalPersonIdentification3, Set<String>> onlyExistsValidator() {
		return new NaturalPersonIdentification3OnlyExistsValidator();
	}
}
