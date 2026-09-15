package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.CreditEventIndexReferenceInformation;
import fpml.consolidated.cd.validation.CreditEventIndexReferenceInformationTypeFormatValidator;
import fpml.consolidated.cd.validation.CreditEventIndexReferenceInformationValidator;
import fpml.consolidated.cd.validation.exists.CreditEventIndexReferenceInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditEventIndexReferenceInformation.class)
public class CreditEventIndexReferenceInformationMeta implements RosettaMetaData<CreditEventIndexReferenceInformation> {

	@Override
	public List<Validator<? super CreditEventIndexReferenceInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditEventIndexReferenceInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditEventIndexReferenceInformation> validator(ValidatorFactory factory) {
		return factory.<CreditEventIndexReferenceInformation>create(CreditEventIndexReferenceInformationValidator.class);
	}

	@Override
	public Validator<? super CreditEventIndexReferenceInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditEventIndexReferenceInformation>create(CreditEventIndexReferenceInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditEventIndexReferenceInformation> validator() {
		return new CreditEventIndexReferenceInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditEventIndexReferenceInformation> typeFormatValidator() {
		return new CreditEventIndexReferenceInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditEventIndexReferenceInformation, Set<String>> onlyExistsValidator() {
		return new CreditEventIndexReferenceInformationOnlyExistsValidator();
	}
}
