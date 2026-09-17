package fpml.consolidated.sec.lending.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.sec.lending.SecLendCollateralProvisions;
import fpml.consolidated.sec.lending.validation.SecLendCollateralProvisionsTypeFormatValidator;
import fpml.consolidated.sec.lending.validation.SecLendCollateralProvisionsValidator;
import fpml.consolidated.sec.lending.validation.datarule.SecLendCollateralProvisionsChoice0;
import fpml.consolidated.sec.lending.validation.datarule.SecLendCollateralProvisionsChoice1;
import fpml.consolidated.sec.lending.validation.exists.SecLendCollateralProvisionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SecLendCollateralProvisions.class)
public class SecLendCollateralProvisionsMeta implements RosettaMetaData<SecLendCollateralProvisions> {

	@Override
	public List<Validator<? super SecLendCollateralProvisions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SecLendCollateralProvisions>create(SecLendCollateralProvisionsChoice0.class),
			factory.<SecLendCollateralProvisions>create(SecLendCollateralProvisionsChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super SecLendCollateralProvisions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecLendCollateralProvisions> validator(ValidatorFactory factory) {
		return factory.<SecLendCollateralProvisions>create(SecLendCollateralProvisionsValidator.class);
	}

	@Override
	public Validator<? super SecLendCollateralProvisions> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecLendCollateralProvisions>create(SecLendCollateralProvisionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecLendCollateralProvisions> validator() {
		return new SecLendCollateralProvisionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecLendCollateralProvisions> typeFormatValidator() {
		return new SecLendCollateralProvisionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecLendCollateralProvisions, Set<String>> onlyExistsValidator() {
		return new SecLendCollateralProvisionsOnlyExistsValidator();
	}
}
