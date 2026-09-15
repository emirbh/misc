package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.SECPartyInformation;
import drr.regulation.common.validation.SECPartyInformationTypeFormatValidator;
import drr.regulation.common.validation.SECPartyInformationValidator;
import drr.regulation.common.validation.exists.SECPartyInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=SECPartyInformation.class)
public class SECPartyInformationMeta implements RosettaMetaData<SECPartyInformation> {

	@Override
	public List<Validator<? super SECPartyInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SECPartyInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SECPartyInformation> validator(ValidatorFactory factory) {
		return factory.<SECPartyInformation>create(SECPartyInformationValidator.class);
	}

	@Override
	public Validator<? super SECPartyInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SECPartyInformation>create(SECPartyInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SECPartyInformation> validator() {
		return new SECPartyInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SECPartyInformation> typeFormatValidator() {
		return new SECPartyInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SECPartyInformation, Set<String>> onlyExistsValidator() {
		return new SECPartyInformationOnlyExistsValidator();
	}
}
