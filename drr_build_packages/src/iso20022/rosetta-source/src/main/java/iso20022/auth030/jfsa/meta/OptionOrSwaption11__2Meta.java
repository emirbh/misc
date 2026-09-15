package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.OptionOrSwaption11__2;
import iso20022.auth030.jfsa.validation.OptionOrSwaption11__2TypeFormatValidator;
import iso20022.auth030.jfsa.validation.OptionOrSwaption11__2Validator;
import iso20022.auth030.jfsa.validation.exists.OptionOrSwaption11__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionOrSwaption11__2.class)
public class OptionOrSwaption11__2Meta implements RosettaMetaData<OptionOrSwaption11__2> {

	@Override
	public List<Validator<? super OptionOrSwaption11__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionOrSwaption11__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionOrSwaption11__2> validator(ValidatorFactory factory) {
		return factory.<OptionOrSwaption11__2>create(OptionOrSwaption11__2Validator.class);
	}

	@Override
	public Validator<? super OptionOrSwaption11__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionOrSwaption11__2>create(OptionOrSwaption11__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionOrSwaption11__2> validator() {
		return new OptionOrSwaption11__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionOrSwaption11__2> typeFormatValidator() {
		return new OptionOrSwaption11__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionOrSwaption11__2, Set<String>> onlyExistsValidator() {
		return new OptionOrSwaption11__2OnlyExistsValidator();
	}
}
