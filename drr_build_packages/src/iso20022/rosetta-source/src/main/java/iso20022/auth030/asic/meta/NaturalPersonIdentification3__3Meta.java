package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.NaturalPersonIdentification3__3;
import iso20022.auth030.asic.validation.NaturalPersonIdentification3__3TypeFormatValidator;
import iso20022.auth030.asic.validation.NaturalPersonIdentification3__3Validator;
import iso20022.auth030.asic.validation.exists.NaturalPersonIdentification3__3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NaturalPersonIdentification3__3.class)
public class NaturalPersonIdentification3__3Meta implements RosettaMetaData<NaturalPersonIdentification3__3> {

	@Override
	public List<Validator<? super NaturalPersonIdentification3__3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NaturalPersonIdentification3__3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NaturalPersonIdentification3__3> validator(ValidatorFactory factory) {
		return factory.<NaturalPersonIdentification3__3>create(NaturalPersonIdentification3__3Validator.class);
	}

	@Override
	public Validator<? super NaturalPersonIdentification3__3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NaturalPersonIdentification3__3>create(NaturalPersonIdentification3__3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NaturalPersonIdentification3__3> validator() {
		return new NaturalPersonIdentification3__3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super NaturalPersonIdentification3__3> typeFormatValidator() {
		return new NaturalPersonIdentification3__3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NaturalPersonIdentification3__3, Set<String>> onlyExistsValidator() {
		return new NaturalPersonIdentification3__3OnlyExistsValidator();
	}
}
