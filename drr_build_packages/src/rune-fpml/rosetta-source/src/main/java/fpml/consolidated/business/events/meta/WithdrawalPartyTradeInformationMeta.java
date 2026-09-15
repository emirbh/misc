package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.WithdrawalPartyTradeInformation;
import fpml.consolidated.business.events.validation.WithdrawalPartyTradeInformationTypeFormatValidator;
import fpml.consolidated.business.events.validation.WithdrawalPartyTradeInformationValidator;
import fpml.consolidated.business.events.validation.exists.WithdrawalPartyTradeInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=WithdrawalPartyTradeInformation.class)
public class WithdrawalPartyTradeInformationMeta implements RosettaMetaData<WithdrawalPartyTradeInformation> {

	@Override
	public List<Validator<? super WithdrawalPartyTradeInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WithdrawalPartyTradeInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WithdrawalPartyTradeInformation> validator(ValidatorFactory factory) {
		return factory.<WithdrawalPartyTradeInformation>create(WithdrawalPartyTradeInformationValidator.class);
	}

	@Override
	public Validator<? super WithdrawalPartyTradeInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<WithdrawalPartyTradeInformation>create(WithdrawalPartyTradeInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super WithdrawalPartyTradeInformation> validator() {
		return new WithdrawalPartyTradeInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super WithdrawalPartyTradeInformation> typeFormatValidator() {
		return new WithdrawalPartyTradeInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WithdrawalPartyTradeInformation, Set<String>> onlyExistsValidator() {
		return new WithdrawalPartyTradeInformationOnlyExistsValidator();
	}
}
