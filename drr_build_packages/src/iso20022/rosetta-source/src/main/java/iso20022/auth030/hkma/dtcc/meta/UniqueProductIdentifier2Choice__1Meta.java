package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.UniqueProductIdentifier2Choice__1;
import iso20022.auth030.hkma.dtcc.validation.UniqueProductIdentifier2Choice__1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.UniqueProductIdentifier2Choice__1Validator;
import iso20022.auth030.hkma.dtcc.validation.datarule.UniqueProductIdentifier2Choice__1Choice;
import iso20022.auth030.hkma.dtcc.validation.exists.UniqueProductIdentifier2Choice__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=UniqueProductIdentifier2Choice__1.class)
public class UniqueProductIdentifier2Choice__1Meta implements RosettaMetaData<UniqueProductIdentifier2Choice__1> {

	@Override
	public List<Validator<? super UniqueProductIdentifier2Choice__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<UniqueProductIdentifier2Choice__1>create(UniqueProductIdentifier2Choice__1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super UniqueProductIdentifier2Choice__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UniqueProductIdentifier2Choice__1> validator(ValidatorFactory factory) {
		return factory.<UniqueProductIdentifier2Choice__1>create(UniqueProductIdentifier2Choice__1Validator.class);
	}

	@Override
	public Validator<? super UniqueProductIdentifier2Choice__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UniqueProductIdentifier2Choice__1>create(UniqueProductIdentifier2Choice__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UniqueProductIdentifier2Choice__1> validator() {
		return new UniqueProductIdentifier2Choice__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super UniqueProductIdentifier2Choice__1> typeFormatValidator() {
		return new UniqueProductIdentifier2Choice__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UniqueProductIdentifier2Choice__1, Set<String>> onlyExistsValidator() {
		return new UniqueProductIdentifier2Choice__1OnlyExistsValidator();
	}
}
