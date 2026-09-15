package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.ClearingExceptionOrExemption3Choice__1;
import iso20022.auth030.jfsa.validation.ClearingExceptionOrExemption3Choice__1TypeFormatValidator;
import iso20022.auth030.jfsa.validation.ClearingExceptionOrExemption3Choice__1Validator;
import iso20022.auth030.jfsa.validation.exists.ClearingExceptionOrExemption3Choice__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ClearingExceptionOrExemption3Choice__1.class)
public class ClearingExceptionOrExemption3Choice__1Meta implements RosettaMetaData<ClearingExceptionOrExemption3Choice__1> {

	@Override
	public List<Validator<? super ClearingExceptionOrExemption3Choice__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingExceptionOrExemption3Choice__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingExceptionOrExemption3Choice__1> validator(ValidatorFactory factory) {
		return factory.<ClearingExceptionOrExemption3Choice__1>create(ClearingExceptionOrExemption3Choice__1Validator.class);
	}

	@Override
	public Validator<? super ClearingExceptionOrExemption3Choice__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingExceptionOrExemption3Choice__1>create(ClearingExceptionOrExemption3Choice__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingExceptionOrExemption3Choice__1> validator() {
		return new ClearingExceptionOrExemption3Choice__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingExceptionOrExemption3Choice__1> typeFormatValidator() {
		return new ClearingExceptionOrExemption3Choice__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingExceptionOrExemption3Choice__1, Set<String>> onlyExistsValidator() {
		return new ClearingExceptionOrExemption3Choice__1OnlyExistsValidator();
	}
}
