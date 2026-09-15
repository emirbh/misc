package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.NotionalAmount6__2;
import iso20022.auth030.jfsa.validation.NotionalAmount6__2TypeFormatValidator;
import iso20022.auth030.jfsa.validation.NotionalAmount6__2Validator;
import iso20022.auth030.jfsa.validation.exists.NotionalAmount6__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NotionalAmount6__2.class)
public class NotionalAmount6__2Meta implements RosettaMetaData<NotionalAmount6__2> {

	@Override
	public List<Validator<? super NotionalAmount6__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalAmount6__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalAmount6__2> validator(ValidatorFactory factory) {
		return factory.<NotionalAmount6__2>create(NotionalAmount6__2Validator.class);
	}

	@Override
	public Validator<? super NotionalAmount6__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalAmount6__2>create(NotionalAmount6__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalAmount6__2> validator() {
		return new NotionalAmount6__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalAmount6__2> typeFormatValidator() {
		return new NotionalAmount6__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalAmount6__2, Set<String>> onlyExistsValidator() {
		return new NotionalAmount6__2OnlyExistsValidator();
	}
}
