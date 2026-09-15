package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.validation.JurisdictionPartyInformationTypeFormatValidator;
import drr.regulation.common.validation.JurisdictionPartyInformationValidator;
import drr.regulation.common.validation.exists.JurisdictionPartyInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=JurisdictionPartyInformation.class)
public class JurisdictionPartyInformationMeta implements RosettaMetaData<JurisdictionPartyInformation> {

	@Override
	public List<Validator<? super JurisdictionPartyInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super JurisdictionPartyInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super JurisdictionPartyInformation> validator(ValidatorFactory factory) {
		return factory.<JurisdictionPartyInformation>create(JurisdictionPartyInformationValidator.class);
	}

	@Override
	public Validator<? super JurisdictionPartyInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<JurisdictionPartyInformation>create(JurisdictionPartyInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super JurisdictionPartyInformation> validator() {
		return new JurisdictionPartyInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super JurisdictionPartyInformation> typeFormatValidator() {
		return new JurisdictionPartyInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super JurisdictionPartyInformation, Set<String>> onlyExistsValidator() {
		return new JurisdictionPartyInformationOnlyExistsValidator();
	}
}
