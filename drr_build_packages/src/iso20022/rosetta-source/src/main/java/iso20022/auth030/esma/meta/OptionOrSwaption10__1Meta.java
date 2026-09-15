package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.OptionOrSwaption10__1;
import iso20022.auth030.esma.validation.OptionOrSwaption10__1TypeFormatValidator;
import iso20022.auth030.esma.validation.OptionOrSwaption10__1Validator;
import iso20022.auth030.esma.validation.exists.OptionOrSwaption10__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionOrSwaption10__1.class)
public class OptionOrSwaption10__1Meta implements RosettaMetaData<OptionOrSwaption10__1> {

	@Override
	public List<Validator<? super OptionOrSwaption10__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionOrSwaption10__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionOrSwaption10__1> validator(ValidatorFactory factory) {
		return factory.<OptionOrSwaption10__1>create(OptionOrSwaption10__1Validator.class);
	}

	@Override
	public Validator<? super OptionOrSwaption10__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionOrSwaption10__1>create(OptionOrSwaption10__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionOrSwaption10__1> validator() {
		return new OptionOrSwaption10__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionOrSwaption10__1> typeFormatValidator() {
		return new OptionOrSwaption10__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionOrSwaption10__1, Set<String>> onlyExistsValidator() {
		return new OptionOrSwaption10__1OnlyExistsValidator();
	}
}
