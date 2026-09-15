package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.FCAPartyInformation;
import drr.regulation.common.validation.FCAPartyInformationTypeFormatValidator;
import drr.regulation.common.validation.FCAPartyInformationValidator;
import drr.regulation.common.validation.datarule.FCAPartyInformationCorporateSector;
import drr.regulation.common.validation.datarule.FCAPartyInformationFinancialNonFinancial;
import drr.regulation.common.validation.exists.FCAPartyInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=FCAPartyInformation.class)
public class FCAPartyInformationMeta implements RosettaMetaData<FCAPartyInformation> {

	@Override
	public List<Validator<? super FCAPartyInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FCAPartyInformation>create(FCAPartyInformationCorporateSector.class),
			factory.<FCAPartyInformation>create(FCAPartyInformationFinancialNonFinancial.class)
		);
	}
	
	@Override
	public List<Function<? super FCAPartyInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FCAPartyInformation> validator(ValidatorFactory factory) {
		return factory.<FCAPartyInformation>create(FCAPartyInformationValidator.class);
	}

	@Override
	public Validator<? super FCAPartyInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FCAPartyInformation>create(FCAPartyInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FCAPartyInformation> validator() {
		return new FCAPartyInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FCAPartyInformation> typeFormatValidator() {
		return new FCAPartyInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FCAPartyInformation, Set<String>> onlyExistsValidator() {
		return new FCAPartyInformationOnlyExistsValidator();
	}
}
