package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.SupervisoryBody;
import fpml.consolidated.shared.validation.SupervisoryBodyTypeFormatValidator;
import fpml.consolidated.shared.validation.SupervisoryBodyValidator;
import fpml.consolidated.shared.validation.exists.SupervisoryBodyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SupervisoryBody.class)
public class SupervisoryBodyMeta implements RosettaMetaData<SupervisoryBody> {

	@Override
	public List<Validator<? super SupervisoryBody>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SupervisoryBody, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SupervisoryBody> validator(ValidatorFactory factory) {
		return factory.<SupervisoryBody>create(SupervisoryBodyValidator.class);
	}

	@Override
	public Validator<? super SupervisoryBody> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SupervisoryBody>create(SupervisoryBodyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SupervisoryBody> validator() {
		return new SupervisoryBodyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SupervisoryBody> typeFormatValidator() {
		return new SupervisoryBodyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SupervisoryBody, Set<String>> onlyExistsValidator() {
		return new SupervisoryBodyOnlyExistsValidator();
	}
}
