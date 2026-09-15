package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.Package4__1;
import iso20022.auth030.mas.validation.Package4__1TypeFormatValidator;
import iso20022.auth030.mas.validation.Package4__1Validator;
import iso20022.auth030.mas.validation.exists.Package4__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Package4__1.class)
public class Package4__1Meta implements RosettaMetaData<Package4__1> {

	@Override
	public List<Validator<? super Package4__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Package4__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Package4__1> validator(ValidatorFactory factory) {
		return factory.<Package4__1>create(Package4__1Validator.class);
	}

	@Override
	public Validator<? super Package4__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Package4__1>create(Package4__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Package4__1> validator() {
		return new Package4__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super Package4__1> typeFormatValidator() {
		return new Package4__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Package4__1, Set<String>> onlyExistsValidator() {
		return new Package4__1OnlyExistsValidator();
	}
}
