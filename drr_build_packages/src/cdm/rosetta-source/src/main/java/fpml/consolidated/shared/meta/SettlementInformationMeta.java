package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.SettlementInformation;
import fpml.consolidated.shared.validation.SettlementInformationTypeFormatValidator;
import fpml.consolidated.shared.validation.SettlementInformationValidator;
import fpml.consolidated.shared.validation.datarule.SettlementInformationChoice;
import fpml.consolidated.shared.validation.exists.SettlementInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementInformation.class)
public class SettlementInformationMeta implements RosettaMetaData<SettlementInformation> {

	@Override
	public List<Validator<? super SettlementInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SettlementInformation>create(SettlementInformationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SettlementInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementInformation> validator(ValidatorFactory factory) {
		return factory.<SettlementInformation>create(SettlementInformationValidator.class);
	}

	@Override
	public Validator<? super SettlementInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementInformation>create(SettlementInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementInformation> validator() {
		return new SettlementInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementInformation> typeFormatValidator() {
		return new SettlementInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementInformation, Set<String>> onlyExistsValidator() {
		return new SettlementInformationOnlyExistsValidator();
	}
}
