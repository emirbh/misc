package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.HKMAPartyInformation;
import drr.regulation.common.validation.HKMAPartyInformationTypeFormatValidator;
import drr.regulation.common.validation.HKMAPartyInformationValidator;
import drr.regulation.common.validation.datarule.HKMAPartyInformationCorporateSector;
import drr.regulation.common.validation.datarule.HKMAPartyInformationFinancialNonFinancial;
import drr.regulation.common.validation.exists.HKMAPartyInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=HKMAPartyInformation.class)
public class HKMAPartyInformationMeta implements RosettaMetaData<HKMAPartyInformation> {

	@Override
	public List<Validator<? super HKMAPartyInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<HKMAPartyInformation>create(HKMAPartyInformationCorporateSector.class),
			factory.<HKMAPartyInformation>create(HKMAPartyInformationFinancialNonFinancial.class)
		);
	}
	
	@Override
	public List<Function<? super HKMAPartyInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super HKMAPartyInformation> validator(ValidatorFactory factory) {
		return factory.<HKMAPartyInformation>create(HKMAPartyInformationValidator.class);
	}

	@Override
	public Validator<? super HKMAPartyInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<HKMAPartyInformation>create(HKMAPartyInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super HKMAPartyInformation> validator() {
		return new HKMAPartyInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super HKMAPartyInformation> typeFormatValidator() {
		return new HKMAPartyInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super HKMAPartyInformation, Set<String>> onlyExistsValidator() {
		return new HKMAPartyInformationOnlyExistsValidator();
	}
}
