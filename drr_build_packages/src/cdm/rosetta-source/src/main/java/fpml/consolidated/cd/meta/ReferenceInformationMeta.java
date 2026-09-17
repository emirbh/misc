package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.ReferenceInformation;
import fpml.consolidated.cd.validation.ReferenceInformationTypeFormatValidator;
import fpml.consolidated.cd.validation.ReferenceInformationValidator;
import fpml.consolidated.cd.validation.datarule.ReferenceInformationChoice;
import fpml.consolidated.cd.validation.exists.ReferenceInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReferenceInformation.class)
public class ReferenceInformationMeta implements RosettaMetaData<ReferenceInformation> {

	@Override
	public List<Validator<? super ReferenceInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReferenceInformation>create(ReferenceInformationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReferenceInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReferenceInformation> validator(ValidatorFactory factory) {
		return factory.<ReferenceInformation>create(ReferenceInformationValidator.class);
	}

	@Override
	public Validator<? super ReferenceInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReferenceInformation>create(ReferenceInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceInformation> validator() {
		return new ReferenceInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceInformation> typeFormatValidator() {
		return new ReferenceInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceInformation, Set<String>> onlyExistsValidator() {
		return new ReferenceInformationOnlyExistsValidator();
	}
}
