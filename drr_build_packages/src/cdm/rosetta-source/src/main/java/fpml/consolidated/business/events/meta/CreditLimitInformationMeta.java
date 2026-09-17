package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CreditLimitInformation;
import fpml.consolidated.business.events.validation.CreditLimitInformationTypeFormatValidator;
import fpml.consolidated.business.events.validation.CreditLimitInformationValidator;
import fpml.consolidated.business.events.validation.exists.CreditLimitInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditLimitInformation.class)
public class CreditLimitInformationMeta implements RosettaMetaData<CreditLimitInformation> {

	@Override
	public List<Validator<? super CreditLimitInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditLimitInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditLimitInformation> validator(ValidatorFactory factory) {
		return factory.<CreditLimitInformation>create(CreditLimitInformationValidator.class);
	}

	@Override
	public Validator<? super CreditLimitInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditLimitInformation>create(CreditLimitInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditLimitInformation> validator() {
		return new CreditLimitInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditLimitInformation> typeFormatValidator() {
		return new CreditLimitInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditLimitInformation, Set<String>> onlyExistsValidator() {
		return new CreditLimitInformationOnlyExistsValidator();
	}
}
