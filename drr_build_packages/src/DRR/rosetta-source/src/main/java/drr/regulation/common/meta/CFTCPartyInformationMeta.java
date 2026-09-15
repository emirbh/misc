package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.CFTCPartyInformation;
import drr.regulation.common.validation.CFTCPartyInformationTypeFormatValidator;
import drr.regulation.common.validation.CFTCPartyInformationValidator;
import drr.regulation.common.validation.exists.CFTCPartyInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CFTCPartyInformation.class)
public class CFTCPartyInformationMeta implements RosettaMetaData<CFTCPartyInformation> {

	@Override
	public List<Validator<? super CFTCPartyInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CFTCPartyInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CFTCPartyInformation> validator(ValidatorFactory factory) {
		return factory.<CFTCPartyInformation>create(CFTCPartyInformationValidator.class);
	}

	@Override
	public Validator<? super CFTCPartyInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CFTCPartyInformation>create(CFTCPartyInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CFTCPartyInformation> validator() {
		return new CFTCPartyInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CFTCPartyInformation> typeFormatValidator() {
		return new CFTCPartyInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CFTCPartyInformation, Set<String>> onlyExistsValidator() {
		return new CFTCPartyInformationOnlyExistsValidator();
	}
}
