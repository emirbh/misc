package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.FloatingRate13__2;
import iso20022.auth030.asic.validation.FloatingRate13__2TypeFormatValidator;
import iso20022.auth030.asic.validation.FloatingRate13__2Validator;
import iso20022.auth030.asic.validation.exists.FloatingRate13__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FloatingRate13__2.class)
public class FloatingRate13__2Meta implements RosettaMetaData<FloatingRate13__2> {

	@Override
	public List<Validator<? super FloatingRate13__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRate13__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRate13__2> validator(ValidatorFactory factory) {
		return factory.<FloatingRate13__2>create(FloatingRate13__2Validator.class);
	}

	@Override
	public Validator<? super FloatingRate13__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingRate13__2>create(FloatingRate13__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRate13__2> validator() {
		return new FloatingRate13__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRate13__2> typeFormatValidator() {
		return new FloatingRate13__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRate13__2, Set<String>> onlyExistsValidator() {
		return new FloatingRate13__2OnlyExistsValidator();
	}
}
