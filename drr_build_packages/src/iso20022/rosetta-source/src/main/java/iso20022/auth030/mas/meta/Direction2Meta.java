package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.Direction2;
import iso20022.auth030.mas.validation.Direction2TypeFormatValidator;
import iso20022.auth030.mas.validation.Direction2Validator;
import iso20022.auth030.mas.validation.exists.Direction2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Direction2.class)
public class Direction2Meta implements RosettaMetaData<Direction2> {

	@Override
	public List<Validator<? super Direction2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Direction2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Direction2> validator(ValidatorFactory factory) {
		return factory.<Direction2>create(Direction2Validator.class);
	}

	@Override
	public Validator<? super Direction2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Direction2>create(Direction2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Direction2> validator() {
		return new Direction2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super Direction2> typeFormatValidator() {
		return new Direction2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Direction2, Set<String>> onlyExistsValidator() {
		return new Direction2OnlyExistsValidator();
	}
}
