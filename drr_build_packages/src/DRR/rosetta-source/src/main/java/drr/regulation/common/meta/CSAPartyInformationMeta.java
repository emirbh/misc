package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.CSAPartyInformation;
import drr.regulation.common.validation.CSAPartyInformationTypeFormatValidator;
import drr.regulation.common.validation.CSAPartyInformationValidator;
import drr.regulation.common.validation.exists.CSAPartyInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CSAPartyInformation.class)
public class CSAPartyInformationMeta implements RosettaMetaData<CSAPartyInformation> {

	@Override
	public List<Validator<? super CSAPartyInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CSAPartyInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CSAPartyInformation> validator(ValidatorFactory factory) {
		return factory.<CSAPartyInformation>create(CSAPartyInformationValidator.class);
	}

	@Override
	public Validator<? super CSAPartyInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CSAPartyInformation>create(CSAPartyInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CSAPartyInformation> validator() {
		return new CSAPartyInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CSAPartyInformation> typeFormatValidator() {
		return new CSAPartyInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CSAPartyInformation, Set<String>> onlyExistsValidator() {
		return new CSAPartyInformationOnlyExistsValidator();
	}
}
