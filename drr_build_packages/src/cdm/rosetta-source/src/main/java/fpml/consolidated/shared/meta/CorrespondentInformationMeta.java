package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.CorrespondentInformation;
import fpml.consolidated.shared.validation.CorrespondentInformationTypeFormatValidator;
import fpml.consolidated.shared.validation.CorrespondentInformationValidator;
import fpml.consolidated.shared.validation.datarule.CorrespondentInformationChoice;
import fpml.consolidated.shared.validation.exists.CorrespondentInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CorrespondentInformation.class)
public class CorrespondentInformationMeta implements RosettaMetaData<CorrespondentInformation> {

	@Override
	public List<Validator<? super CorrespondentInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CorrespondentInformation>create(CorrespondentInformationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CorrespondentInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CorrespondentInformation> validator(ValidatorFactory factory) {
		return factory.<CorrespondentInformation>create(CorrespondentInformationValidator.class);
	}

	@Override
	public Validator<? super CorrespondentInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CorrespondentInformation>create(CorrespondentInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CorrespondentInformation> validator() {
		return new CorrespondentInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CorrespondentInformation> typeFormatValidator() {
		return new CorrespondentInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorrespondentInformation, Set<String>> onlyExistsValidator() {
		return new CorrespondentInformationOnlyExistsValidator();
	}
}
