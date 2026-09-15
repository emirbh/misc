package drr.base.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.PartyInformation;
import drr.base.trade.validation.PartyInformationTypeFormatValidator;
import drr.base.trade.validation.PartyInformationValidator;
import drr.base.trade.validation.exists.PartyInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=PartyInformation.class)
public class PartyInformationMeta implements RosettaMetaData<PartyInformation> {

	@Override
	public List<Validator<? super PartyInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyInformation> validator(ValidatorFactory factory) {
		return factory.<PartyInformation>create(PartyInformationValidator.class);
	}

	@Override
	public Validator<? super PartyInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyInformation>create(PartyInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyInformation> validator() {
		return new PartyInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyInformation> typeFormatValidator() {
		return new PartyInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyInformation, Set<String>> onlyExistsValidator() {
		return new PartyInformationOnlyExistsValidator();
	}
}
