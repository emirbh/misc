package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.ClearingPartyAndTime21Choice__1;
import iso20022.auth030.fca.validation.ClearingPartyAndTime21Choice__1TypeFormatValidator;
import iso20022.auth030.fca.validation.ClearingPartyAndTime21Choice__1Validator;
import iso20022.auth030.fca.validation.exists.ClearingPartyAndTime21Choice__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ClearingPartyAndTime21Choice__1.class)
public class ClearingPartyAndTime21Choice__1Meta implements RosettaMetaData<ClearingPartyAndTime21Choice__1> {

	@Override
	public List<Validator<? super ClearingPartyAndTime21Choice__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingPartyAndTime21Choice__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingPartyAndTime21Choice__1> validator(ValidatorFactory factory) {
		return factory.<ClearingPartyAndTime21Choice__1>create(ClearingPartyAndTime21Choice__1Validator.class);
	}

	@Override
	public Validator<? super ClearingPartyAndTime21Choice__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingPartyAndTime21Choice__1>create(ClearingPartyAndTime21Choice__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingPartyAndTime21Choice__1> validator() {
		return new ClearingPartyAndTime21Choice__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingPartyAndTime21Choice__1> typeFormatValidator() {
		return new ClearingPartyAndTime21Choice__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingPartyAndTime21Choice__1, Set<String>> onlyExistsValidator() {
		return new ClearingPartyAndTime21Choice__1OnlyExistsValidator();
	}
}
