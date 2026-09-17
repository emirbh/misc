package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.BasketReferenceInformation;
import fpml.consolidated.cd.validation.BasketReferenceInformationTypeFormatValidator;
import fpml.consolidated.cd.validation.BasketReferenceInformationValidator;
import fpml.consolidated.cd.validation.datarule.BasketReferenceInformationChoice;
import fpml.consolidated.cd.validation.exists.BasketReferenceInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BasketReferenceInformation.class)
public class BasketReferenceInformationMeta implements RosettaMetaData<BasketReferenceInformation> {

	@Override
	public List<Validator<? super BasketReferenceInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<BasketReferenceInformation>create(BasketReferenceInformationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BasketReferenceInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BasketReferenceInformation> validator(ValidatorFactory factory) {
		return factory.<BasketReferenceInformation>create(BasketReferenceInformationValidator.class);
	}

	@Override
	public Validator<? super BasketReferenceInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BasketReferenceInformation>create(BasketReferenceInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BasketReferenceInformation> validator() {
		return new BasketReferenceInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BasketReferenceInformation> typeFormatValidator() {
		return new BasketReferenceInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketReferenceInformation, Set<String>> onlyExistsValidator() {
		return new BasketReferenceInformationOnlyExistsValidator();
	}
}
