package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ESMAPartyInformation;
import drr.regulation.common.validation.ESMAPartyInformationTypeFormatValidator;
import drr.regulation.common.validation.ESMAPartyInformationValidator;
import drr.regulation.common.validation.datarule.ESMAPartyInformationCorporateSector;
import drr.regulation.common.validation.datarule.ESMAPartyInformationFinancialNonFinancial;
import drr.regulation.common.validation.exists.ESMAPartyInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ESMAPartyInformation.class)
public class ESMAPartyInformationMeta implements RosettaMetaData<ESMAPartyInformation> {

	@Override
	public List<Validator<? super ESMAPartyInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ESMAPartyInformation>create(ESMAPartyInformationCorporateSector.class),
			factory.<ESMAPartyInformation>create(ESMAPartyInformationFinancialNonFinancial.class)
		);
	}
	
	@Override
	public List<Function<? super ESMAPartyInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ESMAPartyInformation> validator(ValidatorFactory factory) {
		return factory.<ESMAPartyInformation>create(ESMAPartyInformationValidator.class);
	}

	@Override
	public Validator<? super ESMAPartyInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ESMAPartyInformation>create(ESMAPartyInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ESMAPartyInformation> validator() {
		return new ESMAPartyInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ESMAPartyInformation> typeFormatValidator() {
		return new ESMAPartyInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ESMAPartyInformation, Set<String>> onlyExistsValidator() {
		return new ESMAPartyInformationOnlyExistsValidator();
	}
}
