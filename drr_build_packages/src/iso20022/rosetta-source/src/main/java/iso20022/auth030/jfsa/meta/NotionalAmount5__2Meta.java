package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.NotionalAmount5__2;
import iso20022.auth030.jfsa.validation.NotionalAmount5__2TypeFormatValidator;
import iso20022.auth030.jfsa.validation.NotionalAmount5__2Validator;
import iso20022.auth030.jfsa.validation.exists.NotionalAmount5__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NotionalAmount5__2.class)
public class NotionalAmount5__2Meta implements RosettaMetaData<NotionalAmount5__2> {

	@Override
	public List<Validator<? super NotionalAmount5__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalAmount5__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalAmount5__2> validator(ValidatorFactory factory) {
		return factory.<NotionalAmount5__2>create(NotionalAmount5__2Validator.class);
	}

	@Override
	public Validator<? super NotionalAmount5__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalAmount5__2>create(NotionalAmount5__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalAmount5__2> validator() {
		return new NotionalAmount5__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalAmount5__2> typeFormatValidator() {
		return new NotionalAmount5__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalAmount5__2, Set<String>> onlyExistsValidator() {
		return new NotionalAmount5__2OnlyExistsValidator();
	}
}
