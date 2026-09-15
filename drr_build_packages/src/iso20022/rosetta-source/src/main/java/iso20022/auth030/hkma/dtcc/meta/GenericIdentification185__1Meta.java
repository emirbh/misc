package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.GenericIdentification185__1;
import iso20022.auth030.hkma.dtcc.validation.GenericIdentification185__1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.GenericIdentification185__1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.GenericIdentification185__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericIdentification185__1.class)
public class GenericIdentification185__1Meta implements RosettaMetaData<GenericIdentification185__1> {

	@Override
	public List<Validator<? super GenericIdentification185__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericIdentification185__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericIdentification185__1> validator(ValidatorFactory factory) {
		return factory.<GenericIdentification185__1>create(GenericIdentification185__1Validator.class);
	}

	@Override
	public Validator<? super GenericIdentification185__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericIdentification185__1>create(GenericIdentification185__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericIdentification185__1> validator() {
		return new GenericIdentification185__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericIdentification185__1> typeFormatValidator() {
		return new GenericIdentification185__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericIdentification185__1, Set<String>> onlyExistsValidator() {
		return new GenericIdentification185__1OnlyExistsValidator();
	}
}
